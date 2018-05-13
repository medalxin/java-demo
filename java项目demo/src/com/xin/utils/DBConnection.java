package com.xin.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
//	private String dbDriver = "com.mysql.jdbc.Driver";
//	private String url = "jdbc:mysql://192.168.1.10:3306/helloworld?useUnicode=true&characterEncoding=UTF-8";
//	private String usr = "root";
//	private String pwd = "mysql";
	private static String dbDriver = null;
	private static String url = null;
	private static String usr = null;
	private static String pwd = null;
	
	//读取配置文件
	public static void loadProperties(){
		Properties pros = new Properties();
		try {
			pros.load(DBConnection.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//从properties文件中读取数据并赋值
		dbDriver = (String) pros.get("dbDriver");
		url = (String) pros.get("url");
		usr = (String) pros.get("usr");
		pwd = (String) pros.get("pwd");
	}
	
	//获取数据库连接
	public static Connection getConnection(){
		//读properties配置文件
		loadProperties();
		Connection conn = null;
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(url, usr, pwd);//获得连接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//获取Statement对象
	public static Statement createStatement(Connection conn){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	//获取PreparedStatement对象
	public static PreparedStatement createPreparedStatement(Connection conn,String sql){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	//关闭ResultSet
	public static void closeResultSet(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		rs=null;
	}
	
	//关闭PreparedStatement
	public static void closePreparedStatement(PreparedStatement pstmt){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		pstmt=null;
	}
	
	//关闭Statement
	public static void closeStatement(Statement stmt){
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		stmt=null;
	}
	
	//关闭Connection对象
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		conn=null;
	}
	
	////关闭所有对象
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				rs = null;
			}
		}
		
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				pstmt = null;
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				conn = null;
			}
		}
	}
	
	
	public static void close(ResultSet rs,Statement stmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				rs = null;
			}
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				stmt = null;
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				conn = null;
			}
		}
	}
}
