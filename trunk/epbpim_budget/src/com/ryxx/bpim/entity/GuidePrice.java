package com.ryxx.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class GuidePrice extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = 2859075908176503625L;
    
    private String guidePriceFileName;
    
    private Timestamp guidePriceDate;
    
    private String guidePriceDatePage;
    
    private Long id;
    
    private String code;
    
    private String name;
    
    private String unit;
    
    private double price;
    
    private String unName;
    
    private String tag;
    
    private Timestamp uploadDate;
    
    private ProvinceCity provinceCity;
    
    private Major major;
    
    
    
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

	public String getGuidePriceFileName()
    {
        return guidePriceFileName;
    }
    
    public void setGuidePriceFileName(String guidePriceFileName)
    {
        this.guidePriceFileName = guidePriceFileName;
    }
    
    public Timestamp getGuidePriceDate()
    {
        return guidePriceDate;
    }
    
    public void setGuidePriceDate(Timestamp guidePriceDate)
    {
        this.guidePriceDate = guidePriceDate;
    }
    
    public String getGuidePriceDatePage()
    {
        return guidePriceDatePage;
    }
    
    public void setGuidePriceDatePage(String guidePriceDatePage)
    {
        this.guidePriceDatePage = guidePriceDatePage;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Timestamp getUploadDate()
    {
        return uploadDate;
    }
    
    public void setUploadDate(Timestamp uploadDate)
    {
        this.uploadDate = uploadDate;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public void setCode(String code)
    {
        this.code = code;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getUnit()
    {
        return unit;
    }
    
    public void setUnit(String unit)
    {
        this.unit = unit;
    }
    
    public String getTag()
    {
        return tag;
    }
    
    public void setTag(String tag)
    {
        this.tag = tag;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public String getUnName()
    {
        return unName;
    }
    
    public void setUnName(String unName)
    {
        this.unName = unName;
    }
}
