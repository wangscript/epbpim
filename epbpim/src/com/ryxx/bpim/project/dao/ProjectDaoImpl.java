package com.ryxx.bpim.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.dao.AbstractBaseDAO;
import com.ryxx.bpim.project.entity.ProjectInfo;

public class ProjectDaoImpl extends AbstractBaseDAO<ProjectInfo, Long> implements ProjectDAO
{
    
    @Override
    public void saveProjectInfo(ProjectInfo projectInfo)
    {
        save(projectInfo);
    }
    
    @Override
    public void updateProjectInfo(ProjectInfo projectInfo)
    {
        save(projectInfo);
        
    }
    
    @Override
    public void deleteProjectInfo(ProjectInfo projectInfo)
    {
        remove(projectInfo);
    }
    
    @Override
    public ProjectInfo findProjectInfo(ProjectInfo projectInfo)
    {
        return fetchById(projectInfo.getId());
    }
    
    @Override
    public List<ProjectInfo> listProjectInfo(ProjectInfo projectInfo)
    {
        return findPageByPage(projectInfo.getStartRow(), projectInfo.getPageSize(), wrapCriterion(projectInfo));
    }
    
    @Override
    public int getRowCount(ProjectInfo projectInfo)
    {
        return findByCriteria(wrapCriterion(projectInfo)).size();
        
    }
    
    private Criterion[] wrapCriterion(ProjectInfo projectInfo)
    {
        List<Criterion> list = new ArrayList<Criterion>();
        if (projectInfo != null)
        {
            if (!StringUtils.isEmpty(projectInfo.getName()))
            {
                Criterion criterion1 = Restrictions.like("name", "%" + projectInfo.getName() + "%");
                list.add(criterion1);
            }
        }
        
        Criterion[] criterions = {};
        if (list != null && list.size() > 0)
        {
            criterions = new Criterion[list.size()];
            for (int i = 0; i < list.size(); i++)
            {
                criterions[i] = list.get(i);
            }
        }
        
        return criterions;
    }
}
