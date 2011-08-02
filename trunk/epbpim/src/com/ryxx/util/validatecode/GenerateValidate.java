package com.ryxx.util.validatecode;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GenerateValidate {
	public GenerateValidate(HttpServletRequest request) {
		try {
			m_request = request;
			m_session = m_request.getSession(true);
			// m_request.setCharacterEncoding(APP_CONSTANT.ENCODING_TYPE); //
		} catch (Exception ex) {
		}
		m_strValidate = new String("");
	}

	public void genValidate() {
		GenerateCode objGenerateCode = new GenerateCode(4);

		m_strToken = objGenerateCode.getToken();
		m_strValidate = objGenerateCode.getCode();
		m_session.setAttribute(m_strToken, String.valueOf(m_strValidate));// å†™å…¥ä¼šè¯�
	}

	public String getValidateValue() {
		return m_strValidate;
	}

	public String getValidateForm() {
		String str = new String();
		str = "<input type=\"hidden\" name=\"__token\" value=\"";
		str += m_strToken;
		str += "\">";
		str += "<input type=\"text\" name=\"__num\" size=\"10\">";

		return str;
	}

	/**
	 * ç”Ÿæˆ�éªŒè¯�çš„å›¾ç‰‡
	 * 
	 * @param token
	 *            String å†™å…¥ä¼šè¯�çš„sessionå��ç§°ä¸º CheckValidate.checkImage()æ–¹æ³•éªŒè¯�
	 */
	public void genValidateImage(String token) {
		GenerateCode objGenerateCode = new GenerateCode(4);
		m_strValidate = objGenerateCode.getCode();
		m_session.setAttribute(token, m_strValidate);// å†™å…¥ä¼šè¯�
	}

	/**
	 * å�–å›¾ç‰‡è¯·ç”¨æ­¤æ–¹æ³•
	 * 
	 * @return BufferedImage
	 */
	public BufferedImage getValidateImage() {
		GenerateImage objImage = new GenerateImage();
		return objImage.creatImage(m_strValidate);// ç”Ÿæˆ�å›¾ç‰‡,2004-10-15
	}

	private HttpServletRequest m_request = null;

	private HttpSession m_session = null;

	private String m_strValidate;

	private String m_strToken;

}
