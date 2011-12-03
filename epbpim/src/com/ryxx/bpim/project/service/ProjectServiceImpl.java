package com.ryxx.bpim.project.service;

import java.util.List;

import com.ryxx.bpim.project.dao.ProjectDAO;
import com.ryxx.bpim.project.entity.ProjectInfo;
import com.ryxx.bpim.service.AbstractService;
import com.ryxx.util.page.PageTools;

public class ProjectServiceImpl extends AbstractService<ProjectInfo, ProjectDAO, Long> implements ProjectService
{
    
    @Override
    public void saveProjectInfo(ProjectInfo projectInfo)
    {
        getDao().saveProjectInfo(projectInfo);
    }
    
    @Override
    public void updateProjectInfo(ProjectInfo projectInfo)
    {
        getDao().updateProjectInfo(projectInfo);
    }
    
    @Override
    public void deleteProjectInfo(ProjectInfo projectInfo)
    {
        getDao().deleteProjectInfo(projectInfo);
    }
    
    @Override
    public ProjectInfo findProjectInfo(ProjectInfo projectInfo)
    {
        return getDao().findProjectInfo(projectInfo);
    }
    
    @Override
    public List<ProjectInfo> listProjectInfo(ProjectInfo projectInfo, PageTools page)
    {
        if (page != null)
        {
            if (page.getRecordCount() == 0)
            {
                int count = getDao().getRowCount(projectInfo);
                page.setRecordCount(count);
            }
            projectInfo.setStartRow(page.getPageStartRow());
            projectInfo.setPageSize(page.getPageSize());
        }
        return getDao().listProjectInfo(projectInfo);
    }
    
}