package com.ryxx.bpim.web.action.mainPanel;

import java.util.List;

import org.jfree.util.Log;

import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.QuestionAnswer;
import com.ryxx.bpim.entity.UserInfo;
import com.ryxx.bpim.service.QuestionAnswerService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

/**
 * author Delgado
 */
public class QuestionAnswerAction extends ActionSupportBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -251531175570040393L;

	private QuestionAnswer questionAnswer;
	private QuestionAnswerService questionAnswerService;
	private List<QuestionAnswer> datas;
	private PageTools page;

	public PageTools getPage() {
		return page;
	}

	public void setPage(PageTools page) {
		this.page = page;
	}

	public String listQA() {
		try {
			int pageNo = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_NO, 1);
			int pageSize = ParamTools.getIntParameter(request,
					Constants.PARA_PAGE_SIZE, 0);
			PageTools page = new PageTools(pageNo, pageSize);
			if (questionAnswer == null) {
				questionAnswer = new QuestionAnswer();
			}
			questionAnswer.setRowCount(pageNo);
			questionAnswer.setPageSize(pageSize);
			if ("1".equals(questionAnswer.getType())) {
				UserInfo user = new UserInfo();
				user.setId(Long.valueOf(session.get(Constants.LOGIN_USER_ID)
						.toString()));
				questionAnswer.setQuestionUser(user);
			}

			datas = questionAnswerService.listQA(questionAnswer, page);
			if (datas != null && datas.size() > 0) {
				this.page = page;
			} else {
				super.addNotFoundErrorMsg();
			}
		} catch (Exception e) {
			Log.error(e);
		}
		return SUCCESS;
	}

	public String addQA() {
		try {
			UserInfo user = new UserInfo();
			user.setId(Long.valueOf(session.get(Constants.LOGIN_USER_ID)
					.toString()));
			questionAnswer.setQuestionUser(user);
			questionAnswerService.save(questionAnswer);
		} catch (Exception e) {
			Log.error(e);
		}
		return SUCCESS;
	}

	public String viewQA() {
		try {
			questionAnswer = questionAnswerService.findById(questionAnswer
					.getId());
		} catch (Exception e) {
			Log.error(e);
		}
		return SUCCESS;
	}

	public String delQA() {
		try {
			questionAnswerService.delete(questionAnswer.getId());
		} catch (Exception e) {
			Log.error(e);
		}
		return SUCCESS;
	}

	public String updateQA() {
		try {
			UserInfo user = new UserInfo();
			user.setId(Long.valueOf(session.get(Constants.LOGIN_USER_ID)
					.toString()));
			questionAnswer.setAnswerUser(user);
			questionAnswerService.merge(questionAnswer);
		} catch (Exception e) {
			Log.error(e);
		}
		return SUCCESS;
	}

	/**
	 * @return the questionAnswer
	 */
	public QuestionAnswer getQuestionAnswer() {
		return questionAnswer;
	}

	/**
	 * @param questionAnswer
	 *            the questionAnswer to set
	 */
	public void setQuestionAnswer(QuestionAnswer questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	/**
	 * @return the questionAnswerService
	 */
	public QuestionAnswerService getQuestionAnswerService() {
		return questionAnswerService;
	}

	/**
	 * @param questionAnswerService
	 *            the questionAnswerService to set
	 */
	public void setQuestionAnswerService(
			QuestionAnswerService questionAnswerService) {
		this.questionAnswerService = questionAnswerService;
	}

	/**
	 * @return the datas
	 */
	public List<QuestionAnswer> getDatas() {
		return datas;
	}

	/**
	 * @param datas
	 *            the datas to set
	 */
	public void setDatas(List<QuestionAnswer> datas) {
		this.datas = datas;
	}

}
