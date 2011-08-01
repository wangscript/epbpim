package com.bpim.dao;

import java.sql.SQLException;
import java.util.List;

import com.bpim.entity.GovernmentInventory;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgadoo
 */
public interface GovernmentInventoryDAO
{
    
    List<GovernmentInventory> searchGovernmentInventory(SearchDataCondition condition)
        throws SQLException;
    
    int countSearchGovernmentInventory(SearchDataCondition condition)
        throws SQLException;
    
}
