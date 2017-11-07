package com.qjk.ddshop.service;

import com.qjk.ddshop.common.dto.Page;
import com.qjk.ddshop.common.dto.Result;
import com.qjk.ddshop.pojo.po.TbItem;
import com.qjk.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface ItemService {
    TbItem getById(Long itemId);

    //List<TbItem> listItems();

    Result<TbItemCustom> listItemsByPage(Page page);
}
