package com.ryxx.bpim.system.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;

import com.ryxx.bpim.dao.AbstractBaseDAO;
import com.ryxx.bpim.system.entity.NewsAnnouncement;

public class NewsAnnounceDAOImpl extends
		AbstractBaseDAO<NewsAnnouncement, Long> implements NewsAnnounceDAO {

	@Override
	public void saveNewsAnnouncement(NewsAnnouncement newsAnnouncement) {
		save(newsAnnouncement);
	}

	@Override
	public void deleteNewsAnnouncement(NewsAnnouncement newsAnnouncement) {
		remove(newsAnnouncement);
	}

	@Override
	public NewsAnnouncement viewNewsAnnouncement(
			NewsAnnouncement newsAnnouncement) {
		return findById(newsAnnouncement.getId());
	}

	@Override
	public List<NewsAnnouncement> listNewsAnnouncement(
			NewsAnnouncement newsAnnouncement) {
		return findByCriteria(wrapCriterion(newsAnnouncement));
	}

	@Override
	public int getRowCount(NewsAnnouncement newsAnnouncement) {
		return findByCriteria(wrapCriterion(newsAnnouncement)).size();

	}

	private Criterion[] wrapCriterion(NewsAnnouncement newsAnnouncement) {
		List<Criterion> list = new ArrayList<Criterion>();
		if (newsAnnouncement != null) {
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
