package com.ryxx.bpim.project.action;

import java.util.List;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.project.entity.ProjectInfo;
import com.ryxx.bpim.project.entity.ProjectStream;
import com.ryxx.bpim.project.service.ProjectService;
import com.ryxx.bpim.project.service.ProjectStreamService;
import com.ryxx.bpim.user.entity.AdminDept;
import com.ryxx.bpim.user.entity.UserInfo;
import com.ryxx.bpim.user.service.AdminDeptService;
import com.ryxx.bpim.user.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class ProjectAction extends ActionSupportBase
{
    
    /** 序列号  */
    private static final long serialVersionUID = 273482916839420012L;
    
    private ProjectInfo projectInfo;
    
    private List<ProjectInfo> projectInfoList;
    
    private ProjectService projectService;
    
    private List<AdminDept> adminDeptList;
    
    private AdminDeptService adminDeptService;
    
    private List<UserInfo> userInfoList;
    
    private UserInfoService userInfoService;
    
    private ProjectStreamService projectStreamService;
    
    private PageTools page;
    
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
            projectInfoList = projectService.listProjectInfo(projectInfo, page);
            if (projectInfoList != null && projectInfoList.size() > 0)
            {
                this.page = page;
            }
            else
            {
                super.addNotFoundErrorMsg();
            }
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String findProjectInfo()
    {
        try
        {
            projectInfo = projectService.findProjectInfo(projectInfo);
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
        adminDeptList = adminDeptService.findAll();
        userInfoList = userInfoService.findAll();
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
    
}
