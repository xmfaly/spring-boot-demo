package com.example.mongo;

import com.example.mongo.dao.UserDao;
import com.example.mongo.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void contextLoads() {

		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("yang");
		userEntity.setPassword("yang");
		userDao.saveUser(userEntity);
	}

	@Test
	public void findOne(){
		UserEntity userEntity = userDao.findUserByUsername("yang");
		System.out.println(userEntity.getPassword());
	}

	@Test
	public void upData(){
		UserEntity userEntity = new UserEntity();

		userEntity.setPassword("123");
		userEntity.setUsername("yang");
		userDao.updataUser(userEntity);
	}

	@Test
	public void delete(){
		userDao.deleteUserByUsername("yang");
	}

}
