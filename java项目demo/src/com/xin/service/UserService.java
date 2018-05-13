package com.xin.service;

import com.xin.domain.User;

public interface UserService {

	public abstract User login(String username, String password,String status);
	public abstract boolean register(User user);
	public abstract boolean modifyUserInf(User user);

}