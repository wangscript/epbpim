package com.ryxx.bpim.project.action;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.project.entity.ProjectStream;
import com.ryxx.bpim.project.service.ProjectStreamService;
import com.ryxx.bpim.user.entity.UserInfo;
import com.ryxx.bpim.web.action.ActionSupportBase;

public class ProjectStreamAction extends ActionSupportBase
{
    
    /** 序列号  */
    private static final long serialVersionUID = -6829547597910423243L;
    
    private long projectID;
    
    private ProjectStream projectStream;
    
    private ProjectStreamService projectStreamService;
    
    public String addProjectStream()
    {
        try
        {
            projectID = projectStream.getProjectID();
            
            UserInfo userinfo = new UserInfo();
            userinfo.setId((Long)session.get(Constants.LOGIN_USER_ID));
            projectStream.setSubmitter(userinfo);
            
            projectStreamService.saveProjectStream(projectStream);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String delProjectStream()
    {
        try
        {
            projectID = projectStream.getProjectID();
            projectStreamService.deleteProjectStream(projectStream);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    public long getProjectID()
    {
        return projectID;
    }
    
    public void setProjectID(long projectID)
    {
        this.projectID = projectID;
    }
    
    public ProjectStream getProjectStream()
    {
        return projectStream;
    }
    
    public void setProjectStream(ProjectStream projectStream)
    {
        this.projectStream = projectStream;
    }
    
    public ProjectStreamService getProjectStreamService()
    {
        return projectStreamService;
    }
    
    public void setProjectStreamService(ProjectStreamService projectStreamService)
    {
        this.projectStreamService = projectStreamService;
    }
    
}
