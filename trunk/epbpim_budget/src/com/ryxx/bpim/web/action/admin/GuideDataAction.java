package com.ryxx.bpim.web.action.admin;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.GuideData;
import com.ryxx.bpim.service.GuideDataService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class GuideDataAction extends ActionSupportBase
{
    private static final long serialVersionUID = -1781372665512868821L;
    
    private static final Log LOG = LogFactory.getLog(GuideDataAction.class);
    
    private GuideData guideData;
    
    private File uploadFile;
    
    private String msg = "";
    
    List<GuideData> datas = new ArrayList<GuideData>();
    
    private PageTools page;
    
    private GuideDataService service;
    
    public String importGuideData()
    {
        try
        {
            msg = service.saveGuideData(guideData, uploadFile);
        }
        catch (Exception e)
        {
            LOG.error(e);
            msg = e.getMessage();
        }
        return SUCCESS;
    }
    
    public String searchGuideData()
    {
        try
        {
            if (null == guideData)
            {
                guideData = new GuideData();
            }
            
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
            PageTools page = new PageTools(pageNo, pageSize);
            guideData.setRowCount(pageNo);
            guideData.setPageSize(pageSize);
            datas = service.listGuideData(guideData, page);
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
    
    public String deleteGuideData()
    {
        try
        {
            msg = service.deleteGuideData(guideData);
        }
        catch (Exception e)
        {
            LOG.error(e);
            msg = "false";
        }
        return SUCCESS;
    }
    
    public GuideData getGuideData()
    {
        return guideData;
    }
    
    public void setGuideData(GuideData guideData)
    {
        this.guideData = guideData;
    }
    
    public File getUploadFile()
    {
        return uploadFile;
    }
    
    public void setUploadFile(File uploadFile)
    {
        this.uploadFile = uploadFile;
    }
    
    public String getMsg()
    {
        return msg;
    }
    
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    
    public List<GuideData> getDatas()
    {
        return datas;
    }
    
    public void setDatas(List<GuideData> datas)
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
    
    public GuideDataService getService()
    {
        return service;
    }
    
    public void setService(GuideDataService service)
    {
        this.service = service;
    }
}