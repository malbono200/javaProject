package com.spring_mvc.mybatisEx.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.mybatisEx.dto.BookDTO;
import com.spring_mvc.mybatisEx.service.BookService;

@Controller
public class BookController {
	@Autowired
    BookService service;

    @RequestMapping("/")
    public String viewIndex() {
        return "index";
    }

    @RequestMapping("/book/listAllBook")
    public String listAllBook(Model model) {
        ArrayList<BookDTO> bookList = service.listAllBook();
        model.addAttribute("bookList", bookList);
        return "book/bookListView";
    }

    @RequestMapping("/book/newBookForm")
    public String newBookForm() {
        return "book/newBookForm";
    }

    @RequestMapping("/book/insertBook")
    public String insertBook(BookDTO dto) {
        service.insertBook(dto);
        return "redirect:/book/listAllBook";
    }

    @RequestMapping("/book/detailViewBook/{bookNo}")
    public String detailViewBook(@PathVariable String bookNo, Model model) {
        BookDTO dto = service.detailViewBook(bookNo);
        model.addAttribute("book", dto);
        return "book/bookDetailView";
    }

    @RequestMapping("/book/updateBookForm/{bookNo}")
    public String updateBookForm(@PathVariable String bookNo, Model model) {
        BookDTO dto = service.detailViewBook(bookNo);
        model.addAttribute("book", dto);
        return "book/updateBookForm";
    }

    @RequestMapping("/book/updateBook")
    public String updateBook(BookDTO dto) {
        service.updateBook(dto);
        return "redirect:/book/listAllBook";
    }

    @RequestMapping("/book/deleteBook/{bookNo}")
    public String deleteBook(@PathVariable String bookNo) {
        service.deleteBook(bookNo);
        return "redirect:/book/listAllBook";
    }
}
