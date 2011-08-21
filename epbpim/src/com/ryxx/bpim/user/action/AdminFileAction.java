package com.ryxx.bpim.user.action;

import java.io.File;
import java.util.List;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.user.entity.AdminFile;
import com.ryxx.bpim.user.service.AdminFileService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class AdminFileAction extends ActionSupportBase
{
    
    /** 序列号  */
    private static final long serialVersionUID = 273482916839420012L;
    
    private AdminFile adminFile;
    
    private File uploadFile;
    
    private List<AdminFile> adminFileList;
    
    private AdminFileService adminFileService;
    
    private PageTools page;
    
    public String schAdminFileList()
    {
        try
        {
            if (null == adminFile)
            {
                adminFile = new AdminFile();
            }
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
            PageTools page = new PageTools(pageNo, pageSize);
            adminFile.setRowCount(pageNo);
            adminFile.setPageSize(pageSize);
            adminFileList = adminFileService.listAdminFile(adminFile, page);
            if (adminFileList != null && adminFileList.size() > 0)
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
    
    public String addAdminFile()
    {
        try
        {
            adminFileService.saveAdminFile(adminFile);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String delAdminFile()
    {
        try
        {
            adminFileService.deleteAdminFile(adminFile);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    public AdminFile getAdminFile()
    {
        return adminFile;
    }
    
    public void setAdminFile(AdminFile adminFile)
    {
        this.adminFile = adminFile;
    }
    
    public File getUploadFile()
    {
        return uploadFile;
    }
    
    public void setUploadFile(File uploadFile)
    {
        this.uploadFile = uploadFile;
    }
    
    public List<AdminFile> getAdminFileList()
    {
        return adminFileList;
    }
    
    public void setAdminFileList(List<AdminFile> adminFileList)
    {
        this.adminFileList = adminFileList;
    }
    
    public AdminFileService getAdminFileService()
    {
        return adminFileService;
    }
    
    public void setAdminFileService(AdminFileService adminFileService)
    {
        this.adminFileService = adminFileService;
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
