package com.qjk.ddshop.search.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchIndexAction {

    @RequestMapping("/")
    public String SearchItemAction(Model model){
        return "search";
    }
}
