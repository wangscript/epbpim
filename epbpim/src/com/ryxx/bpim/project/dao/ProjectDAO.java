package com.ryxx.bpim.project.dao;

import java.util.List;

import com.ryxx.bpim.dao.BaseDAO;
import com.ryxx.bpim.project.entity.ProjectInfo;

public interface ProjectDAO extends BaseDAO<ProjectInfo, Long>
{
    void saveProjectInfo(ProjectInfo projectInfo);
    
    void updateProjectInfo(ProjectInfo projectInfo);
    
    void deleteProjectInfo(ProjectInfo projectInfo);
    
    ProjectInfo findProjectInfo(ProjectInfo projectInfo);
    
    List<ProjectInfo> listProjectInfo(ProjectInfo projectInfo);
    
    int getRowCount(ProjectInfo projectInfo);
}
