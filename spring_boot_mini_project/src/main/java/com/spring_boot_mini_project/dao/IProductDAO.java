package com.spring_boot_mini_project.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mini_project.dto.ProductDTO;

public interface IProductDAO {
	ArrayList<ProductDTO> listCtgProduct(String ctgId);
	ProductDTO detailViewProduct(String prdNo);
	// 관리자 상품관리
	ArrayList<ProductDTO> listAllProduct();
	void insertProduct(ProductDTO dto);
	void updateProduct(ProductDTO dto);
	void deleteProduct(String prdNo);
	
	ArrayList<ProductDTO> bestProduct();
	ArrayList<ProductDTO> listPlayerProduct(HashMap<String, Object> map);
	ArrayList<ProductDTO> searchProduct(String keyword);
}
