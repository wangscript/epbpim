package com.bpim.web.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bpim.common.Constants;
import com.bpim.web.action.LoginAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SameUserLoginInterceptor implements Interceptor
{
    
    private static final long serialVersionUID = -5212074066634437086L;
    
    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
     */
    public void destroy()
    {
        // TODO Auto-generated method stub
        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
     */
    public void init()
    {
        // TODO Auto-generated method stub
        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony
     * .xwork2.ActionInvocation)
     */
    public String intercept(ActionInvocation arg0)
        throws Exception
    {
        Map session = arg0.getInvocationContext().getSession();
        String currentUserid = String.valueOf((Long)session.get(Constants.LOGIN_USER_ID));
        long currentUserLoginTime = (Long)session.get(Constants.USER_LOGIN_TIME);
        List userSessionList = LoginAction.userSessionMap.get(currentUserid);
        if (null != userSessionList && 1 < userSessionList.size())
        {
            
            boolean sameUserLoginFlag = false;
            List invalidSessionList = new ArrayList();
            for (Object obj : userSessionList)
            {
                Map userSession = (Map)obj;
                
                long userLoginTime = 0;
                // 如果session无效,则会抛出异常,此时将session从用户列表中移除
                try
                {
                    userLoginTime = (Long)userSession.get(Constants.USER_LOGIN_TIME);
                }
                catch (Exception e)
                {
                    invalidSessionList.add(obj);
                    continue;
                }
                
                if (currentUserLoginTime < userLoginTime)
                {
                    sameUserLoginFlag = true;
                    break;
                }
            }
            userSessionList.removeAll(invalidSessionList);
            
            if (sameUserLoginFlag)
            {
                return "sameuserlogin";
            }
        }
        
        return arg0.invoke();
    }
}
