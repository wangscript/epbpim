package com.ryxx.bpim.user.entity;

import java.util.List;

import com.ryxx.bpim.entity.VoBase;

public class AdminMenu extends VoBase {
	private static final long serialVersionUID = 8717951662408408201L;
	
	private Integer id;
	private String name;
	private String url;
	private Integer parentId;
	private Integer enable;
	private Integer index;
	private List<AdminRole> roleList;
	private List<AdminMenu> subMenus;
	
	public List<AdminRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<AdminRole> roleList) {
		this.roleList = roleList;
	}
	public Integer getEnable() {
		return enable;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public List<AdminMenu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<AdminMenu> subMenus) {
		this.subMenus = subMenus;
	}
}

