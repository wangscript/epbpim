package com.ryxx.bpim.service;

import java.sql.SQLException;
import java.util.List;

import com.ryxx.bpim.dao.UserAdviceDAO;
import com.ryxx.bpim.entity.UserAdvice;
import com.ryxx.bpim.helper.PageTools;

/**
 * author Delgado
 */
public interface UserAdviceService extends BaseService<UserAdvice, UserAdviceDAO, Long>
{
    List<UserAdvice> searchUserAdvice(UserAdvice condition, PageTools page)
        throws SQLException;
    
    void addUserAdvice(UserAdvice userAdvice)
        throws SQLException;
}
