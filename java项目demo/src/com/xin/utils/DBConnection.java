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
	
	//��ȡ�����ļ�
	public static void loadProperties(){
		Properties pros = new Properties();
		try {
			pros.load(DBConnection.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//��properties�ļ��ж�ȡ���ݲ���ֵ
		dbDriver = (String) pros.get("dbDriver");
		url = (String) pros.get("url");
		usr = (String) pros.get("usr");
		pwd = (String) pros.get("pwd");
	}
	
	//��ȡ���ݿ�����
	public static Connection getConnection(){
		//��properties�����ļ�
		loadProperties();
		Connection conn = null;
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(url, usr, pwd);//�������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//��ȡStatement����
	public static Statement createStatement(Connection conn){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	//��ȡPreparedStatement����
	public static PreparedStatement createPreparedStatement(Connection conn,String sql){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	//�ر�ResultSet
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
	
	//�ر�PreparedStatement
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
	
	//�ر�Statement
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
	
	//�ر�Connection����
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
	
	////�ر����ж���
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
