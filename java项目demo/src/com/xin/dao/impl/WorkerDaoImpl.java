package com.xin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xin.dao.WorkerDao;
import com.xin.domain.Worker;
import com.xin.utils.DBConnection;

public class WorkerDaoImpl implements WorkerDao {


	public boolean add(Worker worker) {
		String sql = "insert into worker(worker_id,worker_name,worker_sex,worker_age,worker_tel,office_tel,worker_memo,ID,position,worker_password) values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setString(1, worker.getWorker_id());
			pstmt.setString(2, worker.getWorker_name());
			pstmt.setString(3, worker.getWorker_sex());
			pstmt.setString(4, worker.getWorker_age());
			pstmt.setString(5, worker.getWorker_tel());
			pstmt.setString(6, worker.getOffice_tel());
			pstmt.setString(7, worker.getWorker_memo());
			pstmt.setString(8, worker.getId());
			pstmt.setString(9, worker.getPosition());
			pstmt.setString(10, worker.getWorker_password());	
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(null, pstmt, conn);
		}
		return false;
	}


	public List<Worker> query() {
		String sql = "select * from worker";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		ResultSet rs = null;
		List<Worker> workerList = new ArrayList<Worker>();
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				Worker worker = new Worker();
				worker.setId(rs.getString("id"));
				worker.setOffice_tel(rs.getString("office_tel"));
				worker.setPosition(rs.getString("Position"));
				worker.setWorker_age(rs.getString("worker_age"));
				worker.setWorker_id(rs.getString("worker_id"));
				worker.setWorker_memo(rs.getString("worker_memo"));
				worker.setWorker_name(rs.getString("worker_name"));
				worker.setWorker_password(rs.getString("worker_password"));
				worker.setWorker_sex(rs.getString("worker_sex"));
				worker.setWorker_tel(rs.getString("worker_tel"));
				workerList.add(worker);
			}
			return workerList;
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return null;
	}

	public boolean delete(String worker_id) {
		String sql = "delete from worker where worker_id=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = DBConnection.createPreparedStatement(conn, sql);
		try {
			pstmt.setString(1, worker_id);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}

}
