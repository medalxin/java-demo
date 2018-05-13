package com.xin.dao;

import java.util.List;

import com.xin.domain.CostRecord;

public interface CostDao {
	public abstract boolean add(CostRecord costRecord);
	public abstract List<CostRecord> query();
	public abstract boolean delete(int costid);
}
