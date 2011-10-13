package com.ryxx.bpim.web.action.admin;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.PricePackageFile;
import com.ryxx.bpim.service.PricePackageFileService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.io.FileUtil;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class PricePackageFileAction extends ActionSupportBase
{
    
    /** 序列号  */
    private static final long serialVersionUID = 273482916839420012L;
    
    /** 目录分隔符 */
    private final String FILE_SEAPRATOR = System.getProperty("file.separator");
    
    private PricePackageFile pricePackageFile;
    
    private File uploadFile;
    
    private List<PricePackageFile> dates;
    
    private PricePackageFileService service;
    
    private PageTools page;
    
    private String msg = "";
    
    public String searchPricePackageFile()
    {
        try
        {
            if (null == pricePackageFile)
            {
                pricePackageFile = new PricePackageFile();
            }
            
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
            PageTools page = new PageTools(pageNo, pageSize);
            pricePackageFile.setRowCount(pageNo);
            pricePackageFile.setPageSize(pageSize);
            dates = service.listPricePackageFile(pricePackageFile, page);
            if (dates != null && dates.size() > 0)
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
    
    public String addPricePackageFile()
    {
        File newUploadFile = null;
        try
        {
            newUploadFile = dealWithUploadFile();
            
            service.savePricePackageFile(pricePackageFile);
            
            msg = "true";
        }
        catch (Exception e)
        {
            LOG.warn(e);
            
            if (null != newUploadFile)
            {
                newUploadFile.delete();
            }
            
            msg = "false";
        }
        return SUCCESS;
    }
    
    public String delPricePackageFile()
    {
        try
        {
            String fileDir = request.getRealPath("/") + FILE_SEAPRATOR + "uploadfile" + FILE_SEAPRATOR + "pricepackage";
            
            String filePath = pricePackageFile.getPricePackagePath();
            if (null != filePath)
            {
                String delFileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length());
                
                if (!StringUtils.isEmpty(delFileName))
                {
                    new File(fileDir + FILE_SEAPRATOR + delFileName).delete();
                }
            }
            
            service.deletePricePackageFile(pricePackageFile);
            msg = "true";
        }
        catch (Exception e)
        {
            LOG.warn(e);
            msg = "false";
        }
        return SUCCESS;
    }
    
    private File dealWithUploadFile()
        throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String newFileName = sdf.format(new Date());
        
        String oldFileName = pricePackageFile.getPricePackageName();
        if (oldFileName.contains("."))
        {
            newFileName += oldFileName.substring(oldFileName.lastIndexOf("."), oldFileName.length());
            pricePackageFile.setPricePackageName(oldFileName.substring(0, oldFileName.lastIndexOf(".")));
        }
        
        String fileDir = request.getRealPath("/") + FILE_SEAPRATOR + "uploadfile" + FILE_SEAPRATOR + "pricepackage";
        
        File fileDirFile = new File(fileDir);
        if (!fileDirFile.exists())
        {
            fileDirFile.mkdirs();
        }
        File newUploadFile = new File(fileDir + FILE_SEAPRATOR + newFileName);
        
        FileUtil.copy(uploadFile, newUploadFile, false);
        
        String filePath =
            "http://" + request.getLocalAddr() + ":" + request.getLocalPort() + request.getContextPath()
                + "/uploadfile/pricepackage/" + newFileName;
        
        pricePackageFile.setPricePackagePath(filePath);
        
        SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM");
        Date periodicalDate = sdff.parse(pricePackageFile.getPricePackageDatePage());
        pricePackageFile.setPricePackageDate(new Timestamp(periodicalDate.getTime()));
        
        pricePackageFile.setUploadDate(new Timestamp(new Date().getTime()));
        
        return newUploadFile;
        
    }
    
    public PricePackageFile getPricePackageFile()
    {
        return pricePackageFile;
    }
    
    public void setPricePackageFile(PricePackageFile pricePackageFile)
    {
        this.pricePackageFile = pricePackageFile;
    }
    
    public File getUploadFile()
    {
        return uploadFile;
    }
    
    public void setUploadFile(File uploadFile)
    {
        this.uploadFile = uploadFile;
    }
    
    public List<PricePackageFile> getDates()
    {
        return dates;
    }
    
    public void setDates(List<PricePackageFile> dates)
    {
        this.dates = dates;
    }
    
    public PageTools getPage()
    {
        return page;
    }
    
    public void setPage(PageTools page)
    {
        this.page = page;
    }
    
    public PricePackageFileService getService()
    {
        return service;
    }
    
    public void setService(PricePackageFileService service)
    {
        this.service = service;
    }
    
    public String getMsg()
    {
        return msg;
    }
    
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    
}
