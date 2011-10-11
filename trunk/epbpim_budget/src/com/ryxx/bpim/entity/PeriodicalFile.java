package com.ryxx.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class PeriodicalFile extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = 2859075908176503625L;
    
    private Long id;
    
    private String periodicalName;
    
    private String periodicalProvice;
    
    private String periodicalType;
    
    private String periodicalUrl;
    
    private Timestamp periodicalDate;
    
    private Timestamp uploadDate;
    
    private String keyword;
    
    private String periodicalDatePage;
    
    private ProvinceCity provinceCity;
    
    
    
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

	public String getPeriodicalDatePage()
    {
        return periodicalDatePage;
    }

    public void setPeriodicalDatePage(String periodicalDatePage)
    {
        this.periodicalDatePage = periodicalDatePage;
    }

    public String getPeriodicalName()
    {
        return periodicalName;
    }
    
    public void setPeriodicalName(String periodicalName)
    {
        this.periodicalName = periodicalName;
    }
    
    public String getPeriodicalType()
    {
        return periodicalType;
    }
    
    public void setPeriodicalType(String periodicalType)
    {
        this.periodicalType = periodicalType;
    }
    
    public String getPeriodicalProvice()
    {
        return periodicalProvice;
    }
    
    public void setPeriodicalProvice(String periodicalProvice)
    {
        this.periodicalProvice = periodicalProvice;
    }
    
    public Timestamp getPeriodicalDate()
    {
        return periodicalDate;
    }
    
    public void setPeriodicalDate(Timestamp periodicalDate)
    {
        this.periodicalDate = periodicalDate;
    }
    
    public String getKeyword()
    {
        return keyword;
    }
    
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    /**
	 * @return the periodicalUrl
	 */
	public String getPeriodicalUrl() {
		return periodicalUrl;
	}

	/**
	 * @param periodicalUrl the periodicalUrl to set
	 */
	public void setPeriodicalUrl(String periodicalUrl) {
		this.periodicalUrl = periodicalUrl;
	}

	public Timestamp getUploadDate()
    {
        return uploadDate;
    }
    
    public void setUploadDate(Timestamp uploadDate)
    {
        this.uploadDate = uploadDate;
    }
    
}
