package com.qjk.ddshop.service;

import com.qjk.ddshop.common.dto.Order;
import com.qjk.ddshop.common.dto.Page;
import com.qjk.ddshop.common.dto.Result;
import com.qjk.ddshop.pojo.po.TbItem;
import com.qjk.ddshop.pojo.vo.TbItemCustom;
import com.qjk.ddshop.pojo.vo.TbItemQuery;

import java.util.List;

public interface ItemService {
    TbItem getById(Long itemId);

    //List<TbItem> listItems();

    Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery query);

    int updateBatch(List<Long> ids,int status);

    /**
     * 新增商品
     * @param tbItem  商品实体类
     * @param content 商品描述
     * @param paramData JSON格式字符串，存商品规格数据
     * @return  新增商品条数
     */
    int saveItem(TbItem tbItem, String content,String paramData);
}
