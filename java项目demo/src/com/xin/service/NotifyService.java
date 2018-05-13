package com.xin.service;


import java.util.List;




import com.xin.domain.NotifyRecord;

public interface NotifyService {
	public abstract boolean add(NotifyRecord notifyRecord);
	public abstract List<NotifyRecord> query();
	public abstract boolean delete(String notify_id);
}
