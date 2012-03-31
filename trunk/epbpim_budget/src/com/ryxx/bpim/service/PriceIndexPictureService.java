package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.PriceIndexPictureDAO;
import com.ryxx.bpim.entity.PriceIndexPicture;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public interface PriceIndexPictureService extends BaseService<PriceIndexPicture, PriceIndexPictureDAO, Long>
{

	/**
	 * @param priceIndexPicture
	 * @param page
	 * @return
	 */
	List<PriceIndexPicture> listPriceIndexPictures(
			PriceIndexPicture priceIndexPicture, PageTools page);

   
    
}
