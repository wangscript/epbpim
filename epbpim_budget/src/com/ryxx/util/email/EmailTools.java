package com.ryxx.util.email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.ryxx.bpim.common.Constants;

public class EmailTools {
	public static void send(String emailAddress, String title, String content) {
		SimpleEmail email = new SimpleEmail();
		email.setTLS(true);
		email.setHostName(Constants.SMTP);
		email.setAuthentication(Constants.MAIL_USER_NAME,
				Constants.MAIL_PASSWORD);
		try {
			email.addTo(emailAddress);
			email.setFrom(Constants.MAIL_DISPLAY_NAME); // 我方
			email.setSubject(title); // 标题
			email.setCharset(Constants.MAIL_CHAR_SET); // 设置Charset
			email.setMsg(content); // 内容
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
