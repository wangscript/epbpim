package com.ryxx.bpim.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.GovernmentInventory;

/**
 * author Delgado
 */
public class GovernmentInventoryDAOImpl extends AbstractBaseDAO<GovernmentInventory, Long> implements
    GovernmentInventoryDAO
{
    
    @Override
    public List<GovernmentInventory> listGovernmentInventory(GovernmentInventory governmentInventory)
    {
        return findPageByPage(governmentInventory.getStartRow(),
            governmentInventory.getPageSize(),
            wrapCriterion(governmentInventory));
    }
    
    @Override
    public int getRowCount(GovernmentInventory governmentInventory)
    {
        return findByCriteria(wrapCriterion(governmentInventory)).size();
        
    }
    
    private Criterion[] wrapCriterion(GovernmentInventory governmentInventory)
    {
        List<Criterion> list = new ArrayList<Criterion>();
        if (governmentInventory != null)
        {
            if (!StringUtils.isEmpty(governmentInventory.getGovernmentInventoryType()))
            {
                Criterion criterion1 =
                    Restrictions.eq("governmentInventoryType", governmentInventory.getGovernmentInventoryType());
                list.add(criterion1);
            }
            
            if (!StringUtils.isEmpty(governmentInventory.getProjectClassLevel1Num()))
            {
                Criterion criterion2 =
                    Restrictions.eq("projectClassLevel1Num", governmentInventory.getProjectClassLevel1Num());
                list.add(criterion2);
            }
            
            if (!StringUtils.isEmpty(governmentInventory.getProjectClassLevel2Num()))
            {
                Criterion criterion3 =
                    Restrictions.eq("projectClassLevel2Num", governmentInventory.getProjectClassLevel2Num());
                list.add(criterion3);
            }
            
            if (!StringUtils.isEmpty(governmentInventory.getProjectNum()))
            {
                Criterion criterion4 = Restrictions.eq("projectNum", governmentInventory.getProjectNum());
                list.add(criterion4);
            }
            
            if (!StringUtils.isEmpty(governmentInventory.getProjectName()))
            {
                Criterion criterion5 =
                    Restrictions.like("projectName", "%" + governmentInventory.getProjectName() + "%");
                list.add(criterion5);
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
