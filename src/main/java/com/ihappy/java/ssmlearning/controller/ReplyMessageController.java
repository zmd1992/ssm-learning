package com.ihappy.java.ssmlearning.controller;


import com.alibaba.fastjson.JSON;
import com.ihappy.java.ssmlearning.model.Account;
import com.ihappy.java.ssmlearning.model.LeavingMessage;
import com.ihappy.java.ssmlearning.model.ReplyMessage;
import com.ihappy.java.ssmlearning.service.ILeavingMessageService;
import com.ihappy.java.ssmlearning.service.IReplyMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/replyMessage")
public class ReplyMessageController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private IReplyMessageService replyMessageService;
    @Resource
    private ILeavingMessageService leavingMessageService;

    /**
     * 根据留言id跳到回复页面
     *
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/reply")
    public String reply(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "content/reply";
    }
    /**
     * 处理回复页面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/addReplyMessage", method = RequestMethod.GET)
    public String addReplyMessage(HttpServletRequest request, Model model,@RequestParam("id")Integer id) {
        //查询用户信息
        Account account = (Account) request.getSession().getAttribute("loginUser");
        model.addAttribute("account",account);
        //查询留言信息
        LeavingMessage leavingMessage=leavingMessageService.queryOneLeavingMessage(id);
        model.addAttribute("leavingMessage",leavingMessage);
        ReplyMessage replyMessage = new ReplyMessage();
        //获取用户id
        replyMessage.setUserId(account.getId());
        //获取留言id
        replyMessage.setLeavingId(leavingMessage.getId());
        replyMessage.setReplyContent(request.getParameter("replyContent"));
        replyMessage.setReplyTime(new Date());
        Integer oneReplyMessage= replyMessageService.addOneReplyMessage(replyMessage);
        System.out.println(JSON.toJSON(oneReplyMessage));
        return "redirect:/leavingMessage/leavingList";
    }

    /**
     * 回复列表
     *
     * @return
     */
    @RequestMapping(value = "/replyList", method = RequestMethod.GET)
    public String replyList(@RequestParam("id") Integer id, Model model) {
        LeavingMessage leavingMessage = leavingMessageService.queryOneLeavingMessage(id);
        model.addAttribute("leavingMessage", leavingMessage);
        //根据留言id查询留言的回复列表
        List<ReplyMessage> replyMessageList = replyMessageService.findReplyMessage(leavingMessage.getId());
        model.addAttribute("replyMessageList", replyMessageList);
        log.debug(replyMessageList.toString());
        return "content/replyList";
    }
}
