package com.xin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xin.dao.GuardDao;
import com.xin.domain.GuardRecord;
import com.xin.utils.DBConnection;

public class GuardDaoImpl implements GuardDao{

	public boolean add(GuardRecord guardRecord) {
		
		String sql = "insert into guard_record(workerid,guardcon,personname,guarddate) values(?,?,?,?)";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
		
			pstmt.setString(1, guardRecord.getWorkerid());
			pstmt.setString(2, guardRecord.getGuardcon());
			pstmt.setString(3, guardRecord.getPersonname());
			pstmt.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));

			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(null, pstmt, conn);
		}
		
		return false;
	}

	public List<GuardRecord> query() {
		String sql = "select * from guard_record";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		ResultSet rs = null;
		List<GuardRecord> guardRecordList = new ArrayList<GuardRecord>();
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				GuardRecord guardRecord = new GuardRecord();
				guardRecord.setGuardid(rs.getInt("guardid"));
				guardRecord.setWorkerid(rs.getString("workerid"));
				guardRecord.setGuardcon(rs.getString("guardcon"));
				guardRecord.setPersonname(rs.getString("personname"));
				guardRecord.setGuarddate(rs.getTimestamp("guarddate"));

				guardRecordList.add(guardRecord);
			}
			return guardRecordList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int guardid) {
		String sql = "delete from guard_record where guardid=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setInt(1, guardid);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
