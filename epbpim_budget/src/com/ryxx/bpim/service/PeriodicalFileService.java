package com.ryxx.bpim.service;

import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.ryxx.bpim.dao.PeriodicalFileDAO;
import com.ryxx.bpim.entity.PeriodicalFile;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public interface PeriodicalFileService extends BaseService<PeriodicalFile, PeriodicalFileDAO, Long>
{
    
    String savePeriodicalFile(PeriodicalFile periodicalFile)
        throws ParseException, SQLException;
    
    List<PeriodicalFile> listPeriodicalFile(PeriodicalFile periodicalFile, PageTools page)
    throws SQLException;
    
    String getPeriodicalFile(PeriodicalFile periodicalFile)
        throws Exception;
    
}
