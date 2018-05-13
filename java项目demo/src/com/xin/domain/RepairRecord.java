package com.xin.domain;

import java.util.Date;

public class RepairRecord {
	private int id;
	private Date recordTime;
	private Date repairTime;
	private String content;
	private String house;

	public RepairRecord() {
	}

	public RepairRecord(int id, String content, String house) {
		this.id = id;
		this.content = content;
		this.house = house;
	}

	@Override
	public String toString() {
		return "RepairRecord [id=" + id + ", recordTime=" + recordTime
				+ ", repairTime=" + repairTime + ", content=" + content
				+ ", recordPerson=" + house + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public Date getRepairTime() {
		return repairTime;
	}

	public void setRepairTime(Date repairTime) {
		this.repairTime = repairTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

}
