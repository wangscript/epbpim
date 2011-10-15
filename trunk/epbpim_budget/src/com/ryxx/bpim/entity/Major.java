package com.ryxx.bpim.entity;


public class Major extends VoBase {
	
	private static final long serialVersionUID = -3699089574630795142L;
	
	private Long id;
	private String name;
	private String majorDesc;
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
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the majorDesc
	 */
	public String getMajorDesc() {
		return majorDesc;
	}
	/**
	 * @param majorDesc the majorDesc to set
	 */
	public void setMajorDesc(String majorDesc) {
		this.majorDesc = majorDesc;
	}
	
}

