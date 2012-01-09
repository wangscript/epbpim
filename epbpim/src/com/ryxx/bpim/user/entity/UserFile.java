/**
 * 
 */
package com.ryxx.bpim.user.entity;

import com.ryxx.bpim.entity.VoBase;

/**
 * @author Delgado Ding
 *
 */
public class UserFile extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = -1749608509573047697L;
    
    private String fileName;
    
    private String filePath;
    
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
    
}
