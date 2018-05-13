package com.xin.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.xin.dao.UserDao;
import com.xin.dao.impl.UserDaoImpl;
import com.xin.domain.User;

public class UserDaoTest {
	
	@Test
	public void testFind(){
		UserDao userDao = new UserDaoImpl();
		userDao.find("abc", "123");
	}

	@Test
	public void testAdd(){
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setUsername("john");
		user.setPassword("john");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = sdf.parse("1949-10-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		user.setBirthday(birthday);
		userDao.add(user);
	}
}
