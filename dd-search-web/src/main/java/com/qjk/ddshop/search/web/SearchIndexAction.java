package com.qjk.ddshop.search.web;

import com.qjk.ddshop.pojo.vo.TbSearchItemResult;
import com.qjk.ddshop.service.SearchItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

@Controller
public class SearchIndexAction {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SearchItemService searchItemService;

    /**
     * 查询系统首页查询
     * @param keyword 跟页面的控件的name一致
     * @param page 默认为1  @RequestParam(defaultValue = "1")
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String SearchItemAction(String keyword,
                                   @RequestParam(defaultValue = "1")Integer page, Model model){
        if (keyword != null) {
            try {
                keyword = new String(keyword.getBytes("iso-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                logger.error(e.getMessage(),e);
                e.printStackTrace();
            }
            //查询商品列表    //每页60条
            TbSearchItemResult searchResult = searchItemService.search(keyword, page, 60);
            //把结果传递给页面
            model.addAttribute("query", keyword);
            model.addAttribute("totalPages", searchResult.getTotalPages());
            model.addAttribute("page", page);
            model.addAttribute("recourdCount", searchResult.getRecordCount());
            model.addAttribute("itemList", searchResult.getItemList());
        }

        return "search";
    }
}
