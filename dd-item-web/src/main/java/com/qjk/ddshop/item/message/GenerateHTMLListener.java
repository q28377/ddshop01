package com.qjk.ddshop.item.message;

import com.qjk.ddshop.pojo.po.TbItem;
import com.qjk.ddshop.pojo.po.TbItemDesc;
import com.qjk.ddshop.service.ItemDescService;
import com.qjk.ddshop.service.ItemService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class GenerateHTMLListener implements MessageListener{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemDescService itemDescService;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public void onMessage(Message message) {
        try {
            //1接收消息
            TextMessage textMessage = (TextMessage)message;
            String text = textMessage.getText();
            long itemId = Long.parseLong(text);
            //2根据商品id查询商品和商品描述
            TbItem tbItem = itemService.getById(itemId);
            TbItemDesc desc =  itemDescService.getByItemId(itemId);
            //3添加数据集
            Map<String, Object> dataModel = new HashMap<String, Object>();
            dataModel.put("item",tbItem);
            dataModel.put("itemDesc", desc);
            //4获取freemarker的配置对象
            Configuration configuration = freeMarkerConfigurer.getConfiguration();
            Template template = configuration.getTemplate("item.ftl");
            Writer out = new FileWriter("d:/GONGJU/Java/java_study/projectsTest/ftl/"+itemId+".html");
                //d:/GONGJU/Java/java_study/projectsTest/ftl/123.html
            //生成静态页面
            template.process(dataModel,out);
            out.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }
}
