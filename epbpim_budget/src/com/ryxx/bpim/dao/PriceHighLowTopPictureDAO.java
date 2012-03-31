/**
 * 
 */
package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.PriceHighLowTopPicture;

/**
 * @author Delgado Ding
 *
 */
public interface PriceHighLowTopPictureDAO extends BaseDAO<PriceHighLowTopPicture, Long> {

	/**
	 * @param condition
	 * @return
	 */
	int getRowCount(PriceHighLowTopPicture condition);

	/**
	 * @param condition
	 * @return
	 */
	List<PriceHighLowTopPicture> listPricePackageFile(
			PriceHighLowTopPicture condition);

}
