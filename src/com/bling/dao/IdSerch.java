package com.bling.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import com.bling.bean.Goods;
import com.bling.bean.returnForm;
import com.bling.util.Util;

public class IdSerch extends StorageDao{

	/**
	 * @descrite 此方法不能单独使用，必须伴随着goods的增加而增加
	 * @param goods
	 * @return
	 */
	public int add(Goods goods) {
		int result = 0;
		String sql = "insert into idform values(?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, goods.getGoodsId());
			preparedStatement.setString(2, goods.getGoodsName());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				Util.close(preparedStatement, connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * @descrite 这是通过物品编号来查询物品的相关信息的方法。
	 * @param goodsName
	 * @return
	 */
	public Goods searchOfid(int goodsId) {
		String sql = "select * from idform where goodsid = '"+goodsId+"'";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				Goods goods = new Goods(resultSet.getInt(1));
				goods.setGoodsName(resultSet.getString(2));
				return goods;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @descrite 这是通过物品名称来查询物品编号方法。
	 * @param goodsName
	 * @return
	 */
	public TreeSet<Goods> searchOfName(String goodsName) {
		TreeSet<Goods> treeSet = new TreeSet<>();
		String sql = "select * from idform where goodsname = '"+goodsName+"'";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				Goods goods = new Goods(resultSet.getInt(1));
				goods.setGoodsName(resultSet.getString(2));
				treeSet.add(goods);
			}
			return treeSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return treeSet;
		}
	}
	
	
	/**
	 * @descrite 这个方法可以得到全部的物品的编号的和名称
	 * @return
	 */
	public TreeSet<Goods> searchAll() {
		TreeSet<Goods> treeSet = new TreeSet<Goods>();
		String sql = "select * from idform ";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				Goods goods = new Goods(resultSet.getInt(1));
				goods.setGoodsName(resultSet.getString(2));
				treeSet.add(goods);
			}
			return treeSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return treeSet;
		}
	}
	
}
