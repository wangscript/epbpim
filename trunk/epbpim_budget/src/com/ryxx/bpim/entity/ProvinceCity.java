package com.ryxx.bpim.entity;

import java.util.List;

public class ProvinceCity extends VoBase {
	
	private static final long serialVersionUID = -3699089574630795142L;
	
	private Long id;
	private String city;
	private Long parentId;
	private Integer sort;
	private Integer enable;
	private List<UserInfo> users;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public List<UserInfo> getUsers() {
		return users;
	}
	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}
}

