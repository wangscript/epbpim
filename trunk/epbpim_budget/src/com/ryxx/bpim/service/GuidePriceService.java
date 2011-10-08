package com.ryxx.bpim.service;

import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.ryxx.bpim.dao.GuidePriceDAO;
import com.ryxx.bpim.entity.GuidePrice;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public interface GuidePriceService extends BaseService<GuidePrice, GuidePriceDAO, Long>
{
    
    String saveGuidePrice(GuidePrice guidePrice, File uploadfile)
        throws ParseException, SQLException;
    
    void deleteGuidePrice(GuidePrice guidePrice)
        throws ParseException, SQLException;
    
    List<GuidePrice> listGuidePrice(GuidePrice guidePrice, PageTools page)
        throws SQLException;
    
}
