package com.spring_boot_mini_project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring_boot_mini_project.dto.ProductDTO;
import com.spring_boot_mini_project.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	private static final String[] CTG_NAMES = {"", "파티게임", "전략게임", "협력게임", "추리게임", "카드게임"};
	
	@GetMapping("/product/productListCtg/{ctgId}")
	public String productCtgList(@PathVariable String ctgId, Model model) {
		model.addAttribute("prdList", service.listCtgProduct(ctgId));
		model.addAttribute("ctgName", CTG_NAMES[Integer.parseInt(ctgId)]);
		return "product/productCtgListView";
	}
	
	@GetMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		ProductDTO prd = service.detailViewProduct(prdNo);
		if(prd == null) return "redirect:/";
		model.addAttribute("prd", prd);
		model.addAttribute("ctgName", CTG_NAMES[Integer.parseInt(prd.getCtgId())]);
		return "product/productDetailView";
	}
}
