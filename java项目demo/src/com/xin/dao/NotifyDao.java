package com.xin.dao;

import java.util.List;



import com.xin.domain.NotifyRecord;

public interface NotifyDao {
	public abstract boolean add(NotifyRecord notifyRecord);
	public abstract List<NotifyRecord> query();
	public abstract boolean delete(String notify_id);
}
