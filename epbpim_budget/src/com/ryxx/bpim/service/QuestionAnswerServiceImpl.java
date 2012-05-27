package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.QuestionAnswerDAO;
import com.ryxx.bpim.entity.Book;
import com.ryxx.bpim.entity.QuestionAnswer;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public class QuestionAnswerServiceImpl extends AbstractService<QuestionAnswer, QuestionAnswerDAO, Long> implements QuestionAnswerService
{


	/* (non-Javadoc)
	 * @see com.ryxx.bpim.service.QuestionAnswerService#listQA(com.ryxx.bpim.entity.QuestionAnswer, com.ryxx.util.page.PageTools)
	 */
	@Override
	public List<QuestionAnswer> listQA(QuestionAnswer questionAnswer,
			PageTools page) {
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = getDao().getRowCount(questionAnswer);
				page.setRecordCount(count);
			}
			questionAnswer.setStartRow(page.getPageStartRow());
			questionAnswer.setPageSize(page.getPageSize());
		}
		return getDao().findByCount(questionAnswer);
	}
   
	
}
