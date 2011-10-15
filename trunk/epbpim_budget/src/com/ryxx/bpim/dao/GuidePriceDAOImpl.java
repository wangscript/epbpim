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
        
        if (guidePrice.getProvinceCity()!=null&&0!=guidePrice.getProvinceCity().getId())
        {
            criteria.add(Restrictions.eq("provinceCity.id", guidePrice.getProvinceCity().getId()));
        }
        
        if (guidePrice.getMajor()!=null&&guidePrice.getMajor().getId()!=0)
        {
            criteria.add(Restrictions.eq("major.id", guidePrice.getMajor().getId()));
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
            
            if (!StringUtils.isEmpty(guidePrice.getName()))
            {
                Criterion criterion1 = Restrictions.like("name", "%" + guidePrice.getName() + "%");
                list.add(criterion1);
            }
            
            if (!StringUtils.isEmpty(guidePrice.getCode()))
            {
                Criterion criterion2 = Restrictions.like("code", guidePrice.getCode() + "%");
                list.add(criterion2);
            }
            
            if (guidePrice.getMajor()!=null&&guidePrice.getMajor().getId()!=0)
            {
            	 Criterion criterion3 = Restrictions.eq("major.id", guidePrice.getMajor().getId());
            	 list.add(criterion3);
            }
            
            if (guidePrice.getProvinceCity()!=null&&0!=guidePrice.getProvinceCity().getId())
            {
            	Criterion criterion4 = Restrictions.eq("provinceCity.id", guidePrice.getProvinceCity().getId());
            	list.add(criterion4);
            }
            
            if (!StringUtils.isEmpty(guidePrice.getGuidePriceDatePage()))
            {
                try
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                    Date periodicalDate = sdf.parse(guidePrice.getGuidePriceDatePage());
                    Criterion criterion5 = Restrictions.eq("guidePriceDate", new Timestamp(periodicalDate.getTime()));
                    list.add(criterion5);
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
