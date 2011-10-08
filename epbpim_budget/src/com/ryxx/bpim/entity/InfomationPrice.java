/**
 * 
 */
package com.ryxx.bpim.entity;

import java.sql.Timestamp;

/**
 * @author Delgado Ding
 *
 */
public class InfomationPrice extends VoBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3673661140546729352L;
	private Long id;
	private String provice;
	private String type;
	private Timestamp dataDate;
	private String code;
	private String name;
	private String unit;
	private double price;
	private String unName;
	private String tag;
	private Timestamp uploadDate;
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
	 * @return the provice
	 */
	public String getProvice() {
		return provice;
	}
	/**
	 * @param provice the provice to set
	 */
	public void setProvice(String provice) {
		this.provice = provice;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the dataDate
	 */
	public Timestamp getDataDate() {
		return dataDate;
	}
	/**
	 * @param dataDate the dataDate to set
	 */
	public void setDataDate(Timestamp dataDate) {
		this.dataDate = dataDate;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the unName
	 */
	public String getUnName() {
		return unName;
	}
	/**
	 * @param unName the unName to set
	 */
	public void setUnName(String unName) {
		this.unName = unName;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the uploadDate
	 */
	public Timestamp getUploadDate() {
		return uploadDate;
	}
	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	
}
