package com.ryxx.bpim.user.dao;

import java.util.List;

import com.ryxx.bpim.dao.BaseDAO;
import com.ryxx.bpim.user.entity.AdminDept;

public interface AdminDeptDAO extends BaseDAO<AdminDept, Long>
{
    void addAdminDept(AdminDept adminDept);
    
    void modAdminDept(AdminDept adminDept);
    
    void delAdminDept(AdminDept adminDept);
    
    List<AdminDept> schAdminDeptList(AdminDept adminDept);
    
    int getRowCount(AdminDept adminDept);
}
