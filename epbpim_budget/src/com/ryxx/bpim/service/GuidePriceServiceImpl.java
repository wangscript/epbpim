package com.ryxx.bpim.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
        throws ParseException, SQLException, IOException
    {
        List<GuidePrice> guidePriceList = parseGuidePriceFile(uploadfile, guidePrice);
        
        for (GuidePrice guidePricee : guidePriceList)
        {
            getDao().saveGuidePrice(guidePricee);
        }
        
        return "true";
    }
    
    public String deleteGuidePrice(GuidePrice guidePrice)
        throws ParseException, SQLException
    {
        
        List<GuidePrice> preDelGuidePrice = getDao().getGuidePrice(guidePrice);
        
        for (GuidePrice guidePricee : preDelGuidePrice)
        {
            getDao().deleteGuidePrice(guidePricee);
        }
        return "true";
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
    private List<GuidePrice> parseGuidePriceFile(File uploadfile, GuidePrice guidePrice)
        throws IOException, ParseException
    {
        
        List<GuidePrice> resultList = new ArrayList<GuidePrice>();
        
        Sheet[] allSheet = getWb(uploadfile, guidePrice.getGuidePriceFileName());
        
        Row row = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Timestamp uploadDate = new Timestamp(new Date().getTime());
        
        for (Sheet sheet : allSheet)
        {
            
            if ("机价说明".equals(sheet.getSheetName()))
            {
                continue;
            }
            int countRow = sheet.getLastRowNum();
            for (int i = 3; i <= countRow; i++)
            {
                row = sheet.getRow(i);
                GuidePrice data = new GuidePrice();
                data.setName(getValue(row.getCell(0)));
                data.setUnit(getValue(row.getCell(1)));
                data.setComment(getValue(row.getCell(2)));
                data.setPrice(row.getCell(3).getNumericCellValue());
                if ("公路机械".equals(sheet.getSheetName()))
                {
                    StringBuffer sb = new StringBuffer();                    
                    sb.append("不变费用(元)：")
                        .append(getValue(row.getCell(4)))
                        .append("，可变费用(元)：")
                        .append(getValue(row.getCell(5)))
                        .append("，折旧费(元)：")
                        .append(getValue(row.getCell(6)))
                        .append("，大修理费(元)：")
                        .append(getValue(row.getCell(7)))
                        .append("，经修费(元)：")
                        .append(getValue(row.getCell(8)))
                        .append("，安拆辅设(元)：")
                        .append(getValue(row.getCell(9)))
                        .append("，人工(工日)：")
                        .append(getValue(row.getCell(10)))
                        .append("，汽油(kg)：")
                        .append(getValue(row.getCell(11)))
                        .append("，柴油(kg)：")
                        .append(getValue(row.getCell(12)))
                        .append("，重油(kg)：")
                        .append(getValue(row.getCell(13)))
                        .append("，煤(kg)：")
                        .append(getValue(row.getCell(14)))
                        .append("，电(kw.h)：")
                        .append(getValue(row.getCell(15)))
                        .append("，水(m3)：")
                        .append(getValue(row.getCell(16)))
                        .append("，木柴(kg)：")
                        .append(getValue(row.getCell(17)))
                        .append("，养路费及车船使用税：")
                        .append(getValue(row.getCell(18)));
                    
                    data.setPriceComment(sb.toString());
                }
                else
                {
                    data.setPriceComment(getValue(row.getCell(4)));
                }
                
                data.setGuidePriceClass(sheet.getSheetName());
                data.setGuidePriceType(guidePrice.getGuidePriceType());
                data.setGuidePriceDate(new Timestamp(sdf.parse(guidePrice.getGuidePriceDatePage()).getTime()));
                data.setUploadDate(uploadDate);
                data.setProvinceCity(guidePrice.getProvinceCity());
                resultList.add(data);
            }
        }
        
        return resultList;
    }
    
    /**
     * @param cell
     * @return
     */
    private String getValue(Cell cell)
    {
        if (isBlank(cell))
        {
            return "";
        }
        if (isString(cell))
        {
            return cell.getStringCellValue();
        }
        if (isNumber(cell))
        {
            return String.valueOf(cell.getNumericCellValue());
        }
        return null;
    }
    
    private static final int version2003 = 2003;
    
    private static final int version2007 = 2007;
    
    private static int version = version2003;
    
    private Sheet[] getWb(File file, String fileName)
        throws IOException
    {
        Workbook wb = null;
        if (fileName.endsWith("xls"))
            version = version2003;
        else if (fileName.endsWith("xlsx"))
            version = version2007;
        InputStream stream = null;
        if (version == version2003)
        {
            stream = new FileInputStream(file);
            wb = (Workbook)new HSSFWorkbook(stream);
        }
        else if (version == version2007)
        {
            wb = (Workbook)new XSSFWorkbook(file.getAbsolutePath());
        }
        
        Sheet[] allSheet = new Sheet[wb.getNumberOfSheets()];
        for (int i = 0; i < wb.getNumberOfSheets(); i++)
        {
            allSheet[i] = wb.getSheetAt(i);
        }
        
        return allSheet;
    }
    
    private Boolean isBlank(Cell cell)
    {
        return cell.getCellType() == Cell.CELL_TYPE_BLANK;
    }
    
    private Boolean isString(Cell cell)
    {
        return cell.getCellType() == Cell.CELL_TYPE_STRING;
    }
    
    private Boolean isNumber(Cell cell)
    {
        return cell.getCellType() == Cell.CELL_TYPE_NUMERIC;
    }
}
