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
public class ProjectInvoice extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = -6899594424877105415L;
    
    private Timestamp invoiceDate;
    
    private String invoiceNumber;
    
    private String invoicePrice;
    
    public String getInvoicePrice()
    {
        return invoicePrice;
    }
    
    public void setInvoicePrice(String invoicePrice)
    {
        this.invoicePrice = invoicePrice;
    }
    
    public Timestamp getInvoiceDate()
    {
        return invoiceDate;
    }
    
    public void setInvoiceDate(Timestamp invoiceDate)
    {
        this.invoiceDate = invoiceDate;
    }
    
    public String getInvoiceNumber()
    {
        return invoiceNumber;
    }
    
    public void setInvoiceNumber(String invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
    }
}
