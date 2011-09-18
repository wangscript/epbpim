package com.ryxx.bpim.web.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.PeriodicalFile;
import com.ryxx.bpim.service.PeriodicalFileService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class PeriodicalFileAction extends ActionSupportBase
{
    private static final long serialVersionUID = -1781372665512868821L;
    
    private static final Log LOG = LogFactory.getLog(PeriodicalFileAction.class);
    
    private PeriodicalFile periodicalFile;
    
    private File uploadFile;
    
    private String msg = "";
    
    List<PeriodicalFile> datas = new ArrayList<PeriodicalFile>();
    
    private PageTools page;
    
    private PeriodicalFileService service;
    
    public String importPeriodicalFile()
    {
        try
        {
            msg = service.savePeriodicalFile(periodicalFile, uploadFile);
        }
        catch (Exception e)
        {
            LOG.error(e);
            msg = "出错了，请重试!";
        }
        return SUCCESS;
    }
    
    public String viewPeriodicalFile()
    {
        String sourceCode = "";
        
        try
        {
            sourceCode = service.getPeriodicalFile(periodicalFile);
        }
        catch (SQLException e)
        {
            LOG.error(e);
        }
        PrintWriter pw = null;
        try
        {
            pw = response.getWriter();
        }
        catch (IOException e)
        {
            LOG.error(e);
        }
        if (!StringUtils.isBlank(periodicalFile.getKeyword()))
        {
            String keyword = periodicalFile.getKeyword().replace("\5", "&#");
            sourceCode = sourceCode.replace(keyword, "<span style='background:yellow'>" + keyword + "</span>");
        }
        pw.println(sourceCode);
        pw.println("</body></html>");
        return SUCCESS;
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
        return paramStr;
    }
    
    public String searchPeriodicalFile()
    {
        try
        {
            if (null == periodicalFile)
            {
                periodicalFile = new PeriodicalFile();
            }
            
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
            PageTools page = new PageTools(pageNo, pageSize);
            periodicalFile.setRowCount(pageNo);
            periodicalFile.setPageSize(pageSize);
            datas = service.listPeriodicalFile(periodicalFile, page);
            periodicalFile.setKeyword(compileCode(periodicalFile.getKeyword()));
            if (datas != null && datas.size() > 0)
            {
                this.page = page;
            }
            else
            {
                super.addNotFoundErrorMsg();
                return SUCCESS;
            }
        }
        catch (SQLException e)
        {
            LOG.error(e);
        }
        return SUCCESS;
    }
    
    public static String toUnicode(String s)
    {
        String as[] = new String[s.length()];
        String s1 = "";
        String result = "";
        for (int i = 0; i < s.length(); i++)
        {
            as[i] = Integer.toHexString(s.charAt(i) & 0xffff);
            int i1 = Integer.parseInt(as[i], 16);
            s1 = String.valueOf(i1);
            result = result + "&#" + s1 + ";";
        }
        
        return result;
    }
    
    public PeriodicalFile getPeriodicalFile()
    {
        return periodicalFile;
    }
    
    public void setPeriodicalFile(PeriodicalFile periodicalFile)
    {
        this.periodicalFile = periodicalFile;
    }
    
    public File getUploadFile()
    {
        return uploadFile;
    }
    
    public void setUploadFile(File uploadFile)
    {
        this.uploadFile = uploadFile;
    }
    
    public List<PeriodicalFile> getDatas()
    {
        return datas;
    }
    
    public void setDatas(List<PeriodicalFile> datas)
    {
        this.datas = datas;
    }
    
    public PageTools getPage()
    {
        return page;
    }
    
    public void setPage(PageTools page)
    {
        this.page = page;
    }
    
    public PeriodicalFileService getService()
    {
        return service;
    }
    
    public void setService(PeriodicalFileService service)
    {
        this.service = service;
    }
    
    /**
     * @return the msg
     */
    public String getMsg()
    {
        return msg;
    }
    
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    
}