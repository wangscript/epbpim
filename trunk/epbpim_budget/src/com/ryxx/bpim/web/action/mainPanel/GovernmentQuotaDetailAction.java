package com.ryxx.bpim.web.action.mainPanel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ryxx.bpim.entity.GovernmentQuota;
import com.ryxx.bpim.entity.GovernmentQuotaRecord;
import com.ryxx.bpim.service.GovernmentQuotaRecordService;
import com.ryxx.bpim.service.GovernmentQuotaRecordServiceImpl;
import com.ryxx.bpim.service.GovernmentQuotaService;
import com.ryxx.bpim.service.GovernmentQuotaServiceImpl;
import com.ryxx.bpim.web.action.ActionSupportBase;

/**
 * author Delgado
 */
public class GovernmentQuotaDetailAction extends ActionSupportBase {

	private static final long serialVersionUID = 6638298297294518090L;
	private GovernmentQuotaService governmentQuotaService;
	private GovernmentQuotaRecordService governmentQuotaRecordService;
	List<GovernmentQuotaRecord> datas = new ArrayList<GovernmentQuotaRecord>();
	GovernmentQuota quota = new GovernmentQuota();

	public String listGovernmentQuotaDetail() {
		try {
			String id = request.getParameter("id");
			datas = governmentQuotaRecordService.listGovernmentQuotaDetail(Long.valueOf(id));
			quota = governmentQuotaService.getQuotaById(Long.valueOf(id));
		} catch (SQLException e) {
			LOG.error(e);
		}
		return SUCCESS;
	}

	/**
	 * @return the datas
	 */
	public List<GovernmentQuotaRecord> getDatas() {
		return datas;
	}

	/**
	 * @param datas the datas to set
	 */
	public void setDatas(List<GovernmentQuotaRecord> datas) {
		this.datas = datas;
	}

	/**
	 * @return the quota
	 */
	public GovernmentQuota getQuota() {
		return quota;
	}

	/**
	 * @param quota the quota to set
	 */
	public void setQuota(GovernmentQuota quota) {
		this.quota = quota;
	}

	public GovernmentQuotaService getGovernmentQuotaService() {
		return governmentQuotaService;
	}

	public void setGovernmentQuotaService(
			GovernmentQuotaService governmentQuotaService) {
		this.governmentQuotaService = governmentQuotaService;
	}

	public GovernmentQuotaRecordService getGovernmentQuotaRecordService() {
		return governmentQuotaRecordService;
	}

	public void setGovernmentQuotaRecordService(
			GovernmentQuotaRecordService governmentQuotaRecordService) {
		this.governmentQuotaRecordService = governmentQuotaRecordService;
	}
}
