package com.spring_boot_mini_project.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring_boot_mini_project.dao.IOrderDAO;
import com.spring_boot_mini_project.dto.OrderInfoDTO;

@Service
public class OrderService implements IOrderService {
	@Autowired
	@Qualifier("IOrderDAO")
	IOrderDAO dao;

	@Override
	@Transactional
	public String insertOrder(OrderInfoDTO dto) {
		String memId = dto.getMemId();

		//장바구니가 비었거나 재고가 부족하면 주문 중단
		if(dao.countCart(memId) == 0) return "empty";
		if(dao.countOverStock(memId) > 0) return "soldout";

		//주문,배송 정보 저장
		dao.insertOrderInfo(dto);

		//장바구니 상품을 주문 상품으로 저장
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ordNo", dto.getOrdNo());
		map.put("memId", memId);
		dao.insertOrderProduct(map);

		//재고 차감, 장바구니 비우기
		dao.decreaseStock(memId);
		dao.deleteCartAfterOrder(memId);

		return "success";
	}

	@Override
	public ArrayList<OrderInfoDTO> orderList(String memId) {
		return dao.orderList(memId);
	}

	@Override
	public void updateOrderStatus(OrderInfoDTO dto) {
		dao.updateOrderStatus(dto);
	}
	
}
