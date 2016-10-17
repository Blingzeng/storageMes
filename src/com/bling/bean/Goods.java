package com.bling.bean;

/**
 * 
 * @author  Bling
 * @descrite 这是一个描述物品的类，它的属性有：物品编号，物品名称，物品单价，物品数量，物品描述
 *
 */
public class Goods implements Comparable<Goods>{

	private int goodsID;
	private String goodsName;
	private double goodsPrice;
	private double goodsNumber;
	private String goodsDec;
	private int upLimit;
	private int dowmLimit;
	
	
	@Override
	public String toString() {
		return "物品 [物品编号=" + goodsID + ", 物品名称=" + goodsName
				+ ", 物品单价=" + goodsPrice + ", 物品数量=" + goodsNumber
				+ ", 物品描述=" + goodsDec + ", 物品上限=" + upLimit
				+ ", 物品下限=" + dowmLimit + "]";
	}
	public int getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
	}
	public int getUpLimit() {
		return upLimit;
	}
	public void setUpLimit(int upLimit) {
		this.upLimit = upLimit;
	}
	public int getDowmLimit() {
		return dowmLimit;
	}
	public void setDowmLimit(int dowmLimit) {
		this.dowmLimit = dowmLimit;
	}
	public Goods(int i) {
		// TODO Auto-generated constructor stub
		goodsID = i;
	}
	public int getGoodsId() {
		return goodsID;
	}
	public void setGoodsId(int goodsId) {
		this.goodsID = goodsId;
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
	@Override
	public int compareTo(Goods goods) {
		// TODO Auto-generated method stub
		return goodsID-goods.getGoodsId();
	}
	
	
	
	
	
}
