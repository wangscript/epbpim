package com.ryxx.bpim.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.GuidePrice;

/**
 * author Delgado
 */
public class GuidePriceDAOImpl extends AbstractBaseDAO<GuidePrice, Long> implements GuidePriceDAO
{
    @Override
    public void saveGuidePrice(GuidePrice guidePrice)
    {
        save(guidePrice);
    }
    
    @Override
    public void deleteGuidePrice(GuidePrice guidePrice)
    {
        remove(guidePrice);
    }
    
    @Override
    public List<GuidePrice> listGuidePrice(GuidePrice guidePrice)
    {
        return findPageByPage(guidePrice.getStartRow(), guidePrice.getPageSize(), wrapCriterion(guidePrice));
    }
    
    @Override
    public int getRowCount(GuidePrice guidePrice)
    {
        return findByCriteria(wrapCriterion(guidePrice)).size();
        
    }
    
    private Criterion[] wrapCriterion(GuidePrice guidePrice)
    {
        List<Criterion> list = new ArrayList<Criterion>();
        if (guidePrice != null)
        {
            if (!StringUtils.isEmpty(guidePrice.getGuidePriceType()))
            {
                String guidePriceType = "";
                if ("1".equals(guidePrice.getGuidePriceType()))
                {
                    guidePriceType = "市政";
                }
                else if ("3".equals(guidePrice.getGuidePriceType()))
                {
                    guidePriceType = "土建";
                }
                
                Criterion criterion2 = Restrictions.eq("guidePriceType", guidePriceType);
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
