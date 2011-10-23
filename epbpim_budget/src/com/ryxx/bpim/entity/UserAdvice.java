package com.ryxx.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class UserAdvice extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = -3114157248757234058L;
    
    private Long id;
    
    private String userID;
    
    private String userName;
    
    private String adviceContent;
    
    private Timestamp adviceDate;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    
    
    /**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getAdviceContent()
    {
        return adviceContent;
    }
    
    public void setAdviceContent(String adviceContent)
    {
        this.adviceContent = adviceContent;
    }
    
    public Timestamp getAdviceDate()
    {
        return adviceDate;
    }
    
    public void setAdviceDate(Timestamp adviceDate)
    {
        this.adviceDate = adviceDate;
    }
}
