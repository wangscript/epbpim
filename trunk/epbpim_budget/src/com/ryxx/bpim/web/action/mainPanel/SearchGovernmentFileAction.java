package com.ryxx.bpim.web.action.mainPanel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.GovernmentFile;
import com.ryxx.bpim.service.GovernmentFileService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

/**
 * author Delgado
 */
public class SearchGovernmentFileAction extends ActionSupportBase
{
    
    /** åº�åˆ—å�· */
    private static final long serialVersionUID = 3895966524415236488L;
    
    GovernmentFile condition = new GovernmentFile();
    
    GovernmentFileService service;
    
    List<GovernmentFile> datas = new ArrayList<GovernmentFile>();
    
    String sourceCode = "";
    
    private PageTools page;
    
    public PageTools getPage()
    {
        return page;
    }
    
    public void setPage(PageTools page)
    {
        this.page = page;
    }
    
    public String viewGovernmentFile()
    {
        Long id = Long.valueOf(request.getParameter("id"));
        String keyword = request.getParameter("keyword");
        try
        {
            sourceCode = service.getGovernmentFile(id);
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
        if (!StringUtils.isBlank(keyword))
        {
            keyword = keyword.replace("\5", "&#");
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
    
    public String searchGovernmentFile()
    {
        try
        {
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
            PageTools page = new PageTools(pageNo, pageSize);
            condition.setRowCount(pageNo);
            condition.setPageSize(pageSize);
            String keyWord = null == condition.getKeyword() ? "" : condition.getKeyword();
            condition.setKeyword(toUnicode(keyWord));
            datas = service.listGovernmentFile(condition, page);
            condition.setKeyword(compileCode(keyWord));
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
    
    /**
     * @return the condition
     */
    public GovernmentFile getCondition()
    {
        return condition;
    }
    
    /**
     * @param condition
     *            the condition to set
     */
    public void setCondition(GovernmentFile condition)
    {
        this.condition = condition;
    }
    
    /**
     * @return the datas
     */
    public List<GovernmentFile> getDatas()
    {
        return datas;
    }
    
    /**
     * @param datas
     *            the datas to set
     */
    public void setDatas(List<GovernmentFile> datas)
    {
        this.datas = datas;
    }
    
    /**
     * @return the sourceCode
     */
    public String getSourceCode()
    {
        return sourceCode;
    }
    
    /**
     * @param sourceCode
     *            the sourceCode to set
     */
    public void setSourceCode(String sourceCode)
    {
        this.sourceCode = sourceCode;
    }
    
    public GovernmentFileService getService()
    {
        return service;
    }
    
    public void setService(GovernmentFileService service)
    {
        this.service = service;
    }
}
