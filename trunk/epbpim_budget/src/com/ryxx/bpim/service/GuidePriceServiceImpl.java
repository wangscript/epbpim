package com.ryxx.bpim.service;

import java.io.File;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        List<GuidePrice> guidePriceList = parseGuidePriceFile(uploadfile);
        
        for (GuidePrice guidePricee : guidePriceList)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            Date periodicalDate = sdf.parse(guidePrice.getGuidePriceDatePage());
            guidePricee.setGuidePriceDate(new Timestamp(periodicalDate.getTime()));
            
            guidePricee.setUploadDate(new Timestamp(new Date().getTime()));
            
            getDao().saveGuidePrice(guidePricee);
        }
        
        return "导入成功";
    }
    
    public void deleteGuidePrice(GuidePrice guidePrice)
        throws ParseException, SQLException
    {
        getDao().deleteGuidePrice(guidePrice);
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
    
    /*
     * 解析信息价文件 
     */
    private List<GuidePrice> parseGuidePriceFile(File uploadfile)
    {
        List<GuidePrice> resultList = new ArrayList<GuidePrice>();
        
        return resultList;
    }
}
