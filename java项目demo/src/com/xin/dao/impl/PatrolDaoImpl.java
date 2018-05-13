package com.xin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xin.dao.PatrolDao;
import com.xin.domain.PatrolRecord;
import com.xin.utils.DBConnection;

public class PatrolDaoImpl implements PatrolDao{

	public boolean add(PatrolRecord patrolRecord) {
		
		String sql = "insert into patrol_record(workId,patrolArea,patrolPerson,patrolTime,patrolResult) values(?,?,?,?,?)";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			
			pstmt.setString(1, patrolRecord.getWorkId());
			pstmt.setString(2, patrolRecord.getPatrolArea());
			pstmt.setString(3, patrolRecord.getPatrolPerson());
			pstmt.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(5, patrolRecord.getPatrolResult());
			//pstmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(null, pstmt, conn);
		}
		
		return false;
	}

	public List<PatrolRecord> query() {
		String sql = "select * from patrol_record";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		ResultSet rs = null;
		List<PatrolRecord> patrolRecordList = new ArrayList<PatrolRecord>();
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				PatrolRecord patrolRecord = new PatrolRecord();
				patrolRecord.setId(rs.getInt("id"));
				patrolRecord.setWorkId(rs.getString("workId"));
				patrolRecord.setPatrolArea(rs.getString("patrolArea"));
				patrolRecord.setPatrolPerson(rs.getString("PatrolPerson"));
				patrolRecord.setPatrolTime(rs.getTimestamp("patrolTime"));
				patrolRecord.setPatrolResult(rs.getString("PatrolResult"));
				patrolRecordList.add(patrolRecord);
			}
			return patrolRecordList;
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int id) {
		String sql = "delete from patrol_record where id=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
