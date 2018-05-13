package com.xin.service.impl;

import com.xin.dao.UserDao;
import com.xin.dao.impl.UserDaoImpl;
import com.xin.domain.User;
import com.xin.service.UserService;

public class UserServiceImpl implements UserService {
	
	public User login(String username,String password,String status){
		UserDao userDao = new UserDaoImpl();
		return userDao.findS(username, password,status);
	}
	
	public boolean register(User user){
		UserDao userDao = new UserDaoImpl();
		return userDao.add(user);
	}

	public boolean modifyUserInf(User user) {
		UserDao userDao = new UserDaoImpl();
		return userDao.modify(user);
	}

}
