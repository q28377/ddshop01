package com.qjk.ddshop.dao;

import com.qjk.ddshop.common.dto.Page;
import com.qjk.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

/**
 * 自定义的商品实体数据访问层接口
 */
public interface TbItemCustomMapper {
    /**
     * 查询商品表中所有记录的数量
     * @return
     */
    int countItems();

    /**
     * 查询指定页码显示记录集合
     * @param page
     * @return
     */
    List<TbItemCustom> listItemsByPage(Page page);
}
