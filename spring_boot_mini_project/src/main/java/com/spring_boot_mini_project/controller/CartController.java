package com.spring_boot_mini_project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot_mini_project.dto.CartDTO;
import com.spring_boot_mini_project.service.CartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	@Autowired
	CartService cartService;
	
	// 장바구니 담기 (상세 페이지에서 prdNo, cartQty 전송)
	@PostMapping("/product/insertCart")
	public String insertCart(CartDTO dto, HttpSession session) {
		String memId = (String)session.getAttribute("sid");
		if(memId == null) return "redirect:/member/loginForm";
		dto.setMemId(memId);

		// 같은 상품이 없으면 새로 담고, 있으면 수량만 추가
		if(cartService.checkPrdInCart(dto) == 0) {
			cartService.insertCart(dto);
		} else {
			cartService.updateQtyInCart(dto);
		}
		return "redirect:/product/cartList";
	}

	// 장바구니 목록
	@GetMapping("/product/cartList")
	public String cartList(Model model, HttpSession session) {
		String memId = (String)session.getAttribute("sid");
		if(memId == null) return "redirect:/member/loginForm";
		model.addAttribute("cartList", cartService.cartList(memId));
		return "cart/cartListView";
	}

	// 선택 삭제 (Ajax)
	@ResponseBody
	@PostMapping("/product/deleteCart")
	public int deleteCart(@RequestParam("delPrd") ArrayList<String> chkArr) {
		int result = 0;
		if(chkArr != null) {
			cartService.deleteCart(chkArr);
			result = 1;
		}
		return result;
	}
}
