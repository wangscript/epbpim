package com.ryxx.bpim.web.action.admin;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.PriceHighLowTopPicture;
import com.ryxx.bpim.entity.ProvinceCity;
import com.ryxx.bpim.service.PriceHighLowTopPictureService;
import com.ryxx.bpim.service.ProvinceCityService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.io.FileUtil;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class PriceHighLowTopPictureAction extends ActionSupportBase {
	private static final long serialVersionUID = -1781372665512868821L;

	private static final Log LOG = LogFactory.getLog(PriceHighLowTopPictureAction.class);

	private PriceHighLowTopPicture priceHighLowTopPicture;

	private List<PriceHighLowTopPicture> datas = new ArrayList<PriceHighLowTopPicture>();

	private File uploadFile;

	private String msg = "";

	private PageTools page;

	private PriceHighLowTopPictureService service;
	
	private ProvinceCityService provinceCityService;

	private String flashFileUrl;
	
	private List<ProvinceCity> provinceCities;

	public String uploadPriceHighLowTopPicture() {
		String fileName = new Date().getTime() + ".swf";
		File newUploadFile = null;
		try {
			msg = "true";
			String uploadRealPath = request.getRealPath("/") + "priceHighLowTopPicture" + "/";
			File uploadDir = new File(uploadRealPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}

			if (uploadFile != null) {
				newUploadFile = new File(uploadRealPath + fileName);
				FileUtil.copy(uploadFile, newUploadFile, false);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date priceHighLowTopDate = sdf.parse(priceHighLowTopPicture.getPriceHighLowTopDatePage());
			priceHighLowTopPicture.setPriceHighLowTopDate(new Timestamp(priceHighLowTopDate.getTime()));
			priceHighLowTopPicture.setRealName(priceHighLowTopPicture.getRealName().substring(0,
					priceHighLowTopPicture.getRealName().indexOf(".")));
			priceHighLowTopPicture.setFileName(fileName);
			service.save(priceHighLowTopPicture);

		} catch (Exception e) {
			if (newUploadFile != null && newUploadFile.exists()) {
				newUploadFile.delete();
			}
			LOG.error(e);
			msg = "false";
		}
		return SUCCESS;
	}

	public String searchPriceHighLowTopPicture() {
		try {
			if (priceHighLowTopPicture == null) {
				priceHighLowTopPicture = new PriceHighLowTopPicture();
				ProvinceCity proviceCity = new ProvinceCity();
				proviceCity.setId((long) 3);
				priceHighLowTopPicture.setProvinceCity(proviceCity);
			}
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			priceHighLowTopPicture.setRowCount(pageNo);
			priceHighLowTopPicture.setPageSize(pageSize);
			datas = service.listPriceHighLowTopPictures(priceHighLowTopPicture, page);
			if (datas != null && datas.size() > 0) {
				this.page = page;
			} else {
				super.addNotFoundErrorMsg();
				return SUCCESS;
			}
			provinceCities = provinceCityService.list();
		} catch (Exception e) {
			LOG.error(e);
		}
		return SUCCESS;
	}

	public String viewPriceHighLowTopPicture() {
		String priceHighLowTopPictureFileName = request.getParameter("priceHighLowTopPictureFileName");
		flashFileUrl = "../priceHighLowTopPicture/" + priceHighLowTopPictureFileName;
		return SUCCESS;
	}

	/**
	 * @return the priceHighLowTopPicture
	 */
	public PriceHighLowTopPicture getPriceHighLowTopPicture() {
		return priceHighLowTopPicture;
	}

	/**
	 * @param priceHighLowTopPicture the priceHighLowTopPicture to set
	 */
	public void setPriceHighLowTopPicture(
			PriceHighLowTopPicture priceHighLowTopPicture) {
		this.priceHighLowTopPicture = priceHighLowTopPicture;
	}

	/**
	 * @return the datas
	 */
	public List<PriceHighLowTopPicture> getDatas() {
		return datas;
	}

	/**
	 * @param datas the datas to set
	 */
	public void setDatas(List<PriceHighLowTopPicture> datas) {
		this.datas = datas;
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
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the page
	 */
	public PageTools getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(PageTools page) {
		this.page = page;
	}

	/**
	 * @return the service
	 */
	public PriceHighLowTopPictureService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(PriceHighLowTopPictureService service) {
		this.service = service;
	}

	/**
	 * @return the provinceCityService
	 */
	public ProvinceCityService getProvinceCityService() {
		return provinceCityService;
	}

	/**
	 * @param provinceCityService the provinceCityService to set
	 */
	public void setProvinceCityService(ProvinceCityService provinceCityService) {
		this.provinceCityService = provinceCityService;
	}


	/**
	 * @return the flashFileUrl
	 */
	public String getFlashFileUrl() {
		return flashFileUrl;
	}

	/**
	 * @param flashFileUrl the flashFileUrl to set
	 */
	public void setFlashFileUrl(String flashFileUrl) {
		this.flashFileUrl = flashFileUrl;
	}

	/**
	 * @return the provinceCities
	 */
	public List<ProvinceCity> getProvinceCities() {
		return provinceCities;
	}

	/**
	 * @param provinceCities the provinceCities to set
	 */
	public void setProvinceCities(List<ProvinceCity> provinceCities) {
		this.provinceCities = provinceCities;
	}

	
	
}