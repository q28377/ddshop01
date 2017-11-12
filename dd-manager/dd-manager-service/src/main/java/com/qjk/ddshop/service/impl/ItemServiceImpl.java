package com.qjk.ddshop.service.impl;

import com.qjk.ddshop.common.dto.Order;
import com.qjk.ddshop.common.dto.Page;
import com.qjk.ddshop.common.dto.Result;
import com.qjk.ddshop.dao.TbItemCustomMapper;
import com.qjk.ddshop.dao.TbItemMapper;
import com.qjk.ddshop.pojo.po.TbItem;
import com.qjk.ddshop.pojo.po.TbItemExample;
import com.qjk.ddshop.pojo.vo.TbItemCustom;
import com.qjk.ddshop.pojo.vo.TbItemQuery;
import com.qjk.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Result<TbItemCustom> listItemsByPage(Page page, Order order,TbItemQuery query) {
        Result<TbItemCustom> result = null;
        try {
            //0.创建一个Map封装前台传递过来的参数,用Map传递多参数
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("page",page);
            map.put("order",order);
            map.put("query",query);

            //1.创建一个响应参数实体类
            result = new Result<TbItemCustom>();
            //2.对total进行设值(符合条件的总记录数)
                        //计数时，要把模糊查询条件传过去,直接传map，就不用注解了
            int total = itemCustomDao.countItems(map);
            result.setTotal(total);
            //3 对rows进行设值(指定页码显示记录集合)
            //List<TbItemCustom> list = itemCustomDao.listItemsByPage(page,order);
            List<TbItemCustom> list = itemCustomDao.listItemsByPage(map);
            result.setRows(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateBatch(List<Long> ids,int status) {
        int i=0;
        try {
            //准备商品对象，这个对象包含了状态为3的字段
            TbItem t = new TbItem();
            t.setStatus((byte) status);
            //创建更新模板 update tb_item set status=? where id in (?,?,?)
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            //执行更新
            i = itemDao.updateByExampleSelective(t,example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

}
