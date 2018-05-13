package com.xin.dao;

import java.util.List;

import com.xin.domain.PatrolRecord;

public interface PatrolDao {
	public abstract boolean add(PatrolRecord PatrolRecord);
	public abstract List<PatrolRecord> query();
	public abstract boolean delete(int id);

}
