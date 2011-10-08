package com.ryxx.bpim.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        
        if (!StringUtils.isEmpty(guidePrice.getGuidePriceProvice()))
        {
            criteria.add(Restrictions.eq("guidePriceProvice", guidePrice.getGuidePriceProvice()));
        }
        
        if (!StringUtils.isEmpty(guidePrice.getGuidePriceType()))
        {
            String guidePriceType = "";
            if ("1".equals(guidePrice.getGuidePriceType()))
            {
                guidePriceType = "市政";
            }
            else if ("2".equals(guidePrice.getGuidePriceType()))
            {
                guidePriceType = "园林";
            }
            criteria.add(Restrictions.eq("guidePriceType", guidePriceType));
        }
        
        if (!StringUtils.isEmpty(guidePrice.getGuidePriceDatePage()))
        {
            try
            {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                Date periodicalDate = sdf.parse(guidePrice.getGuidePriceDatePage());
                criteria.add(Restrictions.eq("guidePriceDate", new Timestamp(periodicalDate.getTime())));
            }
            catch (ParseException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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
            if (!StringUtils.isEmpty(guidePrice.getGuidePriceProvice()))
            {
                Criterion criterion1 = Restrictions.eq("guidePriceProvice", guidePrice.getGuidePriceProvice());
                list.add(criterion1);
            }
            
            if (!StringUtils.isEmpty(guidePrice.getGuidePriceType()))
            {
                String guidePriceType = "";
                if ("1".equals(guidePrice.getGuidePriceType()))
                {
                    guidePriceType = "市政";
                }
                else if ("2".equals(guidePrice.getGuidePriceType()))
                {
                    guidePriceType = "园林";
                }
                
                Criterion criterion2 = Restrictions.eq("guidePriceType", guidePriceType);
                list.add(criterion2);
            }
            
            if (!StringUtils.isEmpty(guidePrice.getGuidePriceDatePage()))
            {
                try
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                    Date periodicalDate = sdf.parse(guidePrice.getGuidePriceDatePage());
                    Criterion criterion1 = Restrictions.eq("guidePriceDate", new Timestamp(periodicalDate.getTime()));
                    list.add(criterion1);
                }
                catch (ParseException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
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
