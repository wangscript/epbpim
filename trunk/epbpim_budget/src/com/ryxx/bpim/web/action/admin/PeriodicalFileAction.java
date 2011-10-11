package com.ryxx.bpim.web.action.admin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.PeriodicalFile;
import com.ryxx.bpim.service.PeriodicalFileService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.io.FileUtil;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class PeriodicalFileAction extends ActionSupportBase
{
    private static final long serialVersionUID = -1781372665512868821L;
    
    private static final Log LOG = LogFactory.getLog(PeriodicalFileAction.class);
    
    private PeriodicalFile periodicalFile;
    
    private File uploadFile;
    
    private String msg = "";
    
    List<PeriodicalFile> datas = new ArrayList<PeriodicalFile>();
    
    private PageTools page;
    
    private PeriodicalFileService service;
    
    public String importPeriodicalFile()
    {
        try
        {
			String uploadTempPath = request.getRealPath("/") + "temp" + "/";
			String uploadRealPath = request.getRealPath("/") + "periodicalHtml"
					+ "/";
			File newUploadFile = new File(uploadTempPath
					+ periodicalFile.getPeriodicalName());
			FileUtil.copy(uploadFile, newUploadFile, false);
			releaseZipToFile(newUploadFile.getAbsolutePath(), uploadRealPath);
			String url = "periodicalHtml" + "/"
					+ periodicalFile.getPeriodicalName().replace("zip", "html");
			periodicalFile.setPeriodicalUrl(url);
			msg = service.savePeriodicalFile(periodicalFile);
        }
        catch (Exception e)
        {
            LOG.error(e);
            msg = "false";
        }
        return SUCCESS;
    }
    
    public String viewPeriodicalFile()
    {
        String sourceCode = "";
        
        try
        {
            sourceCode = service.getPeriodicalFile(periodicalFile);
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        PrintWriter pw = null;
        try
        {
            pw = response.getWriter();
        }
        catch (IOException e)
        {
            LOG.error(e);
        }
        if (!StringUtils.isBlank(periodicalFile.getKeyword()))
        {
            String keyword = periodicalFile.getKeyword().replace("\5", "&#");
            sourceCode = sourceCode.replace(keyword, "<span style='background:yellow'>" + keyword + "</span>");
        }
        pw.println(sourceCode);
        pw.println("</body></html>");
        pw.flush();
        
        return SUCCESS;
    }
    
    public String searchPeriodicalFile()
    {
        try
        {
            if (null == periodicalFile)
            {
                periodicalFile = new PeriodicalFile();
            }
            
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
            PageTools page = new PageTools(pageNo, pageSize);
            periodicalFile.setRowCount(pageNo);
            periodicalFile.setPageSize(pageSize);
            datas = service.listPeriodicalFile(periodicalFile, page);
            if (datas != null && datas.size() > 0)
            {
                this.page = page;
            }
            else
            {
                super.addNotFoundErrorMsg();
                return SUCCESS;
            }
        }
        catch (SQLException e)
        {
            LOG.error(e);
        }
        return SUCCESS;
    }
    
    public static String toUnicode(String s)
    {
        String as[] = new String[s.length()];
        String s1 = "";
        String result = "";
        for (int i = 0; i < s.length(); i++)
        {
            as[i] = Integer.toHexString(s.charAt(i) & 0xffff);
            int i1 = Integer.parseInt(as[i], 16);
            s1 = String.valueOf(i1);
            result = result + "&#" + s1 + ";";
        }
        
        return result;
    }
    
	public void releaseZipToFile(String sourceZip, String outFileName)
			throws IOException {
		ZipFile zfile = new ZipFile(sourceZip);
		System.out.println(zfile.getName());
		Enumeration zList = zfile.entries();
		ZipEntry ze = null;
		byte[] buf = new byte[1024];
		while (zList.hasMoreElements()) {
			// 从ZipFile中得到一个ZipEntry
			ze = (ZipEntry) zList.nextElement();
			if (ze.isDirectory()) {
				continue;
			}
			// 以ZipEntry为参数得到一个InputStream，并写到OutputStream中
			OutputStream os = new BufferedOutputStream(new FileOutputStream(
					getRealFileName(outFileName, ze.getName())));
			InputStream is = new BufferedInputStream(zfile.getInputStream(ze));
			int readLen = 0;
			while ((readLen = is.read(buf, 0, 1024)) != -1) {
				os.write(buf, 0, readLen);
			}
			is.close();
			os.close();
			System.out.println("Extracted: " + ze.getName());
		}
		zfile.close();

	}

	private File getRealFileName(String baseDir, String absFileName) {
		String[] dirs = absFileName.split("/");
		// System.out.println(dirs.length);
		File ret = new File(baseDir);
		// System.out.println(ret);
		if (dirs.length > 1) {
			for (int i = 0; i < dirs.length - 1; i++) {
				ret = new File(ret, dirs[i]);
			}
		}
		if (!ret.exists()) {
			ret.mkdirs();
		}
		ret = new File(ret, dirs[dirs.length - 1]);
		return ret;
	}
    
    public PeriodicalFile getPeriodicalFile()
    {
        return periodicalFile;
    }
    
    public void setPeriodicalFile(PeriodicalFile periodicalFile)
    {
        this.periodicalFile = periodicalFile;
    }
    
    public File getUploadFile()
    {
        return uploadFile;
    }
    
    public void setUploadFile(File uploadFile)
    {
        this.uploadFile = uploadFile;
    }
    
    public List<PeriodicalFile> getDatas()
    {
        return datas;
    }
    
    public void setDatas(List<PeriodicalFile> datas)
    {
        this.datas = datas;
    }
    
    public PageTools getPage()
    {
        return page;
    }
    
    public void setPage(PageTools page)
    {
        this.page = page;
    }
    
    public PeriodicalFileService getService()
    {
        return service;
    }
    
    public void setService(PeriodicalFileService service)
    {
        this.service = service;
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
    
}