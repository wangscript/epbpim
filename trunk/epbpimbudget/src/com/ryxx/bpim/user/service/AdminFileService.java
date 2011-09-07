package com.ryxx.bpim.user.service;

import java.util.List;

import com.ryxx.bpim.service.BaseService;
import com.ryxx.bpim.user.dao.AdminFileDAO;
import com.ryxx.bpim.user.entity.AdminFile;
import com.ryxx.util.page.PageTools;

public interface AdminFileService extends BaseService<AdminFile, AdminFileDAO, Long>
{
    void saveAdminFile(AdminFile adminFile);
    
    void deleteAdminFile(AdminFile adminFile);
    
    List<AdminFile> listAdminFile(AdminFile adminFile, PageTools page);
}
