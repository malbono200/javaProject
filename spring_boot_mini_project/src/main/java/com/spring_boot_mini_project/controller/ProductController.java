package com.spring_boot_mini_project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/product/productListPlayer/{type}")
	public String productListPlayer(@PathVariable int type, Model model) {
		int min, max;
		String title;
		switch(type) {
			case 1:  min = 1; max = 1;  title = "혼자 하는 게임"; break;
			case 2:  min = 2; max = 2;  title = "2인 게임"; break;
			case 3:  min = 3; max = 4;  title = "3~4인 게임"; break;
			default: min = 5; max = 99; title = "5인 이상 게임"; break;
		}
		model.addAttribute("prdList", service.listPlayerProduct(min, max));
		model.addAttribute("ctgName", title);   // 목록 화면 제목으로 사용
		return "product/productCtgListView";
	}
	
	@GetMapping("/product/search")
	public String searchProduct(@RequestParam String keyword, Model model) {
		keyword = keyword.trim();
		if(keyword.isEmpty()) return "redirect:/";
		model.addAttribute("prdList", service.searchProduct(keyword));
		model.addAttribute("ctgName", "'" + keyword + "' 검색 결과");   // 목록 화면 제목
		return "product/productCtgListView";
	}
}
