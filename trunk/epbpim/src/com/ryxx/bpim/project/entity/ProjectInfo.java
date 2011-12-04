/**
 * 
 */
package com.ryxx.bpim.project.entity;

import java.sql.Timestamp;
import java.util.List;

import com.ryxx.bpim.entity.VoBase;
import com.ryxx.bpim.user.entity.AdminDept;
import com.ryxx.bpim.user.entity.UserInfo;

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
    
    private String startDatePage;
    
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
    
    private String biddingCompany;
    
    private String biddingContactor;
    
    private String biddingContact;
    
    private AdminDept dept;
    
    private String deptTransferNumber;
    
    private UserInfo owner;
    
    private String projectType;
    
    private String judgePrice1;
    
    private String judgePrice2;
    
    private String judgeDays;
    
    private Timestamp reportDate;
    
    private String reportDatePage;
    
    private String plusPrice;
    
    private String minusPrice;
    
    private String comments;
    
    private Timestamp achiveDate;
    
    private String achiveDatePage;
    
    private String reportNumber;
    
    private String masterJudgeComments;
    
    private String achiveReceiver;
    
    private String contractNumber;
    
    private String contractMoney;
    
    private String contractAbstract;
    
    private Timestamp invoiceDate;
    
    private String invoiceDatePage;
    
    private String invoiceNumber;
    
    private String invoicePrice;
    
    private String status;
    
    private UserInfo submitter;
    
    private List<ProjectStream> projectStreams;
    
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
    
    public String getNumber()
    {
        return number;
    }
    
    public void setNumber(String number)
    {
        this.number = number;
    }
    
    public String getMajorType()
    {
        return majorType;
    }
    
    public void setMajorType(String majorType)
    {
        this.majorType = majorType;
    }
    
    public String getValuationType()
    {
        return valuationType;
    }
    
    public void setValuationType(String valuationType)
    {
        this.valuationType = valuationType;
    }
    
    public Timestamp getStartDate()
    {
        return startDate;
    }
    
    public void setStartDate(Timestamp startDate)
    {
        this.startDate = startDate;
    }
    
    public String getStartDatePage()
    {
        return startDatePage;
    }
    
    public void setStartDatePage(String startDatePage)
    {
        this.startDatePage = startDatePage;
    }
    
    public String getQuality()
    {
        return quality;
    }
    
    public void setQuality(String quality)
    {
        this.quality = quality;
    }
    
    public String getCustomerCompany()
    {
        return customerCompany;
    }
    
    public void setCustomerCompany(String customerCompany)
    {
        this.customerCompany = customerCompany;
    }
    
    public String getCustomerContactor()
    {
        return customerContactor;
    }
    
    public void setCustomerContactor(String customerContactor)
    {
        this.customerContactor = customerContactor;
    }
    
    public String getCustomerContact()
    {
        return customerContact;
    }
    
    public void setCustomerContact(String customerContact)
    {
        this.customerContact = customerContact;
    }
    
    public String getMediatorCompany()
    {
        return mediatorCompany;
    }
    
    public void setMediatorCompany(String mediatorCompany)
    {
        this.mediatorCompany = mediatorCompany;
    }
    
    public String getMediatorContactor()
    {
        return mediatorContactor;
    }
    
    public void setMediatorContactor(String mediatorContactor)
    {
        this.mediatorContactor = mediatorContactor;
    }
    
    public String getMediatorContact()
    {
        return mediatorContact;
    }
    
    public void setMediatorContact(String mediatorContact)
    {
        this.mediatorContact = mediatorContact;
    }
    
    public String getVendorCompany()
    {
        return vendorCompany;
    }
    
    public void setVendorCompany(String vendorCompany)
    {
        this.vendorCompany = vendorCompany;
    }
    
    public String getVendorContactor()
    {
        return vendorContactor;
    }
    
    public void setVendorContactor(String vendorContactor)
    {
        this.vendorContactor = vendorContactor;
    }
    
    public String getVendorContact()
    {
        return vendorContact;
    }
    
    public void setVendorContact(String vendorContact)
    {
        this.vendorContact = vendorContact;
    }
    
    public AdminDept getDept()
    {
        return dept;
    }
    
    public void setDept(AdminDept dept)
    {
        this.dept = dept;
    }
    
    public String getDeptTransferNumber()
    {
        return deptTransferNumber;
    }
    
    public void setDeptTransferNumber(String deptTransferNumber)
    {
        this.deptTransferNumber = deptTransferNumber;
    }
    
    public UserInfo getOwner()
    {
        return owner;
    }
    
    public void setOwner(UserInfo owner)
    {
        this.owner = owner;
    }
    
    public String getProjectType()
    {
        return projectType;
    }
    
    public void setProjectType(String projectType)
    {
        this.projectType = projectType;
    }
    
    public String getJudgePrice1()
    {
        return judgePrice1;
    }
    
    public void setJudgePrice1(String judgePrice1)
    {
        this.judgePrice1 = judgePrice1;
    }
    
    public String getJudgePrice2()
    {
        return judgePrice2;
    }
    
    public void setJudgePrice2(String judgePrice2)
    {
        this.judgePrice2 = judgePrice2;
    }
    
    public String getJudgeDays()
    {
        return judgeDays;
    }
    
    public void setJudgeDays(String judgeDays)
    {
        this.judgeDays = judgeDays;
    }
    
    public Timestamp getReportDate()
    {
        return reportDate;
    }
    
    public void setReportDate(Timestamp reportDate)
    {
        this.reportDate = reportDate;
    }
    
    public String getReportDatePage()
    {
        return reportDatePage;
    }
    
    public void setReportDatePage(String reportDatePage)
    {
        this.reportDatePage = reportDatePage;
    }
    
    public String getPlusPrice()
    {
        return plusPrice;
    }
    
    public void setPlusPrice(String plusPrice)
    {
        this.plusPrice = plusPrice;
    }
    
    public String getMinusPrice()
    {
        return minusPrice;
    }
    
    public void setMinusPrice(String minusPrice)
    {
        this.minusPrice = minusPrice;
    }
    
    public String getComments()
    {
        return comments;
    }
    
    public void setComments(String comments)
    {
        this.comments = comments;
    }
    
    public Timestamp getAchiveDate()
    {
        return achiveDate;
    }
    
    public void setAchiveDate(Timestamp achiveDate)
    {
        this.achiveDate = achiveDate;
    }
    
    public String getAchiveDatePage()
    {
        return achiveDatePage;
    }
    
    public void setAchiveDatePage(String achiveDatePage)
    {
        this.achiveDatePage = achiveDatePage;
    }
    
    public String getReportNumber()
    {
        return reportNumber;
    }
    
    public void setReportNumber(String reportNumber)
    {
        this.reportNumber = reportNumber;
    }
    
    public String getMasterJudgeComments()
    {
        return masterJudgeComments;
    }
    
    public void setMasterJudgeComments(String masterJudgeComments)
    {
        this.masterJudgeComments = masterJudgeComments;
    }
    
    public String getAchiveReceiver()
    {
        return achiveReceiver;
    }
    
    public void setAchiveReceiver(String achiveReceiver)
    {
        this.achiveReceiver = achiveReceiver;
    }
    
    public String getContractNumber()
    {
        return contractNumber;
    }
    
    public void setContractNumber(String contractNumber)
    {
        this.contractNumber = contractNumber;
    }
    
    public String getContractMoney()
    {
        return contractMoney;
    }
    
    public void setContractMoney(String contractMoney)
    {
        this.contractMoney = contractMoney;
    }
    
    public String getContractAbstract()
    {
        return contractAbstract;
    }
    
    public void setContractAbstract(String contractAbstract)
    {
        this.contractAbstract = contractAbstract;
    }
    
    public Timestamp getInvoiceDate()
    {
        return invoiceDate;
    }
    
    public void setInvoiceDate(Timestamp invoiceDate)
    {
        this.invoiceDate = invoiceDate;
    }
    
    public String getInvoiceDatePage()
    {
        return invoiceDatePage;
    }
    
    public void setInvoiceDatePage(String invoiceDatePage)
    {
        this.invoiceDatePage = invoiceDatePage;
    }
    
    public String getInvoiceNumber()
    {
        return invoiceNumber;
    }
    
    public void setInvoiceNumber(String invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
    }
    
    public String getInvoicePrice()
    {
        return invoicePrice;
    }
    
    public void setInvoicePrice(String invoicePrice)
    {
        this.invoicePrice = invoicePrice;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public UserInfo getSubmitter()
    {
        return submitter;
    }
    
    public void setSubmitter(UserInfo submitter)
    {
        this.submitter = submitter;
    }

	/**
	 * @return the biddingCompany
	 */
	public String getBiddingCompany() {
		return biddingCompany;
	}

	/**
	 * @param biddingCompany the biddingCompany to set
	 */
	public void setBiddingCompany(String biddingCompany) {
		this.biddingCompany = biddingCompany;
	}

	/**
	 * @return the biddingContactor
	 */
	public String getBiddingContactor() {
		return biddingContactor;
	}

	/**
	 * @param biddingContactor the biddingContactor to set
	 */
	public void setBiddingContactor(String biddingContactor) {
		this.biddingContactor = biddingContactor;
	}

	/**
	 * @return the biddingContact
	 */
	public String getBiddingContact() {
		return biddingContact;
	}

	/**
	 * @param biddingContact the biddingContact to set
	 */
	public void setBiddingContact(String biddingContact) {
		this.biddingContact = biddingContact;
	}

	/**
	 * @return the projectStreams
	 */
	public List<ProjectStream> getProjectStreams() {
		return projectStreams;
	}

	/**
	 * @param projectStreams the projectStreams to set
	 */
	public void setProjectStreams(List<ProjectStream> projectStreams) {
		this.projectStreams = projectStreams;
	}
    
    
}
