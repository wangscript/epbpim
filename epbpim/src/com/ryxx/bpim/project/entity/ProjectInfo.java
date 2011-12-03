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
public class ProjectInfo extends VoBase
{
    /** 序列号 */
    private static final long serialVersionUID = 8135345694920297076L;
    
    private Long id;
    
    private String name;
    
    private String number;
    
    private String majorType;
    
    private String valuationType;
    
    private Timestamp startDate;
    
    private String quality;
    
    private String customerCompany;
    
    private String customerContactor;
    
    private String customerContact;
    
    private String mediatorCompany;
    
    private String mediatorContactor;
    
    private String mediatorContact;
    
    private String vendorCompany;
    
    private String vendorContactor;
    
    private String vendorContact;
    
    private String dept;
    
    private String deptTransferNumber;
    
    private String owner;
    
    private String projectType;
    
    private String judgePrice1;
    
    private String judgePrice2;
    
    private String judgeDays;
    
    private Timestamp reportDate;
    
    private String plusPrice;
    
    private String minusPrice;
    
    private String comments;
    
    private Timestamp achiveDate;
    
    private String reportNumber;
    
    private String masterJudgeComments;
    
    private String achiveReceiver;
    
    private String contractNumber;
    
    private String contractMoney;
    
    private String contractAbstract;
    
    private String invoiceDate;
    
    private String invoiceNumber;
    
    private String invoicePrice;
    
    private Long submitter;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * @return the number
     */
    public String getNumber()
    {
        return number;
    }
    
    /**
     * @param number the number to set
     */
    public void setNumber(String number)
    {
        this.number = number;
    }
    
    /**
     * @return the majorType
     */
    public String getMajorType()
    {
        return majorType;
    }
    
    /**
     * @param majorType the majorType to set
     */
    public void setMajorType(String majorType)
    {
        this.majorType = majorType;
    }
    
    /**
     * @return the valuationType
     */
    public String getValuationType()
    {
        return valuationType;
    }
    
    /**
     * @param valuationType the valuationType to set
     */
    public void setValuationType(String valuationType)
    {
        this.valuationType = valuationType;
    }
    
    /**
     * @return the startDate
     */
    public Timestamp getStartDate()
    {
        return startDate;
    }
    
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Timestamp startDate)
    {
        this.startDate = startDate;
    }
    
    /**
     * @return the quality
     */
    public String getQuality()
    {
        return quality;
    }
    
    /**
     * @param quality the quality to set
     */
    public void setQuality(String quality)
    {
        this.quality = quality;
    }
    
    /**
     * @return the customerCompany
     */
    public String getCustomerCompany()
    {
        return customerCompany;
    }
    
    /**
     * @param customerCompany the customerCompany to set
     */
    public void setCustomerCompany(String customerCompany)
    {
        this.customerCompany = customerCompany;
    }
    
    /**
     * @return the customerContactor
     */
    public String getCustomerContactor()
    {
        return customerContactor;
    }
    
    /**
     * @param customerContactor the customerContactor to set
     */
    public void setCustomerContactor(String customerContactor)
    {
        this.customerContactor = customerContactor;
    }
    
    /**
     * @return the customerContact
     */
    public String getCustomerContact()
    {
        return customerContact;
    }
    
    /**
     * @param customerContact the customerContact to set
     */
    public void setCustomerContact(String customerContact)
    {
        this.customerContact = customerContact;
    }
    
    /**
     * @return the mediatorCompany
     */
    public String getMediatorCompany()
    {
        return mediatorCompany;
    }
    
    /**
     * @param mediatorCompany the mediatorCompany to set
     */
    public void setMediatorCompany(String mediatorCompany)
    {
        this.mediatorCompany = mediatorCompany;
    }
    
    /**
     * @return the mediatorContactor
     */
    public String getMediatorContactor()
    {
        return mediatorContactor;
    }
    
    /**
     * @param mediatorContactor the mediatorContactor to set
     */
    public void setMediatorContactor(String mediatorContactor)
    {
        this.mediatorContactor = mediatorContactor;
    }
    
    /**
     * @return the mediatorContact
     */
    public String getMediatorContact()
    {
        return mediatorContact;
    }
    
    /**
     * @param mediatorContact the mediatorContact to set
     */
    public void setMediatorContact(String mediatorContact)
    {
        this.mediatorContact = mediatorContact;
    }
    
    /**
     * @return the vendorCompany
     */
    public String getVendorCompany()
    {
        return vendorCompany;
    }
    
    /**
     * @param vendorCompany the vendorCompany to set
     */
    public void setVendorCompany(String vendorCompany)
    {
        this.vendorCompany = vendorCompany;
    }
    
    /**
     * @return the vendorContactor
     */
    public String getVendorContactor()
    {
        return vendorContactor;
    }
    
    /**
     * @param vendorContactor the vendorContactor to set
     */
    public void setVendorContactor(String vendorContactor)
    {
        this.vendorContactor = vendorContactor;
    }
    
    /**
     * @return the vendorContact
     */
    public String getVendorContact()
    {
        return vendorContact;
    }
    
    /**
     * @param vendorContact the vendorContact to set
     */
    public void setVendorContact(String vendorContact)
    {
        this.vendorContact = vendorContact;
    }
    
    /**
     * @return the dept
     */
    public String getDept()
    {
        return dept;
    }
    
    /**
     * @param dept the dept to set
     */
    public void setDept(String dept)
    {
        this.dept = dept;
    }
    
    /**
     * @return the deptTransferNumber
     */
    public String getDeptTransferNumber()
    {
        return deptTransferNumber;
    }
    
    /**
     * @param deptTransferNumber the deptTransferNumber to set
     */
    public void setDeptTransferNumber(String deptTransferNumber)
    {
        this.deptTransferNumber = deptTransferNumber;
    }
    
    /**
     * @return the owner
     */
    public String getOwner()
    {
        return owner;
    }
    
    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner)
    {
        this.owner = owner;
    }
    
    /**
     * @return the projectType
     */
    public String getProjectType()
    {
        return projectType;
    }
    
    /**
     * @param projectType the projectType to set
     */
    public void setProjectType(String projectType)
    {
        this.projectType = projectType;
    }
    
    /**
     * @return the judgePrice1
     */
    public String getJudgePrice1()
    {
        return judgePrice1;
    }
    
    /**
     * @param judgePrice1 the judgePrice1 to set
     */
    public void setJudgePrice1(String judgePrice1)
    {
        this.judgePrice1 = judgePrice1;
    }
    
    /**
     * @return the judgePrice2
     */
    public String getJudgePrice2()
    {
        return judgePrice2;
    }
    
    /**
     * @param judgePrice2 the judgePrice2 to set
     */
    public void setJudgePrice2(String judgePrice2)
    {
        this.judgePrice2 = judgePrice2;
    }
    
    /**
     * @return the judgeDays
     */
    public String getJudgeDays()
    {
        return judgeDays;
    }
    
    /**
     * @param judgeDays the judgeDays to set
     */
    public void setJudgeDays(String judgeDays)
    {
        this.judgeDays = judgeDays;
    }
    
    /**
     * @return the reportDate
     */
    public Timestamp getReportDate()
    {
        return reportDate;
    }
    
    /**
     * @param reportDate the reportDate to set
     */
    public void setReportDate(Timestamp reportDate)
    {
        this.reportDate = reportDate;
    }
    
    /**
     * @return the plusPrice
     */
    public String getPlusPrice()
    {
        return plusPrice;
    }
    
    /**
     * @param plusPrice the plusPrice to set
     */
    public void setPlusPrice(String plusPrice)
    {
        this.plusPrice = plusPrice;
    }
    
    /**
     * @return the minusPrice
     */
    public String getMinusPrice()
    {
        return minusPrice;
    }
    
    /**
     * @param minusPrice the minusPrice to set
     */
    public void setMinusPrice(String minusPrice)
    {
        this.minusPrice = minusPrice;
    }
    
    /**
     * @return the comments
     */
    public String getComments()
    {
        return comments;
    }
    
    /**
     * @param comments the comments to set
     */
    public void setComments(String comments)
    {
        this.comments = comments;
    }
    
    /**
     * @return the achiveDate
     */
    public Timestamp getAchiveDate()
    {
        return achiveDate;
    }
    
    /**
     * @param achiveDate the achiveDate to set
     */
    public void setAchiveDate(Timestamp achiveDate)
    {
        this.achiveDate = achiveDate;
    }
    
    /**
     * @return the reportNumber
     */
    public String getReportNumber()
    {
        return reportNumber;
    }
    
    /**
     * @param reportNumber the reportNumber to set
     */
    public void setReportNumber(String reportNumber)
    {
        this.reportNumber = reportNumber;
    }
    
    /**
     * @return the masterJudgeComments
     */
    public String getMasterJudgeComments()
    {
        return masterJudgeComments;
    }
    
    /**
     * @param masterJudgeComments the masterJudgeComments to set
     */
    public void setMasterJudgeComments(String masterJudgeComments)
    {
        this.masterJudgeComments = masterJudgeComments;
    }
    
    /**
     * @return the achiveReceiver
     */
    public String getAchiveReceiver()
    {
        return achiveReceiver;
    }
    
    /**
     * @param achiveReceiver the achiveReceiver to set
     */
    public void setAchiveReceiver(String achiveReceiver)
    {
        this.achiveReceiver = achiveReceiver;
    }
    
    /**
     * @return the contractNumber
     */
    public String getContractNumber()
    {
        return contractNumber;
    }
    
    /**
     * @param contractNumber the contractNumber to set
     */
    public void setContractNumber(String contractNumber)
    {
        this.contractNumber = contractNumber;
    }
    
    /**
     * @return the contractMoney
     */
    public String getContractMoney()
    {
        return contractMoney;
    }
    
    /**
     * @param contractMoney the contractMoney to set
     */
    public void setContractMoney(String contractMoney)
    {
        this.contractMoney = contractMoney;
    }
    
    /**
     * @return the contractAbstract
     */
    public String getContractAbstract()
    {
        return contractAbstract;
    }
    
    /**
     * @param contractAbstract the contractAbstract to set
     */
    public void setContractAbstract(String contractAbstract)
    {
        this.contractAbstract = contractAbstract;
    }
    
    /**
     * @return the invoiceDate
     */
    public String getInvoiceDate()
    {
        return invoiceDate;
    }
    
    /**
     * @param invoiceDate the invoiceDate to set
     */
    public void setInvoiceDate(String invoiceDate)
    {
        this.invoiceDate = invoiceDate;
    }
    
    /**
     * @return the invoiceNumber
     */
    public String getInvoiceNumber()
    {
        return invoiceNumber;
    }
    
    /**
     * @param invoiceNumber the invoiceNumber to set
     */
    public void setInvoiceNumber(String invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
    }
    
    /**
     * @return the invoicePrice
     */
    public String getInvoicePrice()
    {
        return invoicePrice;
    }
    
    /**
     * @param invoicePrice the invoicePrice to set
     */
    public void setInvoicePrice(String invoicePrice)
    {
        this.invoicePrice = invoicePrice;
    }
    
    /**
     * @return the submitter
     */
    public Long getSubmitter()
    {
        return submitter;
    }
    
    /**
     * @param submitter the submitter to set
     */
    public void setSubmitter(Long submitter)
    {
        this.submitter = submitter;
    }
    
}
