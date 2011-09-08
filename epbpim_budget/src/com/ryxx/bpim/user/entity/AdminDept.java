package com.ryxx.bpim.user.entity;

import com.ryxx.bpim.entity.VoBase;

public class AdminDept extends VoBase {
	private static final long serialVersionUID = 5440631038707450449L;
	
	private Long id;
	private String name;
	private String remark;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}

