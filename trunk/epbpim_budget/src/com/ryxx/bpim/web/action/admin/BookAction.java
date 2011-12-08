package com.ryxx.bpim.web.action.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.Book;
import com.ryxx.bpim.entity.ProvinceCity;
import com.ryxx.bpim.service.BookService;
import com.ryxx.bpim.service.ProvinceCityService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.io.FileUtil;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class BookAction extends ActionSupportBase {
	private static final long serialVersionUID = -1781372665512868821L;

	private static final Log LOG = LogFactory.getLog(BookAction.class);

	private Book book;

	private List<Book> datas = new ArrayList<Book>();

	private File uploadFile;

	private String msg = "";

	private PageTools page;

	private BookService service;
	
	private ProvinceCityService provinceCityService;

	private String bookFileUrl;
	
	private List<ProvinceCity> provinceCities;

	public String uploadBook() {
		String fileName = new Date().getTime() + ".swf";
		File newUploadFile = null;
		try {
			msg = "true";
			String uploadRealPath = request.getRealPath("/") + "book" + "/";
			File uploadDir = new File(uploadRealPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}

			if (uploadFile != null) {
				newUploadFile = new File(uploadRealPath + fileName);
				FileUtil.copy(uploadFile, newUploadFile, false);
			}

			book.setBookRealName(book.getBookRealName().substring(0,
					book.getBookRealName().indexOf(".")));
			book.setFileName(fileName);
			service.save(book);

		} catch (Exception e) {
			if (newUploadFile != null && newUploadFile.exists()) {
				newUploadFile.delete();
			}
			LOG.error(e);
			msg = "false";
		}
		return SUCCESS;
	}

	public String searchBook() {
		try {
			if (book == null) {
				book = new Book();
				ProvinceCity proviceCity = new ProvinceCity();
				proviceCity.setId((long) 3);
				book.setProvinceCity(proviceCity);
			}
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			book.setRowCount(pageNo);
			book.setPageSize(pageSize);
			datas = service.listBooks(book, page);
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

	public String viewBook() {
		String bookFileName = request.getParameter("bookFileName");
		bookFileUrl = "../book/" + bookFileName;
		return SUCCESS;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book
	 *            the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @return the uploadFile
	 */
	public File getUploadFile() {
		return uploadFile;
	}

	/**
	 * @param uploadFile
	 *            the uploadFile to set
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
	 * @param msg
	 *            the msg to set
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
	 * @param page
	 *            the page to set
	 */
	public void setPage(PageTools page) {
		this.page = page;
	}

	/**
	 * @return the service
	 */
	public BookService getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(BookService service) {
		this.service = service;
	}

	/**
	 * @return the datas
	 */
	public List<Book> getDatas() {
		return datas;
	}

	/**
	 * @param datas the datas to set
	 */
	public void setDatas(List<Book> datas) {
		this.datas = datas;
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
	 * @return the bookFileUrl
	 */
	public String getBookFileUrl() {
		return bookFileUrl;
	}

	/**
	 * @param bookFileUrl the bookFileUrl to set
	 */
	public void setBookFileUrl(String bookFileUrl) {
		this.bookFileUrl = bookFileUrl;
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