package com.ryxx.bpim.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.GovernmentFile;

/**
 * author Delgado
 */
public class GovernmentFileDAOImpl extends AbstractBaseDAO<GovernmentFile, Long> implements GovernmentFileDAO
{
    @Override
    public void saveGovernmentFile(GovernmentFile governmentFile)
    {
        save(governmentFile);
    }
    
    @Override
    public void deleteGovernmentFile(GovernmentFile governmentFile)
    {
        remove(governmentFile);
    }
    
    @Override
    public GovernmentFile viewGovernmentFile(Long id)
    {
        // TODO Auto-generated method stub
        return findById(id);
    }
    
    @Override
    public List<GovernmentFile> listGovernmentFile(GovernmentFile governmentFile)
    {
        return findPageByPage("filePublishDate",false,governmentFile.getStartRow(), governmentFile.getPageSize(), wrapCriterion(governmentFile));
    }
    
    @Override
    public int getRowCount(GovernmentFile governmentFile)
    {
        return findByCriteria(wrapCriterion(governmentFile)).size();
        
    }
    
    private Criterion[] wrapCriterion(GovernmentFile governmentFile)
    {
        List<Criterion> list = new ArrayList<Criterion>();
        if (governmentFile != null)
        {
            if (null != governmentFile.getFilePublishDateFrom())
            {
                Criterion criterion1 = Restrictions.ge("filePublishDate", governmentFile.getFilePublishDateFrom());
                list.add(criterion1);
            }
            if (null != governmentFile.getFilePublishDateTo())
            {
                Criterion criterion2 = Restrictions.le("filePublishDate", governmentFile.getFilePublishDateTo());
                list.add(criterion2);
            }
            
            if (null != governmentFile.getFileEffectiveDateFrom())
            {
                Criterion criterion3 = Restrictions.ge("fileEffectiveDate", governmentFile.getFileEffectiveDateFrom());
                list.add(criterion3);
            }
            if (null != governmentFile.getFileEffectiveDateTo())
            {
                Criterion criterion4 = Restrictions.le("fileEffectiveDate", governmentFile.getFileEffectiveDateTo());
                list.add(criterion4);
            }
            
            if (governmentFile.getFileSubType() != null && !"".equals(governmentFile.getFileSubType())&&!"0".equals(governmentFile.getFileSubType()))
            {
                Criterion criterion5 = Restrictions.eq("fileSubType", governmentFile.getFileSubType());
                list.add(criterion5);
            }
            
            if (governmentFile.getFileType() != null && !"".equals(governmentFile.getFileType())&&!"0".equals(governmentFile.getFileType()))
            {
                Criterion criterion6 = Restrictions.eq("fileType", governmentFile.getFileType());
                list.add(criterion6);
            }
            
            if (!StringUtils.isEmpty(governmentFile.getKeyword()))
            {
                Criterion criterion7 = Restrictions.like("sourceCode", "%" + governmentFile.getKeyword() + "%");
                list.add(criterion7);
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
