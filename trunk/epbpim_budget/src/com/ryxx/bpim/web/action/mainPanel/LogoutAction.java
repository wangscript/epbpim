package com.ryxx.bpim.web.action.mainPanel;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.web.action.ActionSupportBase;

public class LogoutAction extends ActionSupportBase
{
    /** 序列号 */
    private static final long serialVersionUID = -3207860126993596361L;
    
    public String execute()
        throws Exception
    {
        String userid = String.valueOf((Long)session.get(Constants.LOGIN_USER_ID));
        UserInfoAction.userSessionMap.remove(userid);
        
        session.remove(Constants.LOGIN_USER_NAME);
        session.remove(Constants.LOGIN_USER_ID);
        session.remove(Constants.LOGIN_EXPIRE_DATE);
        
        return SUCCESS;
    }
}
