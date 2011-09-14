package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.GovernmentFile;

/**
 * author Delgado
 */
public interface GovernmentFileDAO extends BaseDAO<GovernmentFile, Long>
{
    
    void saveGovernmentFile(GovernmentFile governmentFile);
    
    void deleteGovernmentFile(GovernmentFile governmentFile);
    
    GovernmentFile viewGovernmentFile(Long id);
    
    List<GovernmentFile> listGovernmentFile(GovernmentFile governmentFile);
    
    int getRowCount(GovernmentFile governmentFile);
    
}
