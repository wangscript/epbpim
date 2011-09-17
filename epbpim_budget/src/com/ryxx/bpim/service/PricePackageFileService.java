package com.ryxx.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.dao.PricePackageFileDAO;
import com.ryxx.bpim.entity.PricePackageFile;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public interface PricePackageFileService extends BaseService<PricePackageFile, PricePackageFileDAO, Long>
{
    void savePricePackageFile(PricePackageFile pricePackageFile)
        throws SQLException;
    
    void deletePricePackageFile(PricePackageFile pricePackageFile)
    throws SQLException;
    
    List<PricePackageFile> listPricePackageFile(PricePackageFile pricePackageFile, PageTools page)
    throws SQLException;
}
