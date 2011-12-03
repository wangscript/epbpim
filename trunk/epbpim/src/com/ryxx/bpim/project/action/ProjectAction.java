package com.ryxx.bpim.project.action;

import java.util.List;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.project.entity.ProjectInfo;
import com.ryxx.bpim.project.service.ProjectService;
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
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
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
            projectService.saveProjectInfo(projectInfo);
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
    
    public PageTools getPage()
    {
        return page;
    }
    
    public void setPage(PageTools page)
    {
        this.page = page;
    }
}
