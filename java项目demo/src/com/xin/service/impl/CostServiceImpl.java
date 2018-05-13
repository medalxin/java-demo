package com.xin.service.impl;

import java.util.List;

import com.xin.dao.CostDao;
import com.xin.dao.impl.CostDaoImpl;
import com.xin.domain.CostRecord;
import com.xin.service.CostService;



    public class CostServiceImpl implements CostService{

	public boolean add(CostRecord costRecord) {
		CostDao costDao = new CostDaoImpl();
		return costDao.add(costRecord);
	}

	public List<CostRecord> query() {
		CostDao costDao = new CostDaoImpl();
		return costDao.query();
	}

	public boolean delete(int costid) {
		CostDao costDao = new CostDaoImpl();
		return costDao.delete(costid);
	}

}
