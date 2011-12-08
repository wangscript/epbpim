package com.ryxx.bpim.project.service;

import java.util.List;

import com.ryxx.bpim.project.dao.ProjectStreamDAO;
import com.ryxx.bpim.project.entity.ProjectStream;
import com.ryxx.bpim.service.BaseService;

public interface ProjectStreamService extends BaseService<ProjectStream, ProjectStreamDAO, Long>
{
    void saveProjectStream(ProjectStream projectStream);
    
    void deleteProjectStream(ProjectStream projectStream);
    
    List<ProjectStream> listProjectStream(ProjectStream projectStream);
}
