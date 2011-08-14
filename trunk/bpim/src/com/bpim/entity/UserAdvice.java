package com.bpim.entity;

import java.sql.Timestamp;

/**
 * author Delgado
 */
public class UserAdvice
{
    
    private Long id;
    
    private Long userID;
    
    private String ADVICE_CONTENT;
    
    private Timestamp ADVICE_DATE;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Long getUserID()
    {
        return userID;
    }
    
    public void setUserID(Long userID)
    {
        this.userID = userID;
    }
    
    public String getADVICE_CONTENT()
    {
        return ADVICE_CONTENT;
    }
    
    public void setADVICE_CONTENT(String aDVICE_CONTENT)
    {
        ADVICE_CONTENT = aDVICE_CONTENT;
    }
    
    public Timestamp getADVICE_DATE()
    {
        return ADVICE_DATE;
    }
    
    public void setADVICE_DATE(Timestamp aDVICE_DATE)
    {
        ADVICE_DATE = aDVICE_DATE;
    }
    
}
