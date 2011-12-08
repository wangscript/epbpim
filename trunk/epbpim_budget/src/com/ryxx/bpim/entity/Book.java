package com.ryxx.bpim.entity;


/**
 * author Delgado
 */
public class Book extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = 2859075908176503625L;
    
    private Long id;
    
    private String fileName;
    
    private String bookRealName;
    
    private ProvinceCity provinceCity;

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
	 * @return the bookRealName
	 */
	public String getBookRealName() {
		return bookRealName;
	}

	/**
	 * @param bookRealName the bookRealName to set
	 */
	public void setBookRealName(String bookRealName) {
		this.bookRealName = bookRealName;
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
    
    
    
}
