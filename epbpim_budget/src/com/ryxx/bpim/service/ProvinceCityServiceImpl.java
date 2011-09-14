package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.ProvinceCityDAO;
import com.ryxx.bpim.entity.ProvinceCity;

public class ProvinceCityServiceImpl  extends AbstractService<ProvinceCity,ProvinceCityDAO, Long> implements ProvinceCityService{
	@Override
	public List<ProvinceCity> list() {
		return getDao().list();
	}
}