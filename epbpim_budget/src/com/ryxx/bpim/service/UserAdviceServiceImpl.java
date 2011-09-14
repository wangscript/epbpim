package com.ryxx.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.dao.UserAdviceDAO;
import com.ryxx.bpim.dao.UserAdviceDAOImpl;
import com.ryxx.bpim.entity.UserAdvice;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public class UserAdviceServiceImpl extends AbstractService<UserAdvice, UserAdviceDAO, Long> implements
    UserAdviceService
{
    
    UserAdviceDAO dao = new UserAdviceDAOImpl();
    
    public List<UserAdvice> searchUserAdvice(UserAdvice condition, PageTools page)
        throws SQLException
    {
        if (page != null)
        {
            if (page.getRecordCount() == 0)
            {
                int count = getDao().getRowCount(condition);
                page.setRecordCount(count);
            }
            condition.setStartRow(page.getPageStartRow());
            condition.setPageSize(page.getPageSize());
        }
        return getDao().listUserAdvice(condition);
    }
    
    @Override
    public void addUserAdvice(UserAdvice userAdvice)
        throws SQLException
    {
        getDao().save(userAdvice);
    }
    
}
