package com.ryxx.bpim.web.action.mainPanel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.GovernmentInventory;
import com.ryxx.bpim.service.GovernmentInventoryService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

/**
 * author Delgado
 */
public class SearchGovernmentInventoryAction extends ActionSupportBase
{
    /**
     * 
     */
    private static final long serialVersionUID = -251531175570040393L;
    
    GovernmentInventory condition = new GovernmentInventory();
    
    List<GovernmentInventory> datas = new ArrayList<GovernmentInventory>();
    
    private PageTools page; 
    
    private GovernmentInventoryService service;
    
    public String searchGovernmentInventory()
    {
        try
        {
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
            PageTools page = new PageTools(pageNo, pageSize);
            condition.setRowCount(pageNo);
            condition.setPageSize(pageSize);
            datas = service.listGovernmentInventory(condition, page);
            if (datas != null && datas.size() > 0)
            {
                this.page = page;
            }
            else
            {
                super.addNotFoundErrorMsg();
            }
        }
        catch (SQLException e)
        {
            LOG.error(e);
        }
        
        if ("2003".equals(condition.getGovernmentInventoryType()))
        {
            return "inventory2003";
        }
        else if ("2008".equals(condition.getGovernmentInventoryType()))
        {
            return "inventory2008";
        }
        else
        {
            return SUCCESS;
        }
        
    }
    
    /**
     * @return the condition
     */
    public GovernmentInventory getCondition()
    {
        return condition;
    }
    
    /**
     * @param condition
     *            the condition to set
     */
    public void setCondition(GovernmentInventory condition)
    {
        this.condition = condition;
    }
    
    public PageTools getPage()
    {
        return page;
    }
    
    public void setPage(PageTools page)
    {
        this.page = page;
    }
    
    public List<GovernmentInventory> getDatas()
    {
        return datas;
    }
    
    public void setDatas(List<GovernmentInventory> datas)
    {
        this.datas = datas;
    }
    
    public GovernmentInventoryService getService()
    {
        return service;
    }
    
    public void setService(GovernmentInventoryService service)
    {
        this.service = service;
    }
}
