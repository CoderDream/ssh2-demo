package com.coderdream.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coderdream.model.User;

public class UserDaoTest {

	private ApplicationContext context = null;

	private User user = null;

	private UserDao userDao = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) context.getBean("userDao");
	}

	@After
	public void tearDown() throws Exception {
		userDao = null;
		user = null;
	}

	//@Test
	public void addUser() {
		user = new User();
		user.setUsername("username3");
		user.setPassword("password");
		userDao.addUser(user);
		Assert.assertEquals(1, user.getId());
		userDao.addUser(user);
		Assert.assertEquals(1, user.getId());

		User userTwo = new User();
		userTwo.setUsername("username1");
		userTwo.setPassword("password");
		userDao.addUser(userTwo);
		Assert.assertEquals(2, userTwo.getId());
	}

	//@Test
	public void listAll() {
		List<User> users = userDao.listAll();
		Assert.assertEquals(users.size(), 2);
	}

}
