package com.xin.domain;

import java.util.Date;

public class CostRecord {
	private int costid;
	private String customerid;
	private String cost;
	private Date costdate;
	private String money;
	private String costmemo;

	public CostRecord() {

		// TODO Auto-generated constructor stub
	}

	public CostRecord(int costid, String customerid, String cost, String money,
			String costmemo) {

		this.costid = costid;
		this.customerid = customerid;
		this.cost = cost;
		this.money = money;
		this.costmemo = costmemo;
	}

	@Override
	public String toString() {
		return "CostRecord [costid=" + costid + ", customerid=" + customerid
				+ ", cost=" + cost + ", costdate=" + costdate + ", money="
				+ money + ", costmemo=" + costmemo + "]";
	}

	public int getCostid() {
		return costid;
	}

	public void setCostid(int costid) {
		this.costid = costid;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}


	public Date getCostdate() {
		return costdate;
	}

	public void setCostdate(Date costdate) {
		this.costdate = costdate;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getCostmemo() {
		return costmemo;
	}

	public void setCostmemo(String costmemo) {
		this.costmemo = costmemo;
	}

}
