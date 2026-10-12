package com.spring_boot_mini_project.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mini_project.dto.OrderInfoDTO;

public interface IOrderDAO {
	int countCart(String memId);
	int countOverStock(String memId);
	void insertOrderInfo(OrderInfoDTO dto);
	void insertOrderProduct(HashMap<String, Object> map);
	void decreaseStock(String memId);
	void deleteCartAfterOrder(String memId);
	ArrayList<OrderInfoDTO> orderList(String memId);
	void updateOrderStatus(OrderInfoDTO dto);
}
