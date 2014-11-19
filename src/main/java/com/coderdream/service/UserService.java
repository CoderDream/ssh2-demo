package com.coderdream.service;

import java.util.List;

import com.coderdream.model.User;

public interface UserService {
	public String addUser(User user);

	public List<User> findUserByName(String username);

	public List<User> listAll();
}