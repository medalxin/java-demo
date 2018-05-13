package com.xin.service.impl;

import java.util.List;








import com.xin.dao.ParkingpotDao;
import com.xin.dao.impl.ParkingpotDaoImpl;
import com.xin.domain.ParkingpotRecord;
import com.xin.service.ParkingpotService;


public class ParkingpotServiceImpl implements ParkingpotService{

	public boolean add(ParkingpotRecord parkingpotRecord) {
		ParkingpotDao parkingpotDao = new ParkingpotDaoImpl();
		return parkingpotDao.add(parkingpotRecord);
	}

	public List<ParkingpotRecord> query() {
		ParkingpotDao parkingpotDao = new ParkingpotDaoImpl();
		return parkingpotDao.query();
	}

	public boolean delete(int id) {
		ParkingpotDao parkingpotDao = new ParkingpotDaoImpl();
		return parkingpotDao.delete(id);
	}

}
