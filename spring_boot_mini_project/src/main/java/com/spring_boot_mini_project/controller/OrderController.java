package com.spring_boot_mini_project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_boot_mini_project.dto.CartDTO;
import com.spring_boot_mini_project.dto.OrderInfoDTO;
import com.spring_boot_mini_project.service.CartService;
import com.spring_boot_mini_project.service.IMemberService;
import com.spring_boot_mini_project.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	@Autowired
	CartService cartService;

	@Autowired
	@Qualifier("MemberService")
	IMemberService memService;

	@Autowired
	OrderService orderService;
	
	// 주문서 작성 (장바구니에서 cartNo, cartQty 배열 전송)
	@PostMapping("/product/orderForm")
	public String orderForm(@RequestParam int[] cartNo, @RequestParam int[] cartQty,
	                        HttpSession session, Model model) {
		String memId = (String)session.getAttribute("sid");
		if(memId == null) return "redirect:/member/loginForm";

		// 장바구니에서 바꾼 수량을 먼저 저장
		for(int i = 0; i < cartNo.length; i++) {
			CartDTO dto = new CartDTO();
			dto.setCartNo(cartNo[i]);
			dto.setCartQty(cartQty[i]);
			cartService.updateCart(dto);
		}

		model.addAttribute("mem", memService.selectMember(memId));
		model.addAttribute("cartList", cartService.cartList(memId));
		return "order/orderForm";
	}
	
	// 주문 완료
	@PostMapping("/product/orderComplete")
	public String orderComplete(OrderInfoDTO dto, @RequestParam String hp1, @RequestParam String hp2, @RequestParam String hp3, HttpSession session, Model model, RedirectAttributes rttr) {
		String memId = (String)session.getAttribute("sid");
		if(memId == null) return "redirect:/member/loginForm";

		dto.setMemId(memId);
		dto.setOrdRcvPhone(hp1 + "-" + hp2 + "-" + hp3);

		// 주문번호 : 날짜시분초_랜덤4자리 (예: 20261008153012_4821)
		String ordNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
		             + "_" + (int)(Math.random() * 9000 + 1000);
		dto.setOrdNo(ordNo);

		String result = orderService.insertOrder(dto);
		if(!"success".equals(result)) {
			// 실패하면 장바구니로 돌아가서 알림 표시
			rttr.addFlashAttribute("msg", "soldout".equals(result)
					? "재고가 부족한 상품이 있어요. 수량을 확인해 주세요."
					: "장바구니가 비어 있어요.");
			return "redirect:/product/cartList";
		}

		model.addAttribute("ordNo", ordNo);
		return "order/orderCompleteView";
	}
	
	// 회원 주문내역
	@GetMapping("/order/orderListView")
	public String orderListView(HttpSession session, Model model) {
		String memId = (String)session.getAttribute("sid");
		if(memId == null) return "redirect:/member/loginForm";
		model.addAttribute("orderList", orderService.orderList(memId));
		return "order/orderListView";
	}
}
