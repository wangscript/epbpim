package com.ryxx.bpim.user.entity;

import java.sql.Timestamp;

import com.ryxx.bpim.entity.VoBase;

public class AdminFile extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = 4691370091966904625L;
    
    private String id;
    
    private String fileModule;
    
    private String fileName;
    
    private String filePath;
    
    private String fileType;
    
    private String fileContent;
    
    private Timestamp uploadDate;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getFileModule()
    {
        return fileModule;
    }
    
    public void setFileModule(String fileModule)
    {
        this.fileModule = fileModule;
    }
    
    public String getFileName()
    {
        return fileName;
    }
    
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    public String getFilePath()
    {
        return filePath;
    }
    
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }
    
    public String getFileType()
    {
        return fileType;
    }
    
    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }
    
    public String getFileContent()
    {
        return fileContent;
    }
    
    public void setFileContent(String fileContent)
    {
        this.fileContent = fileContent;
    }
    
    public Timestamp getUploadDate()
    {
        return uploadDate;
    }
    
    public void setUploadDate(Timestamp uploadDate)
    {
        this.uploadDate = uploadDate;
    }
}
