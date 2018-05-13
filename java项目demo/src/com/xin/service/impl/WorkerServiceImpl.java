package com.xin.service.impl;

import java.util.List;

import com.xin.dao.WorkerDao;
import com.xin.dao.impl.WorkerDaoImpl;
import com.xin.domain.Worker;
import com.xin.service.WorkerService;

public class WorkerServiceImpl implements WorkerService {
	public boolean add(Worker worker) {
		WorkerDao workerDao = new WorkerDaoImpl();
		return workerDao.add(worker);
	}


	public List<Worker> query() {
		WorkerDao workerDao = new WorkerDaoImpl();
		return workerDao.query();
	}

	
	public boolean delete(String worker_id) {
		WorkerDao workerDao = new WorkerDaoImpl();
		return workerDao.delete(worker_id);
	}
	
	
}
