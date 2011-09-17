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
    
    private String name = "";
    
    private String type = "";
    
    private String sourceCode = "";
    
    private Timestamp uploadDate;
    
    private String keyword;
    
    private String uploadDatePage;
    
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
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
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
