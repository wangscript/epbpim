/**
 * 
 */
package com.ryxx.bpim.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.PriceIndexPicture;

/**
 * @author Delgado Ding
 *
 */
public class PriceIndexPictureDAOImpl extends AbstractBaseDAO<PriceIndexPicture, Long> implements PriceIndexPictureDAO{

	/* (non-Javadoc)
	 * @see com.ryxx.bpim.dao.PriceIndexPictureDAO#getRowCount(com.ryxx.bpim.entity.PriceIndexPicture)
	 */
	@Override
	public int getRowCount(PriceIndexPicture condition) {
		return findByCriteria(wrapCriterion(condition)).size();
	}

	/* (non-Javadoc)
	 * @see com.ryxx.bpim.dao.PriceIndexPictureDAO#listPricePackageFile(com.ryxx.bpim.entity.PriceIndexPicture)
	 */
	@Override
	public List<PriceIndexPicture> listPricePackageFile(
			PriceIndexPicture condition) {
		 return findPageByPage("priceIndexDate",false,condition.getStartRow(), condition.getPageSize(), wrapCriterion(condition));
	}

	
	 private Criterion[] wrapCriterion(PriceIndexPicture condition)
	    {
	        List<Criterion> list = new ArrayList<Criterion>();
	        if (condition != null)
	        {
	        	if (condition.getProvinceCity()!=null&&0!=condition.getProvinceCity().getId())
	            {
	        		Criterion criterion1 = Restrictions.eq("provinceCity.id", condition.getProvinceCity().getId());
	                list.add(criterion1);
	            }
	            
	            
	            if (condition.getMajor()!=null&&condition.getMajor().getId()!=0)
	            {
	            	 Criterion criterion2 = Restrictions.eq("major.id", condition.getMajor().getId());
	            	 list.add(criterion2);
	            }
	            
	            
	            //            if (null != condition.getUploadDate())
	            //            {
	            //                Criterion criterion3 = Restrictions.ge("uploadDate", condition.getUploadDate());
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
