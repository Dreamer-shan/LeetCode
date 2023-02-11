package com.shy.redis_springboot;

import com.shy.pojo.User;
import com.shy.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisSpringbootApplicationTests {

	@Autowired
	@Qualifier("redisTemplate")		// 指定名字
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisUtil redisUtil;
	@Test
	void contextLoads() {
		// 获取redis连接对象
//		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//		connection.flushDb();
//		connection.flushAll();
		// 中文需要序列化
		redisTemplate.opsForValue().set("name","试试是是");
		System.out.println(redisTemplate.opsForValue().get("name"));

	}
	@Test
	public void test(){
		// 真是开发一般用json传递对象
		User user = new User("属实", 3);
		redisTemplate.opsForValue().set("user", user);
	}

	@Test
	public void  test1(){
		redisUtil.set("name","shy");
	}

}
