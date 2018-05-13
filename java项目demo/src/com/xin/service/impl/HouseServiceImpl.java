package com.xin.service.impl;

import java.util.List;

import com.xin.dao.HouseDao;
import com.xin.dao.impl.HouseDaoImpl;
import com.xin.domain.HouseRecord;
import com.xin.service.HouseService;

public class HouseServiceImpl implements HouseService {

	public boolean add(HouseRecord houseRecord) {
	    HouseDao houseDao=new HouseDaoImpl();
		return houseDao.add(houseRecord);
	}

	public List<HouseRecord> query() {
		
		HouseDao houseDao=new HouseDaoImpl();
		return houseDao.query();
	}

	public boolean delete(int homeid) {
		
		HouseDao houseDao=new HouseDaoImpl();
		return houseDao.delete(homeid);
	}

}
