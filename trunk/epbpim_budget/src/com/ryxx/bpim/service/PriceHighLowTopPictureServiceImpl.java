/**
 * 
 */
package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.PriceHighLowTopPictureDAO;
import com.ryxx.bpim.entity.PriceHighLowTopPicture;
import com.ryxx.util.page.PageTools;

/**
 * @author Delgado Ding
 *
 */
public class PriceHighLowTopPictureServiceImpl extends AbstractService<PriceHighLowTopPicture, PriceHighLowTopPictureDAO, Long> implements 
		PriceHighLowTopPictureService {

	/* (non-Javadoc)
	 * @see com.ryxx.bpim.service.PriceHighLowTopPictureService#listPriceHighLowTopPictures(com.ryxx.bpim.entity.PriceHighLowTopPicture, com.ryxx.util.page.PageTools)
	 */
	@Override
	public List<PriceHighLowTopPicture> listPriceHighLowTopPictures(
			PriceHighLowTopPicture condition, PageTools page) {
		 if (page != null)
	        {
	            if (page.getRecordCount() == 0)
	            {
	                int count = getDao().getRowCount(condition);
	                page.setRecordCount(count);
	            }
	            condition.setStartRow(page.getPageStartRow());
	            condition.setPageSize(page.getPageSize());
	        }
	        return getDao().listPricePackageFile(condition);
	}

}
