/**
 * 
 */
package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.PriceIndexPictureDAO;
import com.ryxx.bpim.entity.PriceIndexPicture;
import com.ryxx.util.page.PageTools;

/**
 * @author Delgado Ding
 *
 */
public class PriceIndexPictureServiceImpl extends AbstractService<PriceIndexPicture, PriceIndexPictureDAO, Long> implements 
PriceIndexPictureService {

	/* (non-Javadoc)
	 * @see com.ryxx.bpim.service.PriceIndexPictureService#listPriceIndexPictures(com.ryxx.bpim.entity.PriceIndexPicture, com.ryxx.util.page.PageTools)
	 */
	@Override
	public List<PriceIndexPicture> listPriceIndexPictures(
			PriceIndexPicture condition, PageTools page) {
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
