package com.spring.cloud.userservice;

import java.util.ArrayList;
import java.util.List;

public class Result {
	List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
