package com.ryxx.bpim.web.action.mainPanel;

import java.util.ArrayList;
import java.util.List;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.GovernmentQuota;
import com.ryxx.bpim.form.SearchDataCondition;
import com.ryxx.bpim.service.GovernmentQuotaService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

/**
 * author Delgado
 */
public class SearchGovernmentQuotaAction extends ActionSupportBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -251531175570040393L;
	SearchDataCondition condition = new SearchDataCondition();
	private GovernmentQuotaService governmentQuotaService;
	List<GovernmentQuota> datas = new ArrayList<GovernmentQuota>();
	private PageTools page;
	
	public PageTools getPage() {
		return page;
	}

	public void setPage(PageTools page) {
		this.page = page;
	}

	public String searchGovernmentQuota() {
		int pageNo = ParamTools.getIntParameter(request,
				Constants.PARA_PAGE_NO, 1);
		int pageSize = ParamTools.getIntParameter(request,
				Constants.PARA_PAGE_SIZE, 0);
		PageTools page = new PageTools(pageNo, pageSize);
		GovernmentQuota quota = new GovernmentQuota();
		quota.setArea(condition.getArea());
		quota.setGovernmentQuotaClass(condition.getQuotaClass());
		quota.setGovernmentQuotaNum(condition.getQuotaNum());
		quota.setGovernmentQuotaName(condition.getQuotaName());
		quota.setRowCount(pageNo);
		quota.setPageSize(pageSize);
		datas = governmentQuotaService.listPage(quota, page);
		if (datas != null && datas.size() > 0) {
			this.page = page;
		} else {
			super.addNotFoundErrorMsg();
			return SUCCESS;
		}
		return SUCCESS;
	}

	/**
	 * @return the condition
	 */
	public SearchDataCondition getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(SearchDataCondition condition) {
		this.condition = condition;
	}

	/**
	 * @return the datas
	 */
	public List<GovernmentQuota> getDatas() {
		return datas;
	}

	/**
	 * @param datas the datas to set
	 */
	public void setDatas(List<GovernmentQuota> datas) {
		this.datas = datas;
	}

	public GovernmentQuotaService getGovernmentQuotaService() {
		return governmentQuotaService;
	}

	public void setGovernmentQuotaService(
			GovernmentQuotaService governmentQuotaService) {
		this.governmentQuotaService = governmentQuotaService;
	}
}
