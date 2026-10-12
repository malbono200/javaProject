package com.spring_boot_mini_project.service;

import java.util.ArrayList;

import com.spring_boot_mini_project.dto.OrderInfoDTO;

public interface IOrderService {
	String insertOrder(OrderInfoDTO dto);
	ArrayList<OrderInfoDTO> orderList(String memId);
	void updateOrderStatus(OrderInfoDTO dto);
}
