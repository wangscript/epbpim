package com.ryxx.bpim.project.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            if (!StringUtils.isEmpty(projectInfo.getNumber()))
            {
                Criterion criterion2 = Restrictions.eq("number", projectInfo.getNumber());
                list.add(criterion2);
            }
            if (!StringUtils.isEmpty(projectInfo.getDept().getName()))
            {
                Criterion criterion3 = Restrictions.like("pdept.name", "%" + projectInfo.getDept().getName() + "%");
                list.add(criterion3);
            }
            
            try
            {
                if (!StringUtils.isEmpty(projectInfo.getStartDateFrom()))
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date startDateFrom = sdf.parse(projectInfo.getStartDateFrom());
                    Criterion criterion4 = Restrictions.ge("startDate", new Timestamp(startDateFrom.getTime()));
                    list.add(criterion4);
                }
                if (!StringUtils.isEmpty(projectInfo.getStartDateTo()))
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date startDateTo = sdf.parse(projectInfo.getStartDateTo());
                    Criterion criterion5 = Restrictions.le("startDate", new Timestamp(startDateTo.getTime()));
                    list.add(criterion5);
                }
            }
            catch (ParseException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
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
