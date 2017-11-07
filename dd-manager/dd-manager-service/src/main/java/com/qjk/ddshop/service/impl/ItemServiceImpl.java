package com.qjk.ddshop.service.impl;

import com.qjk.ddshop.dao.TbItemMapper;
import com.qjk.ddshop.pojo.po.TbItem;
import com.qjk.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
//    实现接口或抽象类的方法: Ctrl + I

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemMapper itemDao;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem = itemDao.selectByPrimaryKey(itemId);
        return tbItem;
    }

    @Override
    public List<TbItem> listItems(){
        List<TbItem> list = null;
        try {
            list = itemDao.selectByExample(null);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }


}
