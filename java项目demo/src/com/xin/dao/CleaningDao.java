package com.xin.dao;

import java.util.List;

import com.xin.domain.CleaningRecord;

public interface CleaningDao {
	public abstract boolean add(CleaningRecord cleaningRecord);
	public abstract List<CleaningRecord> query();
	public abstract boolean delete(int id);

}
