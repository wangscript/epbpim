package com.ryxx.bpim.web.action.admin;

import java.util.List;

import com.ryxx.bpim.entity.Major;
import com.ryxx.bpim.entity.ProvinceCity;
import com.ryxx.bpim.service.MajorService;
import com.ryxx.bpim.service.ProvinceCityService;
import com.ryxx.bpim.web.action.ActionSupportBase;

public class ListProvinceAndMajorAction extends ActionSupportBase
{
    /** 序列号   */
    private static final long serialVersionUID = -8858603100856357832L;
    
    private ProvinceCityService provinceCityService;
    
    private MajorService majorService;
    
    private List<ProvinceCity> provinceCities;
    
    private List<Major> majors;
    
    private String msg;
    
    public String listProvinceAndMajor()
    {
        provinceCities = provinceCityService.list();
        majors = majorService.findAll();
        return SUCCESS;
    }
    
    
    /**
	 * @return the majors
	 */
	public List<Major> getMajors() {
		return majors;
	}


	/**
	 * @param majors the majors to set
	 */
	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}


	/**
	 * @return the majorService
	 */
	public MajorService getMajorService() {
		return majorService;
	}


	/**
	 * @param majorService the majorService to set
	 */
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}


	public ProvinceCityService getProvinceCityService()
    {
        return provinceCityService;
    }
    
    public void setProvinceCityService(ProvinceCityService provinceCityService)
    {
        this.provinceCityService = provinceCityService;
    }
    
    public List<ProvinceCity> getProvinceCities()
    {
        return provinceCities;
    }
    
    public void setProvinceCities(List<ProvinceCity> provinceCities)
    {
        this.provinceCities = provinceCities;
    }
    
    public String getMsg()
    {
        return msg;
    }
    
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}