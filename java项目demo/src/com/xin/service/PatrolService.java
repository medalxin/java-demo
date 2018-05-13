package com.xin.service;

import java.util.List;

import com.xin.domain.PatrolRecord;

public interface PatrolService {
	public abstract boolean add(PatrolRecord patrolRecord);
	public abstract List<PatrolRecord> query();
	public abstract boolean delete(int id);

}
