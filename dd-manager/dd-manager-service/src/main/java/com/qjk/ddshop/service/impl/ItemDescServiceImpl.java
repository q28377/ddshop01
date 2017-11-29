package com.qjk.ddshop.service.impl;


import com.qjk.ddshop.dao.TbItemDescMapper;
import com.qjk.ddshop.pojo.po.TbItemDesc;
import com.qjk.ddshop.service.ItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDescServiceImpl implements ItemDescService{

    @Autowired
    private TbItemDescMapper itemDescDao;

    @Override
    public TbItemDesc getByItemId(long itemId) {
        TbItemDesc desc = null;
        try {
            desc = itemDescDao.selectByPrimaryKey(itemId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return desc;
    }
}
