package com.ryxx.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class GuidePrice extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = 2859075908176503625L;
    
    private Long id;
    
    private String guidePriceType;
    
    private String guidePriceClass;
    
    private String name;
    
    private String unit;
    
    private double price;
    
    private String priceComment;
    
    private Timestamp guidePriceDate;
    
    private Timestamp uploadDate;
    
    private ProvinceCity provinceCity;
    
    private String comment;
    
    private String guidePriceFileName;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getGuidePriceType()
    {
        return guidePriceType;
    }
    
    public void setGuidePriceType(String guidePriceType)
    {
        this.guidePriceType = guidePriceType;
    }
    
    public String getGuidePriceClass()
    {
        return guidePriceClass;
    }
    
    public void setGuidePriceClass(String guidePriceClass)
    {
        this.guidePriceClass = guidePriceClass;
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
    
    public double getPrice()
    {
        return price;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public String getPriceComment()
    {
        return priceComment;
    }
    
    public void setPriceComment(String priceComment)
    {
        this.priceComment = priceComment;
    }
    
    public Timestamp getGuidePriceDate()
    {
        return guidePriceDate;
    }
    
    public void setGuidePriceDate(Timestamp guidePriceDate)
    {
        this.guidePriceDate = guidePriceDate;
    }
    
    public Timestamp getUploadDate()
    {
        return uploadDate;
    }
    
    public void setUploadDate(Timestamp uploadDate)
    {
        this.uploadDate = uploadDate;
    }
    
    public ProvinceCity getProvinceCity()
    {
        return provinceCity;
    }
    
    public void setProvinceCity(ProvinceCity provinceCity)
    {
        this.provinceCity = provinceCity;
    }
    
    public String getComment()
    {
        return comment;
    }
    
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    
    public String getGuidePriceFileName()
    {
        return guidePriceFileName;
    }
    
    public void setGuidePriceFileName(String guidePriceFileName)
    {
        this.guidePriceFileName = guidePriceFileName;
    }
    
}
