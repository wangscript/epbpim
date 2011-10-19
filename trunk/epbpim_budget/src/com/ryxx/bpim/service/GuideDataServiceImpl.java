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
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ryxx.bpim.common.ExcelTitleUtil;
import com.ryxx.bpim.common.PropertyConstants;
import com.ryxx.bpim.dao.GuideDataDAO;
import com.ryxx.bpim.entity.GuideData;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public class GuideDataServiceImpl extends AbstractService<GuideData, GuideDataDAO, Long> implements GuideDataService
{
    
    private static final Log LOG = LogFactory.getLog(GuideDataServiceImpl.class);
    
    private static final int version2003 = 2003;
    
    private static final int version2007 = 2007;
    
    private static int version = version2003;
    
    private String msg = "";
    
    // 有效数据开始的行数
    private int dataRowNum;
    
    public String saveGuideData(GuideData guideData, File uploadfile)
        throws Exception
    {
        List<GuideData> guideDataList = parseGuideDataFile(uploadfile, guideData);
        
        for (GuideData guideDatae : guideDataList)
        {
            getDao().saveGuideData(guideDatae);
        }
        
        return "true";
    }
    
    public String deleteGuideData(GuideData guideData)
        throws ParseException, SQLException
    {
        
        List<GuideData> preDelGuideData = getDao().getGuideData(guideData);
        
        for (GuideData guideDatae : preDelGuideData)
        {
            getDao().deleteGuideData(guideDatae);
        }
        return "true";
    }
    
    public List<GuideData> listGuideData(GuideData condition, PageTools page)
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
        return getDao().listGuideData(condition);
    }
    
    /*
     * 解析信息价文件
     */
    private List<GuideData> parseGuideDataFile(File uploadfile, GuideData guideData)
        throws Exception
    {
        Sheet sheet = getWb(uploadfile, uploadfile.getName());
        Row row = null;
        int count_row = sheet.getLastRowNum();
        int submitRowNumber = 0;
        List<GuideData> dataList = new ArrayList<GuideData>();
        Hashtable<String, Integer> tableTitleTable = getTableTitle(sheet, ExcelTitleUtil.userCustomDataTitleSet);
        msg = checkTableTitle(tableTitleTable, ExcelTitleUtil.userCustomDataTitleSet);
        if (!"".equals(msg))
        {
            throw new Exception(msg);
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Timestamp importDate = new Timestamp(new Date().getTime());
        
        for (int i = dataRowNum; i <= count_row; i++)
        {
            try
            {
                
                row = sheet.getRow(i);
                
                if (!validateCustomData(row, tableTitleTable))
                {
                    continue;
                }
                
                GuideData data = new GuideData();
                data.setImportDate(importDate);
                data.setGuideDataDate(new Timestamp(sdf.parse(guideData.getGuideDataDatePage()).getTime()));
                data.setMajor(guideData.getMajor());
                data.setProvinceCity(guideData.getProvinceCity());
                
                data.setNum(trim(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordCode)).getStringCellValue()));
                data.setName(trim(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordName)).getStringCellValue()));
                data.setGuideDataClass(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordClass))
                    .getStringCellValue());
                data.setPrice(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordPrice)).getNumericCellValue());
                data.setUnit(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordUnit)).getStringCellValue());
                data.setGross(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordAmount)).getNumericCellValue());
                
                if (null != row.getCell(tableTitleTable.get(ExcelTitleUtil.recordPercent)))
                {
                    data.setPercent(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordPercent))
                        .getNumericCellValue());
                }
                
                if (null != row.getCell(tableTitleTable.get(ExcelTitleUtil.recordModel)))
                {
                    data.setModel(trim(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordModel))
                        .getStringCellValue()));
                }
                
                if (null != row.getCell(tableTitleTable.get(ExcelTitleUtil.recordTotalPrice)))
                {
                    data.setTotalPrice(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordTotalPrice))
                        .getNumericCellValue());
                }
                
                submitRowNumber++;
                dataList.add(data);
                
            }
            catch (Exception e)
            {
                LOG.error(e);
                msg = PropertyConstants.THE + (i + 1) + PropertyConstants.WRONGNUMBER;
                throw new Exception(msg);
            }
        }
        
        msg = submitRowNumber + PropertyConstants.TOTLEIMPORT;
        return dataList;
    }
    
    private Boolean isBlank(Cell cell)
    {
        return (null == cell || cell.getCellType() == Cell.CELL_TYPE_BLANK);
    }
    
    private Boolean isNumeric(Cell cell)
    {
        return (null != cell && cell.getCellType() == Cell.CELL_TYPE_NUMERIC);
    }
    
    private String checkTableTitle(Hashtable<String, Integer> tableTitleTable, Set<String> set)
    {
        Iterator<String> i = set.iterator();
        String orgTitle;
        while (i.hasNext())
        {
            orgTitle = i.next();
            Object index = tableTitleTable.get(orgTitle);
            if (index != null && (Integer)index > -1)
            {
                continue;
            }
            else
            {
                return orgTitle + PropertyConstants.CHANNELNOTEXIST;
            }
        }
        return "";
    }
    
    private Hashtable<String, Integer> getTableTitle(Sheet sheet, Set<String> set)
    {
        Row row = null;
        Cell cell;
        String title = "";
        Hashtable<String, Integer> titleMappings = new Hashtable<String, Integer>();
        try
        {
            
            for (int i = 0; i < sheet.getLastRowNum(); i++)
            {
                row = sheet.getRow(i);
                
                if (null != row.getCell(0)
                    && !ExcelTitleUtil.recordCode.equals(row.getCell(0).getStringCellValue().trim()))
                {
                    continue;
                }
                else
                {
                    dataRowNum = i + 1;
                    break;
                    
                }
            }
            
            for (int i = 0; i <= row.getLastCellNum(); i++)
            {
                cell = row.getCell(i);
                if (null != cell && cell.getCellType() == Cell.CELL_TYPE_STRING)
                {
                    title = trim(cell.getStringCellValue());
                    if (set.contains(title))
                    {
                        titleMappings.put(title, i);
                    }
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
            msg = PropertyConstants.ANALYSISFAILED;
        }
        return titleMappings;
    }
    
    private Sheet getWb(File peopleData, String fileName)
        throws IOException
    {
        Workbook wb = null;
        if (fileName.endsWith(PropertyConstants.XLSSUFFIX))
            version = version2003;
        else if (fileName.endsWith(PropertyConstants.XLSXSUFFIX))
            version = version2007;
        InputStream stream = null;
        if (version == version2003)
        {
            stream = new FileInputStream(peopleData);
            wb = (Workbook)new HSSFWorkbook(stream);
        }
        else if (version == version2007)
        {
            wb = (Workbook)new XSSFWorkbook(peopleData.getAbsolutePath());
        }
        return wb.getSheetAt(0);
    }
    
    public static String trim(String Str)
    {
        String newstr = Str.replaceAll("　", "  ");
        newstr = newstr.trim();
        newstr = newstr.replaceAll("  ", "　");
        return newstr;
    }
    
    private boolean validateCustomData(Row row, Hashtable<String, Integer> tableTitleTable)
    {
        // 过滤不合法数据
        if (isBlank(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordCode)))
            || isBlank(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordName)))
            || isBlank(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordUnit)))
            || isBlank(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordPrice)))
            || isBlank(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordAmount)))
            || isBlank(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordClass))))
        {
            
            return false;
        }
        // 过滤表头
        if (!isNumeric(row.getCell(tableTitleTable.get(ExcelTitleUtil.recordPrice))))
        {
            return false;
        }
        
        return true;
    }
}
