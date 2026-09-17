package com.spring_mvc.mybatisEx.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_mvc.mybatisEx.dto.BookDTO;

public interface IBookDAO {
	void insertBook(BookDTO bookDto);
	void updateBook(BookDTO bookDto);
	void deleteBook(String bookNo);
	ArrayList<BookDTO> listAllBook();
    BookDTO detailViewBook(String bookNo);
    String bookNoCheck(String bookNo);
    ArrayList<BookDTO> bookSearch(HashMap<String, Object> map);
}
