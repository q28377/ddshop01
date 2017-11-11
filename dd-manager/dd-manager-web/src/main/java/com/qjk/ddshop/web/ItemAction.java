package com.qjk.ddshop.web;

import com.qjk.ddshop.common.dto.Page;
import com.qjk.ddshop.common.dto.Result;
import com.qjk.ddshop.pojo.po.TbItem;
import com.qjk.ddshop.pojo.vo.TbItemCustom;
import com.qjk.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Scope("prototype")
public class ItemAction {

    //日志
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemService itemService;

    @ResponseBody   //转换为json
    @RequestMapping(value = "/item/{itemId}" , method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemId")Long itemId){
        System.out.print(itemId);
        return itemService.getById(itemId);
    }

/*    //查询所有商品
    @ResponseBody   //Json格式，返回给easyUI的表格
    @RequestMapping("/items")
    public List<TbItem> listItems(){
        List<TbItem> list = null;
        try {
            list = itemService.listItems();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return  list;
    }*/

    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCustom> listItemsByPage(Page page){
        Result<TbItemCustom> list = null;
        try {
            list = itemService.listItemsByPage(page);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }

    //批量删除方法（其实批量删除只是批量修改,将status改为3）
    //批量上架、下架
    @ResponseBody
    @RequestMapping("/items/batch/{status}")
    public int updateBatch(@RequestParam("ids[]") List<Long>ids,@PathVariable("status") int status){
        int i=0;
        try {
            i = itemService.updateBatch(ids,status);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }



}
