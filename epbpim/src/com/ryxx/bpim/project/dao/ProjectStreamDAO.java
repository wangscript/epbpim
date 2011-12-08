package com.ryxx.bpim.project.dao;

import java.util.List;

import com.ryxx.bpim.dao.BaseDAO;
import com.ryxx.bpim.project.entity.ProjectStream;

public interface ProjectStreamDAO extends BaseDAO<ProjectStream, Long>
{
    void saveProjectStream(ProjectStream projectStream);
    
    void deleteProjectStream(ProjectStream projectStream);
    
    List<ProjectStream> listProjectStream(ProjectStream projectStream);
}
