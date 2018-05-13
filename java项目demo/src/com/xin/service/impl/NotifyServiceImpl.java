package com.xin.service.impl;




import java.util.List;

import com.xin.dao.NotifyDao;
import com.xin.dao.impl.NotifyDaoImpl;
import com.xin.domain.NotifyRecord;
import com.xin.service.NotifyService;

public  class NotifyServiceImpl implements NotifyService{

	public boolean add(NotifyRecord notifyRecord) {
		NotifyDao notifyDao = new NotifyDaoImpl();
		return notifyDao.add(notifyRecord);	
	}

	public List<NotifyRecord> query() {
		NotifyDao notifyDao = new NotifyDaoImpl();
		return notifyDao.query();
	}

	public boolean delete(String notify_id) {
		NotifyDao notifyDao = new NotifyDaoImpl();
		return notifyDao.delete(notify_id);
		
	}
}
