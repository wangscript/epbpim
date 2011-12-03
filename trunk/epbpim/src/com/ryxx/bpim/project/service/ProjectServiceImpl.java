package com.ryxx.bpim.project.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ryxx.bpim.project.dao.ProjectDAO;
import com.ryxx.bpim.project.entity.ProjectInfo;
import com.ryxx.bpim.service.AbstractService;
import com.ryxx.util.page.PageTools;

public class ProjectServiceImpl extends AbstractService<ProjectInfo, ProjectDAO, Long> implements ProjectService
{
    
    @Override
    public void saveProjectInfo(ProjectInfo projectInfo)
    {
        transDatePage(projectInfo);
        getDao().saveProjectInfo(projectInfo);
    }
    
    @Override
    public void updateProjectInfo(ProjectInfo projectInfo)
    {
        transDatePage(projectInfo);
        getDao().updateProjectInfo(projectInfo);
    }
    
    @Override
    public void deleteProjectInfo(ProjectInfo projectInfo)
    {
        getDao().deleteProjectInfo(projectInfo);
    }
    
    @Override
    public ProjectInfo findProjectInfo(ProjectInfo projectInfo)
    {
        return getDao().findProjectInfo(projectInfo);
    }
    
    @Override
    public List<ProjectInfo> listProjectInfo(ProjectInfo projectInfo, PageTools page)
    {
        if (page != null)
        {
            if (page.getRecordCount() == 0)
            {
                int count = getDao().getRowCount(projectInfo);
                page.setRecordCount(count);
            }
            projectInfo.setStartRow(page.getPageStartRow());
            projectInfo.setPageSize(page.getPageSize());
        }
        return getDao().listProjectInfo(projectInfo);
    }
    
    private void transDatePage(ProjectInfo projectInfo)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date startDate = sdf.parse(projectInfo.getStartDatePage());
            projectInfo.setStartDate(new Timestamp(startDate.getTime()));
            
            Date reportDate = sdf.parse(projectInfo.getReportDatePage());
            projectInfo.setReportDate(new Timestamp(reportDate.getTime()));
            
            Date achiveDate = sdf.parse(projectInfo.getAchiveDatePage());
            projectInfo.setAchiveDate(new Timestamp(achiveDate.getTime()));
            
            Date invoiceDate = sdf.parse(projectInfo.getInvoiceDatePage());
            projectInfo.setInvoiceDate(new Timestamp(invoiceDate.getTime()));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        
    }
    
}