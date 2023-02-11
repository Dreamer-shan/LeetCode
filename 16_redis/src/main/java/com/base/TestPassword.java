package com.base;

import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/13/20:11
 * @Description:
 */
public class TestPassword {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.connect();
        jedis.disconnect();
        jedis.flushAll();
    }
}
