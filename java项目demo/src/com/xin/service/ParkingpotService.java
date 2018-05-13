package com.xin.service;

import java.util.List;

import com.xin.domain.ParkingpotRecord;

public interface ParkingpotService {
	public abstract boolean add(ParkingpotRecord parkingpotRecord);
	public abstract List<ParkingpotRecord> query();
	public abstract boolean delete(int id);

}
