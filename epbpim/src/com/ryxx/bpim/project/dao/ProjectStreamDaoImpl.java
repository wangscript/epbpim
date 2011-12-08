package com.ryxx.bpim.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.dao.AbstractBaseDAO;
import com.ryxx.bpim.project.entity.ProjectStream;

public class ProjectStreamDaoImpl extends AbstractBaseDAO<ProjectStream, Long> implements ProjectStreamDAO
{
    
    @Override
    public void saveProjectStream(ProjectStream projectStream)
    {
        save(projectStream);
    }
    
    @Override
    public void deleteProjectStream(ProjectStream projectStream)
    {
        remove(projectStream);
    }
    
    @Override
    public List<ProjectStream> listProjectStream(ProjectStream projectStream)
    {
        Criteria criteria = getSession().createCriteria(ProjectStream.class);
        criteria.add(Restrictions.eq("projectID", projectStream.getProjectID()));
        criteria.addOrder(Order.desc("streamDate"));
        return criteria.list();
    }
}
