package com.ryxx.bpim.user.service;

import java.util.List;

import com.ryxx.bpim.service.AbstractService;
import com.ryxx.bpim.user.dao.AdminFileDAO;
import com.ryxx.bpim.user.entity.AdminFile;
import com.ryxx.util.page.PageTools;

public class AdminFileServiceImpl extends AbstractService<AdminFile, AdminFileDAO, Long> implements AdminFileService
{
    
    @Override
    public void saveAdminFile(AdminFile adminFile)
    {
        getDao().saveAdminFile(adminFile);
    }
    
    @Override
    public void deleteAdminFile(AdminFile adminFile)
    {
        getDao().deleteAdminFile(adminFile);
    }
    
    @Override
    public List<AdminFile> listAdminFile(AdminFile adminFile, PageTools page)
    {
        if (page != null)
        {
            if (page.getRecordCount() == 0)
            {
                int count = getDao().getRowCount(adminFile);
                page.setRecordCount(count);
            }
            adminFile.setStartRow(page.getPageStartRow());
            adminFile.setPageSize(page.getPageSize());
        }
        return getDao().listAdminFile(adminFile);
    }
}