package com.netease.test.trade.controller;

import com.netease.test.trade.entity.Account;
import com.netease.test.trade.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }

    @RequestMapping("/userLogin")
    public String login(Account account, HttpServletRequest request){
        boolean isValid = accountService.validUser(account.getUserName(), account.getPassword());
        if(isValid){
            request.removeAttribute("error");
            request.getSession().setAttribute("user", account.getUserName());
            return "redirect:/";
        }else {
            request.setAttribute("error", "用户名或密码错误");
            return "login";
        }
    }





}
