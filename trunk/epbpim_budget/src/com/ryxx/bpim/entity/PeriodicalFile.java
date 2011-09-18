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
    
    private String sourceCode;
    
    private Timestamp periodicalDate;
    
    private Timestamp uploadDate;
    
    private String keyword;
    
    private String uploadDatePage;
    
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
    
    public String getUploadDatePage()
    {
        return uploadDatePage;
    }
    
    public void setUploadDatePage(String uploadDatePage)
    {
        this.uploadDatePage = uploadDatePage;
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
    
    public String getSourceCode()
    {
        return sourceCode;
    }
    
    public void setSourceCode(String sourceCode)
    {
        this.sourceCode = sourceCode;
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
