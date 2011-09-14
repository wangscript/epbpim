package com.ryxx.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.dao.GovernmentInventoryDAO;
import com.ryxx.bpim.entity.GovernmentInventory;
import com.ryxx.bpim.helper.PageTools;

/**
 * author Delgado
 */
public interface GovernmentInventoryService extends BaseService<GovernmentInventory, GovernmentInventoryDAO, Long>
{
    List<GovernmentInventory> searchGovernmentInventory(GovernmentInventory condition, PageTools page)
        throws SQLException;
}
