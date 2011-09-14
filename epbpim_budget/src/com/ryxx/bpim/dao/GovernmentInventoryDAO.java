package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.GovernmentInventory;

/**
 * author Delgado
 */
public interface GovernmentInventoryDAO extends BaseDAO<GovernmentInventory, Long>
{
    
    List<GovernmentInventory> listGovernmentInventory(GovernmentInventory governmentInventory);
    
    int getRowCount(GovernmentInventory governmentInventory);
    
}
