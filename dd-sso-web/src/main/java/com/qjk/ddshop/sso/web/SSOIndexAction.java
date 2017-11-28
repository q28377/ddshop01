package com.qjk.ddshop.sso.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SSOIndexAction {
    @RequestMapping(value = "/")
    public String index(){
        return "login";
    }

}
