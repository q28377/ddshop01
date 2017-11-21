package com.qjk.ddshop.jedis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

public class JedisTest {

    /*@Test
    public void testJedis1(){
        Jedis jedis = new Jedis("10.31.161.120", 6379);
        jedis.set("key1", "value1");
        System.out.println(jedis.get("key1"));
        jedis.close();
    }*/

    /*@Test
    public void testJedis2(){
        //获取jedis池
        JedisPool jedisPool = new JedisPool("10.31.161.120",6379);
        //获取Jedis对象
        Jedis jedis = jedisPool.getResource();
        jedis.set("key2","value2");
        System.out.println(jedis.get("key2"));
        //关闭连接
        jedis.close();
        jedisPool.close();
    }*/

    /*@Test
    public void testJedis03(){
        //创建存放节点的集合
        Set<HostAndPort> clusterSet = new HashSet<HostAndPort>();
        clusterSet.add(new HostAndPort("10.31.161.120", 9001));
        clusterSet.add(new HostAndPort("10.31.161.120", 9002));
        clusterSet.add(new HostAndPort("10.31.161.120", 9003));
        clusterSet.add(new HostAndPort("10.31.161.120", 9004));
        clusterSet.add(new HostAndPort("10.31.161.120", 9005));
        clusterSet.add(new HostAndPort("10.31.161.120", 9006));
        //创建jedis集群对象进行使用
        JedisCluster jedisCluster = new JedisCluster(clusterSet);
        jedisCluster.set("name", "nnn");
        jedisCluster.hset("content_list", "123456", "{'name':'dhc'}");
        System.out.println(jedisCluster.get("name"));
        jedisCluster.close();
    }*/
}
