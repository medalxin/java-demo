package com.xin.domain;

import java.util.Date;

public class ComplaintRecord {
	private int id;
	private Date complaintTime;
	private Date resolveTime;
	private String content;
	private String complaintPerson;

	public ComplaintRecord() {
	}

	public ComplaintRecord(int id, String content, String complaintPerson) {
		this.id = id;
		this.content = content;
		this.complaintPerson = complaintPerson;
	}

	@Override
	public String toString() {
		return "complaintRecord [id=" + id + ", complaintTime=" + complaintTime
				+ ", resolveTime=" + resolveTime + ", content=" + content
				+ ", complaintPerson=" + complaintPerson + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getcomplaintTime() {
		return complaintTime;
	}

	public void setcomplaintTime(Date complaintTime) {
		this.complaintTime = complaintTime;
	}

	public Date getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(Date resolveTime) {
		this.resolveTime = resolveTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComplaintPerson() {
		return complaintPerson;
	}

	public void setComplaintPerson(String complaintPerson) {
		this.complaintPerson = complaintPerson;
	}

}
