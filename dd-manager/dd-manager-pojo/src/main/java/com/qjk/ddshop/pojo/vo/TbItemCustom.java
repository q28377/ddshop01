package com.qjk.ddshop.pojo.vo;

import com.qjk.ddshop.pojo.po.TbItem;

//自定义的商品显示类(VO)     继承商品类
public class TbItemCustom extends TbItem{
    private String catName;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
