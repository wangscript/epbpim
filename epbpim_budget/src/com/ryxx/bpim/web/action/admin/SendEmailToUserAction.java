/**
 * 
 */
package com.ryxx.bpim.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.EmailException;

import com.ryxx.bpim.service.UserInfoService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.email.EmailTools;

/**
 * @author Delgado Ding
 * 
 */
public class SendEmailToUserAction extends ActionSupportBase {
	private static final long serialVersionUID = -5620230655376038210L;

	private static final Log LOG = LogFactory
			.getLog(SendEmailToUserAction.class);
	private String mailBody;
	private String msg;
	private String testMailAddress;
	private String mailTitle;
	private UserInfoService userInfoService;

	public String sendEmailToUser() {
		if (!StringUtils.isEmpty(mailBody) && !StringUtils.isEmpty(mailTitle)) {
			msg = "true";
			EmailTools emailTools = new EmailTools();
			List<String> addressList = new ArrayList();
			try {
				if (!StringUtils.isEmpty(testMailAddress)) {
					addressList.add(testMailAddress);
				} else {
					addressList = userInfoService.getAllUserEmails();
				}
				emailTools.send(addressList, mailTitle, mailBody);
			} catch (EmailException e) {
				LOG.equals(e);
				msg = "false";
			}
		}
		return SUCCESS;
	}

	/**
	 * @return the mailBody
	 */
	public String getMailBody() {
		return mailBody;
	}

	/**
	 * @param mailBody
	 *            the mailBody to set
	 */
	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}



	/**
	 * @return the userInfoService
	 */
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	/**
	 * @param userInfoService the userInfoService to set
	 */
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the testMailAddress
	 */
	public String getTestMailAddress() {
		return testMailAddress;
	}

	/**
	 * @param testMailAddress
	 *            the testMailAddress to set
	 */
	public void setTestMailAddress(String testMailAddress) {
		this.testMailAddress = testMailAddress;
	}

	/**
	 * @return the mailTitle
	 */
	public String getMailTitle() {
		return mailTitle;
	}

	/**
	 * @param mailTitle
	 *            the mailTitle to set
	 */
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}

}
