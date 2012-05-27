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
    
    private UserInfo manager;
    
    private String projectType;
    
    private String projectTypeComment;
    
    private String judgePrice1;
    
    private String judgePrice2;
    
    private String judgeDays;
    
    private Timestamp reportDate;
    
    private String reportDatePage;
    
    private String plusPrice;
    
    private String minusPrice;
    
    private String plusPriceRate;
    
    private String minusPriceRate;
    
    private String comments;
    
    private Timestamp achiveDate;
    
    private String achiveDatePage;
    
    private String reportNumber;
    
    private String reportReferNumber;
    
    private String masterJudgeComments;
    
    private String corrective;
    
    private String achiveReceiver;
    
    private Timestamp achiveReceiveDate;
    
    private String contractNumber;
    
    private String contractMoney;
    
    private String contractAbstract;
    
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
    
    private String fileName;
    
    private String oldFileName;
    
    private String filePath;
    
    private Timestamp updateTime;
    
    private Timestamp submitTime;
    
    private Timestamp deptApproveTime;
    
    private Timestamp masterApproveTime;
    
    private Timestamp managerApproveTIme;
    
    private List<ProjectFile> projectFiles;
    
    // 业务人员和账务人员权限更改
    
    private UserInfo formater;
    
    private UserInfo verifier;
    
    private String participant;
    
    private List<ProjectParticipant> participants;
    
    private UserInfo earnestInDrawer;
    
    private Timestamp earnestInInvoiceDate;
    
    private String earnestInNumber;
    
    private String earnestInPrice;
    
    private UserInfo earnestUndertaker;
    
    private Timestamp tenderReceiveDate;
    
    private String tenderInvoiceNumber;
    
    private String tenderInvoicePrice;
    
    private UserInfo tenderUndertaker;
    
    private UserInfo agentInvoiceDrawer;
    
    private Timestamp agentInvoiceDate;
    
    private String agentInvoiceNumber;
    
    private String agentInvoicePrice;
    
    private UserInfo agentInvoiceHolder;
    
    private Timestamp agentReceiveDate;
    
    private String agentReceivePrice;
    
    private String agentAccount;
    
    private String agentComment;
    
    private UserInfo vendorInvoiceDrawer;
    
    private Timestamp vendorInvoiceDate;
    
    private String vendorInvoiceNumber;
    
    private String vendorInvoicePrice;
    
    private UserInfo vendorInvoiceHolder;
    
    private Timestamp vendorReceiveDate;
    
    private String vendorReceivePrice;
    
    private String vendorAccount;
    
    private String vendorComment;
    
    private UserInfo earnestOutRefunder;
    
    private Timestamp earnestOutRefundDate;
    
    private String earnestOutType;
    
    private String earnestOutPrice;
    
    private UserInfo earnestOutUndertaker;
    
    private UserInfo meetingPlacePayer;
    
    private Timestamp meetingPlacePayDate;
    
    private String meetingPlacePrice;
    
    private UserInfo meetingPlaceUndertaker;
    
    private String meetingPlaceAddress;
    
    private UserInfo expertPayer;
    
    private Timestamp expertPayDate;
    
    private String expertPrice;
    
    private UserInfo expertUndertaker;
    
    private String expertPerson;
    
    private String costRemittee;
    
    private String costSettleDate;
    
    private String costApprover;
    
    private String costApproveDate;
    
    private String costPrice;
    
    private String costAccount;
    
    private String costComment;
    
    private List<ProjectCost> costs;
    
    public UserInfo getFormater()
    {
        return formater;
    }
    
    public void setFormater(UserInfo formater)
    {
        this.formater = formater;
    }
    
    public UserInfo getVerifier()
    {
        return verifier;
    }
    
    public void setVerifier(UserInfo verifier)
    {
        this.verifier = verifier;
    }
    
    public String getParticipant()
    {
        return participant;
    }
    
    public void setParticipant(String participant)
    {
        this.participant = participant;
    }
    
    public List<ProjectParticipant> getParticipants()
    {
        return participants;
    }
    
    public void setParticipants(List<ProjectParticipant> participants)
    {
        this.participants = participants;
    }
    
    public UserInfo getEarnestInDrawer()
    {
        return earnestInDrawer;
    }
    
    public void setEarnestInDrawer(UserInfo earnestInDrawer)
    {
        this.earnestInDrawer = earnestInDrawer;
    }
    
    public Timestamp getEarnestInInvoiceDate()
    {
        return earnestInInvoiceDate;
    }
    
    public void setEarnestInInvoiceDate(Timestamp earnestInInvoiceDate)
    {
        this.earnestInInvoiceDate = earnestInInvoiceDate;
    }
    
    public String getEarnestInNumber()
    {
        return earnestInNumber;
    }
    
    public void setEarnestInNumber(String earnestInNumber)
    {
        this.earnestInNumber = earnestInNumber;
    }
    
    public String getEarnestInPrice()
    {
        return earnestInPrice;
    }
    
    public void setEarnestInPrice(String earnestInPrice)
    {
        this.earnestInPrice = earnestInPrice;
    }
    
    public UserInfo getEarnestUndertaker()
    {
        return earnestUndertaker;
    }
    
    public void setEarnestUndertaker(UserInfo earnestUndertaker)
    {
        this.earnestUndertaker = earnestUndertaker;
    }
    
    public Timestamp getTenderReceiveDate()
    {
        return tenderReceiveDate;
    }
    
    public void setTenderReceiveDate(Timestamp tenderReceiveDate)
    {
        this.tenderReceiveDate = tenderReceiveDate;
    }
    
    public String getTenderInvoiceNumber()
    {
        return tenderInvoiceNumber;
    }
    
    public void setTenderInvoiceNumber(String tenderInvoiceNumber)
    {
        this.tenderInvoiceNumber = tenderInvoiceNumber;
    }
    
    public String getTenderInvoicePrice()
    {
        return tenderInvoicePrice;
    }
    
    public void setTenderInvoicePrice(String tenderInvoicePrice)
    {
        this.tenderInvoicePrice = tenderInvoicePrice;
    }
    
    public UserInfo getTenderUndertaker()
    {
        return tenderUndertaker;
    }
    
    public void setTenderUndertaker(UserInfo tenderUndertaker)
    {
        this.tenderUndertaker = tenderUndertaker;
    }
    
    public UserInfo getAgentInvoiceDrawer()
    {
        return agentInvoiceDrawer;
    }
    
    public void setAgentInvoiceDrawer(UserInfo agentInvoiceDrawer)
    {
        this.agentInvoiceDrawer = agentInvoiceDrawer;
    }
    
    public Timestamp getAgentInvoiceDate()
    {
        return agentInvoiceDate;
    }
    
    public void setAgentInvoiceDate(Timestamp agentInvoiceDate)
    {
        this.agentInvoiceDate = agentInvoiceDate;
    }
    
    public String getAgentInvoiceNumber()
    {
        return agentInvoiceNumber;
    }
    
    public void setAgentInvoiceNumber(String agentInvoiceNumber)
    {
        this.agentInvoiceNumber = agentInvoiceNumber;
    }
    
    public String getAgentInvoicePrice()
    {
        return agentInvoicePrice;
    }
    
    public void setAgentInvoicePrice(String agentInvoicePrice)
    {
        this.agentInvoicePrice = agentInvoicePrice;
    }
    
    public UserInfo getAgentInvoiceHolder()
    {
        return agentInvoiceHolder;
    }
    
    public void setAgentInvoiceHolder(UserInfo agentInvoiceHolder)
    {
        this.agentInvoiceHolder = agentInvoiceHolder;
    }
    
    public Timestamp getAgentReceiveDate()
    {
        return agentReceiveDate;
    }
    
    public void setAgentReceiveDate(Timestamp agentReceiveDate)
    {
        this.agentReceiveDate = agentReceiveDate;
    }
    
    public String getAgentReceivePrice()
    {
        return agentReceivePrice;
    }
    
    public void setAgentReceivePrice(String agentReceivePrice)
    {
        this.agentReceivePrice = agentReceivePrice;
    }
    
    public String getAgentAccount()
    {
        return agentAccount;
    }
    
    public void setAgentAccount(String agentAccount)
    {
        this.agentAccount = agentAccount;
    }
    
    public String getAgentComment()
    {
        return agentComment;
    }
    
    public void setAgentComment(String agentComment)
    {
        this.agentComment = agentComment;
    }
    
    public UserInfo getVendorInvoiceDrawer()
    {
        return vendorInvoiceDrawer;
    }
    
    public void setVendorInvoiceDrawer(UserInfo vendorInvoiceDrawer)
    {
        this.vendorInvoiceDrawer = vendorInvoiceDrawer;
    }
    
    public Timestamp getVendorInvoiceDate()
    {
        return vendorInvoiceDate;
    }
    
    public void setVendorInvoiceDate(Timestamp vendorInvoiceDate)
    {
        this.vendorInvoiceDate = vendorInvoiceDate;
    }
    
    public String getVendorInvoiceNumber()
    {
        return vendorInvoiceNumber;
    }
    
    public void setVendorInvoiceNumber(String vendorInvoiceNumber)
    {
        this.vendorInvoiceNumber = vendorInvoiceNumber;
    }
    
    public String getVendorInvoicePrice()
    {
        return vendorInvoicePrice;
    }
    
    public void setVendorInvoicePrice(String vendorInvoicePrice)
    {
        this.vendorInvoicePrice = vendorInvoicePrice;
    }
    
    public UserInfo getVendorInvoiceHolder()
    {
        return vendorInvoiceHolder;
    }
    
    public void setVendorInvoiceHolder(UserInfo vendorInvoiceHolder)
    {
        this.vendorInvoiceHolder = vendorInvoiceHolder;
    }
    
    public Timestamp getVendorReceiveDate()
    {
        return vendorReceiveDate;
    }
    
    public void setVendorReceiveDate(Timestamp vendorReceiveDate)
    {
        this.vendorReceiveDate = vendorReceiveDate;
    }
    
    public String getVendorReceivePrice()
    {
        return vendorReceivePrice;
    }
    
    public void setVendorReceivePrice(String vendorReceivePrice)
    {
        this.vendorReceivePrice = vendorReceivePrice;
    }
    
    public String getVendorAccount()
    {
        return vendorAccount;
    }
    
    public void setVendorAccount(String vendorAccount)
    {
        this.vendorAccount = vendorAccount;
    }
    
    public String getVendorComment()
    {
        return vendorComment;
    }
    
    public void setVendorComment(String vendorComment)
    {
        this.vendorComment = vendorComment;
    }
    
    public UserInfo getEarnestOutRefunder()
    {
        return earnestOutRefunder;
    }
    
    public void setEarnestOutRefunder(UserInfo earnestOutRefunder)
    {
        this.earnestOutRefunder = earnestOutRefunder;
    }
    
    public Timestamp getEarnestOutRefundDate()
    {
        return earnestOutRefundDate;
    }
    
    public void setEarnestOutRefundDate(Timestamp earnestOutRefundDate)
    {
        this.earnestOutRefundDate = earnestOutRefundDate;
    }
    
    public String getEarnestOutType()
    {
        return earnestOutType;
    }
    
    public void setEarnestOutType(String earnestOutType)
    {
        this.earnestOutType = earnestOutType;
    }
    
    public String getEarnestOutPrice()
    {
        return earnestOutPrice;
    }
    
    public void setEarnestOutPrice(String earnestOutPrice)
    {
        this.earnestOutPrice = earnestOutPrice;
    }
    
    public UserInfo getEarnestOutUndertaker()
    {
        return earnestOutUndertaker;
    }
    
    public void setEarnestOutUndertaker(UserInfo earnestOutUndertaker)
    {
        this.earnestOutUndertaker = earnestOutUndertaker;
    }
    
    public UserInfo getMeetingPlacePayer()
    {
        return meetingPlacePayer;
    }
    
    public void setMeetingPlacePayer(UserInfo meetingPlacePayer)
    {
        this.meetingPlacePayer = meetingPlacePayer;
    }
    
    public Timestamp getMeetingPlacePayDate()
    {
        return meetingPlacePayDate;
    }
    
    public void setMeetingPlacePayDate(Timestamp meetingPlacePayDate)
    {
        this.meetingPlacePayDate = meetingPlacePayDate;
    }
    
    public String getMeetingPlacePrice()
    {
        return meetingPlacePrice;
    }
    
    public void setMeetingPlacePrice(String meetingPlacePrice)
    {
        this.meetingPlacePrice = meetingPlacePrice;
    }
    
    public UserInfo getMeetingPlaceUndertaker()
    {
        return meetingPlaceUndertaker;
    }
    
    public void setMeetingPlaceUndertaker(UserInfo meetingPlaceUndertaker)
    {
        this.meetingPlaceUndertaker = meetingPlaceUndertaker;
    }
    
    public String getMeetingPlaceAddress()
    {
        return meetingPlaceAddress;
    }
    
    public void setMeetingPlaceAddress(String meetingPlaceAddress)
    {
        this.meetingPlaceAddress = meetingPlaceAddress;
    }
    
    public UserInfo getExpertPayer()
    {
        return expertPayer;
    }
    
    public void setExpertPayer(UserInfo expertPayer)
    {
        this.expertPayer = expertPayer;
    }
    
    public Timestamp getExpertPayDate()
    {
        return expertPayDate;
    }
    
    public void setExpertPayDate(Timestamp expertPayDate)
    {
        this.expertPayDate = expertPayDate;
    }
    
    public String getExpertPrice()
    {
        return expertPrice;
    }
    
    public void setExpertPrice(String expertPrice)
    {
        this.expertPrice = expertPrice;
    }
    
    public UserInfo getExpertUndertaker()
    {
        return expertUndertaker;
    }
    
    public void setExpertUndertaker(UserInfo expertUndertaker)
    {
        this.expertUndertaker = expertUndertaker;
    }
    
    public String getExpertPerson()
    {
        return expertPerson;
    }
    
    public void setExpertPerson(String expertPerson)
    {
        this.expertPerson = expertPerson;
    }
    
    public String getCostRemittee()
    {
        return costRemittee;
    }
    
    public void setCostRemittee(String costRemittee)
    {
        this.costRemittee = costRemittee;
    }
    
    public String getCostSettleDate()
    {
        return costSettleDate;
    }
    
    public void setCostSettleDate(String costSettleDate)
    {
        this.costSettleDate = costSettleDate;
    }
    
    public String getCostApprover()
    {
        return costApprover;
    }
    
    public void setCostApprover(String costApprover)
    {
        this.costApprover = costApprover;
    }
    
    public String getCostApproveDate()
    {
        return costApproveDate;
    }
    
    public void setCostApproveDate(String costApproveDate)
    {
        this.costApproveDate = costApproveDate;
    }
    
    public String getCostPrice()
    {
        return costPrice;
    }
    
    public void setCostPrice(String costPrice)
    {
        this.costPrice = costPrice;
    }
    
    public String getCostAccount()
    {
        return costAccount;
    }
    
    public void setCostAccount(String costAccount)
    {
        this.costAccount = costAccount;
    }
    
    public String getCostComment()
    {
        return costComment;
    }
    
    public void setCostComment(String costComment)
    {
        this.costComment = costComment;
    }
    
    public List<ProjectCost> getCosts()
    {
        return costs;
    }
    
    public void setCosts(List<ProjectCost> costs)
    {
        this.costs = costs;
    }
    
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
    
    public UserInfo getManager()
    {
        return manager;
    }
    
    public void setManager(UserInfo manager)
    {
        this.manager = manager;
    }
    
    public String getProjectType()
    {
        return projectType;
    }
    
    public void setProjectType(String projectType)
    {
        this.projectType = projectType;
    }
    
    public String getProjectTypeComment()
    {
        return projectTypeComment;
    }
    
    public void setProjectTypeComment(String projectTypeComment)
    {
        this.projectTypeComment = projectTypeComment;
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
    public Double getSubInvoice()
    {
        return subInvoice;
    }
    
    /**
     * @param subInvoice the subInvoice to set
     */
    public void setSubInvoice(Double subInvoice)
    {
        this.subInvoice = subInvoice;
    }
    
    /**
     * @return the subCost
     */
    public Double getSubCost()
    {
        return subCost;
    }
    
    /**
     * @param subCost the subCost to set
     */
    public void setSubCost(Double subCost)
    {
        this.subCost = subCost;
    }
    
    /**
     * @return the balance
     */
    public Double getBalance()
    {
        return balance;
    }
    
    /**
     * @param balance the balance to set
     */
    public void setBalance(Double balance)
    {
        this.balance = balance;
    }
    
    public String getFileName()
    {
        return fileName;
    }
    
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    public String getOldFileName()
    {
        return oldFileName;
    }
    
    public void setOldFileName(String oldFileName)
    {
        this.oldFileName = oldFileName;
    }
    
    public String getFilePath()
    {
        return filePath;
    }
    
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }
    
    public List<ProjectFile> getProjectFiles()
    {
        return projectFiles;
    }
    
    public void setProjectFiles(List<ProjectFile> projectFiles)
    {
        this.projectFiles = projectFiles;
    }
    
    public Timestamp getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(Timestamp updateTime)
    {
        this.updateTime = updateTime;
    }
    
    /**
     * @return the submitTime
     */
    public Timestamp getSubmitTime()
    {
        return submitTime;
    }
    
    /**
     * @param submitTime the submitTime to set
     */
    public void setSubmitTime(Timestamp submitTime)
    {
        this.submitTime = submitTime;
    }
    
    /**
     * @return the deptApproveTime
     */
    public Timestamp getDeptApproveTime()
    {
        return deptApproveTime;
    }
    
    /**
     * @param deptApproveTime the deptApproveTime to set
     */
    public void setDeptApproveTime(Timestamp deptApproveTime)
    {
        this.deptApproveTime = deptApproveTime;
    }
    
    /**
     * @return the masterApproveTime
     */
    public Timestamp getMasterApproveTime()
    {
        return masterApproveTime;
    }
    
    /**
     * @param masterApproveTime the masterApproveTime to set
     */
    public void setMasterApproveTime(Timestamp masterApproveTime)
    {
        this.masterApproveTime = masterApproveTime;
    }
    
    /**
     * @return the managerApproveTIme
     */
    public Timestamp getManagerApproveTIme()
    {
        return managerApproveTIme;
    }
    
    /**
     * @param managerApproveTIme the managerApproveTIme to set
     */
    public void setManagerApproveTIme(Timestamp managerApproveTIme)
    {
        this.managerApproveTIme = managerApproveTIme;
    }
    
    public String getPlusPriceRate()
    {
        return plusPriceRate;
    }
    
    public void setPlusPriceRate(String plusPriceRate)
    {
        this.plusPriceRate = plusPriceRate;
    }
    
    public String getMinusPriceRate()
    {
        return minusPriceRate;
    }
    
    public void setMinusPriceRate(String minusPriceRate)
    {
        this.minusPriceRate = minusPriceRate;
    }
    
    public String getReportReferNumber()
    {
        return reportReferNumber;
    }
    
    public void setReportReferNumber(String reportReferNumber)
    {
        this.reportReferNumber = reportReferNumber;
    }
    
    public String getCorrective()
    {
        return corrective;
    }
    
    public void setCorrective(String corrective)
    {
        this.corrective = corrective;
    }
    
    public Timestamp getAchiveReceiveDate()
    {
        return achiveReceiveDate;
    }
    
    public void setAchiveReceiveDate(Timestamp achiveReceiveDate)
    {
        this.achiveReceiveDate = achiveReceiveDate;
    }
}
