package com.ryxx.bpim.entity;

import java.sql.Timestamp;
import java.util.List;

public class AdminMenu extends VoBase {
	private static final long serialVersionUID = 8717951662408408201L;
	private Long id;
	private String name;
	private String url;
	private Long parentId;
	private Integer enable;
	private ProvinceCity region;
	private Integer mDefault;
	private Integer index;
	private Integer price;
	private String description;
	private String title;
	private Timestamp registerDate;
	private Timestamp adviceDate;
	private List<UserInfo> users;
	private List<AdminMenu> subMenus;
	
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
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public ProvinceCity getRegion() {
		return region;
	}
	public void setRegion(ProvinceCity region) {
		this.region = region;
	}
	public Integer getmDefault() {
		return mDefault;
	}
	public void setmDefault(Integer mDefault) {
		this.mDefault = mDefault;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	public Timestamp getAdviceDate() {
		return adviceDate;
	}
	public void setAdviceDate(Timestamp adviceDate) {
		this.adviceDate = adviceDate;
	}
	public List<AdminMenu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<AdminMenu> subMenus) {
		this.subMenus = subMenus;
	}
	public List<UserInfo> getUsers() {
		return users;
	}
	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}
}

