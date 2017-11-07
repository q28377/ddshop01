package com.qjk.ddshop.service.impl;

import com.qjk.ddshop.common.dto.Page;
import com.qjk.ddshop.common.dto.Result;
import com.qjk.ddshop.dao.TbItemCustomMapper;
import com.qjk.ddshop.dao.TbItemMapper;
import com.qjk.ddshop.pojo.po.TbItem;
import com.qjk.ddshop.pojo.vo.TbItemCustom;
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
    @Autowired
    private TbItemCustomMapper itemCustomDao;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem = itemDao.selectByPrimaryKey(itemId);
        return tbItem;
    }

    /*@Override
    public List<TbItem> listItems(){
        List<TbItem> list = null;
        try {
            list = itemDao.selectByExample(null);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }*/

    @Override
    public Result<TbItemCustom> listItemsByPage(Page page) {
        Result<TbItemCustom> result = null;
        try {
            //1.创建一个响应参数实体类
            result = new Result<TbItemCustom>();
            //2.对total进行设值(符合条件的总记录数)
            int total = itemCustomDao.countItems();
            result.setTotal(total);
            //3 对rows进行设值(指定页码显示记录集合)
            List<TbItemCustom> list = itemCustomDao.listItemsByPage(page);
            result.setRows(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }


}
