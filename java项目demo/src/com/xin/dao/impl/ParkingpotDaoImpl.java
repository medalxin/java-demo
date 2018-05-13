package com.xin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xin.dao.ParkingpotDao;
import com.xin.domain.ParkingpotRecord;
import com.xin.utils.DBConnection;

public class ParkingpotDaoImpl implements ParkingpotDao{

	public boolean add(ParkingpotRecord parkingpotRecord) {
		
		String sql = "insert into parkingpot_record(customerid,parkingpotposition) values(?,?)";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setString(1, parkingpotRecord.getCustomerid());
			pstmt.setString(2, parkingpotRecord.getParkingpotposition());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(null, pstmt, conn);
		}
		
		return false;
	}

	public List<ParkingpotRecord> query() {
		String sql = "select * from parkingpot_record";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		ResultSet rs = null;
		List<ParkingpotRecord> parkingpotRecordList = new ArrayList<ParkingpotRecord>();
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				ParkingpotRecord parkingpotRecord = new ParkingpotRecord();
				parkingpotRecord.setParkingpotid(rs.getInt("parkingpotid"));
				parkingpotRecord.setCustomerid(rs.getString("customerid"));
				parkingpotRecord.setParkingpotposition(rs.getString("parkingpotposition"));
				
				parkingpotRecordList.add(parkingpotRecord);
			}
			return parkingpotRecordList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int parkingpotid) {
		String sql = "delete from parkingpot_record where parkingpotid=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setInt(1,parkingpotid);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
