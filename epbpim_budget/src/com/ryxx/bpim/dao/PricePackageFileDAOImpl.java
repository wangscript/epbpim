package com.ryxx.bpim.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.PricePackageFile;

/**
 * author Delgado
 */
public class PricePackageFileDAOImpl extends AbstractBaseDAO<PricePackageFile, Long> implements PricePackageFileDAO
{
    
    @Override
    public void savePricePackageFile(PricePackageFile pricePackageFile)
    {
        save(pricePackageFile);
    }
    
    @Override
    public void deletePricePackageFile(PricePackageFile pricePackageFile)
    {
        remove(pricePackageFile);
    }
    
    @Override
    public List<PricePackageFile> listPricePackageFile(PricePackageFile pricePackageFile)
    {
        return findPageByPage(pricePackageFile.getStartRow(),
            pricePackageFile.getPageSize(),
            wrapCriterion(pricePackageFile));
    }
    
    @Override
    public int getRowCount(PricePackageFile pricePackageFile)
    {
        return findByCriteria(wrapCriterion(pricePackageFile)).size();
        
    }
    
    private Criterion[] wrapCriterion(PricePackageFile pricePackageFile)
    {
        List<Criterion> list = new ArrayList<Criterion>();
        
        if (null != pricePackageFile.getPricePackageProvice() && "" != pricePackageFile.getPricePackageProvice())
        {
            Criterion criterion1 = Restrictions.eq("pricePackageProvice", pricePackageFile.getPricePackageProvice());
            list.add(criterion1);
        }
        if (null != pricePackageFile.getPricePackageType() && "" != pricePackageFile.getPricePackageType())
        {
            Criterion criterion1 = Restrictions.eq("pricePackageType", pricePackageFile.getPricePackageType());
            list.add(criterion1);
        }
        
        //            if (null != pricePackageFile.getPricePackageDate())
        //            {
        //                Criterion criterion1 = Restrictions.eq("pricePackageDate", pricePackageFile.PricePackageDate());
        //                list.add(criterion1);
        //            }  
        
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
