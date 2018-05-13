package com.xin.dao;

import java.util.List;

import com.xin.domain.GuardRecord;

public interface GuardDao {
	public abstract boolean add(GuardRecord guardRecord);
	public abstract List<GuardRecord> query();
	public abstract boolean delete(int guardid);

}
