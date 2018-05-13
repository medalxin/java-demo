package com.xin.dao;

import java.util.List;

import com.xin.domain.ComplaintRecord;

public interface ComplaintDao {
	public abstract boolean add(ComplaintRecord complaintRecord);
	public abstract List<ComplaintRecord> query();
	public abstract boolean delete(int id);

}
