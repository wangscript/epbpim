package com.ryxx.util.email;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.UserInfo;

public class EmailTools {
	public static void send(List<String> emailAddress, String title,
			String content) {
		SimpleEmail email = new SimpleEmail();
		email.setTLS(true);
		email.setHostName(Constants.SMTP);
		email.setAuthentication(Constants.MAIL_USER_NAME,
				Constants.MAIL_PASSWORD);
		try {
			for (String address : emailAddress) {
				email.addTo(address);
			}
			email.setFrom(Constants.MAIL_DISPLAY_NAME); // 我方
			email.setSubject(title); // 标题
			email.setCharset(Constants.MAIL_CHAR_SET); // 设置Charset
			email.setContent(content, "text/html"); // 内容
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param userInfo
	 * @return
	 */
	public static String generateEnterPriseUserContent(UserInfo userInfo) {
		StringBuilder sb = new StringBuilder(Constants.EMAIL_ENTERPRISE_TITLE1
				+ userInfo.getEnterpriseInfo().getName() + "," + "<br>"
				+ Constants.EMAIL_ENTERPRISE_TITLE2 + "<br>");
		sb.append("&nbsp;&nbsp;" + Constants.EMAIL_USERNAME_BLOCK
				+ userInfo.getIdentifier() + "<br>");
		sb.append("&nbsp;&nbsp;" + Constants.EMAIL_PASSWORD_BLOCK
				+ Constants.DEFAULT_PASSWORD + "<br>");
		sb.append("&nbsp;&nbsp;" + Constants.EMAIL_PRIVILEGE_BLOCK
				+ userInfo.getRoleType().getValue() + "<br>");
		sb.append(Constants.EMAIL_FOOTER);
		return sb.toString();
	}
}
