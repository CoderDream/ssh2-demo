package com.coderdream.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.coderdream.dao.UserDao;
import com.coderdream.model.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public String addUser(User user) {
		String success = "";
		String username = user.getUsername();
		if (findUserByName(username).size() == 0) {
			try {
				getHibernateTemplate().save(user);
				success = "User saved ok!";
			} catch (DataAccessException e) {
				success = "Sorry, user can't be added.";
			}
		} else {
			success = "The username has been existed!";
		}
		return success;
	}

	@SuppressWarnings("unchecked")
	public List<User> findUserByName(String username) {
		return getHibernateTemplate().find(
				"from User users where users.username = ?", username);
	}

	@SuppressWarnings("unchecked")
	public List<User> listAll() {
		return getHibernateTemplate().find("from User");
	}

}