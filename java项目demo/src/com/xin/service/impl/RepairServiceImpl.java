package com.xin.service.impl;

import java.util.List;

import com.xin.dao.RepairDao;
import com.xin.dao.impl.RepairDaoImpl;
import com.xin.domain.RepairRecord;
import com.xin.service.RepairService;

public class RepairServiceImpl implements RepairService{

	public boolean add(RepairRecord repairRecord) {
		RepairDao repairDao = new RepairDaoImpl();
		return repairDao.add(repairRecord);
	}

	public List<RepairRecord> query() {
		RepairDao repairDao = new RepairDaoImpl();
		return repairDao.query();
	}

	public boolean delete(int id) {
		RepairDao repairDao = new RepairDaoImpl();
		return repairDao.delete(id);
	}

}
