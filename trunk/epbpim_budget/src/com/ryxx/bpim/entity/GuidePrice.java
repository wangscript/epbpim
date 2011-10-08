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
    
    private String guidePriceProvice;
    
    private String guidePriceType;
    
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
    
    public String getGuidePriceFileName()
    {
        return guidePriceFileName;
    }
    
    public void setGuidePriceFileName(String guidePriceFileName)
    {
        this.guidePriceFileName = guidePriceFileName;
    }
    
    public String getGuidePriceProvice()
    {
        return guidePriceProvice;
    }
    
    public void setGuidePriceProvice(String guidePriceProvice)
    {
        this.guidePriceProvice = guidePriceProvice;
    }
    
    public String getGuidePriceType()
    {
        return guidePriceType;
    }
    
    public void setGuidePriceType(String guidePriceType)
    {
        this.guidePriceType = guidePriceType;
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
