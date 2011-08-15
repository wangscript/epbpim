package com.ryxx.bpim.user.entity;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.ryxx.bpim.entity.VoBase;

public class AdminRole extends VoBase {
	private static final long serialVersionUID = 9078033198011062718L;
	
	private Long id;
	private String name;
	private Integer roleCount;
	private String remark;
	private List<AdminMenu> menuList;
	
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
	public List<AdminMenu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<AdminMenu> menuList) {
		this.menuList = menuList;
	}
	public boolean equals(Object obj) {
		if((this==obj)) {
			return true;
		}
		if(!(obj instanceof AdminRole)) {
			return false;
		}
		AdminRole adminRole = (AdminRole)obj;
		return new EqualsBuilder().append(this.getId(), adminRole.getId()).isEquals();
	}
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}

