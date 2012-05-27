package com.ryxx.bpim.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ryxx.bpim.entity.QuestionAnswer;

/**
 * author Delgado
 */
public class QuestionAnswerDAOImpl extends
		AbstractBaseDAO<QuestionAnswer, Long> implements QuestionAnswerDAO {

	@Override
	public List<QuestionAnswer> findByCount(QuestionAnswer questionAnswer) {
		return findPageByPage(questionAnswer.getStartRow(),
				questionAnswer.getPageSize(), wrapCriterion(questionAnswer));
	}

	@Override
	public int getRowCount(QuestionAnswer questionAnswer) {
		return findByCriteria(wrapCriterion(questionAnswer)).size();

	}

	private Criterion[] wrapCriterion(QuestionAnswer questionAnswer) {
		List<Criterion> list = new ArrayList<Criterion>();
		if (questionAnswer != null) {
			if (!StringUtils.isEmpty(questionAnswer.getKeyword())) {
				Criterion criterion1 = Restrictions.like("question", "%"
						+ questionAnswer.getKeyword() + "%");
				list.add(criterion1);
			}

			if (!StringUtils.isEmpty(questionAnswer.getType())
					&& "1".equals(questionAnswer.getType())) {
				Criterion criterion1 = Restrictions.eq("questionUser.id",
						questionAnswer.getQuestionUser().getId());
				Criterion criterion2 = Restrictions.isNotNull("answer");
				list.add(criterion1);
				list.add(criterion2);
			} else if (!StringUtils.isEmpty(questionAnswer.getType())
					&& "0".equals(questionAnswer.getType())) {
				Criterion criterion1 = Restrictions.isNotNull("answer");
				list.add(criterion1);
			} else if (!StringUtils.isEmpty(questionAnswer.getType())
					&& "2".equals(questionAnswer.getType())) {
				Criterion criterion1 = Restrictions.isNull("answer");
				list.add(criterion1);
			}

		}

		Criterion[] criterions = {};
		if (list != null && list.size() > 0) {
			criterions = new Criterion[list.size()];
			for (int i = 0; i < list.size(); i++) {
				criterions[i] = list.get(i);
			}
		}

		return criterions;
	}

}
