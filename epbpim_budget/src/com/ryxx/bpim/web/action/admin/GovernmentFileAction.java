package com.ryxx.bpim.web.action.admin;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.service.GovernmentFileService;
import com.ryxx.bpim.web.action.ActionSupportBase;

public class GovernmentFileAction extends ActionSupportBase
{
    private static final long serialVersionUID = -1781372665512868821L;
    
    private String fileName = "";
    
    private String fileType = "";
    
    private String fileSubType = "";
    
    private String provice = "";
    
    private File importGovernmentFile;
    
    private String msg = "";
    
    private static final Log LOG = LogFactory.getLog(GovernmentFileAction.class);
    
    private GovernmentFileService service;
    
    public String importGovernmentFile()
    {
        if (!"".equals(fileName) && !fileName.endsWith("html"))
        {
            msg = "file type is wrong! ";
            return SUCCESS;
        }
        try
        {
            msg = service.saveGovernmentFile(provice, fileType, fileSubType, fileName, importGovernmentFile);
        }
        catch (Exception e)
        {
            LOG.error(e);
            msg = "false";
        }
        return SUCCESS;
    }
    
    public String getFileName()
    {
        return fileName;
    }
    
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    /**
     * @return the fileType
     */
    public String getFileType()
    {
        return fileType;
    }
    
    /**
     * @param fileType the fileType to set
     */
    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }
    
    /**
     * @return the fileSubType
     */
    public String getFileSubType()
    {
        return fileSubType;
    }
    
    /**
     * @param fileSubType the fileSubType to set
     */
    public void setFileSubType(String fileSubType)
    {
        this.fileSubType = fileSubType;
    }
    
    /**
     * @return the provice
     */
    public String getProvice()
    {
        return provice;
    }
    
    /**
     * @param provice the provice to set
     */
    public void setProvice(String provice)
    {
        this.provice = provice;
    }
    
    /**
     * @return the importGovernmentFile
     */
    public File getImportGovernmentFile()
    {
        return importGovernmentFile;
    }
    
    /**
     * @param importGovernmentFile the importGovernmentFile to set
     */
    public void setImportGovernmentFile(File importGovernmentFile)
    {
        this.importGovernmentFile = importGovernmentFile;
    }
    
    /**
     * @return the msg
     */
    public String getMsg()
    {
        return msg;
    }
    
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    
    /**
     * @return the service
     */
    public GovernmentFileService getService()
    {
        return service;
    }
    
    /**
     * @param service the service to set
     */
    public void setService(GovernmentFileService service)
    {
        this.service = service;
    }
    
}