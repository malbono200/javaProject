package com.spring_boot_mini_project.service;

import java.util.ArrayList;

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
	
}
