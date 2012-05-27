package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.QuestionAnswerDAO;
import com.ryxx.bpim.entity.QuestionAnswer;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public interface QuestionAnswerService extends BaseService<QuestionAnswer, QuestionAnswerDAO, Long>
{


	/**
	 * @param questionAnswer
	 * @param page 
	 * @return
	 */
	List<QuestionAnswer> listQA(QuestionAnswer questionAnswer, PageTools page);
    
   
    
}
