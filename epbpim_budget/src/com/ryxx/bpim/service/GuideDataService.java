package com.ryxx.bpim.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.ryxx.bpim.dao.GuideDataDAO;
import com.ryxx.bpim.entity.GuideData;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public interface GuideDataService extends BaseService<GuideData, GuideDataDAO, Long>
{
    
    String saveGuideData(GuideData guideData, File uploadfile)
        throws ParseException, SQLException, IOException, Exception;
    
    String deleteGuideData(GuideData guideData)
        throws ParseException, SQLException;
    
    List<GuideData> listGuideData(GuideData guideData, PageTools page)
        throws SQLException;
    
}
