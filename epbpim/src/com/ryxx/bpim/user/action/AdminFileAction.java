package com.ryxx.bpim.user.action;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.user.entity.AdminFile;
import com.ryxx.bpim.user.service.AdminFileService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.io.FileUtil;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class AdminFileAction extends ActionSupportBase
{
    
    /** 序列号  */
    private static final long serialVersionUID = 273482916839420012L;
    
    /** 目录分隔符 */
    private final String FILE_SEAPRATOR = System.getProperty("file.separator");
    
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
                
                String requestURI = request.getRequestURI();
                
                if (requestURI.toLowerCase().contains("business"))
                {
                    adminFile.setFileModule("1");
                }
                else if (requestURI.toLowerCase().contains("iso"))
                {
                    adminFile.setFileModule("2");
                }
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
        File newUploadFile = null;
        try
        {
            newUploadFile = dealWithUploadFile();
            
            adminFileService.saveAdminFile(adminFile);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            
            if (null != newUploadFile)
            {
                newUploadFile.delete();
            }
            
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String delAdminFile()
    {
        try
        {
            String fileDir =
                request.getRealPath("/") + FILE_SEAPRATOR + "uploadfile" + FILE_SEAPRATOR + adminFile.getFileModule();
            
            String filePath = adminFile.getFilePath();
            if (null != filePath)
            {
                String delFileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length());
                
                if (!StringUtils.isEmpty(delFileName))
                {
                    new File(fileDir + FILE_SEAPRATOR + delFileName).delete();
                }
            }
            
            adminFileService.deleteAdminFile(adminFile);
        }
        catch (Exception e)
        {
            LOG.warn(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    private File dealWithUploadFile()
        throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String newFileName = sdf.format(new Date());
        
        String oldFileName = adminFile.getFileName();
        if (oldFileName.contains("."))
        {
            newFileName += oldFileName.substring(oldFileName.lastIndexOf("."), oldFileName.length());
        }
        
        String fileDir =
            request.getRealPath("/") + FILE_SEAPRATOR + "uploadfile" + FILE_SEAPRATOR + adminFile.getFileModule();
        
        File fileDirFile = new File(fileDir);
        if (!fileDirFile.exists())
        {
            fileDirFile.mkdirs();
        }
        File newUploadFile = new File(fileDir + FILE_SEAPRATOR + newFileName);
        
        FileUtil.copy(uploadFile, newUploadFile, false);
        
        String filePath =
            "http://" + request.getLocalAddr() + ":" + request.getLocalPort() + request.getContextPath()
                + "/uploadfile/" + adminFile.getFileModule() + "/" + newFileName;
        
        adminFile.setFilePath(filePath);
        
        adminFile.setUploadDate(new Timestamp(new Date().getTime()));
        
        return newUploadFile;
        
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
