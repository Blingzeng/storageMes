package com.bling.bean;

import java.sql.Date;

public class outputForm {

	private int goodsID;
	private String goodsName;
	private Date outputTime;
	private double outputNumber;
	private String outputDec;
	private String mainSpond;
	
	
	
	@Override
	public String toString() {
		return "出库单 [物品编号=" + goodsID + ", 物品名称=" + goodsName
				+ ", 出库时间=" + outputTime + ", 出库数量="
				+ outputNumber + ", 出库描述=" + outputDec + ", 负责人="
				+ mainSpond + "]";
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public outputForm(int goodsID) {
		// TODO Auto-generated constructor stub
		this.goodsID = goodsID;
	}
	public int getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
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
	public String getMainSpond() {
		return mainSpond;
	}
	public void setMainSpond(String mainSpond) {
		this.mainSpond = mainSpond;
	}
	
	
}
