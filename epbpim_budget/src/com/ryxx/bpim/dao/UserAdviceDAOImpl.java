package com.ryxx.bpim.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.UserAdvice;

/**
 * author Delgado
 */
public class UserAdviceDAOImpl extends AbstractBaseDAO<UserAdvice, Long> implements UserAdviceDAO
{
    
    @Override
    public void saveUserAdvice(UserAdvice userAdvice)
    {
        save(userAdvice);
    }
    
    @Override
    public List<UserAdvice> listUserAdvice(UserAdvice userAdvice)
    {
        return findPageByPage(userAdvice.getStartRow(), userAdvice.getPageSize(), wrapCriterion(userAdvice));
    }
    
    @Override
    public int getRowCount(UserAdvice userAdvice)
    {
        return findByCriteria(wrapCriterion(userAdvice)).size();
        
    }
    
    private Criterion[] wrapCriterion(UserAdvice userAdvice)
    {
        List<Criterion> list = new ArrayList<Criterion>();
        if (userAdvice != null)
        {
            if (null != userAdvice.getId() && 0 != userAdvice.getId())
            {
                Criterion criterion1 = Restrictions.eq("id", userAdvice.getId());
                list.add(criterion1);
            }
            
            //            if (null != userAdvice.getDataType() && !"".equals(userAdvice.getDataType()))
            //            {
            //                if ("1".equals(userAdvice.getDataType()))
            //                {
            //                    sqlSb.append(" AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= DATE(ADVICE_DATE)");
            //                }
            //                else if ("2".equals(userAdvice.getDataType()))
            //                {
            //                    sqlSb.append(" AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= DATE(ADVICE_DATE)");
            //                }
            //            }
           
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
