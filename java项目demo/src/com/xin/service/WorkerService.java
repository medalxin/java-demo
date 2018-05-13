package com.xin.service;

import java.util.List;

import com.xin.domain.Worker;

public interface WorkerService {
   

	public abstract boolean add(Worker worker);
	public abstract List<Worker> query();
	public abstract boolean delete(String worker_id);
}
