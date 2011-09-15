package com.ryxx.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.dao.UserAdviceDAO;
import com.ryxx.bpim.entity.UserAdvice;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public interface UserAdviceService extends BaseService<UserAdvice, UserAdviceDAO, Long>
{
    List<UserAdvice> listUserAdvice(UserAdvice condition, PageTools page)
        throws SQLException;
    
    void saveUserAdvice(UserAdvice userAdvice)
        throws SQLException;
}
