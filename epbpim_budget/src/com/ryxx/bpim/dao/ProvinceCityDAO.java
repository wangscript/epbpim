package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.ProvinceCity;

public interface ProvinceCityDAO extends BaseDAO<ProvinceCity, Long> {
	public List<ProvinceCity> list();
}
