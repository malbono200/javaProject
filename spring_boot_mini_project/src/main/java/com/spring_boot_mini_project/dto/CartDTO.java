package com.spring_boot_mini_project.dto;

public class CartDTO {
	private int cartNo;
	private String memId;
	private String prdNo;
	private int cartQty;
	private String prdName;
	private int prdPrice;
	
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getPrdNo() {
		return prdNo;
	}
	public void setPrdNo(String prdNo) {
		this.prdNo = prdNo;
	}
	public int getCartQty() {
		return cartQty;
	}
	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public int getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}
	
}
