package com.bling.bean;

import java.sql.Date;

public class returnForm {

	private int goodsID;
	private String goodsName;
	private Date returnTime;
	private double returnNumber;
	private String returnDec;
	private String returner;
	private String mainSpond;
	
	
	
	@Override
	public String toString() {
		return "还库单 [物品编号=" + goodsID + ", 物品名称=" + goodsName
				+ ", 还库时间=" + returnTime + ", 还库数量="
				+ returnNumber + ", 还库描述=" + returnDec + ", 还款人="
				+ returner + ", 负责人=" + mainSpond + "]";
	}
	public String getReturner() {
		return returner;
	}
	public void setReturner(String returner) {
		this.returner = returner;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public returnForm(int goodsID) {
		// TODO Auto-generated constructor stub
		this.goodsID = goodsID;
	}
	public int getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
	}
	public Date getRerurnTime() {
		return returnTime;
	}
	public void setReturnTime(Date rerurnTime) {
		this.returnTime = rerurnTime;
	}
	public double getReturnNumber() {
		return returnNumber;
	}
	public void setReturnNumber(double rerurnNumber) {
		this.returnNumber = rerurnNumber;
	}
	public String getReturnDec() {
		return returnDec;
	}
	public void setReturnDec(String rerurnDec) {
		this.returnDec = rerurnDec;
	}
	public String getMainSpond() {
		return mainSpond;
	}
	public void setMainSpond(String mainSpond) {
		this.mainSpond = mainSpond;
	}
	
	
	
}
