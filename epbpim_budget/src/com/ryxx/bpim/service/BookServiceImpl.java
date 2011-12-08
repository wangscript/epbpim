package com.ryxx.bpim.service;

import java.util.List;

import com.ryxx.bpim.dao.BookDAO;
import com.ryxx.bpim.entity.Book;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public class BookServiceImpl extends AbstractService<Book, BookDAO, Long> implements BookService
{

	/* (non-Javadoc)
	 * @see com.ryxx.bpim.service.BookService#listBook(com.ryxx.bpim.entity.Book, com.ryxx.util.page.PageTools)
	 */
	@Override
	public List<Book> listBooks(Book book, PageTools page) {
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = getDao().getRowCount(book);
				page.setRecordCount(count);
			}
			book.setStartRow(page.getPageStartRow());
			book.setPageSize(page.getPageSize());
		}
		return getDao().findByCount(book);
	}
   
	
}
