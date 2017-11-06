package com.qjk.ddshop.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
public class IndexAction {

    @RequestMapping("/")    //根据配置文件，解析访问到WEB-INF/jsp下的index.jsp
    public String index(){
        return "index";
    }
}
