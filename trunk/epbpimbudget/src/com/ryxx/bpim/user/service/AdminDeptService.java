package com.ryxx.bpim.user.service;

import java.util.List;

import com.ryxx.bpim.service.BaseService;
import com.ryxx.bpim.user.dao.AdminDeptDAO;
import com.ryxx.bpim.user.entity.AdminDept;
import com.ryxx.util.page.PageTools;

public interface AdminDeptService extends BaseService<AdminDept, AdminDeptDAO, Long>
{
    void saveAdminDept(AdminDept adminDept);
    
    void updateAdminDept(AdminDept adminDept);
    
    void deleteAdminDept(AdminDept adminDept);
    
    List<AdminDept> listAdminDept(AdminDept adminDept, PageTools page);
}
