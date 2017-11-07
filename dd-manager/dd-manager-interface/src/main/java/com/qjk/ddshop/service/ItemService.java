package com.qjk.ddshop.service;

import com.qjk.ddshop.pojo.po.TbItem;

import java.util.List;

public interface ItemService {
    TbItem getById(Long itemId);
    List<TbItem> listItems();
}
