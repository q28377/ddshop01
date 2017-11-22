package com.qjk.ddshop.service.impl;

import com.qjk.ddshop.dao.TbItemSearchCustomMapper;
import com.qjk.ddshop.pojo.vo.TbItemSearchCustom;
import com.qjk.ddshop.service.SearchItemService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SearchItemServiceImpl implements SearchItemService {

    @Autowired
    private TbItemSearchCustomMapper tbItemSearchCustomDao;
    @Autowired
    private SolrServer solrServer;

    @Override
    public boolean importAllItems() {
        //采集数据：查询数据到List
        List<TbItemSearchCustom> list = tbItemSearchCustomDao.listSearchItems();
        //创建索引库  documentList
        //遍历
        for (TbItemSearchCustom tbItemSearchCustom : list){
            //创建solr的文档对象
            //先形成文档对象，再形成文档域
            //文档对象Field的name与scheme.xml配置的内容保持一致
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id",tbItemSearchCustom.getId());
            document.addField("item_title",tbItemSearchCustom.getTitle());
            document.addField("item_sell_point",tbItemSearchCustom.getSellPoint());
            document.addField("item_price",tbItemSearchCustom.getPrice());
            document.addField("item_image",tbItemSearchCustom.getImage());
            document.addField("item_category_name",tbItemSearchCustom.getCatName());
            //写入索引库
            try {
                solrServer.add(document);
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //提交
        try {
            solrServer.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
