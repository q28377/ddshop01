package com.qjk.ddshop.pojo.vo;

import java.util.List;

public class TbSearchItemResult {
    private long recordCount;
    private int totalPages;
    private List<TbItemSearchCustom> itemList;

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<TbItemSearchCustom> getItemList() {
        return itemList;
    }

    public void setItemList(List<TbItemSearchCustom> itemList) {
        this.itemList = itemList;
    }
}
