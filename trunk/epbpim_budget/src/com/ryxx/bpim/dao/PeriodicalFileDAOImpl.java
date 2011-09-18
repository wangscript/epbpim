package com.ryxx.bpim.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.PeriodicalFile;

/**
 * author Delgado
 */
public class PeriodicalFileDAOImpl extends AbstractBaseDAO<PeriodicalFile, Long> implements PeriodicalFileDAO
{
    @Override
    public void savePeriodicalFile(PeriodicalFile periodicalFile)
    {
        save(periodicalFile);
    }
    
    @Override
    public void deletePeriodicalFile(PeriodicalFile periodicalFile)
    {
        remove(periodicalFile);
    }
    
    @Override
    public PeriodicalFile viewPeriodicalFile(PeriodicalFile periodicalFile)
    {
        // TODO Auto-generated method stub
        return findById(periodicalFile.getId());
    }
    
    @Override
    public List<PeriodicalFile> listPeriodicalFile(PeriodicalFile periodicalFile)
    {
        return findPageByPage(periodicalFile.getStartRow(), periodicalFile.getPageSize(), wrapCriterion(periodicalFile));
    }
    
    @Override
    public int getRowCount(PeriodicalFile periodicalFile)
    {
        return findByCriteria(wrapCriterion(periodicalFile)).size();
        
    }
    
    private Criterion[] wrapCriterion(PeriodicalFile periodicalFile)
    {
        List<Criterion> list = new ArrayList<Criterion>();
        if (periodicalFile != null)
        {
            
            if (!StringUtils.isEmpty(periodicalFile.getPeriodicalName()))
            {
                Criterion criterion1 =
                    Restrictions.like("periodicalName", "%" + periodicalFile.getPeriodicalName() + "%");
                list.add(criterion1);
            }
            
            if (!StringUtils.isEmpty(periodicalFile.getPeriodicalType()))
            {
                Criterion criterion2 = Restrictions.eq("periodicalType", periodicalFile.getPeriodicalType());
                list.add(criterion2);
            }
            
            if (!StringUtils.isEmpty(periodicalFile.getKeyword()))
            {
                Criterion criterion3 = Restrictions.like("sourceCode", "%" + periodicalFile.getKeyword() + "%");
                list.add(criterion3);
            }
            
            //            if (null != periodicalFile.getUploadDate())
            //            {
            //                Criterion criterion3 = Restrictions.ge("uploadDate", periodicalFile.getUploadDate());
            //                list.add(criterion3);
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
