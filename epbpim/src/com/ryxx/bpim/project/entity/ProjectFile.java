/**
 * 
 */
package com.ryxx.bpim.project.entity;

import com.ryxx.bpim.entity.VoBase;

/**
 * @author Delgado Ding
 *
 */
public class ProjectFile extends VoBase
{
    
    /** 序列号 */
    private static final long serialVersionUID = 9169928851011354360L;
    
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
