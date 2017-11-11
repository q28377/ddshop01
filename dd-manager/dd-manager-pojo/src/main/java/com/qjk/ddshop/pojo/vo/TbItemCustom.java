package com.qjk.ddshop.pojo.vo;

import com.qjk.ddshop.pojo.po.TbItem;

//自定义的商品显示类(VO)     继承商品类
public class TbItemCustom extends TbItem{
    private String catName;
    private String statusName;

    private String updatedTime;
    private String priceView;


    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getPriceView() {
        return priceView;
    }

    public void setPriceView(String priceView) {
        this.priceView = priceView;
    }
}
