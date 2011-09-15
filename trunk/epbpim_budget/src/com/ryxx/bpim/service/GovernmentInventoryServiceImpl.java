package com.ryxx.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.dao.GovernmentInventoryDAO;
import com.ryxx.bpim.entity.GovernmentInventory;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public class GovernmentInventoryServiceImpl extends AbstractService<GovernmentInventory, GovernmentInventoryDAO, Long>
    implements GovernmentInventoryService
{
    
    public List<GovernmentInventory> listGovernmentInventory(GovernmentInventory condition, PageTools page)
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
        return getDao().listGovernmentInventory(condition);
    }
    
}
