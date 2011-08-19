package com.ryxx.bpim.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.dao.AbstractBaseDAO;
import com.ryxx.bpim.user.entity.AdminDept;

public class AdminDeptDAOImpl extends AbstractBaseDAO<AdminDept, Long> implements AdminDeptDAO
{
    
    @Override
    public void addAdminDept(AdminDept adminDept)
    {
        save(adminDept);
    }
    
    @Override
    public void modAdminDept(AdminDept adminDept)
    {
        save(adminDept);
        
    }
    
    @Override
    public void delAdminDept(AdminDept adminDept)
    {
        
    }
    
    @Override
    public List<AdminDept> schAdminDeptList(AdminDept adminDept)
    {
        return findPageByPage(adminDept.getStartRow(), adminDept.getPageSize(), wrapCriterion(adminDept));
    }
    
    @Override
    public int getRowCount(AdminDept adminDept)
    {
        return findByCriteria(wrapCriterion(adminDept)).size();
        
    }
    
    private Criterion[] wrapCriterion(AdminDept adminDept)
    {
        List<Criterion> list = new ArrayList<Criterion>();
        if (adminDept != null)
        {
            if (!StringUtils.isEmpty(adminDept.getName()))
            {
                Criterion criterion1 = Restrictions.like("name", "%" + adminDept.getName() + "%");
                list.add(criterion1);
            }
        }
        Criterion[] criterions = {};
        if (list != null && list.size() > 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                criterions[i] = list.get(i);
            }
        }
        
        return criterions;
    }
    
}
