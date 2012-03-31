package com.ryxx.bpim.entity;

import java.sql.Timestamp;


/**
 * author Delgado
 */
public class PriceIndexPicture extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = 2859075908176503625L;
    
    private Long id;
    
    private String fileName;
    
    private String realName;
    
    private Timestamp priceIndexDate;
    
    private String priceIndexPagePage;
    
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
	 * @return the priceIndexDate
	 */
	public Timestamp getPriceIndexDate() {
		return priceIndexDate;
	}

	/**
	 * @param priceIndexDate the priceIndexDate to set
	 */
	public void setPriceIndexDate(Timestamp priceIndexDate) {
		this.priceIndexDate = priceIndexDate;
	}

	/**
	 * @return the priceIndexPagePage
	 */
	public String getPriceIndexPagePage() {
		return priceIndexPagePage;
	}

	/**
	 * @param priceIndexPagePage the priceIndexPagePage to set
	 */
	public void setPriceIndexPagePage(String priceIndexPagePage) {
		this.priceIndexPagePage = priceIndexPagePage;
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
