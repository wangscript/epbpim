package com.ryxx.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class GovernmentFile extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = 2859075908176503625L;
    
    private Long id;
    
    private String fileTitle = "";
    
    private String fileType = "";
    
    private String fileSubType = "";
    
    private String area = "";
    
    private String sourceCode = "";
    
    private Timestamp filePublishDate;
    
    private Timestamp fileEffectiveDate;
    
    private int effective = 1;
    
    private String keyword;
    
    private String fileEffectiveYear = "";
    
    private String fileEffectiveMonth = "";
    
    private Timestamp fileEffectiveDateFrom;
    
    private Timestamp fileEffectiveDateTo;
    
    private String filePublishYear = "";
    
    private String filePublishMonth = "";
    
    public String getFilePublishYear()
    {
        return filePublishYear;
    }
    
    public void setFilePublishYear(String filePublishYear)
    {
        this.filePublishYear = filePublishYear;
    }
    
    public String getFilePublishMonth()
    {
        return filePublishMonth;
    }
    
    public void setFilePublishMonth(String filePublishMonth)
    {
        this.filePublishMonth = filePublishMonth;
    }
    
    public Timestamp getFilePublishDateFrom()
    {
        return filePublishDateFrom;
    }
    
    public void setFilePublishDateFrom(Timestamp filePublishDateFrom)
    {
        this.filePublishDateFrom = filePublishDateFrom;
    }
    
    public Timestamp getFilePublishDateTo()
    {
        return filePublishDateTo;
    }
    
    public void setFilePublishDateTo(Timestamp filePublishDateTo)
    {
        this.filePublishDateTo = filePublishDateTo;
    }
    
    private Timestamp filePublishDateFrom;
    
    private Timestamp filePublishDateTo;
    
    public String getFileEffectiveYear()
    {
        return fileEffectiveYear;
    }
    
    public void setFileEffectiveYear(String fileEffectiveYear)
    {
        this.fileEffectiveYear = fileEffectiveYear;
    }
    
    public String getFileEffectiveMonth()
    {
        return fileEffectiveMonth;
    }
    
    public void setFileEffectiveMonth(String fileEffectiveMonth)
    {
        this.fileEffectiveMonth = fileEffectiveMonth;
    }
    
    public Timestamp getFileEffectiveDateFrom()
    {
        return fileEffectiveDateFrom;
    }
    
    public void setFileEffectiveDateFrom(Timestamp fileEffectiveDateFrom)
    {
        this.fileEffectiveDateFrom = fileEffectiveDateFrom;
    }
    
    public Timestamp getFileEffectiveDateTo()
    {
        return fileEffectiveDateTo;
    }
    
    public void setFileEffectiveDateTo(Timestamp fileEffectiveDateTo)
    {
        this.fileEffectiveDateTo = fileEffectiveDateTo;
    }
    
    public String getKeyword()
    {
        return keyword;
    }
    
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }
    
    /**
     * @return the fileTitle
     */
    public String getFileTitle()
    {
        return fileTitle;
    }
    
    /**
     * @param fileTitle the fileTitle to set
     */
    public void setFileTitle(String fileTitle)
    {
        this.fileTitle = fileTitle;
    }
    
    /**
     * @return the fileType
     */
    public String getFileType()
    {
        return fileType;
    }
    
    /**
     * @param fileType the fileType to set
     */
    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }
    
    /**
     * @return the fileSubType
     */
    public String getFileSubType()
    {
        return fileSubType;
    }
    
    /**
     * @param fileSubType the fileSubType to set
     */
    public void setFileSubType(String fileSubType)
    {
        this.fileSubType = fileSubType;
    }
    
    /**
     * @return the area
     */
    public String getArea()
    {
        return area;
    }
    
    /**
     * @param area the area to set
     */
    public void setArea(String area)
    {
        this.area = area;
    }
    
    /**
     * @return the filePublishDate
     */
    public Timestamp getFilePublishDate()
    {
        return filePublishDate;
    }
    
    /**
     * @param filePublishDate the filePublishDate to set
     */
    public void setFilePublishDate(Timestamp filePublishDate)
    {
        this.filePublishDate = filePublishDate;
    }
    
    /**
     * @return the fileEffectiveDate
     */
    public Timestamp getFileEffectiveDate()
    {
        return fileEffectiveDate;
    }
    
    /**
     * @param fileEffectiveDate the fileEffectiveDate to set
     */
    public void setFileEffectiveDate(Timestamp fileEffectiveDate)
    {
        this.fileEffectiveDate = fileEffectiveDate;
    }
    
  
	/**
	 * @return the effective
	 */
	public int getEffective() {
		return effective;
	}

	/**
	 * @param effective the effective to set
	 */
	public void setEffective(int effective) {
		this.effective = effective;
	}

	/**
     * @return the sourceCode
     */
    public String getSourceCode()
    {
        return sourceCode;
    }
    
    /**
     * @param sourceCode the sourceCode to set
     */
    public void setSourceCode(String sourceCode)
    {
        this.sourceCode = sourceCode;
    }
    
    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }
    
}
