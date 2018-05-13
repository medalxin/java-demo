package com.xin.service.impl;

import java.util.List;

import com.xin.dao.ComplaintDao;
import com.xin.dao.impl.ComplaintDaoImpl;
import com.xin.domain.ComplaintRecord;
import com.xin.service.ComplaintService;

public class ComplaintServiceImpl implements ComplaintService{

	public boolean add(ComplaintRecord complaintRecord) {
		ComplaintDao complaintDao = new ComplaintDaoImpl();
		return complaintDao.add(complaintRecord);
	}

	public List<ComplaintRecord> query() {
		ComplaintDao complaintDao = new ComplaintDaoImpl();
		return complaintDao.query();
	}

	public boolean delete(int id) {
		ComplaintDao complaintDao = new ComplaintDaoImpl();
		return complaintDao.delete(id);
	}

}
