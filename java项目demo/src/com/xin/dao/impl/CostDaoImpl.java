package com.xin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xin.dao.CostDao;
import com.xin.domain.CostRecord;
import com.xin.utils.DBConnection;

public class CostDaoImpl implements CostDao{

	public boolean add(CostRecord costRecord) {
		
		String sql = "insert into cost (customerid,cost,costdate,money,costmemo) values(?,?,?,?,?)";
		  
		   Connection conn = DBConnection.getConnection();
		   PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		   try {
			pstmt.setString(1, costRecord.getCustomerid());
			pstmt.setString(2, costRecord.getCost());
			pstmt.setTimestamp(3,new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(4, costRecord.getMoney());
			pstmt.setString(5, costRecord.getCostmemo());
			pstmt.executeUpdate();
		    return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
	   }finally{
			DBConnection.close(null,pstmt,conn);
		 }
		 return false;
		
	}

	public List<CostRecord> query() {
		String sql = "select * from cost";
		  
		   Connection conn = DBConnection.getConnection();
		   PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		   ResultSet rs = null;
		   List<CostRecord> costRecordList = new ArrayList<CostRecord>();
		   try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				CostRecord costRecord = new CostRecord();
				costRecord.setCostid(rs.getInt("costid"));
				costRecord.setCustomerid(rs.getString("customerid"));
				costRecord.setCost(rs.getString("cost"));
				costRecord.setCostdate(rs.getDate("costdate"));
				costRecord.setMoney(rs.getString("money"));
				
				costRecord.setCostmemo(rs.getString("costmemo"));
				costRecordList.add(costRecord);
				
			}
			return costRecordList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   return null;
	}

	public boolean delete(int costid) {
		String sql = "delete from cost where costid=?";
		  
		   Connection conn = DBConnection.getConnection();
		   PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		   try {
			   pstmt.setInt(1,costid);
			   pstmt.executeUpdate();
			 
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   return false;
	}

}
