package com.spring_boot_mini_project.service;

import java.util.ArrayList;

import com.spring_boot_mini_project.dto.CartDTO;

public interface ICartService {
	void insertCart(CartDTO dto);
	int checkPrdInCart(CartDTO dto);
	void updateQtyInCart(CartDTO dto);
	ArrayList<CartDTO> cartList(String memId);
	void deleteCart(ArrayList<String> chkArr);
	void updateCart(CartDTO dto);
}
