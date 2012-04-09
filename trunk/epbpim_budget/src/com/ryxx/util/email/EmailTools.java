package com.ryxx.util.email;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.bpim.entity.UserMenuReg;

public class EmailTools
{
    private static Logger logger = Logger.getLogger(EmailTools.class);
    
    public static void send(List<String> emailAddress, String title, String content)
        throws EmailException
    {
        SimpleEmail email = new SimpleEmail();
        email.setTLS(true);
        email.setHostName(Constants.SMTP);
        email.setAuthentication(Constants.MAIL_USER_NAME, Constants.MAIL_PASSWORD);
        try
        {
            for (String address : emailAddress)
            {
                email.addTo(address);
            }
            email.setFrom(Constants.MAIL_DISPLAY_NAME); // 我方
            email.setSubject(title); // 标题
            email.setCharset(Constants.MAIL_CHAR_SET); // 设置Charset
            email.setContent(content, "text/html"); // 内容
            email.send();
        }
        catch (EmailException e)
        {
            logger.error(e);
            String emailAddresses = "";
            for (String address : emailAddress)
            {
                emailAddresses = emailAddresses + " " + address;
            }
            throw new EmailException("send email fail, please send it by manual. The email address is "
                + emailAddresses + "/n" + "email subject is " + title + "/n" + "content is " + content + "/n");
        }
    }
    
    /**
     * @param userInfo
     * @return
     */
    public static String generateEnterPriseUserContent(UserInfo userInfo)
    {
        StringBuilder sb =
            new StringBuilder(Constants.EMAIL_ENTERPRISE_TITLE1 + userInfo.getEnterpriseInfo().getName() + "," + "<br>"
                + Constants.EMAIL_ENTERPRISE_TITLE2 + "<br>");
        sb.append("<table style='background:grey; text-align:center;border: 1px solid #c0c0c0;'><tr> <td style='width:100px; border: 1px solid #c0c0c0;'>"
            + Constants.EMAIL_USERNAME_BLOCK
            + " </td><td style='width:100px; border: 1px solid #c0c0c0;'> "
            + Constants.EMAIL_PASSWORD_BLOCK
            + " </td><td style='width:100px; border: 1px solid #c0c0c0;'> "
            + Constants.EMAIL_PRIVILEGE_BLOCK + "</td>");
        sb.append("<tr>");
        sb.append("<td style='border: 1px solid #c0c0c0;'>" + userInfo.getIdentifier() + "</td>");
        sb.append("<td style='border: 1px solid #c0c0c0;'>" + userInfo.getPasswordDecode() + "</td>");
        sb.append("<td style='border: 1px solid #c0c0c0;'>" + userInfo.getRoleType().getValue() + "</td>");
        sb.append("</tr>");
        sb.append("</table>");
        sb.append(Constants.EMAIL_FOOTER);
        return sb.toString();
    }
    
    /**
     * @param users
     * @return
     */
    public static String generateBatchUserContent(List<UserInfo> users)
    {
        StringBuilder sb =
            new StringBuilder(Constants.EMAIL_ENTERPRISE_TITLE1 + users.get(0).getEnterpriseInfo().getName() + ","
                + "<br>" + Constants.EMAIL_ENTERPRISE_TITLE2 + "<br>");
        sb.append("<table style='background:grey; text-align:center;border: 1px solid #c0c0c0;'><tr> <td style='width:100px; border: 1px solid #c0c0c0;'>"
            + Constants.EMAIL_USERNAME_BLOCK
            + " </td><td style='width:100px; border: 1px solid #c0c0c0;'> "
            + Constants.EMAIL_PASSWORD_BLOCK
            + " </td><td style='width:100px; border: 1px solid #c0c0c0;'> "
            + Constants.EMAIL_PRIVILEGE_BLOCK
            + "</td>"
            + " </td><td style='width:400px;border: 1px solid #c0c0c0;'> "
            + Constants.EMAIL_APP_BLOCK + "</td>");
        for (UserInfo userInfo : users)
        {
            sb.append("<tr>");
            sb.append("<td style='border: 1px solid #c0c0c0;'>" + userInfo.getIdentifier() + "</td>");
            sb.append("<td style='border: 1px solid #c0c0c0;'>" + userInfo.getPasswordDecode() + "</td>");
            sb.append("<td style='border: 1px solid #c0c0c0;'>" + userInfo.getRoleType().getValue() + "</td>");
            sb.append("<td style='border: 1px solid #c0c0c0;'>");
            for (UserMenuReg userMenuReg : userInfo.getMenus())
            {
                sb.append(userMenuReg.getAdminMenu().getTitle() + "&nbsp;&nbsp;&nbsp;");
            }
            sb.append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append(Constants.EMAIL_FOOTER);
        return sb.toString();
    }
    
    /**
     * @param newPassword
     * @param newPassword2
     * @return
     */
    public static String generateFindPasswordContent(String realName, String newPassword)
    {
        StringBuilder sb =
            new StringBuilder(Constants.EMAIL_NORMAI_USER_TITLE1 + realName + "," + "<br>"
                + Constants.EMAIL_FIND_PASSWORD + "<br>");
        sb.append("<label style='background:grey;'>" + newPassword + "</lable>");
        sb.append("<br>" + "请使用新密码登陆平台，感谢您对本平台的支持");
        sb.append(Constants.EMAIL_FOOTER);
        return sb.toString();
    }
}
