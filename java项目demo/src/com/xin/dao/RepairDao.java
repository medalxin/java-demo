package com.xin.dao;

import java.util.List;

import com.xin.domain.RepairRecord;

public interface RepairDao {
	public abstract boolean add(RepairRecord repairRecord);
	public abstract List<RepairRecord> query();
	public abstract boolean delete(int id);

}
