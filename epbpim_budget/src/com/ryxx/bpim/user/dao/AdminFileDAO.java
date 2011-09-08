package com.ryxx.bpim.user.dao;

import java.util.List;

import com.ryxx.bpim.dao.BaseDAO;
import com.ryxx.bpim.user.entity.AdminFile;

public interface AdminFileDAO extends BaseDAO<AdminFile, Long>
{
    void saveAdminFile(AdminFile adminFile);
    
    void deleteAdminFile(AdminFile adminFile);
    
    List<AdminFile> listAdminFile(AdminFile adminFile);
    
    int getRowCount(AdminFile adminFile);
}
