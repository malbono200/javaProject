package com.spring_boot_mini_project.dto;

import java.util.Date;

public class OrderInfoDTO {
	private String ordNo;
	private String memId;
	private Date ordDate;
	private String ordReceiver;
	private String ordRcvZipcode;
	private String ordRcvAddress1;
	private String ordRcvAddress2;
	private String ordRcvPhone;
	private String ordStatus;
	private int totalPrice;
	private String orderItems;
	
	public String getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public Date getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}
	public String getOrdReceiver() {
		return ordReceiver;
	}
	public void setOrdReceiver(String ordReceiver) {
		this.ordReceiver = ordReceiver;
	}
	public String getOrdRcvZipcode() {
		return ordRcvZipcode;
	}
	public void setOrdRcvZipcode(String ordRcvZipcode) {
		this.ordRcvZipcode = ordRcvZipcode;
	}
	public String getOrdRcvAddress1() {
		return ordRcvAddress1;
	}
	public void setOrdRcvAddress1(String ordRcvAddress1) {
		this.ordRcvAddress1 = ordRcvAddress1;
	}
	public String getOrdRcvAddress2() {
		return ordRcvAddress2;
	}
	public void setOrdRcvAddress2(String ordRcvAddress2) {
		this.ordRcvAddress2 = ordRcvAddress2;
	}
	public String getOrdRcvPhone() {
		return ordRcvPhone;
	}
	public void setOrdRcvPhone(String ordRcvPhone) {
		this.ordRcvPhone = ordRcvPhone;
	}
	public String getOrdStatus() {
		return ordStatus;
	}
	public void setOrdStatus(String ordStatus) {
		this.ordStatus = ordStatus;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(String orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
