package com.spring_boot_mini_project.dao;

import java.util.ArrayList;

import com.spring_boot_mini_project.dto.ProductDTO;

public interface IProductDAO {
	ArrayList<ProductDTO> listCtgProduct(String ctgId);
	ProductDTO detailViewProduct(String prdNo);
}
