package com.ryxx.bpim.user.entity;

import java.sql.Timestamp;

import com.ryxx.bpim.entity.VoBase;

public class WorkingExperience extends VoBase {
	private static final long serialVersionUID = -5736014916018823802L;
	
	private Long id;
	private Timestamp startDate;
	private String startDateTemp;
	private Timestamp endDate;
	private String endDateTemp;
	private String company;
	private String title;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStartDateTemp() {
		return startDateTemp;
	}
	public void setStartDateTemp(String startDateTemp) {
		this.startDateTemp = startDateTemp;
	}
	public String getEndDateTemp() {
		return endDateTemp;
	}
	public void setEndDateTemp(String endDateTemp) {
		this.endDateTemp = endDateTemp;
	}
	
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}

