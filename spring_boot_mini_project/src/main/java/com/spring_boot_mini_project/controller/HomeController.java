package com.spring_boot_mini_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring_boot_mini_project.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	ProductService service;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("bestList", service.bestProduct());   // 인기 게임 4개
		return "index";
	}
}
