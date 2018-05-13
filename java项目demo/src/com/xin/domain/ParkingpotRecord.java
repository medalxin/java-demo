package com.xin.domain;

import java.util.Date;

public class ParkingpotRecord {
	private int parkingpotid;
	
	private String customerid;
	private String parkingpotposition;

	public ParkingpotRecord() {
	}

	

	public ParkingpotRecord(int parkingpotid, String customerid,
			String parkingpotposition) {
		super();
		this.parkingpotid = parkingpotid;
		this.customerid = customerid;
		this.parkingpotposition = parkingpotposition;
	}

	

	@Override
	public String toString() {
		return "ParkingpotRecord [parkingpotid=" + parkingpotid
				+ ", customerid=" + customerid + ", parkingpotposition="
				+ parkingpotposition + "]";
	}



	public int getParkingpotid() {
		return parkingpotid;
	}



	public void setParkingpotid(int parkingpotid) {
		this.parkingpotid = parkingpotid;
	}



	public String getCustomerid() {
		return customerid;
	}



	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}



	public String getParkingpotposition() {
		return parkingpotposition;
	}



	public void setParkingpotposition(String parkingpotposition) {
		this.parkingpotposition = parkingpotposition;
	}



	
}
