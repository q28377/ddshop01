package com.qjk.ddshop.service;

public interface SearchItemService {
    /**
     * 将采集到的数据导入到索引库
     * @return
     */
    boolean importAllItems();
}
