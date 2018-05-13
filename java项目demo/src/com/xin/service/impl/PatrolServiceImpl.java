package com.xin.service.impl;

import java.util.List;

import com.xin.dao.PatrolDao;
import com.xin.dao.impl.PatrolDaoImpl;
import com.xin.domain.PatrolRecord;
import com.xin.service.PatrolService;

public class PatrolServiceImpl implements PatrolService{

	public boolean add(PatrolRecord patrolRecord) {
		PatrolDao patrolDao = new PatrolDaoImpl();
		return patrolDao.add(patrolRecord);
	}

	public List<PatrolRecord> query() {
		PatrolDao patrolDao = new PatrolDaoImpl();
		return patrolDao.query();
	}

	public boolean delete(int id) {
		PatrolDao patrolDao = new PatrolDaoImpl();
		return patrolDao.delete(id);
	}

}
