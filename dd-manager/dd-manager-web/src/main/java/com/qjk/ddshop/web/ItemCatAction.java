package com.qjk.ddshop.web;

import com.qjk.ddshop.common.dto.TreeNode;
import com.qjk.ddshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller         //商品分类的实体Action
@Scope("prototype")
public class ItemCatAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemCatService itemCatService;

    @ResponseBody
    @RequestMapping("/itemCats")        //查找当前父节点下的子节点
    public List<TreeNode> listItemCatsByPid(@RequestParam("parentId") Long parentId ){
        List<TreeNode> treeNodeList = null;
        try {
            treeNodeList = itemCatService.listItemCatsByPid(parentId);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return treeNodeList;
    }

}
