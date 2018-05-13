package com.xin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xin.dao.CleaningDao;
import com.xin.domain.CleaningRecord;
import com.xin.utils.DBConnection;

public class CleaningDaoImpl implements CleaningDao{

	public boolean add(CleaningRecord cleaningRecord) {
		
		String sql = "insert into cleaning_record(cleaningSite,cleaningTime,cleaning,cleaningTel,cleaningRemarks) values(?,?,?,?,?)";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setString(1, cleaningRecord.getCleaningSite());
			pstmt.setString(2, cleaningRecord.getCleaningTime());
			pstmt.setString(3, cleaningRecord.getCleaning());
			pstmt.setString(4, cleaningRecord.getCleaningTel());
			pstmt.setString(5, cleaningRecord.getCleaningRemarks());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(null, pstmt, conn);
		}
		
		return false;
	}

	public List<CleaningRecord> query() {
		String sql = "select * from cleaning_record";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		ResultSet rs = null;
		List<CleaningRecord> cleaningRecordList = new ArrayList<CleaningRecord>();
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				CleaningRecord cleaningRecord = new CleaningRecord();
				cleaningRecord.setId(rs.getInt("id"));
				cleaningRecord.setCleaningSite(rs.getString("cleaningSite"));
				cleaningRecord.setCleaningTime(rs.getString("cleaningTime"));	
				cleaningRecord.setCleaning(rs.getString("cleaning"));
				cleaningRecord.setCleaningTel(rs.getString("cleaningTel"));
				cleaningRecord.setCleaningRemarks(rs.getString("cleaningTel"));
				cleaningRecordList.add(cleaningRecord);
			}
			return cleaningRecordList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int id) {
		String sql = "delete from cleaning_record where id=?";
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
