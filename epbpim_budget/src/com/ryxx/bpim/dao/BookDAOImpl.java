package com.ryxx.bpim.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.Book;
import com.ryxx.bpim.entity.EnterpriseInfo;
import com.ryxx.bpim.entity.PeriodicalFile;

/**
 * author Delgado
 */
public class BookDAOImpl extends AbstractBaseDAO<Book, Long> implements BookDAO
{

	 @Override
	    public List<Book> findByCount(Book book)
	    {
	        return findPageByPage(book.getStartRow(), book.getPageSize(), wrapCriterion(book));
	    }
	    
	    @Override
	    public int getRowCount(Book book)
	    {
	        return findByCriteria(wrapCriterion(book)).size();
	        
	    }
	    
	    private Criterion[] wrapCriterion(Book book)
	    {
	        List<Criterion> list = new ArrayList<Criterion>();
	        if (book != null)
	        {
	        	if (book.getProvinceCity()!=null&&0!=book.getProvinceCity().getId())
	            {
	        		Criterion criterion1 = Restrictions.eq("provinceCity.id", book.getProvinceCity().getId());
	                list.add(criterion1);
	            }
	            
	            if (!StringUtils.isEmpty(book.getBookRealName()))
	            {
	                Criterion criterion1 =
	                    Restrictions.like("bookRealName", "%" + book.getBookRealName() + "%");
	                list.add(criterion1);
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
