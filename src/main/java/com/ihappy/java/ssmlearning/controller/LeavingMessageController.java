package com.ihappy.java.ssmlearning.controller;

import com.ihappy.java.ssmlearning.bo.QueryLeavingMessageBO;
import com.ihappy.java.ssmlearning.common.domain.Page;
import com.ihappy.java.ssmlearning.common.util.StringUtil;
import com.ihappy.java.ssmlearning.model.Account;
import com.ihappy.java.ssmlearning.model.LeavingMessage;
import com.ihappy.java.ssmlearning.service.IAccountService;
import com.ihappy.java.ssmlearning.service.ILeavingMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.function.Consumer;


@Controller
@RequestMapping("/leavingMessage")
public class LeavingMessageController {
    private static final Logger log = LoggerFactory.getLogger(LeavingMessageController.class);
    @Resource
    private ILeavingMessageService leavingMessageService;
    @Resource
    private IAccountService accountService;
    /**
     * 查询留言列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/leavingList", method = RequestMethod.GET)
    public String getLeavingMessageList(@RequestParam(value = "currentPage",defaultValue = "1",required = false)Integer currentPage,Model model){
        model.addAttribute("pagemsg",leavingMessageService.getLeavingMessage(currentPage));
        return "content/leavingList";
    }

    /**
     * 查看留言内容
     */
    @RequestMapping(value = "/leavingInfo", method = RequestMethod.GET)
    public String getLeavingInfo(HttpServletRequest request, @RequestParam("id") Integer id, Model model) {
        LeavingMessage leavingMessageInfo = leavingMessageService.queryOneLeavingMessage(id);
        Account account = (Account) request.getSession().getAttribute("loginUser");
        leavingMessageInfo.setLeavingMan(account.getUserName());
        model.addAttribute("leavingMessageInfo", leavingMessageInfo);
        log.debug(leavingMessageInfo.toString());
        return "content/leavingInfo";

    }

    /**
     * 新增留言的页面
     *
     * @return
     */
    @RequestMapping(value = "leavingMessage")
    public String leavingMessage() {
        return "content/leavingMessage";
    }

    /**
     * 处理留言
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/addLeavingMessage", method = RequestMethod.POST)
    public String addLeavingMessage(HttpServletRequest request, Model model, @RequestParam("title") String title, @RequestParam("content") String content) {
        if (StringUtil.isBlank(title)) {
            return "content/titleIsNotNull";
        }
        if (StringUtil.isBlank(content)) {
            return "content/contentIsNotNull";
        }
        if (title.length() > 10) {
            return "content/titleLengthLimit";
        }
        if (content.length() > 100) {
            return "content/contentLengthLimit";
        }
        //查询用户信息
        Account account = (Account) request.getSession().getAttribute("loginUser");
        LeavingMessage leavingMessage = new LeavingMessage();
        leavingMessage.setTitle(request.getParameter("title"));
        leavingMessage.setContent(request.getParameter("content"));
        leavingMessage.setLeavingTime(new Date());
        //留言人
        leavingMessage.setLeavingMan(account.getUserName());
        long message = leavingMessageService.addLeavingMessage(leavingMessage);
        model.addAttribute("message", message);
        return "redirect:/leavingMessage/leavingList";
    }

    /**
     * 删除一条留言
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/removeLeavingMessage", method = RequestMethod.GET)
    public String deleteLeavingMessage(@RequestParam("id") Integer id, Model model) {
        long message = leavingMessageService.removeLeavingMessage(id);
        model.addAttribute("message", message);
        return "redirect:/leavingMessage/leavingList";
    }
    /**
     * 批量删除
     */
    @RequestMapping(value = "/batchDeleteLeavingMessage",method = RequestMethod.POST)
    public String batchDeleteLeavingMessage(Model model){
        List<LeavingMessage> leavingMessageList=leavingMessageService.queryLeavingMessageList();
        List<Integer> idList=new ArrayList<>();
        leavingMessageList.forEach(x->{
            Integer id=x.getId();
            idList.add(id);
        });
        Integer batchDelete=leavingMessageService.batchDeleteLeavingMessage(idList);
        model.addAttribute("batchDelete",batchDelete);
        return "content/leavingList";
    }

    /**
     * 查询留言详情
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "findOneLeavingMessage")
    public String findOneLeavingMessage(@RequestParam("id") Integer id, Model model) {
        LeavingMessage oneLeavingMessage = leavingMessageService.queryOneLeavingMessage(id);
        model.addAttribute("oneLeavingMessage", oneLeavingMessage);
        return "redirect:/replyMessage/replyMessage";
    }
}
