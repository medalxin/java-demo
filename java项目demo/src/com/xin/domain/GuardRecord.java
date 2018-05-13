package com.xin.domain;

import java.util.Date;

public class GuardRecord {
	private int guardid;

	private String workerid;
	private String guardcon;
	private String personname;
	private Date guarddate;

	public GuardRecord() {

	}

	public GuardRecord(int guardid, String workerid, String guardcon,
			String personname, Date guarddate) {

		this.guardid = guardid;
		this.workerid = workerid;
		this.guardcon = guardcon;
		this.personname = personname;
		this.guarddate = guarddate;
	}

	@Override
	public String toString() {
		return "GuardRecord [guardid=" + guardid + ", workerid=" + workerid
				+ ", guardcon=" + guardcon + ", personname=" + personname
				+ ", guarddate=" + guarddate + "]";
	}

	public int getGuardid() {
		return guardid;
	}

	public void setGuardid(int guardid) {
		this.guardid = guardid;
	}

	public String getWorkerid() {
		return workerid;
	}

	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}

	public String getGuardcon() {
		return guardcon;
	}

	public void setGuardcon(String guardcon) {
		this.guardcon = guardcon;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public Date getGuarddate() {
		return guarddate;
	}

	public void setGuarddate(Date guarddate) {
		this.guarddate = guarddate;
	}

}
