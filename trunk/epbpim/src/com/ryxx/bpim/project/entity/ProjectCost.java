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
    
    private long remitteeID;
    
    private long approverID;
    
    private String remitteeName;
    
    private String approverName;
    
    private String Price;
    
    private String account;
    
    private String comment;
    
    private Timestamp settleDate;
    
    private Timestamp approveDate;
    
    public long getApproverID()
    {
        return approverID;
    }
    
    public void setApproverID(long approverID)
    {
        this.approverID = approverID;
    }
    
    public String getApproverName()
    {
        return approverName;
    }
    
    public void setApproverName(String approverName)
    {
        this.approverName = approverName;
    }
    
    public Timestamp getApproveDate()
    {
        return approveDate;
    }
    
    public void setApproveDate(Timestamp approveDate)
    {
        this.approveDate = approveDate;
    }
    
    public long getRemitteeID()
    {
        return remitteeID;
    }
    
    public void setRemitteeID(long remitteeID)
    {
        this.remitteeID = remitteeID;
    }
    
    public String getRemitteeName()
    {
        return remitteeName;
    }
    
    public void setRemitteeName(String remitteeName)
    {
        this.remitteeName = remitteeName;
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
