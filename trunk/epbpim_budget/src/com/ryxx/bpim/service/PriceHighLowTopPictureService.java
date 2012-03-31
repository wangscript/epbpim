package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.PriceHighLowTopPictureDAO;
import com.ryxx.bpim.entity.PriceHighLowTopPicture;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public interface PriceHighLowTopPictureService extends BaseService<PriceHighLowTopPicture, PriceHighLowTopPictureDAO, Long>
{

	/**
	 * @param priceHighLowTopPicture
	 * @param page
	 * @return
	 */
	List<PriceHighLowTopPicture> listPriceHighLowTopPictures(
			PriceHighLowTopPicture priceHighLowTopPicture, PageTools page);

   
    
}
