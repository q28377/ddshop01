package com.qjk.ddshop.web;

import com.qjk.ddshop.common.dto.MessageResult;
import com.qjk.ddshop.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchItemAction {
    @Autowired
    private SearchItemService searchItemService;

    @ResponseBody
    @RequestMapping("/item/search/import")
    public MessageResult searchItemIndex(){
        //通过调用service层方法将采集到的数据导入到索引库
        boolean bool = searchItemService.importAllItems();
        MessageResult mr = new MessageResult();
        if (bool) {
            mr.setSuccess(true);
            mr.setMessage("索引导入成功");
        }else {
            mr.setSuccess(false);
            mr.setMessage("索引导入失败");
        }
        return mr;
    }
}
