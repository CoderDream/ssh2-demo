package com.coderdream.service.impl;

import java.util.List;

import com.coderdream.dao.UserDao;
import com.coderdream.model.User;
import com.coderdream.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String addUser(User user) {
		return userDao.addUser(user);
	}

	public List<User> findUserByName(String username) {
		return userDao.findUserByName(username);
	}

	public List<User> listAll() {
		return userDao.listAll();
	}

}