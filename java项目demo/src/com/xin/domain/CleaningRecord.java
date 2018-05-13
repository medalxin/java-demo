package com.xin.domain;

import java.util.Date;

public class CleaningRecord {
	private int id;
	private String cleaningSite;
	private String cleaningTime;
	private String cleaning;
	private String cleaningTel;
	private String cleaningRemarks;
	
	public CleaningRecord() {
	}
	
	public CleaningRecord(int id, String cleaningSite, String cleaningTime,
			String cleaning, String cleaningTel, String cleaningRemarks) {
		this.id = id;
		this.cleaningSite = cleaningSite;
		this.cleaningTime = cleaningTime;
		this.cleaning = cleaning;
		this.cleaningTel = cleaningTel;
		this.cleaningRemarks = cleaningRemarks;
	}

	@Override
	public String toString() {
		return "CleaningRecord [id=" + id + ", cleaningSite=" + cleaningSite
				+ ", cleaningTime=" + cleaningTime + ", cleaning=" + cleaning
				+ ", cleaningTel=" + cleaningTel + ", cleaningRemarks="
				+ cleaningRemarks + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCleaningSite() {
		return cleaningSite;
	}

	public void setCleaningSite(String cleaningSite) {
		this.cleaningSite = cleaningSite;
	}

	public String getCleaningTime() {
		return cleaningTime;
	}

	public void setCleaningTime(String cleaningTime) {
		this.cleaningTime = cleaningTime;
	}

	public String getCleaning() {
		return cleaning;
	}

	public void setCleaning(String cleaning) {
		this.cleaning = cleaning;
	}

	public String getCleaningTel() {
		return cleaningTel;
	}

	public void setCleaningTel(String cleaningTel) {
		this.cleaningTel = cleaningTel;
	}

	public String getCleaningRemarks() {
		return cleaningRemarks;
	}

	public void setCleaningRemarks(String cleaningRemarks) {
		this.cleaningRemarks = cleaningRemarks;
	}

	
	
}
