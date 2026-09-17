package com.spring_mvc.mybatisEx.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_mvc.mybatisEx.dao.IBookDAO;
import com.spring_mvc.mybatisEx.dto.BookDTO;

@Service
public class BookService implements IBookService {
	
	@Autowired
    @Qualifier("IBookDAO")
    IBookDAO dao;

	@Override
	public void insertBook(BookDTO bookDto) {
		dao.insertBook(bookDto);
	}

	@Override
	public void updateBook(BookDTO bookDto) {
		dao.updateBook(bookDto);
	}

	@Override
	public void deleteBook(String bookNo) {
		dao.deleteBook(bookNo);
	}

	@Override
	public ArrayList<BookDTO> listAllBook() {
		return dao.listAllBook();
	}

	@Override
	public BookDTO detailViewBook(String bookNo) {
		return dao.detailViewBook(bookNo);
	}

	@Override
	public String bookNoCheck(String bookNo) {
		String res = dao.bookNoCheck(bookNo);
	    String result = "available";
	    if(res != null) {
	        result = "no_available";
	    }
	    return result;
	}

	@Override
	public ArrayList<BookDTO> bookSearch(HashMap<String, Object> map) {
		return dao.bookSearch(map);
	}
	
	
}
