package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.ProvinceCityDAO;
import com.ryxx.bpim.entity.ProvinceCity;

public interface ProvinceCityService extends BaseService<ProvinceCity,ProvinceCityDAO, Integer> {
	public List<ProvinceCity> list();
}
