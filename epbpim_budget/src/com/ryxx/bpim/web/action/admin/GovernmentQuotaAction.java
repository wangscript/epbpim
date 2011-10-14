package com.ryxx.bpim.web.action.admin;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ryxx.bpim.service.GovernmentQuotaRecordService;
import com.ryxx.bpim.service.GovernmentQuotaService;
import com.ryxx.bpim.service.GovernmentQuotaServiceImpl;
import com.ryxx.bpim.web.action.ActionSupportBase;

public class GovernmentQuotaAction extends ActionSupportBase {
	private static final long serialVersionUID = -1781372665512868821L;

	private static final Log LOG = LogFactory.getLog(GovernmentQuotaAction.class);
	private static String path = "WEB-INF/governmentQuota/";
	
	private GovernmentQuotaService governmentQuotaService;
	private GovernmentQuotaRecordService governmentQuotaRecordService;
	
	private String msg = "删除成功";

	private GovernmentQuotaService service = new GovernmentQuotaServiceImpl();

	public String deleteGovernmentQuota() {
		try {
			governmentQuotaService.delete();
			governmentQuotaRecordService.delete();
		} catch (SQLException e) {
			msg = "删除失败";
			LOG.error(e);
		}

		return SUCCESS;
	}

	public String importGovernmentQuota() {
		try {
			String folderPath = request.getSession().getServletContext().getRealPath(path);
			msg = service.importGovernmentQuota(folderPath);
		} catch (IOException e) {
			LOG.error(e);
			msg = "文件夹未找到";
		} catch (SQLException e) {
			LOG.error(e);
			msg = "数据库异常";
		}
		return SUCCESS;
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

}