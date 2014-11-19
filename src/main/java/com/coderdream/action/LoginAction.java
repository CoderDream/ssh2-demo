package com.coderdream.action;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.coderdream.model.User;
import com.coderdream.service.UserService;
import com.coderdream.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private UserService userService;
	private User user;

	public LoginAction() {
		ApplicationContext context = InitApplicationContext
				.getApplicationContext();
		userService = (UserService) context.getBean("userService");
	}

	@Override
	public String execute() throws Exception {
		if (user == null) {
			return INPUT;
		}

		if (!isValid(user.getUsername())) {
			return INPUT;
		}
		if (!isValid(user.getPassword())) {
			return INPUT;
		}
		if (!userCheck(user)) {
			return INPUT;
		} else {
			ActionContext actionContext = ActionContext.getContext();
			@SuppressWarnings("unchecked")
			Map<String, Object> request = (Map<String, Object>) actionContext
					.get("request");
			request.put("user", user);
			Map<String, Object> session = actionContext.getSession();
			session.put("user", user);
		}
		return SUCCESS;
	}

	public boolean isValid(String keyword) {
		return keyword != null && keyword != "";
	}

	public boolean userCheck(User user) {
		List<User> userList = userService.findUserByName(user.getUsername());
		if (userList == null || userList.size() < 1) {
			return false;
		}
		User checkUser = userList.get(0);
		if (user.getUsername().equals(checkUser.getUsername())
				&& user.getPassword().equals(checkUser.getPassword())) {
			return true;
		}
		addActionError("Username or password is wrong, please check!");
		return false;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}