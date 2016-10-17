package com.bling.test;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

import com.bling.bean.Form;
import com.bling.bean.Goods;
import com.bling.bean.InputForm;
import com.bling.bean.BorrowForm;
import com.bling.dao.BorrowDao;
import com.bling.dao.GoodsDao;
import com.bling.dao.IdSerch;
import com.bling.dao.InputDao;
import com.bling.dao.StorageDao;
import com.bling.service.StorageSer;
import com.bling.util.Util;

public class TT {
	Date d = new Date(System.currentTimeMillis());
//	@Test
//	public void test() {
//		StorageDao s = new StorageDao();
//		Form form = new Form("13");
//		form.setGoodsName("书架");
//		form.setGoodsPrice(500);
//		form.setGoodsNumber(10);
//		form.setGoodsDec("图书馆使用，每个教室也可分配一个");
//		
//		form.setInputTime(d);
//		form.setInputNumber(10);
//		form.setInputDec("银行捐赠");
//		
//		s.add(form);
//	}
	
//	@Test
//	public void add() throws SQLException{
//		Connection connection = Util.getConnection();
//		String goodsFormSql = "insert into goodsform values(?,?,?,?,?)";
//		PreparedStatement preparedStatement = connection.prepareStatement(goodsFormSql);
//		preparedStatement.setString(1, "5");
//		preparedStatement.setString(2, "����");
//		preparedStatement.setDouble(3, 20);
//		preparedStatement.setDouble(4, 45);
//		preparedStatement.setString(5, "û������");
//	}
	
//	@Test
//	public void add() {
//		Goods goods = new Goods(35);
//		goods.setGoodsName("电池");
//		goods.setGoodsPrice(4);
//		goods.setGoodsNumber(100);
//		goods.setGoodsDec("五号电池");
//		
//		InputForm inputForm = new InputForm(35);
//		inputForm.setGoodsName("电池");
//		inputForm.setInputTime(Util.getDate());
//		inputForm.setInputNumber(100);
//		inputForm.setInputDec("五号电池");
//		inputForm.setMainSpond("奥巴马");
//		
//		StorageDao storageDao = new StorageDao();
//		storageDao.addNew(goods, inputForm);
//	}

	
	public void add() {
		BorrowForm BorrowForm = new BorrowForm(10);
		BorrowForm.setGoodsName("粉笔");
		BorrowForm.setBorrowTime(Util.getDate());
		BorrowForm.setBorrowNumber(100);
		BorrowForm.setBorrowDec("单位是盒");
		BorrowForm.setMainSpond("分解");
		BorrowForm.setBorrower("几时");
		
		BorrowDao borrowDao = new BorrowDao();
		borrowDao.addBorrow(BorrowForm);
		
	}
	

	public void test(){
		Date date = null;
		date=date.valueOf("2015-11-17");
		System.out.println(date);
	}
	

	public void search(){
		BorrowDao dao =new BorrowDao();
		ArrayList<BorrowForm> borrowForms = dao.getAllBorrowForms();
		for(Iterator<BorrowForm> iterator = borrowForms.iterator();iterator.hasNext();) {
			BorrowForm BorrowForm = iterator.next();
			System.out.println(BorrowForm.getGoodsName());
		}
		
		
	}
	

	public void resultSet(){
		StorageDao dao = new StorageDao();
		ResultSet resultSet = dao.getResultSet("select * from borrowform ");
		try {
			while(resultSet.next()){
				int s=resultSet.getInt(1);
				System.out.println(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void idsearch(){
		int goodsid = 3;
		StorageSer ser = new StorageSer();
		boolean flag = ser.idIsTrue(goodsid);
		System.out.println(flag);
		
	}
	
	
	public void updateOfIdTest(){
		GoodsDao dao = new GoodsDao();
		Goods goods  = new Goods(3);
		goods.setGoodsDec("老师喜欢");
		goods.setDowmLimit(0);
		goods.setGoodsName("大黑板");
		goods.setGoodsNumber(110);
		goods.setGoodsPrice(100);
		goods.setUpLimit(10000);
		dao.updateOfId(goods);
		
	}

	public void getInputFormsTest(){
		InputDao inputDao = new InputDao();
		ArrayList<InputForm> inputForms = inputDao.getInputForms("2016-5-31");
		for(Iterator<InputForm> iterator = inputForms.iterator();iterator.hasNext();)
		{
			InputForm inputForm = iterator.next();
			System.out.println(inputForm.toString());
		}
	}
	
	@Test
	public void getGoodsId(){
		IdSerch idSerch = new IdSerch();
		TreeSet<Goods> treeSet = idSerch.searchOfName("小黑板");
		for(Iterator<Goods> iterator = treeSet.iterator();iterator.hasNext();){
			System.out.println(iterator.next().getGoodsId());
		}
		Goods goods = idSerch.searchOfid(3);
		System.out.println(goods.getGoodsName());
	}
	
}
