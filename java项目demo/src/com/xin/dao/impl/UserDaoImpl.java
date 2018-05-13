package com.xin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xin.dao.UserDao;
import com.xin.domain.User;
import com.xin.utils.DBConnection;

public class UserDaoImpl implements UserDao {
	
	public User find(String username,String password){
		
		User user = null;
		String sql = "select * from user where username=? and password=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		ResultSet rs = null;
		try {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getDate("birthday"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs,pstmt,conn);
		}
		
		return user;
	}
	
    public User findS(String username,String password,String status){
    	User user = null;
		String sql = "select * from user where username='" + username + "' and password='" + password + "' and status='" + status + "'";
		Connection conn = DBConnection.getConnection();
		Statement stmt = DBConnection.createStatement(conn);
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getDate("birthday"));
				user.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs, stmt, conn);
		}
		
		return user;
	}
	
	public boolean add(User user){
		String sql = "insert into user(username,password,birthday,status) values(?,?,?,?)";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			pstmt.setString(4, user.getStatus());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(null, pstmt, conn);
		}
		
		return false;
	}

	public boolean modify(User user) {
		String sql = "update user set username=?, password =?, birthday=? where id=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			pstmt.setInt(4, user.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(null, pstmt, conn);
		}
		
		return false;
	}

}
