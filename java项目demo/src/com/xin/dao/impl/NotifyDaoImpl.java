package com.xin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xin.dao.NotifyDao;
import com.xin.domain.NotifyRecord;
import com.xin.utils.DBConnection;

public class NotifyDaoImpl implements NotifyDao {

	public boolean add(NotifyRecord notifyRecord) {
		String sql = "insert into notify(notify_id,worker_id,notify_con,notify_date,notify_title) values(?,?,?,?,?)";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn,
				sql);
		System.out.println(notifyRecord.toString());
		try {
			pstmt.setString(1, notifyRecord.getNotify_id());
			pstmt.setString(2, notifyRecord.getWorker_id());
			pstmt.setString(3, notifyRecord.getNotify_con());
			pstmt.setDate(4, new java.sql.Date(notifyRecord.getNotify_date()
					.getTime()));
			pstmt.setString(5, notifyRecord.getNotify_title());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(null, pstmt, conn);
		}
		return false;
	}

	public List<NotifyRecord> query() {
		String sql = "select * from notify";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn,sql);
		ResultSet rs = null;
		List<NotifyRecord> notifyRecordList = new ArrayList<NotifyRecord>();
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				NotifyRecord notifyRecord = new NotifyRecord();
				notifyRecord.setNotify_id(rs.getString("notify_id"));
				notifyRecord.setWorker_id(rs.getString("worker_id"));
				notifyRecord.setNotify_con(rs.getString("notify_con"));
				notifyRecord.setNotify_date(rs.getDate("notify_date"));
				notifyRecord.setNotify_title(rs.getString("notify_title"));
				notifyRecordList.add(notifyRecord);
				System.out.println(notifyRecord.getNotify_id()+"......."+notifyRecord.getNotify_title());
			}
			return notifyRecordList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean delete(String notify_id) {
		String sql = "delete from notify where notify_id=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn,sql);
		try {
			pstmt.setString(1, notify_id);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}