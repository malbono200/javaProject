package com.spring_boot_mini_project.service;

import java.util.ArrayList;

import com.spring_boot_mini_project.dto.ProductDTO;

public interface IProductService {
	ArrayList<ProductDTO> listCtgProduct(String ctgId);
	ProductDTO detailViewProduct(String prdNo);
	
	ArrayList<ProductDTO> listAllProduct();
	void insertProduct(ProductDTO dto);
	void updateProduct(ProductDTO dto);
	void deleteProduct(String prdNo);
	
	ArrayList<ProductDTO> bestProduct();
	ArrayList<ProductDTO> listPlayerProduct(int min, int max);
	ArrayList<ProductDTO> searchProduct(String keyword);
}
