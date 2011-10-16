package com.ryxx.bpim.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.dao.GovernmentQuotaDAO;
import com.ryxx.bpim.entity.GovernmentQuota;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public interface GovernmentQuotaService extends BaseService<GovernmentQuota, GovernmentQuotaDAO, Long>
{
	void delete() throws SQLException;

	GovernmentQuota getQuotaById(Long id) throws SQLException;
	
	public List<GovernmentQuota> listPage(GovernmentQuota governmentQuota, PageTools page);
	
	public String saveGovernmentQuota(String folderPath) throws IOException, SQLException;
}

