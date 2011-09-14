package com.ryxx.bpim.service;

import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.ryxx.bpim.dao.GovernmentFileDAO;
import com.ryxx.bpim.entity.GovernmentFile;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public interface GovernmentFileService extends BaseService<GovernmentFile, GovernmentFileDAO, Long>
{
    
    List<GovernmentFile> searchGovernmentFile(GovernmentFile condition, PageTools page)
        throws SQLException;
    
    String importGovernmentFile(String fileType, String fileSubType, String provice, File importGovernmentFile)
        throws ParseException, SQLException;
    
    String viewGovernmentFile(Long id)
        throws SQLException;
    
}
