package com.spring_boot_react.project.controller;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_boot_react.project.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@GetMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	

}

























