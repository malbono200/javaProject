package com.spring_boot_mini_project.service;

import java.util.ArrayList;

import com.spring_boot_mini_project.dto.ProductDTO;

public interface IProductService {
	ArrayList<ProductDTO> listCtgProduct(String ctgId);
	ProductDTO detailViewProduct(String prdNo);
}
