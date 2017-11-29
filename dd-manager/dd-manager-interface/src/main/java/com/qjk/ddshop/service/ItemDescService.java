package com.qjk.ddshop.service;

import com.qjk.ddshop.pojo.po.TbItemDesc;

public interface ItemDescService {
    TbItemDesc getByItemId(long itemId);
}
