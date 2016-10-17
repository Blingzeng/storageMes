package com.bling.bean;

import java.sql.Date;

/**
* 
* @author Bling
* @descrite 这是一个描述库单表的类，它的属性有：物品编号，物品名称，物品单价，物品数量，物品描述
* 											 入库时间，入库数量，入库描述
* 											 出库时间，出库数量，出库描述
* 											 借出时间，借出数量，借出描述
* 											 还库时间，还库数量，还库描述
* 											 负责人，借物人。
*
*/

public class Form {

	private int goodsId;
	private String goodsName;
	private double goodsPrice;
	private double goodsNumber;
	private String goodsDec;
	
	private Date inputTime;
	private double inputNumber;
	private String inputDec;
	
	private Date outputTime;
	private double outputNumber;
	private String outputDec;
	
	private Date borrowTime;
	private double borrowNumber;
	private String borrowDec;
	
	private Date rerurnTime;
	private double rerurnNumber;
	private String rerurnDec;
	
	private String mainSpond;
	private String borrower;
	
	
	public Form(int ID) {
		// TODO Auto-generated constructor stub
		goodsId = ID;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsID) {
		this.goodsId = goodsID;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public double getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(double goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getGoodsDec() {
		return goodsDec;
	}
	public void setGoodsDec(String goodsDec) {
		this.goodsDec = goodsDec;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	public double getInputNumber() {
		return inputNumber;
	}
	public void setInputNumber(double inputNumber) {
		this.inputNumber = inputNumber;
	}
	public String getInputDec() {
		return inputDec;
	}
	public void setInputDec(String inputDec) {
		this.inputDec = inputDec;
	}
	public Date getOutputTime() {
		return outputTime;
	}
	public void setOutputTime(Date outputTime) {
		this.outputTime = outputTime;
	}
	public double getOutputNumber() {
		return outputNumber;
	}
	public void setOutputNumber(double outputNumber) {
		this.outputNumber = outputNumber;
	}
	public String getOutputDec() {
		return outputDec;
	}
	public void setOutputDec(String outputDec) {
		this.outputDec = outputDec;
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
	public Date getRerurnTime() {
		return rerurnTime;
	}
	public void setRerurnTime(Date rerurnTime) {
		this.rerurnTime = rerurnTime;
	}
	public double getRerurnNumber() {
		return rerurnNumber;
	}
	public void setRerurnNumber(double rerurnNumber) {
		this.rerurnNumber = rerurnNumber;
	}
	public String getRerurnDec() {
		return rerurnDec;
	}
	public void setRerurnDec(String rerurnDec) {
		this.rerurnDec = rerurnDec;
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
