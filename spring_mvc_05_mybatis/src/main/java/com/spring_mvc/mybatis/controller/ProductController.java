package com.spring_mvc.mybatis.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.mybatis.dto.ProductDTO;
import com.spring_mvc.mybatis.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	@RequestMapping("/product/listAllProduct")
	public String listAllProduct(Model model) {
		ArrayList<ProductDTO> prdList = service.listAllProduct();
		model.addAttribute("prdList", prdList);
		return "product/productListView";
	}
}
