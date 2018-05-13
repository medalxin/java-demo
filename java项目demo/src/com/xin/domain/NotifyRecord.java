package com.xin.domain;

import java.util.Date;

public class NotifyRecord {
	private String notify_id;
    private String worker_id;
    private String notify_con;
    private Date notify_date;
    private String notify_title;
	public NotifyRecord() {
	}
	public NotifyRecord(String notify_id, String worker_id, String notify_con,
			Date notify_date, String notify_title) {
		super();
		this.notify_id = notify_id;
		this.worker_id = worker_id;
		this.notify_con = notify_con;
		this.notify_date = notify_date;
		this.notify_title = notify_title;
	}
	@Override
	public String toString() {
		return "Notify [notify_id=" + notify_id + ", worker_id=" + worker_id
				+ ", notify_con=" + notify_con + ", notify_date=" + notify_date
				+ ", notify_title=" + notify_title + "]";
	}
	public String getNotify_id() {
		return notify_id;
	}
	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}
	public String getWorker_id() {
		return worker_id;
	}
	public void setWorker_id(String worker_id) {
		this.worker_id = worker_id;
	}
	public String getNotify_con() {
		return notify_con;
	}
	public void setNotify_con(String notify_con) {
		this.notify_con = notify_con;
	}
	public Date getNotify_date() {
		return notify_date;
	}
	public void setNotify_date(Date notify_date) {
		this.notify_date = notify_date;
	}
	public String getNotify_title() {
		return notify_title;
	}
	public void setNotify_title(String notify_title) {
		this.notify_title = notify_title;
	}
	
	
	
	
}
