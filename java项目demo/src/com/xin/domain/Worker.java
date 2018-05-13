package com.xin.domain;

public class Worker {
	private String id;
	private String worker_name;
	private String worker_password;
	private String worker_tel;
	private String worker_sex;
	private String worker_memo;
	private String office_tel;
	private String position;
	private String worker_id;
	private String worker_age;
	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Worker(String id, String worker_name, String worker_password, String worker_tel,
			String worker_sex, String worker_memo, String office_tel,
			String position, String worker_id, String worker_age) {
		super();
		this.id = id;
		this.worker_name = worker_name;
		this.worker_password = worker_password;
		this.worker_tel = worker_tel;
		this.worker_sex = worker_sex;
		this.worker_memo = worker_memo;
		this.office_tel = office_tel;
		this.position = position;
		this.worker_id = worker_id;
		this.worker_age = worker_age;
	}
	@Override
	public String toString() {
		return "Worker [id=" + id + ", worker_name=" + worker_name
				+ ", worker_password=" + worker_password + ", worker_tel=" + worker_tel
				+ ", worker_sex=" + worker_sex + ", worker_memo=" + worker_memo
				+ ", office_tel=" + office_tel + ", position=" + position
				+ ", worker_id=" + worker_id + ", worker_age=" + worker_age + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWorker_name() {
		return worker_name;
	}	
	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}
	public String getWorker_password() {
		return worker_password;
	}
	public void setWorker_password(String worker_password) {
		this.worker_password = worker_password;
	}
	public String getWorker_tel() {
		return worker_tel;
	}
	public void setWorker_tel(String worker_tel) {
		this.worker_tel = worker_tel;
	}
	public String getWorker_sex() {
		return worker_sex;
	}
	public void setWorker_sex(String worker_sex) {
		this.worker_sex = worker_sex;
	}
	public String getWorker_memo() {
		return worker_memo;
	}
	public void setWorker_memo(String worker_memo) {
		this.worker_memo = worker_memo;
	}
	public String getOffice_tel() {
		return office_tel;
	}
	public void setOffice_tel(String office_tel) {
		this.office_tel = office_tel;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getWorker_id() {
		return worker_id;
	}
	public void setWorker_id(String worker_id) {
		this.worker_id = worker_id;
	}
	public String getWorker_age() {
		return worker_age;
	}
	public void setWorker_age(String worker_age) {
		this.worker_age = worker_age;
	}
	
	
	
	
}
