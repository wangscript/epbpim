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
    
}
