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
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        periodicalFile.setUploadDate(new Timestamp(new Date().getTime()));
        
        periodicalFile.setSourceCode(compileCode(readHtml(uploadfile.getAbsolutePath())));
        
        getDao().savePeriodicalFile(periodicalFile);
        
        return "导入成功";
    }
    
    public String getPeriodicalFile(PeriodicalFile periodicalFile)
        throws SQLException
    {
        PeriodicalFile periodicalFileDetail = getDao().viewPeriodicalFile(periodicalFile);
        return null != periodicalFileDetail ? periodicalFileDetail.getSourceCode() : "";
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
    
    private String compileCode(String paramStr)
    {
        Pattern p = Pattern.compile("&#.*?;");
        Matcher m = p.matcher(paramStr);
        boolean rs = m.find();
        while (rs)
        {
            String aa = m.group();
            String str = aa.replaceAll("&#", ",").replaceAll(";", "");
            String[] s2 = str.split(",");
            String s1 = "";
            for (int i = 1; i < s2.length; i++)
            {
                int v = Integer.parseInt(s2[i], 10);
                s1 = s1 + (char)v;
                paramStr = paramStr.replace(aa, s1);
            }
            rs = m.find();
        }
        paramStr = paramStr.replace("7.0000pt", "12.0000pt");
        paramStr = paramStr.replace("8.0000pt", "12.0000pt");
        // System.out.println(paramStr);
        return paramStr;
    }
    
}
