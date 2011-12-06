package com.ryxx.bpim.project.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.dao.AbstractBaseDAO;
import com.ryxx.bpim.project.entity.ProjectInfo;
import com.ryxx.bpim.user.entity.UserInfo;

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
        Criteria criteria = wrapCriterion(projectInfo);
        criteria.setFirstResult(projectInfo.getStartRow());
        criteria.setMaxResults(projectInfo.getPageSize());
        return criteria.list();
    }
    
    @Override
    public int getRowCount(ProjectInfo projectInfo)
    {
        Criteria criteria = wrapCriterion(projectInfo);
        List<UserInfo> list = criteria.list();
        if (list != null)
        {
            return list.size();
        }
        return 0;
        
    }
    
    private Criteria wrapCriterion(ProjectInfo projectInfo)
    {
        Criteria criteria = getSession().createCriteria(ProjectInfo.class);
        if (projectInfo != null)
        {
            if (!StringUtils.isEmpty(projectInfo.getName()))
            {
                criteria.add(Restrictions.like("name", "%" + projectInfo.getName() + "%"));
            }
            if (!StringUtils.isEmpty(projectInfo.getNumber()))
            {
                criteria.add(Restrictions.eq("number", projectInfo.getNumber()));
            }
            if (null != projectInfo.getDept() && !StringUtils.isEmpty(projectInfo.getDept().getName()))
            {
                criteria.createCriteria("dept").add(Restrictions.like("name", "%" + projectInfo.getDept().getName()
                    + "%"));
                
            }
            if (!StringUtils.isEmpty(projectInfo.getMajorType()))
            {
                criteria.add(Restrictions.eq("majorType", projectInfo.getMajorType()));
            }
            
            if (!StringUtils.isEmpty(projectInfo.getValuationType()))
            {
                criteria.add(Restrictions.eq("valuationType", projectInfo.getValuationType()));
            }
            
            try
            {
                if (!StringUtils.isEmpty(projectInfo.getStartDateFrom()))
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date startDateFrom = sdf.parse(projectInfo.getStartDateFrom());
                    criteria.add(Restrictions.ge("startDate", new Timestamp(startDateFrom.getTime())));
                }
                if (!StringUtils.isEmpty(projectInfo.getStartDateTo()))
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date startDateTo = sdf.parse(projectInfo.getStartDateTo());
                    criteria.add(Restrictions.le("startDate", new Timestamp(startDateTo.getTime())));
                }
            }
            catch (ParseException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return criteria;
    }
}
