package com.spring_boot_mini_project.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mini_project.dto.CartDTO;

public interface ICartDAO {
	void insertCart(CartDTO dto);
	int checkPrdInCart(HashMap<String, Object> map);
	void updateQtyInCart(CartDTO dto);
	ArrayList<CartDTO> cartList(String memId);
	void deleteCart(ArrayList<String> chkArr);
	void updateCart(CartDTO dto);
}
