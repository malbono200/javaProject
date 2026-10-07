package com.spring_boot_mini_project.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot_mini_project.dao.ICartDAO;
import com.spring_boot_mini_project.dto.CartDTO;

@Service
public class CartService implements ICartService {
	@Autowired
	@Qualifier("ICartDAO")
	ICartDAO dao;

	@Override
	public void insertCart(CartDTO dto) {
		dao.insertCart(dto);
	}

	@Override
	public int checkPrdInCart(CartDTO dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("prdNo", dto.getPrdNo());
		map.put("memId", dto.getMemId());
		return dao.checkPrdInCart(map);
	}

	@Override
	public void updateQtyInCart(CartDTO dto) {
		dao.updateQtyInCart(dto);
	}

	@Override
	public ArrayList<CartDTO> cartList(String memId) {
		return dao.cartList(memId);
	}

	@Override
	public void deleteCart(ArrayList<String> chkArr) {
		dao.deleteCart(chkArr);
	}

	@Override
	public void updateCart(CartDTO dto) {
		dao.updateCart(dto);
	}
	
	
}
