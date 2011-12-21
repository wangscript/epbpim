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
    
    private String invoiceDate;
    
    private String invoiceDatePage;
    
    private String invoiceNumber;
    
    private String invoicePrice;
    
    private List<ProjectInvoice> projectInvoices;
    
    private String status;
    
    private UserInfo submitter;
    
    private List<ProjectStream> projectStreams;
    
    private String startDateFrom;
    
    private String startDateTo;
    
    private String queryType;
    
    private String deptIDs;
    
    //招标代理
    private String proxyInvest; //总投资
    
    private String proxyQuantity; //建安量
    
    private String proxyBiddingAmount; //中标金额
    
    private Timestamp proxyConsult; //征询单日期
    
    private Timestamp proxyStartDate; //代理开始日
    
    private Timestamp proxyOpenEvalDate; //开、评标日
    
    private String proxyEvaluate; //评价
    
    private Timestamp proxyArchiveDate; //归档日期
    
    private String proxyBiddingIdentity; //中标书编号
    
    private String proxyBiddingSend; //中标书发出
    
    private String proxyArchiveRecipient; //档案接收人
    
    //投资监理
    private String supervisorInvest; //总投资
    
    private String supervisorQuantity; //建安量
    
    private String supervisorOutline; //投资监理大纲及成果
    
    private Timestamp supervisorStartDate; //开始日
    
    private Timestamp supervisorFinishDate; //实际完成日
    
    private Timestamp supervisorArchiveDate; //归档日期
    
    private String supervisorConsultOne; //征询平均价1
    
    private String supervisorConsultTwo; //征询评价2
    
    private String supervisorArchiveRecipient; //档案接收人
    
    //工程咨询
    private String consultInvest; //总投资
    
    private String consultQuantity; //建安量
    
    private String consultResultContent; //咨询成果及内容
    
    private Timestamp consultAnnounceDate; //发布日
    
    private Timestamp consultStartDate; //咨询开始日
    
    private Timestamp consultFinishDate; //咨询完成日
    
    private Timestamp consultArchiveDate; //归档日期
    
    private Timestamp consultReviewDate; //评审日期
    
    private String consultExpertList; //专家名单
    
    private String consultArchiveRecipient; //档案接收人
    
    
    private Double subInvoice;//合同金额累加
    
    private Double subCost;//成本金额累加
    
    private Double balance;
    
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
    
    public String getInvoiceDate()
    {
        return invoiceDate;
    }
    
    public void setInvoiceDate(String invoiceDate)
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
    
    public List<ProjectInvoice> getProjectInvoices()
    {
        return projectInvoices;
    }
    
    public void setProjectInvoices(List<ProjectInvoice> projectInvoices)
    {
        this.projectInvoices = projectInvoices;
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
    public String getBiddingCompany()
    {
        return biddingCompany;
    }
    
    /**
     * @param biddingCompany the biddingCompany to set
     */
    public void setBiddingCompany(String biddingCompany)
    {
        this.biddingCompany = biddingCompany;
    }
    
    /**
     * @return the biddingContactor
     */
    public String getBiddingContactor()
    {
        return biddingContactor;
    }
    
    /**
     * @param biddingContactor the biddingContactor to set
     */
    public void setBiddingContactor(String biddingContactor)
    {
        this.biddingContactor = biddingContactor;
    }
    
    /**
     * @return the biddingContact
     */
    public String getBiddingContact()
    {
        return biddingContact;
    }
    
    /**
     * @param biddingContact the biddingContact to set
     */
    public void setBiddingContact(String biddingContact)
    {
        this.biddingContact = biddingContact;
    }
    
    /**
     * @return the projectStreams
     */
    public List<ProjectStream> getProjectStreams()
    {
        return projectStreams;
    }
    
    /**
     * @param projectStreams the projectStreams to set
     */
    public void setProjectStreams(List<ProjectStream> projectStreams)
    {
        this.projectStreams = projectStreams;
    }
    
    public String getStartDateFrom()
    {
        return startDateFrom;
    }
    
    public void setStartDateFrom(String startDateFrom)
    {
        this.startDateFrom = startDateFrom;
    }
    
    public String getStartDateTo()
    {
        return startDateTo;
    }
    
    public void setStartDateTo(String startDateTo)
    {
        this.startDateTo = startDateTo;
    }
    
    public String getQueryType()
    {
        return queryType;
    }
    
    public void setQueryType(String queryType)
    {
        this.queryType = queryType;
    }
    
    public String getDeptIDs()
    {
        return deptIDs;
    }
    
    public void setDeptIDs(String deptIDs)
    {
        this.deptIDs = deptIDs;
    }
    
    public String getProxyInvest()
    {
        return proxyInvest;
    }
    
    public void setProxyInvest(String proxyInvest)
    {
        this.proxyInvest = proxyInvest;
    }
    
    public String getProxyQuantity()
    {
        return proxyQuantity;
    }
    
    public void setProxyQuantity(String proxyQuantity)
    {
        this.proxyQuantity = proxyQuantity;
    }
    
    public String getProxyBiddingAmount()
    {
        return proxyBiddingAmount;
    }
    
    public void setProxyBiddingAmount(String proxyBiddingAmount)
    {
        this.proxyBiddingAmount = proxyBiddingAmount;
    }
    
    public Timestamp getProxyConsult()
    {
        return proxyConsult;
    }
    
    public void setProxyConsult(Timestamp proxyConsult)
    {
        this.proxyConsult = proxyConsult;
    }
    
    public Timestamp getProxyStartDate()
    {
        return proxyStartDate;
    }
    
    public void setProxyStartDate(Timestamp proxyStartDate)
    {
        this.proxyStartDate = proxyStartDate;
    }
    
    public Timestamp getProxyOpenEvalDate()
    {
        return proxyOpenEvalDate;
    }
    
    public void setProxyOpenEvalDate(Timestamp proxyOpenEvalDate)
    {
        this.proxyOpenEvalDate = proxyOpenEvalDate;
    }
    
    public String getProxyEvaluate()
    {
        return proxyEvaluate;
    }
    
    public void setProxyEvaluate(String proxyEvaluate)
    {
        this.proxyEvaluate = proxyEvaluate;
    }
    
    public Timestamp getProxyArchiveDate()
    {
        return proxyArchiveDate;
    }
    
    public void setProxyArchiveDate(Timestamp proxyArchiveDate)
    {
        this.proxyArchiveDate = proxyArchiveDate;
    }
    
    public String getProxyBiddingIdentity()
    {
        return proxyBiddingIdentity;
    }
    
    public void setProxyBiddingIdentity(String proxyBiddingIdentity)
    {
        this.proxyBiddingIdentity = proxyBiddingIdentity;
    }
    
    public String getProxyBiddingSend()
    {
        return proxyBiddingSend;
    }
    
    public void setProxyBiddingSend(String proxyBiddingSend)
    {
        this.proxyBiddingSend = proxyBiddingSend;
    }
    
    public String getProxyArchiveRecipient()
    {
        return proxyArchiveRecipient;
    }
    
    public void setProxyArchiveRecipient(String proxyArchiveRecipient)
    {
        this.proxyArchiveRecipient = proxyArchiveRecipient;
    }
    
    public String getSupervisorInvest()
    {
        return supervisorInvest;
    }
    
    public void setSupervisorInvest(String supervisorInvest)
    {
        this.supervisorInvest = supervisorInvest;
    }
    
    public String getSupervisorQuantity()
    {
        return supervisorQuantity;
    }
    
    public void setSupervisorQuantity(String supervisorQuantity)
    {
        this.supervisorQuantity = supervisorQuantity;
    }
    
    public String getSupervisorOutline()
    {
        return supervisorOutline;
    }
    
    public void setSupervisorOutline(String supervisorOutline)
    {
        this.supervisorOutline = supervisorOutline;
    }
    
    public Timestamp getSupervisorStartDate()
    {
        return supervisorStartDate;
    }
    
    public void setSupervisorStartDate(Timestamp supervisorStartDate)
    {
        this.supervisorStartDate = supervisorStartDate;
    }
    
    public Timestamp getSupervisorFinishDate()
    {
        return supervisorFinishDate;
    }
    
    public void setSupervisorFinishDate(Timestamp supervisorFinishDate)
    {
        this.supervisorFinishDate = supervisorFinishDate;
    }
    
    public Timestamp getSupervisorArchiveDate()
    {
        return supervisorArchiveDate;
    }
    
    public void setSupervisorArchiveDate(Timestamp supervisorArchiveDate)
    {
        this.supervisorArchiveDate = supervisorArchiveDate;
    }
    
    public String getSupervisorConsultOne()
    {
        return supervisorConsultOne;
    }
    
    public void setSupervisorConsultOne(String supervisorConsultOne)
    {
        this.supervisorConsultOne = supervisorConsultOne;
    }
    
    public String getSupervisorConsultTwo()
    {
        return supervisorConsultTwo;
    }
    
    public void setSupervisorConsultTwo(String supervisorConsultTwo)
    {
        this.supervisorConsultTwo = supervisorConsultTwo;
    }
    
    public String getSupervisorArchiveRecipient()
    {
        return supervisorArchiveRecipient;
    }
    
    public void setSupervisorArchiveRecipient(String supervisorArchiveRecipient)
    {
        this.supervisorArchiveRecipient = supervisorArchiveRecipient;
    }
    
    public String getConsultInvest()
    {
        return consultInvest;
    }
    
    public void setConsultInvest(String consultInvest)
    {
        this.consultInvest = consultInvest;
    }
    
    public String getConsultQuantity()
    {
        return consultQuantity;
    }
    
    public void setConsultQuantity(String consultQuantity)
    {
        this.consultQuantity = consultQuantity;
    }
    
    public String getConsultResultContent()
    {
        return consultResultContent;
    }
    
    public void setConsultResultContent(String consultResultContent)
    {
        this.consultResultContent = consultResultContent;
    }
    
    public Timestamp getConsultAnnounceDate()
    {
        return consultAnnounceDate;
    }
    
    public void setConsultAnnounceDate(Timestamp consultAnnounceDate)
    {
        this.consultAnnounceDate = consultAnnounceDate;
    }
    
    public Timestamp getConsultStartDate()
    {
        return consultStartDate;
    }
    
    public void setConsultStartDate(Timestamp consultStartDate)
    {
        this.consultStartDate = consultStartDate;
    }
    
    public Timestamp getConsultFinishDate()
    {
        return consultFinishDate;
    }
    
    public void setConsultFinishDate(Timestamp consultFinishDate)
    {
        this.consultFinishDate = consultFinishDate;
    }
    
    public Timestamp getConsultArchiveDate()
    {
        return consultArchiveDate;
    }
    
    public void setConsultArchiveDate(Timestamp consultArchiveDate)
    {
        this.consultArchiveDate = consultArchiveDate;
    }
    
    public Timestamp getConsultReviewDate()
    {
        return consultReviewDate;
    }
    
    public void setConsultReviewDate(Timestamp consultReviewDate)
    {
        this.consultReviewDate = consultReviewDate;
    }
    
    public String getConsultExpertList()
    {
        return consultExpertList;
    }
    
    public void setConsultExpertList(String consultExpertList)
    {
        this.consultExpertList = consultExpertList;
    }
    
    public String getConsultArchiveRecipient()
    {
        return consultArchiveRecipient;
    }
    
    public void setConsultArchiveRecipient(String consultArchiveRecipient)
    {
        this.consultArchiveRecipient = consultArchiveRecipient;
    }

	/**
	 * @return the subInvoice
	 */
	public Double getSubInvoice() {
		return subInvoice;
	}

	/**
	 * @param subInvoice the subInvoice to set
	 */
	public void setSubInvoice(Double subInvoice) {
		this.subInvoice = subInvoice;
	}

	/**
	 * @return the subCost
	 */
	public Double getSubCost() {
		return subCost;
	}

	/**
	 * @param subCost the subCost to set
	 */
	public void setSubCost(Double subCost) {
		this.subCost = subCost;
	}

	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	
    
}
