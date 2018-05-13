package com.xin.service.impl;

import java.util.List;

import com.xin.dao.GuardDao;
import com.xin.dao.impl.GuardDaoImpl;
import com.xin.domain.GuardRecord;
import com.xin.service.GuardService;

public class GuardServiceImpl implements GuardService{

	public boolean add(GuardRecord guardRecord) {
		GuardDao guardDao = new GuardDaoImpl();
		return guardDao.add(guardRecord);
	}

	public List<GuardRecord> query() {
		GuardDao guardDao = new GuardDaoImpl();
		return guardDao.query();
	}

	public boolean delete(int guardid) {
		GuardDao guardDao = new GuardDaoImpl();
		return guardDao.delete(guardid);
	}

}
