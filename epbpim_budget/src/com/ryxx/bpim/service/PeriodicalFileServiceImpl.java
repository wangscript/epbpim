package com.ryxx.bpim.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ryxx.bpim.dao.PeriodicalFileDAO;
import com.ryxx.bpim.entity.PeriodicalFile;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public class PeriodicalFileServiceImpl extends AbstractService<PeriodicalFile, PeriodicalFileDAO, Long> implements
    PeriodicalFileService
{
    public String savePeriodicalFile(PeriodicalFile periodicalFile, File uploadfile)
        throws ParseException, SQLException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date periodicalDate = sdf.parse(periodicalFile.getPeriodicalDatePage());
        periodicalFile.setPeriodicalDate(new Timestamp(periodicalDate.getTime()));
        
        periodicalFile.setUploadDate(new Timestamp(new Date().getTime()));
        
        periodicalFile.setSourceCode(readHtml(uploadfile.getAbsolutePath()));
        
        System.out.println(readHtml(uploadfile.getAbsolutePath()));
        getDao().savePeriodicalFile(periodicalFile);
        
        return "导入成功";
    }
    
    public String getPeriodicalFile(PeriodicalFile periodicalFile)
        throws Exception
    {
        PeriodicalFile periodicalFileDetail = getDao().viewPeriodicalFile(periodicalFile);
        String sourceCode = null != periodicalFileDetail ? periodicalFileDetail.getSourceCode() : "";
        return new String(sourceCode.getBytes("utf-8"),"gbk");
    }
    
    public List<PeriodicalFile> listPeriodicalFile(PeriodicalFile condition, PageTools page)
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
        return getDao().listPeriodicalFile(condition);
    }
    
    private String readHtml(String filePath)
    {
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try
        {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            String temp = null;
            while ((temp = br.readLine()) != null)
            {
                sb.append(temp);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
