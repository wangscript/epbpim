package com.ryxx.bpim.project.action;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.project.entity.ProjectInfo;
import com.ryxx.bpim.project.entity.ProjectInvoice;
import com.ryxx.bpim.project.entity.ProjectStream;
import com.ryxx.bpim.project.service.ProjectService;
import com.ryxx.bpim.project.service.ProjectStreamService;
import com.ryxx.bpim.user.entity.AdminDept;
import com.ryxx.bpim.user.entity.UserInfo;
import com.ryxx.bpim.user.service.AdminDeptService;
import com.ryxx.bpim.user.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.io.FileUtil;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class ProjectAction extends ActionSupportBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = 273482916839420012L;
    
    /** 目录分隔符 */
    private final String FILE_SEAPRATOR = System.getProperty("file.separator");
    
    private ProjectInfo projectInfo;
    
    private List<ProjectInfo> projectInfoList;
    
    private ProjectService projectService;
    
    private List<AdminDept> adminDeptList;
    
    private AdminDeptService adminDeptService;
    
    private List<UserInfo> userInfoList;
    
    private UserInfoService userInfoService;
    
    private ProjectStreamService projectStreamService;
    
    private PageTools page;
    
    private File[] uploadFiles;
    
    public String schProjectInfoList()
    {
        try
        {
            if (null == projectInfo)
            {
                projectInfo = new ProjectInfo();
            }
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 10);
            PageTools page = new PageTools(pageNo, pageSize);
            projectInfo.setRowCount(pageNo);
            projectInfo.setPageSize(pageSize);
            dealwithQueryType(projectInfo);
            projectInfoList = projectService.listProjectInfo(projectInfo, page);
            projectInfoList = executeData(projectInfoList);
            if (projectInfoList != null && projectInfoList.size() > 0)
            {
                this.page = page;
            }
            else
            {
                super.addNotFoundErrorMsg();
            }
            
            wrapDeptAndUserList();
            
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    /**
     * @param projectInfoList2
     * @return
     */
    private List<ProjectInfo> executeData(List<ProjectInfo> projectInfoList)
    {
        for (ProjectInfo project : projectInfoList)
        {
            wrapInvoiceList(project);
            
            Double subInvoice = (double)0;
            if (project.getProjectInvoices() != null)
            {
                Double invoicePrice = (double)0;
                for (ProjectInvoice invoice : project.getProjectInvoices())
                {
                    if (invoice.getInvoicePrice() != null && !"".equals(invoice.getInvoicePrice()))
                    {
                        try
                        {
                            invoicePrice = Double.valueOf(invoice.getInvoicePrice());
                            subInvoice = subInvoice + invoicePrice;
                        }
                        catch (Exception e)
                        {
                            continue;
                        }
                    }
                }
            }
            project.setSubInvoice(subInvoice);
            
            ProjectStream projectStream = new ProjectStream();
            projectStream.setProjectID(project.getId());
            List<ProjectStream> streams = projectStreamService.listProjectStream(projectStream);
            Double subCost = (double)0;
            if (streams != null)
            {
                
                for (ProjectStream stream : streams)
                {
                    if (stream.getType() == 1)
                    {
                        subCost = subCost + stream.getMoney();
                    }
                }
            }
            project.setSubCost(subCost);
            
            project.setBalance(subInvoice - subCost);
        }
        return projectInfoList;
    }
    
    public String findProjectInfo()
    {
        try
        {
            projectInfo = projectService.findProjectInfo(projectInfo);
            wrapInvoiceList(projectInfo);
            ProjectStream projectStream = new ProjectStream();
            projectStream.setProjectID(projectInfo.getId());
            projectInfo.setProjectStreams(projectStreamService.listProjectStream(projectStream));
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String preAddProjectInfo()
    {
        try
        {
            wrapDeptAndUserList();
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String addProjectInfo()
    {
        try
        {
            UserInfo userinfo = new UserInfo();
            userinfo.setId((Long)session.get(Constants.LOGIN_USER_ID));
            projectInfo.setSubmitter(userinfo);
            
            projectService.saveProjectInfo(projectInfo);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String preModProjectInfo()
    {
        try
        {
            wrapDeptAndUserList();
            findProjectInfo();
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String modProjectInfo()
    {
        try
        {
            projectService.updateProjectInfo(projectInfo);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        
        return SUCCESS;
    }
    
    public String modProjectContractAndInvoices(){
		if(projectInfo!=null){
			ProjectInfo preProjectInfo = projectService.findProjectInfo(projectInfo);
			if(!StringUtils.isBlank(projectInfo.getContractNumber())){
				preProjectInfo.setContractNumber(projectInfo.getContractNumber());
			}
			if(!StringUtils.isBlank(projectInfo.getContractMoney())){
				preProjectInfo.setContractMoney(projectInfo.getContractMoney());
			}
			if(!StringUtils.isBlank(projectInfo.getContractAbstract())){
				preProjectInfo.setContractAbstract(projectInfo.getContractAbstract());
			}
			if(!StringUtils.isBlank(projectInfo.getInvoiceDate())){
				preProjectInfo.setInvoiceDate(projectInfo.getInvoiceDate());
			}
			if(!StringUtils.isBlank(projectInfo.getInvoiceNumber())){
				preProjectInfo.setInvoiceNumber(projectInfo.getInvoiceNumber().replaceAll(", ", ","));
			}
			if(!StringUtils.isBlank(projectInfo.getInvoicePrice())){
				preProjectInfo.setInvoicePrice(projectInfo.getInvoicePrice().replaceAll(", ", ","));
			}
			if(!StringUtils.isBlank(projectInfo.getInvoiceMoneyArrival())){
				preProjectInfo.setInvoiceMoneyArrival(projectInfo.getInvoiceMoneyArrival().replaceAll(", ", ","));
			}
			projectService.updateProjectInfo(preProjectInfo);
		}
		return SUCCESS;
	}
    
    public String closeProjectInfo()
    {
        try
        {
            projectInfo = projectService.fetchById(projectInfo.getId());
            projectInfo.setStatus("2");
            projectService.updateProjectInfo(projectInfo);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        
        return SUCCESS;
    }
    
    public String delProjectInfo()
    {
        try
        {
            projectService.deleteProjectInfo(projectInfo);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    private void wrapDeptAndUserList()
    {
        userInfoList = userInfoService.findAll();
        UserInfo userInfo = userInfoService.fetchById((Long)session.get(Constants.LOGIN_USER_ID));
        adminDeptList = userInfo.getDepts();
    }
    
    private void wrapInvoiceList(ProjectInfo projectInfo)
    {
        int invoiceCount = projectInfo.getInvoiceDate().split(",").length;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        List<ProjectInvoice> projectInvoices = new ArrayList<ProjectInvoice>();
        
        for (int i = 0; i < invoiceCount; i++)
        {
            ProjectInvoice projectInvoice = new ProjectInvoice();
            try
            {
                if (!StringUtils.isEmpty(projectInfo.getInvoiceDate().split(",")[i])
                    && !StringUtils.isEmpty(projectInfo.getInvoiceDate().split(",")[i].trim()))
                {
                    Date invoiceDate = sdf.parse(projectInfo.getInvoiceDate().split(",")[i]);
                    projectInvoice.setInvoiceDate(new Timestamp(invoiceDate.getTime()));
                }
                projectInvoice.setInvoiceNumber(projectInfo.getInvoiceNumber().split(",")[i]);
                projectInvoice.setInvoicePrice(projectInfo.getInvoicePrice().split(",")[i]);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            projectInvoices.add(projectInvoice);
        }
        
        projectInfo.setProjectInvoices(projectInvoices);
        
    }
    
    private void dealwithQueryType(ProjectInfo projectInfo)
    {
        if ("1".equals(projectInfo.getQueryType()) || StringUtils.isEmpty(projectInfo.getQueryType()))
        {
            long userID = (Long)session.get(Constants.LOGIN_USER_ID);
            UserInfo userInfo = new UserInfo();
            userInfo.setId(userID);
            projectInfo.setSubmitter(userInfo);
        }
        else if ("2".equals(projectInfo.getQueryType()))
        {
            UserInfo userInfo = userInfoService.fetchById((Long)session.get(Constants.LOGIN_USER_ID));
            StringBuffer strb = new StringBuffer();
            for (AdminDept adminDept : userInfo.getDepts())
            {
                strb.append(adminDept.getId()).append(",");
            }
            if (strb.length() > 0)
            {
                strb.deleteCharAt(strb.length() - 1);
            }
            projectInfo.setDeptIDs(strb.toString());
        }
    }
    
    private File[] dealWithUploadFiles()
        throws Exception
    {
        File[] newUploadFiles = new File[uploadFiles.length];
        
        StringBuffer filePath = new StringBuffer();
        for (int i = 0; i < uploadFiles.length; i++)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String newFileName = sdf.format(new Date());
            
            String oldFileName = projectInfo.getFileName().split(",")[i];
            if (oldFileName.contains("."))
            {
                newFileName += oldFileName.substring(oldFileName.lastIndexOf("."), oldFileName.length());
            }
            
            String fileDir =
                request.getRealPath("/") + FILE_SEAPRATOR + "uploadfile" + FILE_SEAPRATOR + projectInfo.getId();
            
            File fileDirFile = new File(fileDir);
            if (!fileDirFile.exists())
            {
                fileDirFile.mkdirs();
            }
            File newUploadFile = new File(fileDir + FILE_SEAPRATOR + newFileName);
            newUploadFiles[i] = newUploadFile;
            
            FileUtil.copy(uploadFiles[i], newUploadFile, false);
            
            String filePathPer =
                "http://" + request.getLocalAddr() + ":" + request.getLocalPort() + request.getContextPath()
                    + "/uploadfile/" + projectInfo.getId() + "/" + newFileName;
            filePath.append(filePathPer).append(",");
        }
        if (0 < filePath.length())
        {
            filePath.deleteCharAt(filePath.length() - 1);
        }
        
        projectInfo.setFilePath(filePath.toString());
        
        return newUploadFiles;
        
    }
    
    public ProjectInfo getProjectInfo()
    {
        return projectInfo;
    }
    
    public void setProjectInfo(ProjectInfo projectInfo)
    {
        this.projectInfo = projectInfo;
    }
    
    public List<ProjectInfo> getProjectInfoList()
    {
        return projectInfoList;
    }
    
    public void setProjectInfoList(List<ProjectInfo> projectInfoList)
    {
        this.projectInfoList = projectInfoList;
    }
    
    public ProjectService getProjectService()
    {
        return projectService;
    }
    
    public void setProjectService(ProjectService projectService)
    {
        this.projectService = projectService;
    }
    
    public List<AdminDept> getAdminDeptList()
    {
        return adminDeptList;
    }
    
    public void setAdminDeptList(List<AdminDept> adminDeptList)
    {
        this.adminDeptList = adminDeptList;
    }
    
    public AdminDeptService getAdminDeptService()
    {
        return adminDeptService;
    }
    
    public void setAdminDeptService(AdminDeptService adminDeptService)
    {
        this.adminDeptService = adminDeptService;
    }
    
    public List<UserInfo> getUserInfoList()
    {
        return userInfoList;
    }
    
    public void setUserInfoList(List<UserInfo> userInfoList)
    {
        this.userInfoList = userInfoList;
    }
    
    public UserInfoService getUserInfoService()
    {
        return userInfoService;
    }
    
    public void setUserInfoService(UserInfoService userInfoService)
    {
        this.userInfoService = userInfoService;
    }
    
    public ProjectStreamService getProjectStreamService()
    {
        return projectStreamService;
    }
    
    public void setProjectStreamService(ProjectStreamService projectStreamService)
    {
        this.projectStreamService = projectStreamService;
    }
    
    public PageTools getPage()
    {
        return page;
    }
    
    public void setPage(PageTools page)
    {
        this.page = page;
    }
    
    public File[] getUploadFiles()
    {
        return uploadFiles;
    }
    
    public void setUploadFiles(File[] uploadFiles)
    {
        this.uploadFiles = uploadFiles;
    }
    
}
