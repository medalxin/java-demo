package com.xin.dao;

import java.util.List;

import com.xin.domain.Worker;


public interface WorkerDao {
     public abstract boolean add(Worker worker);
     public abstract List<Worker> query();
	public abstract boolean delete(String worker_id);
}
