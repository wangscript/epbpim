package com.ryxx.bpim.project.service;

import java.util.List;

import com.ryxx.bpim.project.dao.ProjectDAO;
import com.ryxx.bpim.project.entity.ProjectInfo;
import com.ryxx.bpim.service.BaseService;
import com.ryxx.util.page.PageTools;

public interface ProjectService extends BaseService<ProjectInfo, ProjectDAO, Long>
{
    void saveProjectInfo(ProjectInfo projectInfo);
    
    void updateProjectInfo(ProjectInfo projectInfo);
    
    void deleteProjectInfo(ProjectInfo projectInfo);
    
    ProjectInfo findProjectInfo(ProjectInfo projectInfo);
    
    List<ProjectInfo> listProjectInfo(ProjectInfo projectInfo, PageTools page);
}
