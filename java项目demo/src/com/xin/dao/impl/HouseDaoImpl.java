package com.xin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xin.dao.HouseDao;
import com.xin.domain.HouseRecord;
import com.xin.utils.DBConnection;

public class HouseDaoImpl implements HouseDao {

	public boolean add(HouseRecord houseRecord) {
	
		String sql = "insert into house_record(customerid,homezone,homebuilding,homeunit,homenumber,homearea,hometype,homememeo) values(?,?,?,?,?,?,?,?)";
		System.out.println(houseRecord.toString());
		Connection conn =DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setString(1, houseRecord.getCustomerid());
			 pstmt.setString(2, houseRecord.getHomezone());
			 pstmt.setString(3, houseRecord.getHomebuilding());
			 pstmt.setString(4, houseRecord.getHomeunit());
			 pstmt.setString(5, houseRecord.getHomenumber());
		     pstmt.setString(6, houseRecord.getHomearea());
		     pstmt.setString(7, houseRecord.getHometype());
		     pstmt.setString(8, houseRecord.getHomememeo());
		    
			 pstmt.executeUpdate();
			 return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBConnection.close(null,pstmt,conn);
		}
		
		
		return false;
	}

	public List<HouseRecord> query() {
		
		String sql = "select * from house_record";
		
		Connection conn =DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		ResultSet rs=null;
		List<HouseRecord> houseRecordList=new ArrayList<HouseRecord>();
		try {
			rs=pstmt.executeQuery();
			while(rs.next()){
				HouseRecord houseRecord=new HouseRecord();
				houseRecord.setHomeid(rs.getInt("homeid"));
				houseRecord.setCustomerid(rs.getString("customerid"));
				houseRecord.setHomezone(rs.getString("homezone"));
				houseRecord.setHomebuilding(rs.getString("homebuilding"));
				houseRecord.setHomeunit(rs.getString("homeunit"));
				houseRecord.setHomearea(rs.getString("homearea"));
				houseRecord.setHometype(rs.getString("hometype"));
				houseRecord.setHomenumber(rs.getString("homenumber"));
				houseRecord.setHomememeo(rs.getString("homememeo"));
				houseRecordList.add(houseRecord);	
				
			}
			return houseRecordList;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int homeid) {
		
String sql = "delete from house_record where homeid=?";
		
		Connection conn =DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
	
		List<HouseRecord> houseRecordList=new ArrayList<HouseRecord>();
		try {
			pstmt.setInt(1,homeid);
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return false;
	}

}
