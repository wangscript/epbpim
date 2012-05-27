package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.QuestionAnswer;

/**
 * author Delgado
 */
public interface QuestionAnswerDAO extends BaseDAO<QuestionAnswer, Long>
{

	/**
	 * @param questionAnswer
	 * @return
	 */
	int getRowCount(QuestionAnswer questionAnswer);

	/**
	 * @param questionAnswer
	 * @return
	 */
	List<QuestionAnswer> findByCount(QuestionAnswer questionAnswer);
    
}
