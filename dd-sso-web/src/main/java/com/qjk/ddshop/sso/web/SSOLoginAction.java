package com.qjk.ddshop.sso.web;

import com.qjk.ddshop.common.dto.MessageResult;
import com.qjk.ddshop.common.util.CookieUtils;
import com.qjk.ddshop.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SSOLoginAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/user/login")
    public MessageResult login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        MessageResult mr = null;
        try {
            //调用业务逻辑层方法进行登录
            mr = loginService.userLogin(username,password);
            if (mr.isSuccess()){
                //登录成功
                String token = mr.getData().toString();
                //写入cookie
                CookieUtils.setCookie(request,response,"ddshop_token",token);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mr;
    }

}
