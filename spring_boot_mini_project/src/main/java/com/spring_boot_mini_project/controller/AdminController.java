package com.spring_boot_mini_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_boot_mini_project.dto.OrderInfoDTO;
import com.spring_boot_mini_project.dto.ProductDTO;
import com.spring_boot_mini_project.service.OrderService;
import com.spring_boot_mini_project.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	@Autowired
	ProductService service;
	
	@Autowired
	OrderService orderService;
	
	private static final String[] CTG_NAMES = {"", "파티게임", "전략게임", "협력게임", "추리게임", "카드게임"};
	
	// 관리자인지 확인
	private boolean isAdmin(HttpSession session) {
		return "ADMIN".equals(session.getAttribute("srole"));
	}

	// 상품 목록
	@GetMapping("/admin/productList")
	public String productList(HttpSession session, Model model) {
		if(!isAdmin(session)) return "redirect:/";
		model.addAttribute("prdList", service.listAllProduct());
		model.addAttribute("ctgNames", CTG_NAMES);
		return "admin/productList";
	}

	// 상품 등록 폼
	@GetMapping("/admin/productForm")
	public String productForm(HttpSession session) {
		if(!isAdmin(session)) return "redirect:/";
		return "admin/productForm";
	}

	// 상품 등록 처리
	@PostMapping("/admin/insertProduct")
	public String insertProduct(ProductDTO dto, HttpSession session, RedirectAttributes rttr) {
		if(!isAdmin(session)) return "redirect:/";
		service.insertProduct(dto);
		rttr.addFlashAttribute("msg", "상품이 등록되었어요.");
		return "redirect:/admin/productList";
	}

	// 상품 수정 폼 (등록 폼을 같이 사용)
	@GetMapping("/admin/productUpdateForm/{prdNo}")
	public String productUpdateForm(@PathVariable String prdNo, HttpSession session, Model model) {
		if(!isAdmin(session)) return "redirect:/";
		ProductDTO prd = service.detailViewProduct(prdNo);
		if(prd == null) return "redirect:/admin/productList";
		model.addAttribute("prd", prd);
		return "admin/productForm";
	}

	// 상품 수정 처리
	@PostMapping("/admin/updateProduct")
	public String updateProduct(ProductDTO dto, HttpSession session, RedirectAttributes rttr) {
		if(!isAdmin(session)) return "redirect:/";
		service.updateProduct(dto);
		rttr.addFlashAttribute("msg", "상품이 수정되었어요.");
		return "redirect:/admin/productList";
	}

	// 상품 삭제 : 주문된 상품은 FK 때문에 삭제 불가 → 안내 메시지
	@PostMapping("/admin/deleteProduct/{prdNo}")
	public String deleteProduct(@PathVariable String prdNo, HttpSession session, RedirectAttributes rttr) {
		if(!isAdmin(session)) return "redirect:/";
		try {
			service.deleteProduct(prdNo);
			rttr.addFlashAttribute("msg", "상품이 삭제되었어요.");
		} catch(DataIntegrityViolationException e) {
			rttr.addFlashAttribute("msg", "주문 내역이 있는 상품은 삭제할 수 없어요. 수정에서 재고를 0으로 바꿔 품절 처리해 주세요.");
		}
		return "redirect:/admin/productList";
	}
	
	// 주문 관리 : 전체 주문 목록
	@GetMapping("/admin/orderList")
	public String orderList(HttpSession session, Model model) {
		if(!isAdmin(session)) return "redirect:/";
		model.addAttribute("orderList", orderService.orderList(null));
		return "admin/orderList";
	}

	// 배송 상태 변경
	@PostMapping("/admin/updateOrderStatus")
	public String updateOrderStatus(OrderInfoDTO dto, HttpSession session, RedirectAttributes rttr) {
		if(!isAdmin(session)) return "redirect:/";
		orderService.updateOrderStatus(dto);
		rttr.addFlashAttribute("msg", dto.getOrdNo() + " 주문이 " + dto.getOrdStatus() + "(으)로 변경되었어요.");
		return "redirect:/admin/orderList";
	}
}
