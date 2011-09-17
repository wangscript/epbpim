package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.PricePackageFile;

/**
 * author Delgado
 */
public interface PricePackageFileDAO extends BaseDAO<PricePackageFile, Long>
{
    void deletePricePackageFile(PricePackageFile pricePackageFile);
    
    void savePricePackageFile(PricePackageFile pricePackageFile);
    
    List<PricePackageFile> listPricePackageFile(PricePackageFile pricePackageFile);
    
    int getRowCount(PricePackageFile pricePackageFile);
}
