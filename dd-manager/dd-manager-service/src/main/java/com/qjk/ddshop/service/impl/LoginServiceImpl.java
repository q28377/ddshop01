package com.qjk.ddshop.service.impl;

import com.qjk.ddshop.common.dto.MessageResult;
import com.qjk.ddshop.common.jedis.JedisClient;
import com.qjk.ddshop.common.util.JsonUtils;
import com.qjk.ddshop.dao.TbUserMapper;
import com.qjk.ddshop.pojo.po.TbUser;
import com.qjk.ddshop.pojo.po.TbUserExample;
import com.qjk.ddshop.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbUserMapper userDao;
    @Autowired
    private JedisClient jedisClient;

    @Override
    public MessageResult userLogin(String username, String password) {
        MessageResult mr = new MessageResult();
        try {
            //创建模板
            TbUserExample example = new TbUserExample();
            TbUserExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(username);
            //执行查询
            List<TbUser> list = userDao.selectByExample(example);
            //用户名不存在
            if (list == null || list.size() == 0) {
                //返回登录失败
                mr.setSuccess(false);
                mr.setMessage("用户名不存在");
                return mr;
            }
            //用户名已存在，这个是从数据库来的
            TbUser user = list.get(0);
            //把前台传递过来密码进行MD5加密一次
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (!md5Password.equals(user.getPassword())) {
                mr.setSuccess(false);
                mr.setMessage("用户名或者密码错误");
                return mr;
            }
            //用户名和密码都正确的情况
            String token = UUID.randomUUID().toString();
            //把登录成功的信息写入到redis中
            //将用户信息中密码置空
            user.setPassword(null);
            //用户信息存入缓存，并且设置过期时间，1800s(半小时)
            jedisClient.set("DDSHOP_TOKEN:" + token, JsonUtils.objectToJson(user));
            jedisClient.expire("DDSHOP_TOKEN:" + token, 1800);
            //正确情况下返回MessageResult
            mr.setSuccess(true);
            mr.setMessage("登录成功");
            mr.setData(token);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mr;
    }
}
