package com.xin.service;

import java.util.List;

import com.xin.domain.GuardRecord;

public interface GuardService {
	public abstract boolean add(GuardRecord guardRecord);
	public abstract List<GuardRecord> query();
	public abstract boolean delete(int guardid);

}
