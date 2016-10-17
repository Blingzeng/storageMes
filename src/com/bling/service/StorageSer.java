package com.bling.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import com.bling.bean.BorrowForm;
import com.bling.bean.Goods;
import com.bling.bean.InputForm;
import com.bling.bean.outputForm;
import com.bling.bean.returnForm;
import com.bling.dao.BorrowDao;
import com.bling.dao.GoodsDao;
import com.bling.dao.IdSerch;
import com.bling.dao.InputDao;
import com.bling.dao.OutputDao;
import com.bling.dao.ReturnDao;

public class StorageSer {

	/**
	 * @descrite 调用dao层的方法，
	 */
	private BorrowDao borrowDao = new BorrowDao();
	private GoodsDao goodsDao = new GoodsDao();
	private IdSerch idSerch = new IdSerch();
	private InputDao inputDao = new InputDao();
	private OutputDao outputDao = new OutputDao();
	private ReturnDao returnDao = new ReturnDao();
	
	/**
	 * @descrite goods对象中id和名称一定要具备，inputform对象中时间和主要负责人一定要具备
	 * @param goods
	 * @param inputForm
	 * @return
	 */
	public boolean add(Goods goods,InputForm inputForm) {
		//在货物表中增加
		goodsDao.add(goods);
		//在id查询表中增加
		idSerch.add(goods);
		//在入库表中增加
		inputDao.addIput(inputForm);
		return true;
	}
	
	/**
	 * @descrite 增加入库操作，并且改变goods中的数量
	 * 			先判断物品是否在仓库是否存在，若存在在判断在数量上是否可以操作，
	 * 			若都为真，则表明此方法可以执行，返回真
	 * @param inputForm
	 * @return
	 */
	public boolean addInputform(InputForm inputForm) {

		int temp = inputForm.getGoodsID();
		if(idIsTrue(temp)){
			if (setNumberForGoods(temp, inputForm.getInputNumber())){
				inputDao.addIput(inputForm);
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * @descrite 增加出库库操作，并且改变goods表中的数量
	 * 			先判断物品是否在仓库是否存在，若存在在判断在数量上是否可以操作，
	 * 			若都为真，则表明此方法可以执行，返回真
	 * @param outputForm
	 * @return
	 */
	public boolean addOutputForm(outputForm outputForm) {
		
		int temp = outputForm.getGoodsID();
		if(idIsTrue(temp)){
			if(setNumberForGoods(temp, -outputForm.getOutputNumber())){
				outputDao.addOutput(outputForm);
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 *  @descrite 增加借出库操作，并且改变goods表中的数量
	 * 			先判断物品是否在仓库是否存在，若存在在判断在数量上是否可以操作，
	 * 			若都为真，则表明此方法可以执行，返回真
	 * @param borrowForm
	 * @return
	 */
	public boolean addBorrowForm(BorrowForm borrowForm) {
		int temp = borrowForm.getGoodsID();
		if(idIsTrue(temp)){
			if(setNumberForGoods(temp, -borrowForm.getBorrowNumber())){
				borrowDao.addBorrow(borrowForm);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @descrite 增加还库操作，并且改变goods表中的数量
	 * 			先判断物品是否在仓库是否存在，若存在在判断在数量上是否可以操作，
	 * 			若都为真，则表明此方法可以执行，返回真
	 * @param returnForm
	 * @return
	 */
	public boolean  addReturnForm(returnForm returnForm) {
		int temp = returnForm.getGoodsID();
		if(idIsTrue(temp)){
			if(setNumberForGoods(temp, returnForm.getReturnNumber())){
				returnDao.addReturn(returnForm);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @descrite 这是一个删除的方法，将goods表中的物品删除，通过数据库的关联，也将其他表中相同的Id的物品删除
	 * @param goods
	 * @return
	 */
	public boolean deleteGoods(Goods goods) {
		if(idIsTrue(goods.getGoodsId())){
			goodsDao.delete(goods);
			return true;
		}
		return false;
	}
	
	/**
	 * @descrite 这是一个更新的方法，在更新之前先判断数量书否超出限制，如果没有的话，则返回真，如果超过的话则不执行，返回假。
	 * 			 编号和名称会因为数据库的关联而在其他表中做出相应的改变
	 * @param goods
	 * @return
	 */
	public boolean update(Goods goods) {
		int temp = goods.getGoodsId();
		if(idIsTrue(temp)){
			if(goods.getGoodsNumber()>goods.getDowmLimit()&&goods.getGoodsNumber()<goods.getUpLimit()){
				goodsDao.updateOfId(goods);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @descrite 获取全部物品的编号和名称
	 * @return 一个goods集合，但是goods中只带有两个属性
	 */
	public TreeSet<Goods> getAllGoodsOfIdAndName() {
		TreeSet<Goods> treeSet = new TreeSet<>();
		treeSet = idSerch.searchAll();
		return treeSet;
	}
	
	/**
	 * @descrite 通过id获取物品的名称
	 * @param goodsId
	 * @return
	 */
	public String getGoodName(int goodsId) {
		if(idIsTrue(goodsId)){
			Goods goods = idSerch.searchOfid(goodsId);
			return goods.getGoodsName();
		}
		return null;
	}
	
	/**
	 * @descrite 通过物品名称来查找物品的编号
	 * @param goodsName
	 * @return
	 */
	public TreeSet<Goods> getGoodsId(String goodsName) {
		TreeSet<Goods> treeSet = idSerch.searchOfName(goodsName);
		return treeSet;
	}
	
	
	/**
	 * @desrite 通过id查询得到一个物品的全部信息
	 * @param goodsId
	 * @return
	 */
	public Goods getGoods(int goodsId) {
		if(idIsTrue(goodsId)){
			Goods goods = goodsDao.searchOfid(goodsId);
			return goods;
		}
		return null;
	}
	
	/**
	 * @descrite 通过一个日期查询当天的入库单
	 * @param date
	 * @return
	 */
	public ArrayList<InputForm> getInputFormForDate(String date) {
		ArrayList<InputForm> arrayList = new ArrayList<>();
		arrayList = inputDao.getInputForms(date);
		return arrayList;
	}
	
	/**
	 * @descrite 通过一个日期查询当天的出库单
	 * @param date
	 * @return
	 */
	public ArrayList<outputForm> getOutputForDate(String date) {
		ArrayList<outputForm> arrayList = outputDao.getOutputForms(date);
		return arrayList;
	}
	
	/**
	 * @descrite 通过一个日期查询当天的借出单
	 * @param date
	 * @return
	 */
	public ArrayList<BorrowForm> getBorrowForDate(String date) {
		ArrayList<BorrowForm> arrayList	= borrowDao.getBorrowForms(date);
		return arrayList;
	}
	
	/**
	 * @descrite 通过一个日期查询当天的还库单
	 * @param date
	 * @return
	 */
	public ArrayList<returnForm> getReturnForDate(String date) {
		ArrayList<returnForm> arrayList = returnDao.getReturnForms(date);
		return arrayList;
	}
	
	
	/**
	 * @descrite 通过一个日期范围查询入库单
	 * @param date
	 * @return
	 */
	public ArrayList<InputForm> getInputFormForDate(String date,String dateEnd) {
		ArrayList<InputForm> arrayList = new ArrayList<>();
		arrayList = inputDao.getInputForms(date,dateEnd);
		return arrayList;
	}
	
	
	/**
	 * @descrite 通过一个日期范围查询出库单
	 * @param date
	 * @return
	 */
	public ArrayList<outputForm> getOutputForDate(String date,String dateEnd) {
		ArrayList<outputForm> arrayList = outputDao.getOutputForms(date,dateEnd);
		return arrayList;
	}
	
	/**
	 * @descrite 通过一个日期范围查询借出单
	 * @param date
	 * @return
	 */
	public ArrayList<BorrowForm> getBorrowForDate(String date,String dateEnd) {
		ArrayList<BorrowForm> arrayList	= borrowDao.getBorrowForms(date,dateEnd);
		return arrayList;
	}
	
	/**
	 * @descrite 通过一个日期范围查询还库单
	 * @param date
	 * @return
	 */
	public ArrayList<returnForm> getReturnForDate(String date,String dateEnd) {
		ArrayList<returnForm> arrayList = returnDao.getReturnForms(date,dateEnd);
		return arrayList;
	}
	
	/**
	 * @descrite 通过一个日期查询当天的入库单
	 * @param date
	 * @return
	 */
	public ArrayList<InputForm> getInputFormForId(int goodsId) {
		ArrayList<InputForm> arrayList = new ArrayList<>();
		arrayList = inputDao.getInputForms(goodsId);
		return arrayList;
	}
	
	/**
	 * @descrite 通过一个日期查询当天的出库单
	 * @param date
	 * @return
	 */
	public ArrayList<outputForm> getOutputForId(int goodsId) {
		ArrayList<outputForm> arrayList = outputDao.getOutputForms(goodsId);
		return arrayList;
	}
	
	/**
	 * @descrite 通过一个日期查询当天的借出单
	 * @param date
	 * @return
	 */
	public ArrayList<BorrowForm> getBorrowForId(int goodsId) {
		ArrayList<BorrowForm> arrayList	= borrowDao.getBorrowForms(goodsId);
		return arrayList;
	}
	
	/**
	 * @descrite 通过一个日期查询当天的还库单
	 * @param date
	 * @return
	 */
	public ArrayList<returnForm> getReturnForId(int goodsId) {
		ArrayList<returnForm> arrayList = returnDao.getReturnForms(goodsId);
		return arrayList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @descrite 私有方法 ，更改物品的数量，通过id来查询一个物品，然后通过对数量的操作，判断时候可以执行，若是可以执行则返回真
	 * 			 若是不可以执行，则返回假
	 * @param goodsId
	 * @param number
	 * @return
	 */
	private boolean setNumberForGoods(int goodsId,double number){
		Goods goods = goodsDao.searchOfid(goodsId);
		double temp = goods.getGoodsNumber()+number;
		
		if(temp<goods.getDowmLimit()&&temp>goods.getUpLimit()) 
			return false;
		
		goods.setGoodsNumber(temp);
		goodsDao.updateOfId(goods);
		return true;
	}
	
	/**
	 * @descrite 通过在id查询表中匹配，若匹配成功则返回真，若匹配失败则返回假
	 * @param goodsId
	 * @return
	 */
	public boolean idIsTrue(int goodsId)
	{
		TreeSet<Goods> treeSet = idSerch.searchAll();
		if(treeSet!=null){
			for(Iterator<Goods> iterator = treeSet.iterator();iterator.hasNext();)
			{
				Goods goods = iterator.next();
				if(goods.getGoodsId()==goodsId)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
}
