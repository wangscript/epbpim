package com.ryxx.bpim.user.entity;

import com.ryxx.bpim.entity.VoBase;

public class AdminRole extends VoBase {
	private static final long serialVersionUID = 9078033198011062718L;
	
	private Long id;
	private String name;
	private Integer roleCount;
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
	public Integer getRoleCount() {
		return roleCount;
	}
	public void setRoleCount(Integer roleCount) {
		this.roleCount = roleCount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}

