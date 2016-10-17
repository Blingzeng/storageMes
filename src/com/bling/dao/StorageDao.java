package com.bling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.print.DocFlavor.INPUT_STREAM;

import com.bling.bean.Form;
import com.bling.bean.Goods;
import com.bling.bean.InputForm;
import com.bling.bean.BorrowForm;
import com.bling.bean.outputForm;
import com.bling.bean.returnForm;
import com.bling.util.Util;

public class StorageDao {

	//获取数据库连接
	protected Connection connection = Util.getConnection();
	//使用preparedStatement 方法来实现对数据库的增删改查
	protected PreparedStatement preparedStatement = null;
	
	
	/**
	 * @descrite 这是一个获取物品resultSet集合的类，
	 * 			 resultSet中的值取决于你传入的sql语句。
	 * 			 若语句错误或数据库中没有数据则返回空
	 * @param sql
	 * @return
	 */
	public ResultSet getResultSet(String sql) {
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
//	/**
//	 * @descrite 增加一条新的纪录，在货物表，id查询表，入库表中增加新纪录
//	 * @param goods
//	 * @param inputForm
//	 * @return
//	 */
//	public int addNew(Goods goods,InputForm inputForm) {
//		
//		try {
//			String goodsFormSql = "insert into goodsform values(?,?,?,?,?)";
//			preparedStatement = connection.prepareStatement(goodsFormSql);
//			preparedStatement.setInt(1, goods.getGoodsId());
//			preparedStatement.setString(2, goods.getGoodsName());
//			preparedStatement.setDouble(3, goods.getGoodsPrice());
//			preparedStatement.setDouble(4, goods.getGoodsNumber());
//			preparedStatement.setString(5, goods.getGoodsDec());
//			int result = preparedStatement.executeUpdate();
//			
//			String usingFormSql = "insert into inputForm values(?,?,?,?,?,?) ";
//			preparedStatement = connection.prepareStatement(usingFormSql);
//			preparedStatement.setInt(1, inputForm.getGoodsID());
//			preparedStatement.setString(2, inputForm.getGoodsName());
//			preparedStatement.setDate(3, inputForm.getInputTime());
//			preparedStatement.setDouble(4, inputForm.getInputNumber());
//			preparedStatement.setString(5, inputForm.getInputDec());
//			preparedStatement.setString(6, inputForm.getMainSpond());
//			int result1 = preparedStatement.executeUpdate();
//			
//			String idFormSql = "insert into idForm values(?,?)";
//			preparedStatement = connection.prepareStatement(idFormSql);
//			preparedStatement.setInt(1, goods.getGoodsId());
//			preparedStatement.setString(2, goods.getGoodsName());
//			int result2 = preparedStatement.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(849);
//			return 0;
//		}
//		finally{
//			try {
//				Util.close(preparedStatement, connection);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return 1;
//	}
	
	
	
	
	
	
	
	
}
