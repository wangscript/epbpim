package com.ryxx.bpim.web.action.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.UserAdvice;
import com.ryxx.bpim.service.UserAdviceService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

/**
 * author Delgado
 */
public class UserAdviceAction extends ActionSupportBase
{
    /**
     * 
     */
    private static final long serialVersionUID = -251531175570040393L;
    
    UserAdvice condition = new UserAdvice();
    
    List<UserAdvice> datas = new ArrayList<UserAdvice>();
    
    private PageTools page;
    
    private UserAdvice userAdvice;
    
    private String msg = "提交成功，感谢您的参与！";
    
    private UserAdviceService service;
    
    public String searchUserAdvice()
    {
        try
        {
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
            PageTools page = new PageTools(pageNo, pageSize);
            condition.setRowCount(pageNo);
            condition.setPageSize(pageSize);
            datas = service.searchUserAdvice(condition, page);
            if (datas != null && datas.size() > 0)
            {
                this.page = page;
            }
            else
            {
                super.addNotFoundErrorMsg();
            }
        }
        catch (SQLException e)
        {
            LOG.error(e);
        }
        
        return SUCCESS;
    }
    
    public String addUserAdvice()
    {
        userAdvice.setUserID((Long)session.get(Constants.LOGIN_USER_ID));
        
        try
        {
            service.addUserAdvice(userAdvice);
        }
        catch (SQLException e)
        {
            msg = "数据库错误";
            LOG.error(e);
        }
        
        return SUCCESS;
    }
    
    /**
     * @return the condition
     */
    public UserAdvice getCondition()
    {
        return condition;
    }
    
    /**
     * @param condition
     *            the condition to set
     */
    public void setCondition(UserAdvice condition)
    {
        this.condition = condition;
    }
    
    public PageTools getPage()
    {
        return page;
    }
    
    public void setPage(PageTools page)
    {
        this.page = page;
    }
    
    public List<UserAdvice> getDatas()
    {
        return datas;
    }
    
    public void setDatas(List<UserAdvice> datas)
    {
        this.datas = datas;
    }
    
    public UserAdvice getUserAdvice()
    {
        return userAdvice;
    }
    
    public void setUserAdvice(UserAdvice userAdvice)
    {
        this.userAdvice = userAdvice;
    }
    
    public String getMsg()
    {
        return msg;
    }
    
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    
    public UserAdviceService getService()
    {
        return service;
    }
    
    public void setService(UserAdviceService service)
    {
        this.service = service;
    }
}
