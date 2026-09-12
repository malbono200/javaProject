package com.spring_mvc.projectData;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	
	@RequestMapping("/product/productForm")
    public String productFormView() {
        return "product/productForm2";
    }
	
	@RequestMapping("/product/productForm2")
	public String productFormView2() {
	    return "product/productForm2";
	}

    @RequestMapping("/product/newProduct")
    public String insertProduct(HttpServletRequest request, Model model) {
        String prdNo = request.getParameter("prdNo");
        String prdName = request.getParameter("prdName");
        String Price = request.getParameter("Price");
        String Company = request.getParameter("Company");
        String prdDate = request.getParameter("prdDate");
        String Stock = request.getParameter("Stock");

        model.addAttribute("prdNo", prdNo);
        model.addAttribute("prdName", prdName);
        model.addAttribute("Price", Price);
        model.addAttribute("Company", Company);
        model.addAttribute("prdDate", prdDate);
        model.addAttribute("Stock", Stock);

        return "product/productResult";
    }
    
    @RequestMapping("/product/newProduct2")
    public String insertProduct2(@RequestParam("prdNo") String prdNo,
                                 @RequestParam("prdName") String prdName,
                                 @RequestParam("Price") String Price,
                                 @RequestParam("Company") String Company,
                                 @RequestParam("prdDate") String prdDate,
                                 @RequestParam("Stock") String Stock,
                                 Model model) {

        model.addAttribute("prdNo", prdNo);
        model.addAttribute("prdName", prdName);
        model.addAttribute("Price", Price);
        model.addAttribute("Company", Company);
        model.addAttribute("prdDate", prdDate);
        model.addAttribute("Stock", Stock);

        return "product/productResult";
    }
        
    @RequestMapping("/product/newProduct3")
    public String insertProduct3(String prdNo,
                                 String prdName,
                                 String Price,
                                 String Company,
                                 String prdDate,
                                 String Stock,
                                 Model model) {

        model.addAttribute("prdNo", prdNo);
        model.addAttribute("prdName", prdName);
        model.addAttribute("Price", Price);
        model.addAttribute("Company", Company);
        model.addAttribute("prdDate", prdDate);
        model.addAttribute("Stock", Stock);

        return "product/productResult";
    }
    
    @RequestMapping("/product/newProduct4")
    public String insertProduct3(Product product) {
        System.out.println(product.getPrdNo());
        System.out.println(product.getPrdName());
        System.out.println(product.getPrice());
        System.out.println(product.getCompany());
        System.out.println(product.getPrdDate());
        System.out.println(product.getStock());
        
        return "product/productResult3";
    }
    
    @RequestMapping("/product/newProduct5")
    public String insertProduct4(@ModelAttribute("productInfo") Product product) {
        return "product/productResult4";
    }
    
    @RequestMapping("/product/productDetailView/{prdName}")
    public String productDetailView(@PathVariable String prdName) {
        System.out.println("상품명 : " + prdName);
        return "product/productResult5";
    }
    
    @RequestMapping("/product/productDetailView/{prdName}/{Stock}/{prdNo}")
    public String productDetailViewMulti(@PathVariable String prdName,
                                         @PathVariable String Stock,
                                         @PathVariable String prdNo) {
        System.out.println("상품명 : " + prdName);
        System.out.println("재고 : " + Stock);
        System.out.println("상품번호 : " + prdNo);
        return "product/productResult5";
    }
    
    @RequestMapping("/product/prdSearchForm")
    public String prdSearchForm() {
        return "product/prdSearchForm";
    }
    
    @RequestMapping("/product/prdSearch")
    public String prdSearch(@RequestParam HashMap<String, Object> param, Model model) {
        
        // 전송받은 검색 조건과 키워드를 콘솔에 출력 (파라미터명이 key가 됨)
        System.out.println("검색 조건: " + param.get("type"));
        System.out.println("검색 키워드: " + param.get("keyword"));
        
        Product prd1 = new Product();
        prd1.setPrdNo("1001");
        prd1.setPrdName("삼성폰");
        prd1.setPrice(100000);
        prd1.setCompany("삼성");
        prd1.setPrdDate(java.sql.Date.valueOf("2026-09-11"));
        prd1.setStock(50);
        
        Product prd2 = new Product();
        prd2.setPrdNo("1002");
        prd2.setPrdName("삼성태블릿");
        prd2.setPrice(200000);
        prd2.setCompany("삼성");
        prd2.setPrdDate(java.sql.Date.valueOf("2026-09-11"));
        prd2.setStock(50);
        
        ArrayList<Product> prdList = new ArrayList<Product>();
        prdList.add(prd1);
        prdList.add(prd2);
        
        model.addAttribute("prdList", prdList);     
        return "product/prdSearchResult";
    }
}
