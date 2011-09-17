package com.ryxx.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.dao.PricePackageFileDAO;
import com.ryxx.bpim.dao.PricePackageFileDAOImpl;
import com.ryxx.bpim.entity.PricePackageFile;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public class PricePackageFileServiceImpl extends AbstractService<PricePackageFile, PricePackageFileDAO, Long> implements
    PricePackageFileService
{
    
    PricePackageFileDAO dao = new PricePackageFileDAOImpl();
    
    public List<PricePackageFile> listPricePackageFile(PricePackageFile condition, PageTools page)
        throws SQLException
    {
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
    
    @Override
    public void savePricePackageFile(PricePackageFile pricePackageFile)
        throws SQLException
    {
        getDao().savePricePackageFile(pricePackageFile);
    }

    @Override
    public void deletePricePackageFile(PricePackageFile pricePackageFile)
        throws SQLException
    {
        getDao().deletePricePackageFile(pricePackageFile);
        
    }
    
}
