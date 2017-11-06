package com.qjk.ddshop.web;

import com.qjk.ddshop.pojo.po.TbItem;
import com.qjk.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Scope("prototype")
public class ItemAction {

    @Autowired
    private ItemService itemService;

    @ResponseBody   //转换为json
    @RequestMapping(value = "/item/{itemId}" , method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemId")Long itemId){
        System.out.print(itemId);
        return itemService.getById(itemId);
    }

}
