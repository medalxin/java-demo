package com.xin.service;

import java.util.List;

import com.xin.domain.CostRecord;

public interface CostService {
	public abstract boolean add(CostRecord costRecord);
	public abstract List<CostRecord> query();
	public abstract boolean delete(int costid);
}
