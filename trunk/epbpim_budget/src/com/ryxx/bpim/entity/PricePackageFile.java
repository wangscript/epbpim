package com.ryxx.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class PricePackageFile extends VoBase
{
    
    /** 序列号  */
    private static final long serialVersionUID = -6436633110540273118L;
    
    private Long id;
    
    private String pricePackageName;
    
    private String pricePackagePath;
    
    private String pricePackageProvice;
    
    private String pricePackageType;
    
    private Timestamp pricePackageDate;
    
    private Timestamp uploadDate;
    
    private String pricePackageDatePage;
    
    public String getPricePackageDatePage()
    {
        return pricePackageDatePage;
    }

    public void setPricePackageDatePage(String pricePackageDatePage)
    {
        this.pricePackageDatePage = pricePackageDatePage;
    }

    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getPricePackageName()
    {
        return pricePackageName;
    }
    
    public void setPricePackageName(String pricePackageName)
    {
        this.pricePackageName = pricePackageName;
    }
    
    public String getPricePackagePath()
    {
        return pricePackagePath;
    }
    
    public void setPricePackagePath(String pricePackagePath)
    {
        this.pricePackagePath = pricePackagePath;
    }
    
    public String getPricePackageProvice()
    {
        return pricePackageProvice;
    }
    
    public void setPricePackageProvice(String pricePackageProvice)
    {
        this.pricePackageProvice = pricePackageProvice;
    }
    
    public String getPricePackageType()
    {
        return pricePackageType;
    }
    
    public void setPricePackageType(String pricePackageType)
    {
        this.pricePackageType = pricePackageType;
    }
    
    public Timestamp getPricePackageDate()
    {
        return pricePackageDate;
    }
    
    public void setPricePackageDate(Timestamp pricePackageDate)
    {
        this.pricePackageDate = pricePackageDate;
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
