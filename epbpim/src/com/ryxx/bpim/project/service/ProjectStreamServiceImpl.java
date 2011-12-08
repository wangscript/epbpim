package com.ryxx.bpim.project.service;

import java.util.List;

import com.ryxx.bpim.project.dao.ProjectStreamDAO;
import com.ryxx.bpim.project.entity.ProjectStream;
import com.ryxx.bpim.service.AbstractService;

public class ProjectStreamServiceImpl extends AbstractService<ProjectStream, ProjectStreamDAO, Long> implements
    ProjectStreamService
{
    
    @Override
    public void saveProjectStream(ProjectStream projectStream)
    {
        getDao().saveProjectStream(projectStream);
    }
    
    @Override
    public void deleteProjectStream(ProjectStream projectStream)
    {
        getDao().deleteProjectStream(projectStream);
    }
    
    @Override
    public List<ProjectStream> listProjectStream(ProjectStream projectStream)
    {
        return getDao().listProjectStream(projectStream);
    }
}