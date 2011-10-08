package com.ryxx.bpim.web.action.admin;

import java.util.List;

import com.ryxx.bpim.entity.ProvinceCity;
import com.ryxx.bpim.service.ProvinceCityService;
import com.ryxx.bpim.web.action.ActionSupportBase;

public class ListProvinceAction extends ActionSupportBase
{
    /** 序列号   */
    private static final long serialVersionUID = -8858603100856357832L;
    
    private ProvinceCityService provinceCityService;
    
    private List<ProvinceCity> provinceCities;
    
    private String msg;
    
    public String listProvince()
    {
        provinceCities = provinceCityService.list();
        return SUCCESS;
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