/**
 * 
 */
package com.ryxx.bpim.project.entity;

import java.sql.Timestamp;

import com.ryxx.bpim.entity.VoBase;

/**
 * @author Delgado Ding
 *
 */
public class ProjectCost extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = -6899594424877105415L;
    
    private String remittee;
    
    private String Price;
    
    private String account;
    
    private String comment;
    
    private Timestamp settleDate;
    
    public String getRemittee()
    {
        return remittee;
    }
    
    public void setRemittee(String remittee)
    {
        this.remittee = remittee;
    }
    
    public String getPrice()
    {
        return Price;
    }
    
    public void setPrice(String price)
    {
        Price = price;
    }
    
    public String getAccount()
    {
        return account;
    }
    
    public void setAccount(String account)
    {
        this.account = account;
    }
    
    public String getComment()
    {
        return comment;
    }
    
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    
    public Timestamp getSettleDate()
    {
        return settleDate;
    }
    
    public void setSettleDate(Timestamp settleDate)
    {
        this.settleDate = settleDate;
    }
    
}
