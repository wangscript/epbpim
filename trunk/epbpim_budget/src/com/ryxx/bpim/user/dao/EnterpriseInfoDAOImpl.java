package com.ryxx.bpim.user.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.dao.AbstractBaseDAO;
import com.ryxx.bpim.user.entity.EnterpriseInfo;

public class EnterpriseInfoDAOImpl extends AbstractBaseDAO<EnterpriseInfo, Long> implements EnterpriseInfoDAO{
	public List<EnterpriseInfo> list() {
		Criterion criterion = Restrictions.eq("enable", 1);
		return findByCriteria(criterion);
	}
}