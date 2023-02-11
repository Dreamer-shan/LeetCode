package com.base;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/13/19:56
 * @Description:
 */
public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());
        System.out.println("清空数据库："+ jedis.flushDB());
        System.out.println("判断某个键是否存在："+ jedis.exists("name"));
        System.out.println("新增k1,v1键值对："+ jedis.set("name","shan"));
        System.out.println("新增k2,v2键值对："+ jedis.set("age", "24"));
        System.out.println("系统中所有的键如下：");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("删除键k2："+ jedis.del("age"));
        System.out.println("判断键k2是否存在："+ jedis.exists("age"));
        System.out.println("查看键 k1 所存储的数据类型："+ jedis.type("name"));
        System.out.println("随机返回 key 空间的一个："+jedis.randomKey());
        System.out.println("重命名 key ："+ jedis.rename("name", "Name"));
        System.out.println("取出改后的 newk1 ："+ jedis.get("Name"));
        System.out.println("按索引查询："+jedis.select(0));
        System.out.println("删除当前选择数据库中的所有键："+jedis.flushDB());
        System.out.println("返回当前数据库中 key 的数量："+jedis.dbSize());
        System.out.println("删除所有数据库中的所有 key ："+jedis.flushAll());


    }
}
