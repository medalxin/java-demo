package com.xin.dao;

import com.xin.domain.User;

public interface UserDao {

	public abstract User find(String username, String password);
	public abstract User findS(String username, String password,String status);
	public abstract boolean add(User user);
	public abstract boolean modify(User user);

}