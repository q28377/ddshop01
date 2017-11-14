package com.qjk.ddshop.service.impl;

import com.qjk.ddshop.common.dto.Page;
import com.qjk.ddshop.common.dto.Result;
import com.qjk.ddshop.dao.TbItemParamCustomMapper;
import com.qjk.ddshop.dao.TbItemParamMapper;
import com.qjk.ddshop.pojo.po.TbItemParam;
import com.qjk.ddshop.pojo.po.TbItemParamExample;
import com.qjk.ddshop.pojo.vo.TbItemParamCustom;
import com.qjk.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemParamServiceImpl implements ItemParamService{


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemParamCustomMapper itemParamCustomDao;
    @Autowired
    private TbItemParamMapper itemParamDao;

    @Override
    public Result<TbItemParamCustom> listItemParamsByPage(Page page) {
        Result<TbItemParamCustom> result = null;
        try {
            //DAO层接口多个参数解决方案之一
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("page",page);
            //取出tb_item_param这张表的记录条数
            int count = itemParamCustomDao.countItemParams();
            //取出对应页码的记录集合
            List<TbItemParamCustom> list = itemParamCustomDao.listItemParamsByPage(map);

            result = new Result<TbItemParamCustom>();
            result.setTotal(count);
            result.setRows(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public TbItemParam getItemParamByCid(Long cid) {
        TbItemParam tbItemParam = null;
        try {
            //创建查询模板
            TbItemParamExample example = new TbItemParamExample();
            TbItemParamExample.Criteria criteria = example.createCriteria();
            criteria.andItemCatIdEqualTo(cid);
            //执行查询
            List<TbItemParam> list = itemParamDao.selectByExampleWithBLOBs(example);
            if(list != null && list.size() > 0){
                tbItemParam = list.get(0);
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return tbItemParam;
    }
}
