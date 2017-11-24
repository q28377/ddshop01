package com.qjk.ddshop.dao;


import com.qjk.ddshop.pojo.vo.TbItemSearchCustom;

import java.util.List;

public interface TbItemSearchCustomMapper {
    /**
     * 查询所有商品封装到指定BEAN中
     * @return
     */
    List<TbItemSearchCustom> listSearchItems();
    /**
     * 按主键查询指定商品封装到指定BEAN中
     * @return
     */
    TbItemSearchCustom getById(Long itemId);
}
