package com.bling.bean;

import java.sql.Date;

public class BorrowForm {

	private int goodsID;
	private String goodsName;
	private Date borrowTime;
	private double borrowNumber;
	private String borrowDec;
	private String borrower;
	private String mainSpond;
	
	

	@Override
	public String toString() {
		return "借出单 [物品编号=" + goodsID + ", 物品名称=" + goodsName
				+ ", 借出时间=" + borrowTime + ", 借出数量="
				+ borrowNumber + ", 借出描述=" + borrowDec + ", 借款人="
				+ borrower + ", 负责人=" + mainSpond + "]";
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public BorrowForm(int goodsID) {
		// TODO Auto-generated constructor stub
		this.goodsID = goodsID;
	}
	public int getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
	}
	public Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	public double getBorrowNumber() {
		return borrowNumber;
	}
	public void setBorrowNumber(double borrowNumber) {
		this.borrowNumber = borrowNumber;
	}
	public String getBorrowDec() {
		return borrowDec;
	}
	public void setBorrowDec(String borrowDec) {
		this.borrowDec = borrowDec;
	}
	public String getMainSpond() {
		return mainSpond;
	}
	public void setMainSpond(String mainSpond) {
		this.mainSpond = mainSpond;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	
	
}
