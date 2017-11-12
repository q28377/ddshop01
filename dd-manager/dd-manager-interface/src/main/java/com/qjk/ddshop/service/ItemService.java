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


}
