package com.ryxx.bpim.entity;

import java.sql.Timestamp;
import java.util.List;

public class AdminMenu extends VoBase {
	private static final long serialVersionUID = 8717951662408408201L;
	
	private Integer id;
	private String name;
	private String url;
	private Integer parentId;
	private Integer enable;
	private Integer region;
	private Integer index;
	private Float price;
	private String desc;
	private String title;
	private Timestamp registerDate;
	private Timestamp adviceDate;
	private List<AdminMenu> subMenus;
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
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public Integer getRegion() {
		return region;
	}
	public void setRegion(Integer region) {
		this.region = region;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	
}

