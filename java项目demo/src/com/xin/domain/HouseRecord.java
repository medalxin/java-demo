package com.xin.domain;

public class HouseRecord {
	private int homeid;
	private String customerid;
	private String homezone;
	private String homebuilding;
	private String homeunit;
	private String homenumber;
	private String homearea;
	private String hometype;
	private String homememeo;

	public HouseRecord() {

		// TODO Auto-generated constructor stub
	}

	public HouseRecord(int homeid, String customerid, String homezone,
			String homebuilding, String homeunit, String homenumber,
			String homearea, String hometype, String homememeo) {

		this.homeid = homeid;
		this.customerid = customerid;
		this.homezone = homezone;
		this.homebuilding = homebuilding;
		this.homeunit = homeunit;
		this.homenumber = homenumber;
		this.homearea = homearea;
		this.hometype = hometype;
		this.homememeo = homememeo;
	}

	@Override
	public String toString() {
		return "HouseRecord [homeid=" + homeid + ", customerid=" + customerid
				+ ", homezone=" + homezone + ", homebuilding=" + homebuilding
				+ ", homeunit=" + homeunit + ", homenumber=" + homenumber
				+ ", homearea=" + homearea + ", hometype=" + hometype
				+ ", homememo=" + homememeo + "]";
	}

	public int getHomeid() {
		return homeid;
	}

	public void setHomeid(int homeid) {
		this.homeid = homeid;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getHomezone() {
		return homezone;
	}

	public void setHomezone(String homezone) {
		this.homezone = homezone;
	}

	public String getHomebuilding() {
		return homebuilding;
	}

	public void setHomebuilding(String homebuilding) {
		this.homebuilding = homebuilding;
	}

	public String getHomeunit() {
		return homeunit;
	}

	public void setHomeunit(String homeunit) {
		this.homeunit = homeunit;
	}

	public String getHomenumber() {
		return homenumber;
	}

	public void setHomenumber(String homenumber) {
		this.homenumber = homenumber;
	}

	public String getHomearea() {
		return homearea;
	}

	public void setHomearea(String homearea) {
		this.homearea = homearea;
	}

	public String getHometype() {
		return hometype;
	}

	public void setHometype(String hometype) {
		this.hometype = hometype;
	}

	public String getHomememeo() {
		return homememeo;
	}

	public void setHomememeo(String homememeo) {
		this.homememeo = homememeo;
	}

}
