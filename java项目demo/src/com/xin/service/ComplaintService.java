package com.xin.service;

import java.util.List;

import com.xin.domain.ComplaintRecord;

public interface ComplaintService {
	public abstract boolean add(ComplaintRecord complaintRecord);
	public abstract List<ComplaintRecord> query();
	public abstract boolean delete(int id);

}
