package com.ryxx.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class GuideData extends VoBase
{
    /** 注释内容  */
    private static final long serialVersionUID = -3770945738680653745L;
    
    private String guideDataFileName;
    
    private String guideDataClass;
    
    private String guideDataType;
    
    private Timestamp guideDataDate;
    
    private Long id;
    
    private String name;
    
    private String num;
    
    private String model;
    
    private String unit;
    
    private double price;
    
    private double gross;
    
    private double totalPrice;
    
    private double percent;
    
    private Timestamp importDate;
    
    private ProvinceCity provinceCity;
    
    private String guideDataDatePage;
    
    public String getGuideDataFileName()
    {
        return guideDataFileName;
    }
    
    public void setGuideDataFileName(String guideDataFileName)
    {
        this.guideDataFileName = guideDataFileName;
    }
    
    public String getGuideDataClass()
    {
        return guideDataClass;
    }
    
    public void setGuideDataClass(String guideDataClass)
    {
        this.guideDataClass = guideDataClass;
    }
    
    public String getGuideDataType()
    {
        return guideDataType;
    }
    
    public void setGuideDataType(String guideDataType)
    {
        this.guideDataType = guideDataType;
    }
    
    public Timestamp getGuideDataDate()
    {
        return guideDataDate;
    }
    
    public void setGuideDataDate(Timestamp guideDataDate)
    {
        this.guideDataDate = guideDataDate;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getNum()
    {
        return num;
    }
    
    public void setNum(String num)
    {
        this.num = num;
    }
    
    public String getModel()
    {
        return model;
    }
    
    public void setModel(String model)
    {
        this.model = model;
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
    
    public double getGross()
    {
        return gross;
    }
    
    public void setGross(double gross)
    {
        this.gross = gross;
    }
    
    public double getTotalPrice()
    {
        return totalPrice;
    }
    
    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
    public double getPercent()
    {
        return percent;
    }
    
    public void setPercent(double percent)
    {
        this.percent = percent;
    }
    
    public Timestamp getImportDate()
    {
        return importDate;
    }
    
    public void setImportDate(Timestamp importDate)
    {
        this.importDate = importDate;
    }
    
    public ProvinceCity getProvinceCity()
    {
        return provinceCity;
    }
    
    public void setProvinceCity(ProvinceCity provinceCity)
    {
        this.provinceCity = provinceCity;
    }
    
    public String getGuideDataDatePage()
    {
        return guideDataDatePage;
    }
    
    public void setGuideDataDatePage(String guideDataDatePage)
    {
        this.guideDataDatePage = guideDataDatePage;
    }
    
}
