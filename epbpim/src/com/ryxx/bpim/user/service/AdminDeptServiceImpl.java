package com.ryxx.bpim.user.service;

import java.util.List;

import com.ryxx.bpim.service.AbstractService;
import com.ryxx.bpim.user.dao.AdminDeptDAO;
import com.ryxx.bpim.user.entity.AdminDept;
import com.ryxx.util.page.PageTools;

public class AdminDeptServiceImpl extends AbstractService<AdminDept, AdminDeptDAO, Long> implements AdminDeptService
{
    
    @Override
    public void saveAdminDept(AdminDept adminDept)
    {
        getDao().addAdminDept(adminDept);
    }
    
    @Override
    public void updateAdminDept(AdminDept adminDept)
    {
        getDao().addAdminDept(adminDept);
    }
    
    @Override
    public void deleteAdminDept(AdminDept adminDept)
    {
        
    }
    
    @Override
    public List<AdminDept> listAdminDept(AdminDept adminDept, PageTools page)
    {
        if (page != null)
        {
            if (page.getRecordCount() == 0)
            {
                int count = getDao().getRowCount(adminDept);
                page.setRecordCount(count);
            }
            adminDept.setStartRow(page.getPageStartRow());
            adminDept.setPageSize(page.getPageSize());
        }
        return getDao().schAdminDeptList(adminDept);
    }
}