package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.entity.GovernmentInventory;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public class GovernmentInventoryDAOImpl implements GovernmentInventoryDAO
{
    
    String queryGovernmentInventory = "SELECT * FROM GOVERNMENT_INVENTORY_2003 WHERE 1=1";
    
    String countQueryGovernmentQuota = "SELECT count(*) FROM GOVERNMENT_INVENTORY_2003 WHERE 1=1";
    
    int i = 1;
    
    public List<GovernmentInventory> searchGovernmentInventory(SearchDataCondition condition)
        throws SQLException
    {
        
        String sql = getQuerySql(queryGovernmentInventory, condition);
        sql = sql + " ORDER BY PROJECT_NUM LIMIT ?,?";
        PreparedStatement stat = DBConnUtil.getPrepareStatement(sql);
        setConditionValue(stat, condition);
        stat.setInt(i, condition.getStartRow());
        stat.setInt(i + 1, condition.getPageSize());
        ResultSet result = stat.executeQuery();
        List<GovernmentInventory> datas = new ArrayList<GovernmentInventory>();
        while (result.next())
        {
            GovernmentInventory data = new GovernmentInventory();
            data.setId(result.getLong("ID"));
            data.setProjectClassName(result.getString("PROJECT_CLASS_NAME"));
            data.setProjectClassNum(result.getString("PROJECT_CLASS_NUM"));
            data.setProjectNum(result.getString("PROJECT_NUM"));
            data.setProjectName(result.getString("PROJECT_NAME"));
            data.setProjectNameFeature(result.getString("PROJECT_NAME_FEATURE"));
            data.setUnit(result.getString("UNIT"));
            data.setAmount(result.getDouble("AMOUNT"));
            data.setDetail(result.getString("DETAIL"));
            data.setComments(result.getString("COMMENTS"));
            
            datas.add(data);
        }
        return datas;
    }
    
    public int countSearchGovernmentInventory(SearchDataCondition condition)
        throws SQLException
    {
        String sql = getQuerySql(countQueryGovernmentQuota, condition);
        PreparedStatement stat = DBConnUtil.getPrepareStatement(sql);
        setConditionValue(stat, condition);
        ResultSet result = stat.executeQuery();
        int value = 0;
        if (result.next())
        {
            value = result.getInt(1);
        }
        return value;
    }
    
    private String getQuerySql(String sql, SearchDataCondition condition)
    {
        StringBuilder sqlSb = new StringBuilder(sql);
        if (null != condition.getProjectClassNum() && !"".equals(condition.getProjectClassNum()))
        {
            sqlSb.append(" AND PROJECT_CLASS_NUM = ?");
        }
        if (null != condition.getProjectNum() && !"".equals(condition.getProjectNum()))
        {
            sqlSb.append(" AND PROJECT_NUM = ?");
        }
        if (null != condition.getProjectName() && !"".equals(condition.getProjectName()))
        {
            sqlSb.append(" AND PROJECT_NAME like ?");
        }
        return sqlSb.toString();
    }
    
    private void setConditionValue(PreparedStatement stat, SearchDataCondition condition)
        throws SQLException
    {
        i = 1;
        if (null != condition.getProjectClassNum() && !"".equals(condition.getProjectClassNum()))
        {
            stat.setString(i, condition.getProjectClassNum());
            i++;
        }
        if (null != condition.getProjectNum() && !"".equals(condition.getProjectNum()))
        {
            stat.setString(i, condition.getProjectNum());
            i++;
        }
        if (null != condition.getProjectName() && !"".equals(condition.getProjectName()))
        {
            stat.setString(i, "%" + condition.getProjectName() + "%");
            i++;
        }
    }
    
}
