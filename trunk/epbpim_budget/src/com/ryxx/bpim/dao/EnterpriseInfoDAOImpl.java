package com.ryxx.bpim.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.EnterpriseInfo;

public class EnterpriseInfoDAOImpl extends AbstractBaseDAO<EnterpriseInfo, Long> implements EnterpriseInfoDAO{
	public List<EnterpriseInfo> list() {
		Criterion criterion = Restrictions.eq("enable", 1);
		return findByCriteria(criterion);
	}
}