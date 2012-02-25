package com.ryxx.bpim.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
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
    public List<GuidePrice> getGuidePrice(GuidePrice guidePrice)
    {
        Criteria criteria = getSession().createCriteria(GuidePrice.class);
        
        if (guidePrice.getProvinceCity() != null && 0 != guidePrice.getProvinceCity().getId())
        {
            criteria.add(Restrictions.eq("provinceCity.id", guidePrice.getProvinceCity().getId()));
        }
        
        if (!StringUtils.isEmpty(guidePrice.getGuidePriceType()))
        {
            criteria.add(Restrictions.eq("guidePriceType", guidePrice.getGuidePriceType()));
        }
        
        if (null != guidePrice.getGuidePriceDate())
        {
            criteria.add(Restrictions.eq("guidePriceDate", guidePrice.getGuidePriceDate()));
        }
        
        return criteria.list();
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
            
            if (guidePrice.getProvinceCity() != null && 0 != guidePrice.getProvinceCity().getId())
            {
                Criterion criterion4 = Restrictions.eq("provinceCity.id", guidePrice.getProvinceCity().getId());
                list.add(criterion4);
            }
            
            if (!StringUtils.isEmpty(guidePrice.getGuidePriceType()))
            {
                Criterion criterion3 = Restrictions.eq("guidePriceType", guidePrice.getGuidePriceType());
                list.add(criterion3);
            }
            
            if (!StringUtils.isEmpty(guidePrice.getGuidePriceClass()))
            {
                Criterion criterion3 = Restrictions.eq("guidePriceClass", guidePrice.getGuidePriceClass());
                list.add(criterion3);
            }
            
            if (!StringUtils.isEmpty(guidePrice.getName()))
            {
                Criterion criterion1 = Restrictions.like("name", "%" + guidePrice.getName() + "%");
                list.add(criterion1);
            }
            
            if (null != guidePrice.getGuidePriceDate())
            {
                Criterion criterion5 = Restrictions.eq("guidePriceDate", guidePrice.getGuidePriceDate());
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
