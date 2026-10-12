package com.spring_boot_mini_project.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot_mini_project.dao.IProductDAO;
import com.spring_boot_mini_project.dto.ProductDTO;

@Service
public class ProductService implements IProductService{
	@Autowired
	@Qualifier("IProductDAO")
	IProductDAO dao;

	@Override
	public ArrayList<ProductDTO> listCtgProduct(String ctgId) {
		return dao.listCtgProduct(ctgId);
	}

	@Override
	public ProductDTO detailViewProduct(String prdNo) {
		return dao.detailViewProduct(prdNo);
	}

	@Override
	public ArrayList<ProductDTO> listAllProduct() {
		return dao.listAllProduct();
	}

	@Override
	public void insertProduct(ProductDTO dto) {
		dao.insertProduct(dto);
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}

	@Override
	public void deleteProduct(String prdNo) {
		dao.deleteProduct(prdNo);
	}

	@Override
	public ArrayList<ProductDTO> bestProduct() {
		return dao.bestProduct();
	}

	@Override
	public ArrayList<ProductDTO> listPlayerProduct(int min, int max) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("min", min);
		map.put("max", max);
		return dao.listPlayerProduct(map);
	}

	@Override
	public ArrayList<ProductDTO> searchProduct(String keyword) {
		return dao.searchProduct(keyword);
	}
	
}
