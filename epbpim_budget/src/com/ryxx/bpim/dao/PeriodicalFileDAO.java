package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.PeriodicalFile;

/**
 * author Delgado
 */
public interface PeriodicalFileDAO extends BaseDAO<PeriodicalFile, Long>
{
    
    void savePeriodicalFile(PeriodicalFile periodicalFile);
    
    void deletePeriodicalFile(PeriodicalFile periodicalFile);
    
    PeriodicalFile viewPeriodicalFile(PeriodicalFile periodicalFile);
    
    List<PeriodicalFile> listPeriodicalFile(PeriodicalFile periodicalFile);
    
    int getRowCount(PeriodicalFile periodicalFile);
    
}
