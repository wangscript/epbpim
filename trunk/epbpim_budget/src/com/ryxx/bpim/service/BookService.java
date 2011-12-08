package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.BookDAO;
import com.ryxx.bpim.entity.Book;
import com.ryxx.bpim.form.SearchDataCondition;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public interface BookService extends BaseService<Book, BookDAO, Long>
{

	/**
	 * @param condition
	 * @param page
	 * @return
	 */
	List<Book> listBooks(Book book, PageTools page);
    
   
    
}
