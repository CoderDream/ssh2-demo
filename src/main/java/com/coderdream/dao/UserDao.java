package com.coderdream.dao;

import java.util.List;

import com.coderdream.model.User;

public interface UserDao {
	public String addUser(User user);

	public List<User> findUserByName(String username);

	public List<User> listAll();
}