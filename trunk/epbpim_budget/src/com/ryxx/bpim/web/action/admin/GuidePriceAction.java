package com.ryxx.bpim.web.action.admin;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.GuidePrice;
import com.ryxx.bpim.service.GuidePriceService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class GuidePriceAction extends ActionSupportBase
{
    private static final long serialVersionUID = -1781372665512868821L;
    
    private static final Log LOG = LogFactory.getLog(GuidePriceAction.class);
    
    private GuidePrice guidePrice;
    
    private File uploadFile;
    
    private String msg = "";
    
    List<GuidePrice> datas = new ArrayList<GuidePrice>();
    
    private PageTools page;
    
    private GuidePriceService service;
    
    public String importGuidePrice()
    {
        try
        {
            msg = service.saveGuidePrice(guidePrice, uploadFile);
        }
        catch (Exception e)
        {
            LOG.error(e);
            msg = "出错了，请重试!";
        }
        request.setAttribute("msg", msg);
        return SUCCESS;
    }
    
    public String searchPeriodicalFile()
    {
        try
        {
            if (null == guidePrice)
            {
                guidePrice = new GuidePrice();
            }
            
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
            PageTools page = new PageTools(pageNo, pageSize);
            guidePrice.setRowCount(pageNo);
            guidePrice.setPageSize(pageSize);
            datas = service.listGuidePrice(guidePrice, page);
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
    
    public String deleteGuidePrice()
    {
        try
        {
            msg = service.deleteGuidePrice(guidePrice);
        }
        catch (Exception e)
        {
            LOG.error(e);
            msg = "出错了，请重试!";
        }
        return SUCCESS;
    }
    
    public GuidePrice getGuidePrice()
    {
        return guidePrice;
    }
    
    public void setGuidePrice(GuidePrice guidePrice)
    {
        this.guidePrice = guidePrice;
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
    
    public List<GuidePrice> getDatas()
    {
        return datas;
    }
    
    public void setDatas(List<GuidePrice> datas)
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
    
    public GuidePriceService getService()
    {
        return service;
    }
    
    public void setService(GuidePriceService service)
    {
        this.service = service;
    }
}