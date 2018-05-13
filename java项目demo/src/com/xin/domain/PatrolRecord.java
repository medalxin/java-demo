package com.xin.domain;

import java.util.Date;

public class PatrolRecord {
	private int id;
	private String workId;
	private String patrolArea;
	private String patrolPerson;
	private Date patrolTime;
	private String patrolResult;
	public PatrolRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatrolRecord(int id, String workId, String patrolArea,
			String patrolPerson, Date patrolTime, String patrolResult) {
		super();
		this.id = id;
		this.workId = workId;
		this.patrolArea = patrolArea;
		this.patrolPerson = patrolPerson;
		this.patrolTime = patrolTime;
		this.patrolResult = patrolResult;
	}
	@Override
	public String toString() {
		return "PatrolRecord [id=" + id + ", workId=" + workId
				+ ", patrolArea=" + patrolArea + ", patrolPerson="
				+ patrolPerson + ", patrolTime=" + patrolTime
				+ ", patrolResult=" + patrolResult + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	public String getPatrolArea() {
		return patrolArea;
	}
	public void setPatrolArea(String patrolArea) {
		this.patrolArea = patrolArea;
	}
	public String getPatrolPerson() {
		return patrolPerson;
	}
	public void setPatrolPerson(String patrolPerson) {
		this.patrolPerson = patrolPerson;
	}
	public Date getPatrolTime() {
		return patrolTime;
	}
	public void setPatrolTime(Date patrolTime) {
		this.patrolTime = patrolTime;
	}
	public String getPatrolResult() {
		return patrolResult;
	}
	public void setPatrolResult(String patrolResult) {
		this.patrolResult = patrolResult;
	}


}
