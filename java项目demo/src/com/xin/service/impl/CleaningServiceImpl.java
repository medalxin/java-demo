package com.xin.service.impl;

import java.util.List;

import com.xin.dao.CleaningDao;
import com.xin.dao.impl.CleaningDaoImpl;
import com.xin.domain.CleaningRecord;
import com.xin.service.CleaningService;


public class CleaningServiceImpl implements CleaningService{

	public boolean add(CleaningRecord cleaningRecord) {
		CleaningDao cleaningDao = new CleaningDaoImpl();
		return cleaningDao.add(cleaningRecord);
	}

	public List<CleaningRecord> query() {
		CleaningDao cleaningDao = new CleaningDaoImpl();
		return cleaningDao.query();
	}

	public boolean delete(int id) {
		CleaningDao cleaningDao = new CleaningDaoImpl();
		return cleaningDao.delete(id);
	}

}
