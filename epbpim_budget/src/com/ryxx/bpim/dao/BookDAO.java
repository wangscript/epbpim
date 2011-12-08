package com.ryxx.bpim.dao;

import java.util.List;

import com.ryxx.bpim.entity.Book;
import com.ryxx.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public interface BookDAO extends BaseDAO<Book, Long>
{

	/**
	 * @param condition
	 * @return
	 */
	int getRowCount(Book book);

	/**
	 * @param condition
	 * @return
	 */
	List<Book> findByCount(Book book);
    
    
}
