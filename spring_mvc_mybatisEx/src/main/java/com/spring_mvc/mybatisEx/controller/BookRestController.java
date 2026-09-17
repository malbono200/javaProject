package com.spring_mvc.mybatisEx.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_mvc.mybatisEx.dto.BookDTO;
import com.spring_mvc.mybatisEx.service.BookService;

@RestController
public class BookRestController {
	@Autowired
    BookService service;

    @RequestMapping("/book/bookSearch3")
    public ArrayList<BookDTO> bookSearch3(@RequestParam HashMap<String, Object> map) {
        ArrayList<BookDTO> bookList = service.bookSearch(map);
        return bookList;
    }
}
