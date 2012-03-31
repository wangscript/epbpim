package com.ryxx.bpim.entity;

import java.sql.Timestamp;


/**
 * author Delgado
 */
public class PriceHighLowTopPicture extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = 2859075908176503625L;
    
    private Long id;
    
    private String fileName;
    
    private String realName;
    
    private Timestamp priceHighLowTopDate;
    
    private String priceHighLowTopDatePage;
    
    private ProvinceCity provinceCity;
    
    private Major major;

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
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * @return the priceHighLowTopDate
	 */
	public Timestamp getPriceHighLowTopDate() {
		return priceHighLowTopDate;
	}

	/**
	 * @param priceHighLowTopDate the priceHighLowTopDate to set
	 */
	public void setPriceHighLowTopDate(Timestamp priceHighLowTopDate) {
		this.priceHighLowTopDate = priceHighLowTopDate;
	}

	/**
	 * @return the provinceCity
	 */
	public ProvinceCity getProvinceCity() {
		return provinceCity;
	}

	/**
	 * @param provinceCity the provinceCity to set
	 */
	public void setProvinceCity(ProvinceCity provinceCity) {
		this.provinceCity = provinceCity;
	}

	/**
	 * @return the priceHighLowTopDatePage
	 */
	public String getPriceHighLowTopDatePage() {
		return priceHighLowTopDatePage;
	}

	/**
	 * @param priceHighLowTopDatePage the priceHighLowTopDatePage to set
	 */
	public void setPriceHighLowTopDatePage(String priceHighLowTopDatePage) {
		this.priceHighLowTopDatePage = priceHighLowTopDatePage;
	}

	/**
	 * @return the major
	 */
	public Major getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(Major major) {
		this.major = major;
	}
    
    
    
}
