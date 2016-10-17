package com.bling.bean;

import java.sql.Date;

public class InputForm {

	private  int goodsID;
	private String goodsName;
	private Date inputTime;
	private double inputNumber;
	private String inputDec;
	private String mainSpond;
	
	
	@Override
	public String toString() {
		return "入库单 [物品编号=" + goodsID + ", 物品名称=" + goodsName
				+ ", 入库时间=" + inputTime + ", 入库数量=" + inputNumber
				+ ", 入库描述=" + inputDec + ", 负责人=" + mainSpond + "]";
	}
	public String getMainSpond() {
		return mainSpond;
	}
	public void setMainSpond(String mainSpond) {
		this.mainSpond = mainSpond;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public InputForm(int goodsId) {
		// TODO Auto-generated constructor stub
		goodsID = goodsId;
	}
	
	public int getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
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
	
	
}
