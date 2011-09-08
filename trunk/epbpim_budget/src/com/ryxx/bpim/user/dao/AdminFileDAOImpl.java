package com.ryxx.bpim.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.dao.AbstractBaseDAO;
import com.ryxx.bpim.user.entity.AdminFile;

public class AdminFileDAOImpl extends AbstractBaseDAO<AdminFile, Long> implements AdminFileDAO
{
    
    @Override
    public void saveAdminFile(AdminFile adminFile)
    {
        save(adminFile);
    }
    
    @Override
    public void deleteAdminFile(AdminFile adminFile)
    {
        remove(adminFile);
    }
    
    @Override
    public List<AdminFile> listAdminFile(AdminFile adminFile)
    {
        return findPageByPage(adminFile.getStartRow(), adminFile.getPageSize(), wrapCriterion(adminFile));
    }
    
    @Override
    public int getRowCount(AdminFile adminFile)
    {
        return findByCriteria(wrapCriterion(adminFile)).size();
        
    }
    
    private Criterion[] wrapCriterion(AdminFile adminFile)
    {
        List<Criterion> list = new ArrayList<Criterion>();
        if (adminFile != null)
        {
            if (!StringUtils.isEmpty(adminFile.getFileName()))
            {
                Criterion criterion1 = Restrictions.like("fileName", "%" + adminFile.getFileName() + "%");
                list.add(criterion1);
            }
            if (!StringUtils.isEmpty(adminFile.getFileType()))
            {
                Criterion criterion2 = Restrictions.eq("fileType", adminFile.getFileType());
                list.add(criterion2);
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
