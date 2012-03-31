/**
 * 
 */
package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.PriceIndexPicture;

/**
 * @author Delgado Ding
 *
 */
public interface PriceIndexPictureDAO extends BaseDAO<PriceIndexPicture, Long> {

	/**
	 * @param condition
	 * @return
	 */
	int getRowCount(PriceIndexPicture condition);

	/**
	 * @param condition
	 * @return
	 */
	List<PriceIndexPicture> listPricePackageFile(PriceIndexPicture condition);

}
