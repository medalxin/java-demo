package com.xin.domain;

import java.util.Date;

public class User {

	private int id;
	private String username;
	private String password;
	private Date birthday;
	private String status;
	
	public User() {
	}

	public User(int id, String username, String password, Date birthday,
			String status) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", birthday=" + birthday + ", status=" + status
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
