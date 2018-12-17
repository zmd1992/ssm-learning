package com.ihappy.java.ssmlearning.controller;

import com.ihappy.java.ssmlearning.Exception.SsmLearningException;
import com.ihappy.java.ssmlearning.common.enumtype.SsmLearningErrorCodeEnum;
import com.ihappy.java.ssmlearning.common.util.StringUtil;
import com.ihappy.java.ssmlearning.model.Account;
import com.ihappy.java.ssmlearning.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/account")
public class AccountController {
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    @Resource
    private IAccountService accountService;

    @RequestMapping(value = "/registerOneAccount", method = RequestMethod.POST)
    public String registerByUsernameAndPassword(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("userName") String userName, @RequestParam("password") String password) {
        if (StringUtil.isBlank(userName) && StringUtil.isBlank(password)) {
            return "account_info/userNameOrPasswordIsNull";
        }
//        //查询用户
        List<Account> userInfo = accountService.getUserInfoByUserName(userName);
        if (userInfo.size() > 0) {
            return "account_info/userNameIsRepeat";
        }

        Account account = new Account();
        account.setUserName(request.getParameter("userName"));
        account.setPassword(request.getParameter("password"));
        account.setSex(Integer.parseInt(request.getParameter("sex")));
        account.setBirthday(request.getParameter("birthday"));
        account.setTranslate(request.getParameter("translate"));
        account.setEmail(request.getParameter("email"));
        account.setCreateTime(new java.util.Date());
        long user = accountService.registerOneAccountByCondition(account);
        model.addAttribute(user);
        return "account_info/registerSuccess";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String getAccountById(HttpServletRequest request, @RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {
        //通过接口获取数据库里的用户名和密码
        Account user = accountService.getUserInfoByUser(userName);
        model.addAttribute("user", user);
        //如果用户名为空，则返回登录界面
        if (user == null) {
            return "account_info/login";
        }
        //数据表里得到的参数值与前端传入的一样
        if (user.getPassword().equals(password)) {
            request.getSession().setAttribute("loginUser", user);
            return "redirect:/leavingMessage/leavingList";
        } else {
            return "account_info/login";
        }
    }


    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "login")
    public String login() {
        return "account_info/login";
    }

    /**
     * 注册页面
     *
     * @return
     */
    @RequestMapping(value = "register")
    public String register() {
        return "account_info/register";
    }
}
