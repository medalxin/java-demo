package com.xin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xin.dao.RepairDao;
import com.xin.domain.RepairRecord;
import com.xin.utils.DBConnection;

public class RepairDaoImpl implements RepairDao{

	public boolean add(RepairRecord repairRecord) {
		
		String sql = "insert into repair_record(recordTime,content,house) values(?,?,?)";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(2, repairRecord.getContent());
			pstmt.setString(3, repairRecord.getHouse());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(null, pstmt, conn);
		}
		
		return false;
	}

	public List<RepairRecord> query() {
		String sql = "select * from repair_record";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		ResultSet rs = null;
		List<RepairRecord> repairRecordList = new ArrayList<RepairRecord>();
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				RepairRecord repairRecord = new RepairRecord();
				repairRecord.setId(rs.getInt("id"));
				repairRecord.setHouse(rs.getString("house"));
				repairRecord.setContent(rs.getString("content"));
				repairRecord.setRecordTime(rs.getTimestamp("recordTime"));
				repairRecordList.add(repairRecord);
			}
			return repairRecordList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int id) {
		String sql = "delete from repair_record where id=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
