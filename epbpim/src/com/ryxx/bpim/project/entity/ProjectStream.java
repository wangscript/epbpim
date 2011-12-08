/**
 * 
 */
package com.ryxx.bpim.project.entity;

import com.ryxx.bpim.entity.VoBase;
import com.ryxx.bpim.user.entity.UserInfo;

/**
 * @author Delgado Ding
 *
 */
public class ProjectStream extends VoBase
{
    
    /* 序列号 */
    private static final long serialVersionUID = 5824525163798153024L;
    
    private Long id;
    
    private Long projectID;
    
    private UserInfo submitter;
    
    private int type;
    
    private double money;
    
    private String comments;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Long getProjectID()
    {
        return projectID;
    }
    
    public void setProjectID(Long projectID)
    {
        this.projectID = projectID;
    }
    
    public UserInfo getSubmitter()
    {
        return submitter;
    }
    
    public void setSubmitter(UserInfo submitter)
    {
        this.submitter = submitter;
    }
    
    public int getType()
    {
        return type;
    }
    
    public void setType(int type)
    {
        this.type = type;
    }
    
    public double getMoney()
    {
        return money;
    }
    
    public void setMoney(double money)
    {
        this.money = money;
    }
    
    public String getComments()
    {
        return comments;
    }
    
    public void setComments(String comments)
    {
        this.comments = comments;
    }
    
}
