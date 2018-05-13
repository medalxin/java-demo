package com.xin.service;

import java.util.List;

import com.xin.domain.HouseRecord;

public interface HouseService {
    public abstract boolean add(HouseRecord houseRecord);
    public abstract List<HouseRecord> query();
    public abstract boolean delete(int homeid);
}
