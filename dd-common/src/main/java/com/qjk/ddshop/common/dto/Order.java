package com.qjk.ddshop.common.dto;

import java.util.ArrayList;
import java.util.List;

//easyui的datagrid的排序通用类
public class Order {
    private String sort;//按什么排序
    private String order;//升序还是降序

    //private List<String> orderParams;

    public List<String> getOrderParams() {
        String[] sorts = sort.split(",");
        String[] orders = order.split(",");
        List<String> list = new ArrayList<String>();
        for (int i=0;i< sorts.length;i++){
            String temp = sorts[i] +" "+orders[i];//id asc//title desc
            list.add(temp);//[id asc;title desc]
        }
        return list;
    }

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
