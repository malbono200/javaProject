package com.spring_mvc.mybatisEx.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    //도서번호 중복 확인1 : jQuery ajax의 post - 파라미터로 전달
    @ResponseBody
    @RequestMapping("/book/bookNoCheck")
    public String bookNoCheck(@RequestParam("bookNo") String bookNo) {
        String result = service.bookNoCheck(bookNo);
        System.out.println(result);
        return result;
    }
    
    //도서번호 중복 확인2 : fetch의 get - url 경로변수로 전달
    @ResponseBody
    @RequestMapping("/book/bookNoCheck2/{bookNo}")
    public String bookNoCheck2(@PathVariable String bookNo) {
        String result = service.bookNoCheck(bookNo);
        System.out.println(result);
        return result;
    }
    
    //도서번호 중복 확인3 : axios의 post - JSON(k:v) 형태로 body에 담아 전달
    @ResponseBody
    @RequestMapping("/book/bookNoCheck3")
    public String bookNoCheck3(@RequestBody HashMap<String,String> map) {
        String bookNo = map.get("bookNo");
        String result = service.bookNoCheck(bookNo);
        System.out.println(result);
        return result;
    }
}
