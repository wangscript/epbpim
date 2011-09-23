package com.ryxx.util.email;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.AdminMenu;
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
		sb.append("<table style='background:grey; text-align:center;border: 1px solid #c0c0c0;'><tr> <td style='width:100px; style='border: 1px solid #c0c0c0;''>"
				+ Constants.EMAIL_USERNAME_BLOCK
				+ " </td><td style='width:100px; style='border: 1px solid #c0c0c0;''> "
				+ Constants.EMAIL_PASSWORD_BLOCK
				+ " </td><td style='width:100px; style='border: 1px solid #c0c0c0;''> "
				+ Constants.EMAIL_PRIVILEGE_BLOCK + "</td>");
		sb.append("<tr>");
		sb.append("<td style='border: 1px solid #c0c0c0;'>"
				+ userInfo.getIdentifier() + "</td>");
		sb.append("<td style='border: 1px solid #c0c0c0;'>"
				+ Constants.DEFAULT_PASSWORD + "</td>");
		sb.append("<td style='border: 1px solid #c0c0c0;'>"
				+ userInfo.getRoleType().getValue() + "</td>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append(Constants.EMAIL_FOOTER);
		return sb.toString();
	}

	/**
	 * @param users
	 * @return
	 */
	public static String generateBatchUserContent(List<UserInfo> users) {
		StringBuilder sb = new StringBuilder(Constants.EMAIL_ENTERPRISE_TITLE1
				+ users.get(0).getEnterpriseInfo().getName() + "," + "<br>"
				+ Constants.EMAIL_ENTERPRISE_TITLE2 + "<br>");
		sb.append("<table style='background:grey; text-align:center;border: 1px solid #c0c0c0;'><tr> <td style='width:100px; style='border: 1px solid #c0c0c0;''>"
				+ Constants.EMAIL_USERNAME_BLOCK
				+ " </td><td style='width:100px; style='border: 1px solid #c0c0c0;''> "
				+ Constants.EMAIL_PASSWORD_BLOCK
				+ " </td><td style='width:100px; style='border: 1px solid #c0c0c0;''> "
				+ Constants.EMAIL_PRIVILEGE_BLOCK
				+ "</td>"
				+ " </td><td style='width:400px; style='border: 1px solid #c0c0c0;''> "
				+ Constants.EMAIL_APP_BLOCK + "</td>");
		for (UserInfo userInfo : users) {
			sb.append("<tr>");
			sb.append("<td style='border: 1px solid #c0c0c0;'>"
					+ userInfo.getIdentifier() + "</td>");
			sb.append("<td style='border: 1px solid #c0c0c0;'>"
					+ Constants.DEFAULT_PASSWORD + "</td>");
			sb.append("<td style='border: 1px solid #c0c0c0;'>"
					+ userInfo.getRoleType().getValue() + "</td>");
			sb.append("<td style='border: 1px solid #c0c0c0;'>");
			for (AdminMenu menu : userInfo.getMenus()) {
				sb.append(menu.getName());
			}
			sb.append("</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
		sb.append(Constants.EMAIL_FOOTER);
		return sb.toString();
	}
}
