package com.ryxx.bpim.user.action;

import java.util.List;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.user.entity.AdminDept;
import com.ryxx.bpim.user.service.AdminDeptService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class AdminDeptAction extends ActionSupportBase
{
    
    /** 序列号  */
    private static final long serialVersionUID = 273482916839420012L;
    
    private AdminDept adminDept;
    
    private List<AdminDept> adminDeptList;
    
    private AdminDeptService adminDeptService;
    
    private PageTools page;
    
    public String schAdminDeptList()
    {
        try
        {
            if (null == adminDept)
            {
                adminDept = new AdminDept();
            }
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
            PageTools page = new PageTools(pageNo, pageSize);
            adminDept.setRowCount(pageNo);
            adminDept.setPageSize(pageSize);
            adminDeptList = adminDeptService.listAdminDept(adminDept, page);
            if (adminDeptList != null && adminDeptList.size() > 0)
            {
                this.page = page;
            }
            else
            {
                super.addNotFoundErrorMsg();
            }
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String addAdminDept()
    {
        try
        {
            adminDeptService.saveAdminDept(adminDept);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String modAdminDept()
    {
        try
        {
            adminDeptService.updateAdminDept(adminDept);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        
        return SUCCESS;
    }
    
    public String delAdminDept()
    {
        try
        {
            adminDeptService.deleteAdminDept(adminDept);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            // return ERROR;
        }
        return SUCCESS;
    }
    
    public AdminDept getAdminDept()
    {
        return adminDept;
    }
    
    public void setAdminDept(AdminDept adminDept)
    {
        this.adminDept = adminDept;
    }
    
    public List<AdminDept> getAdminDeptList()
    {
        return adminDeptList;
    }
    
    public void setAdminDeptList(List<AdminDept> adminDeptList)
    {
        this.adminDeptList = adminDeptList;
    }
    
    public AdminDeptService getAdminDeptService()
    {
        return adminDeptService;
    }
    
    public void setAdminDeptService(AdminDeptService adminDeptService)
    {
        this.adminDeptService = adminDeptService;
    }
    
    public PageTools getPage()
    {
        return page;
    }
    
    public void setPage(PageTools page)
    {
        this.page = page;
    }
}
