package com.ryxx.bpim.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        return findPageByPage("filePublishDate",
            false,
            governmentFile.getStartRow(),
            governmentFile.getPageSize(),
            wrapCriterion(governmentFile));
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
            if (!StringUtils.isEmpty(governmentFile.getFilePublishDatePage()))
            {
                try
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                    Date filePublishDate = sdf.parse(governmentFile.getFilePublishDatePage());
                    
                    Criterion criterion1 = Restrictions.eq("filePublishDate", new Timestamp(filePublishDate.getTime()));
                    list.add(criterion1);
                }
                catch (ParseException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (!StringUtils.isEmpty(governmentFile.getFileEffectiveDatePage()))
            {
                try
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                    Date fileEffectiveDate = sdf.parse(governmentFile.getFileEffectiveDatePage());
                    
                    Criterion criterion2 =
                        Restrictions.eq("fileEffectiveDate", new Timestamp(fileEffectiveDate.getTime()));
                    list.add(criterion2);
                }
                catch (ParseException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
            if (governmentFile.getFileSubType() != null && !"".equals(governmentFile.getFileSubType())
                && !"0".equals(governmentFile.getFileSubType()))
            {
                Criterion criterion3 = Restrictions.eq("fileSubType", governmentFile.getFileSubType());
                list.add(criterion3);
            }
            
            if (governmentFile.getFileType() != null && !"".equals(governmentFile.getFileType())
                && !"0".equals(governmentFile.getFileType()))
            {
                Criterion criterion4 = Restrictions.eq("fileType", governmentFile.getFileType());
                list.add(criterion4);
            }
            
            if (!StringUtils.isEmpty(governmentFile.getKeyword()))
            {
                Criterion criterion5 = Restrictions.like("sourceCode", "%" + governmentFile.getKeyword() + "%");
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
