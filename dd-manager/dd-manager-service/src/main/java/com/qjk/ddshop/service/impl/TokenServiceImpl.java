package com.qjk.ddshop.service.impl;

import com.qjk.ddshop.common.dto.MessageResult;
import com.qjk.ddshop.common.jedis.JedisClient;
import com.qjk.ddshop.common.util.JsonUtils;
import com.qjk.ddshop.pojo.po.TbUser;
import com.qjk.ddshop.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JedisClient jedisClient;

    @Override
    public MessageResult getUserByToken(String tokenId) {
        MessageResult mr = new MessageResult();
        try {
            String userJson = jedisClient.get("DDSHOP_TOKEN:" + tokenId);
            //userJson为空时
            if (StringUtils.isBlank(userJson)){
                mr.setSuccess(false);
                mr.setMessage("登录已经过期");
                return mr;
            }
            //redis集群中存在该用户名而且在有效时间之内
            //充值半小时
            jedisClient.expire("DDSHOP_TOKEN:" + tokenId, 1800);
            TbUser tbUser = JsonUtils.jsonToPojo(userJson, TbUser.class);
            //返回messageresult
            mr.setSuccess(true);
            mr.setMessage("欢迎回来");
            mr.setData(tbUser);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mr;
    }
}
