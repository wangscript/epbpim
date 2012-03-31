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
import com.ryxx.bpim.entity.PriceIndexPicture;
import com.ryxx.bpim.entity.ProvinceCity;
import com.ryxx.bpim.service.PriceIndexPictureService;
import com.ryxx.bpim.service.ProvinceCityService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.io.FileUtil;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class PriceIndexPictureAction extends ActionSupportBase {
	private static final long serialVersionUID = -1781372665512868821L;

	private static final Log LOG = LogFactory.getLog(PriceIndexPictureAction.class);

	private PriceIndexPicture priceIndexPicture;

	private List<PriceIndexPicture> datas = new ArrayList<PriceIndexPicture>();

	private File uploadFile;

	private String msg = "";

	private PageTools page;

	private PriceIndexPictureService service;
	
	private ProvinceCityService provinceCityService;

	private String flashFileUrl;
	
	private List<ProvinceCity> provinceCities;

	public String uploadPriceIndexPicture() {
		String fileName = new Date().getTime() + ".swf";
		File newUploadFile = null;
		try {
			msg = "true";
			String uploadRealPath = request.getRealPath("/") + "priceIndexPicture" + "/";
			File uploadDir = new File(uploadRealPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}

			if (uploadFile != null) {
				newUploadFile = new File(uploadRealPath + fileName);
				FileUtil.copy(uploadFile, newUploadFile, false);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date priceHighLowTopDate = sdf.parse(priceIndexPicture.getPriceIndexPagePage());
			priceIndexPicture.setPriceIndexDate(new Timestamp(priceHighLowTopDate.getTime()));
			priceIndexPicture.setRealName(priceIndexPicture.getRealName().substring(0,
					priceIndexPicture.getRealName().indexOf(".")));
			priceIndexPicture.setFileName(fileName);
			service.save(priceIndexPicture);

		} catch (Exception e) {
			if (newUploadFile != null && newUploadFile.exists()) {
				newUploadFile.delete();
			}
			LOG.error(e);
			msg = "false";
		}
		return SUCCESS;
	}

	public String searchPriceIndexPicture() {
		try {
			if (priceIndexPicture == null) {
				priceIndexPicture = new PriceIndexPicture();
				ProvinceCity proviceCity = new ProvinceCity();
				proviceCity.setId((long) 3);
				priceIndexPicture.setProvinceCity(proviceCity);
			}
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			priceIndexPicture.setRowCount(pageNo);
			priceIndexPicture.setPageSize(pageSize);
			datas = service.listPriceIndexPictures(priceIndexPicture, page);
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

	public String viewPriceIndexPicture() {
		String priceIndexPictureFileName = request.getParameter("priceIndexPictureFileName");
		flashFileUrl = "../priceIndexPicture/" + priceIndexPictureFileName;
		return SUCCESS;
	}

	/**
	 * @return the priceIndexPicture
	 */
	public PriceIndexPicture getPriceIndexPicture() {
		return priceIndexPicture;
	}

	/**
	 * @param priceIndexPicture the priceIndexPicture to set
	 */
	public void setPriceIndexPicture(PriceIndexPicture priceIndexPicture) {
		this.priceIndexPicture = priceIndexPicture;
	}

	/**
	 * @return the datas
	 */
	public List<PriceIndexPicture> getDatas() {
		return datas;
	}

	/**
	 * @param datas the datas to set
	 */
	public void setDatas(List<PriceIndexPicture> datas) {
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
	public PriceIndexPictureService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(PriceIndexPictureService service) {
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