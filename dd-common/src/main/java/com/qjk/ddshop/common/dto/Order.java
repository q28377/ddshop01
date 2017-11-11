package com.qjk.ddshop.common.dto;

//easyui的datagrid的排序通用类
public class Order {
    private String sort;//按什么排序
    private String order;//升序还是降序

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
