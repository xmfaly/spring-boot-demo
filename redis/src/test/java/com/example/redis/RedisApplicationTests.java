package com.example.redis;

import com.example.redis.entity.UserEntity;
import com.example.redis.util.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisUtil redisUtil;

	@Test
	public void contextLoads() {
		stringRedisTemplate.opsForValue().set("test","yang");
		Assert.assertEquals("yang",stringRedisTemplate.opsForValue().get("test"));
	}

	@Test
	public void test(){
		UserEntity user = new UserEntity("li",44);

		redisUtil.setValue("li",user);

		UserEntity user1 =(UserEntity) redisUtil.getValue("li");

		System.out.println(user1.getAge());



	}

}
