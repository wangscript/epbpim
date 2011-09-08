package com.ryxx.bpim.user.dao;

import java.util.List;

import com.ryxx.bpim.dao.BaseDAO;
import com.ryxx.bpim.user.entity.AdminDept;

public interface AdminDeptDAO extends BaseDAO<AdminDept, Long>
{
    void saveAdminDept(AdminDept adminDept);
    
    void updateAdminDept(AdminDept adminDept);
    
    void deleteAdminDept(AdminDept adminDept);
    
    List<AdminDept> listAdminDept(AdminDept adminDept);
    
    int getRowCount(AdminDept adminDept);
}
