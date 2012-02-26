package com.ryxx.bpim.system.action;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ryxx.bpim.system.entity.NewsAnnouncement;
import com.ryxx.bpim.system.service.NewsAnnounceService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.io.FileUtil;
import com.ryxx.util.string.StringTools;

public class NewAnnounceAction extends ActionSupportBase
{
    private static final long serialVersionUID = 4274988765242874229L;
    
    private NewsAnnounceService service;
    
    private List<NewsAnnouncement> newsAnnounces;
    
    private Long id;
    
    private String title;
    
    private String content;
    
    private Timestamp addTime;
    
    private Timestamp addTimeTemp;
    
    private File uploadFile;
    
    private String fileName;
    
    public Timestamp getAddTimeTemp()
    {
        return addTimeTemp;
    }
    
    public void setAddTimeTemp(Timestamp addTimeTemp)
    {
        this.addTimeTemp = addTimeTemp;
    }
    
    public String listNewsAnnounces()
    {
        try
        {
            newsAnnounces = service.findAll();
            return SUCCESS;
        }
        catch (Exception ex)
        {
            LOG.error("NewAnnounceAction error: ", ex);
            super.addErrorMsg(ex.getMessage());
            ex.printStackTrace();
            return ERROR;
        }
    }
    
    public String getDetailNewsAnnounces()
    {
        try
        {
            NewsAnnouncement ewsAnnounce = new NewsAnnouncement();
            ewsAnnounce.setId(StringTools.string2long(request.getParameter("id"), 0));
            ewsAnnounce = service.getNews(ewsAnnounce);
            if (ewsAnnounce != null)
            {
                setId(ewsAnnounce.getId());
                setTitle(ewsAnnounce.getNewsTitle());
                setContent(ewsAnnounce.getContent());
                setAddTime(ewsAnnounce.getAddTime());
                setAddTimeTemp(ewsAnnounce.getAddTimeTemp());
            }
            return SUCCESS;
        }
        catch (Exception ex)
        {
            LOG.error("NewAnnounceAction error: ", ex);
            super.addErrorMsg(ex.getMessage());
            ex.printStackTrace();
            return ERROR;
        }
    }
    
    public String insertNewsAnnounces()
    {
        try
        {
        	String path = dealWithUploadFile();
            NewsAnnouncement ewsAnnounce = new NewsAnnouncement();
            ewsAnnounce.setNewsTitle(title);
            ewsAnnounce.setContent(content);
            ewsAnnounce.setImagePath(path);
            service.saveNews(ewsAnnounce);
            return SUCCESS;
        }
        catch (Exception ex)
        {
            LOG.error("NewAnnounceAction error: ", ex);
            super.addErrorMsg(ex.getMessage());
            ex.printStackTrace();
            return ERROR;
        }
    }
    
    private final String FILE_SEAPRATOR = System.getProperty("file.separator");
    
    
    private String dealWithUploadFile()
            throws Exception
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String newFileName = sdf.format(new Date());
            
            String oldFileName = fileName;
            if (oldFileName.contains("."))
            {
                newFileName += oldFileName.substring(oldFileName.lastIndexOf("."), oldFileName.length());
            }
            
            String fileDir =
                request.getRealPath("/") + FILE_SEAPRATOR + "uploadfile" + FILE_SEAPRATOR + fileName;
            
            File fileDirFile = new File(fileDir);
            if (!fileDirFile.exists())
            {
                fileDirFile.mkdirs();
            }
            File newUploadFile = new File(fileDir + FILE_SEAPRATOR + newFileName);
            
            FileUtil.copy(uploadFile, newUploadFile, false);
            
            String filePath =
                "http://" + request.getLocalAddr() + ":" + request.getLocalPort() + request.getContextPath()
                    + "/uploadfile/" + fileName + "/" + newFileName;
            
            return filePath;
            
        }
    
    public String updateNewsAnnounces()
    {
        try
        {
        	String path = dealWithUploadFile();
            NewsAnnouncement ewsAnnounce = new NewsAnnouncement();
            ewsAnnounce.setNewsTitle(title);
            ewsAnnounce.setContent(content);
            ewsAnnounce.setImagePath(path);
            service.updateNews(ewsAnnounce);
            return SUCCESS;
        }
        catch (Exception ex)
        {
            LOG.error("NewAnnounceAction error: ", ex);
            super.addErrorMsg(ex.getMessage());
            ex.printStackTrace();
            return ERROR;
        }
    }
    
    public String deleteNewsAnnounces()
    {
        try
        {
            NewsAnnouncement ewsAnnounce = new NewsAnnouncement();
            ewsAnnounce.setId(id);
            service.deleteNews(ewsAnnounce);
            return SUCCESS;
        }
        catch (Exception ex)
        {
            LOG.error("NewAnnounceAction error: ", ex);
            super.addErrorMsg(ex.getMessage());
            ex.printStackTrace();
            return ERROR;
        }
    }
    
    public List<NewsAnnouncement> getNewsAnnounces()
    {
        return newsAnnounces;
    }
    
    public void setNewsAnnounces(List<NewsAnnouncement> newsAnnounces)
    {
        this.newsAnnounces = newsAnnounces;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public Timestamp getAddTime()
    {
        return addTime;
    }
    
    public void setAddTime(Timestamp addTime)
    {
        this.addTime = addTime;
    }
    
    public NewsAnnounceService getService()
    {
        return service;
    }
    
    public void setService(NewsAnnounceService service)
    {
        this.service = service;
    }

	/**
	 * @return the uploadFile
	 */
	public File getUploadFile() {
		return uploadFile;
	}

	/**
	 * @param uploadFile the uploadFile to set
	 */
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    
    
}
