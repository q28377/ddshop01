package com.qjk.ddshop.service;

import com.qjk.ddshop.pojo.vo.TbSearchItemResult;

public interface SearchItemService {
    /**
     * 将采集到的数据导入到索引库
     * @return
     */
    boolean importAllItems();

    /**
     * 分页查询
     * @param keyword
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    TbSearchItemResult search(String keyword, int page, int rows);
}
