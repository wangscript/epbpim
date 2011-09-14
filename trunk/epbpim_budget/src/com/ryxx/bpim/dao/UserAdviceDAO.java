package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.NewsAnnouncement;
import com.ryxx.bpim.entity.UserAdvice;

/**
 * author Delgado
 */
public interface UserAdviceDAO extends BaseDAO<UserAdvice, Long>
{
    
    void saveUserAdvice(UserAdvice userAdvice);
    
    List<UserAdvice> listUserAdvice(UserAdvice userAdvice);
    
    int getRowCount(UserAdvice userAdvice);
    
}
