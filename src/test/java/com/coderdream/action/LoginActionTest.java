package com.coderdream.action;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.coderdream.model.User;
import com.coderdream.service.UserService;
import com.coderdream.util.InitApplicationContext;
import com.opensymphony.xwork2.Action;

public class LoginActionTest {

	private User user;

	private UserService userService;

	private ApplicationContext context = null;

	private LoginAction loginAction = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		context = InitApplicationContext.getApplicationContext();
		loginAction = new LoginAction();
		userService = (UserService) context.getBean("userService");
	}

	@After
	public void tearDown() throws Exception {
	}

	//@Test
	public void testUserLogin() {
		user = new User();
		user.setUsername("username");
		user.setPassword("password");
		try {
			loginAction.setUser(user);
			loginAction.setUserService(userService);
			Assert.assertEquals(Action.SUCCESS, loginAction.execute());
			user.setPassword("password1");
			System.out.println(loginAction.getActionErrors());
			Assert.assertEquals(Action.INPUT, loginAction.execute());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}