package com.ryxx.bpim.service;

import java.io.File;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ryxx.bpim.dao.GuidePriceDAO;
import com.ryxx.bpim.entity.GuidePrice;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public class GuidePriceServiceImpl extends AbstractService<GuidePrice, GuidePriceDAO, Long> implements
    GuidePriceService
{
    public String saveGuidePrice(GuidePrice guidePrice, File uploadfile)
        throws ParseException, SQLException
    {
        // 解析 uploadfile 文件
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date periodicalDate = sdf.parse(guidePrice.getGuidePriceDatePage());
        guidePrice.setGuidePriceDate(new Timestamp(periodicalDate.getTime()));
        
        guidePrice.setUploadDate(new Timestamp(new Date().getTime()));
        
        return "导入成功";
    }
    
    public String deleteGuidePrice(GuidePrice guidePrice)
        throws ParseException, SQLException
    {
        return "导入成功";
    }
    
    public List<GuidePrice> listGuidePrice(GuidePrice condition, PageTools page)
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
        return getDao().listGuidePrice(condition);
    }
    
}
