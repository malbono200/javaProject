package com.spring_boot_mini_project.dto;

import java.util.Date;

public class ProductDTO {
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private String prdCompany;
	private int prdStock;
	private String prdDescript;
	private String ctgId;
	private int minPlayer;
	private int maxPlayer;
	private int playTime;
	private int difficulty;
	private Date prdDate;
	
	public String getPrdNo() {
		return prdNo;
	}
	public void setPrdNo(String prdNo) {
		this.prdNo = prdNo;
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
	public String getPrdCompany() {
		return prdCompany;
	}
	public void setPrdCompany(String prdCompany) {
		this.prdCompany = prdCompany;
	}
	public int getPrdStock() {
		return prdStock;
	}
	public void setPrdStock(int prdStock) {
		this.prdStock = prdStock;
	}
	public String getPrdDescript() {
		return prdDescript;
	}
	public void setPrdDescript(String prdDescript) {
		this.prdDescript = prdDescript;
	}
	public String getCtgId() {
		return ctgId;
	}
	public void setCtgId(String ctgId) {
		this.ctgId = ctgId;
	}
	public int getMinPlayer() {
		return minPlayer;
	}
	public void setMinPlayer(int minPlayer) {
		this.minPlayer = minPlayer;
	}
	public int getMaxPlayer() {
		return maxPlayer;
	}
	public void setMaxPlayer(int maxPlayer) {
		this.maxPlayer = maxPlayer;
	}
	public int getPlayTime() {
		return playTime;
	}
	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public Date getPrdDate() {
		return prdDate;
	}
	public void setPrdDate(Date prdDate) {
		this.prdDate = prdDate;
	}
	
}
