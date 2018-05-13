package com.xin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xin.dao.ComplaintDao;
import com.xin.domain.ComplaintRecord;
import com.xin.utils.DBConnection;

public class ComplaintDaoImpl implements ComplaintDao{

	public boolean add(ComplaintRecord complaintRecord) {
		
		String sql = "insert into complaint_record(complaintTime,content,complaintPerson) values(?,?,?)";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(2, complaintRecord.getContent());
			pstmt.setString(3, complaintRecord.getComplaintPerson());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(null, pstmt, conn);
		}
		
		return false;
	}

	public List<ComplaintRecord> query() {
		String sql = "select * from complaint_record";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		ResultSet rs = null;
		List<ComplaintRecord> complaintRecordList = new ArrayList<ComplaintRecord>();
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				ComplaintRecord complaintRecord = new ComplaintRecord();
				complaintRecord.setId(rs.getInt("id"));
				complaintRecord.setComplaintPerson(rs.getString("complaintPerson"));
				complaintRecord.setContent(rs.getString("content"));
				complaintRecord.setcomplaintTime(rs.getTimestamp("complaintTime"));
				complaintRecordList.add(complaintRecord);
			}
			return complaintRecordList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int id) {
		String sql = "delete from complaint_record where id=?";
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
