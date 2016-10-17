package com.bling.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import com.bling.bean.Goods;
import com.bling.bean.returnForm;
import com.bling.util.Util;

public class GoodsDao extends StorageDao {

	/**
	 * @descrite 这是货品增加的方法，使用此方法需要传入一个货品对象，使用此方法后，可以在数据库增加一条货品记录。
	 * @param goods
	 * @return
	 */
	public int add(Goods goods) {
		int result = 0;
		String sql = "insert into goodsForm values(?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, goods.getGoodsId());
			preparedStatement.setString(2, goods.getGoodsName());
			preparedStatement.setDouble(3, goods.getGoodsPrice());
			preparedStatement.setDouble(4, goods.getGoodsNumber());
			preparedStatement.setString(5, goods.getGoodsDec());
			preparedStatement.setInt(6, goods.getUpLimit());
			preparedStatement.setInt(7, goods.getDowmLimit());
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
	 * @descrite 这是货品删除的方法，使用此方法需要传入一个货品对象，使用此方法后，可以在数据库删除相应的一条货品记录。
	 * 			 需要注意的是，当在货品表删除记录是，id查询表也会有删除的记录，
	 * 			 当货品的编号和名称不对应得时候，有可能会删除两个物品。
	 * @param goods
	 * @return
	 */
	public int delete(Goods goods) {
		int result = 0;
		String sql = "delete from goodsform where goodsId = ? ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, goods.getGoodsId());
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
	 * @descrite 这是一个根据物品的编号来更改物品信息的方法。使用该方法后会在数据库中更改相应的数据
	 * @param goods
	 * @return
	 */
	public int  updateOfId(Goods goods) {
		int result = 0;
		String sql = "update goodsform set goodsname = ?,goodsPrice = ?,goodsNumber = ?,goodsdec = ?,upLimit = ?,dowmlimit = ? where goodsid = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, goods.getGoodsName());
			preparedStatement.setDouble(2, goods.getGoodsPrice());
			preparedStatement.setDouble(3, goods.getGoodsNumber());
			preparedStatement.setString(4, goods.getGoodsDec());
			preparedStatement.setInt(5, goods.getUpLimit());
			preparedStatement.setInt(6, goods.getDowmLimit());
			preparedStatement.setInt(7, goods.getGoodsId());
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
	
//	/**
//	 * @descrite 这是一个根据物品的名称来更改物品的编号。使用该方法后会在数据库中更改相应的数据
//	 * 			 有一个问题：假若有两个物品的名称是一样的，那么在使用此方法后会报错。
//				此方法不安全，
//	 * @param goods
//	 * @return
//	 */
//	public int updateOfName(Goods goods) {
//		int result = 0;
//		String sql = "update form goodsform set goodsid = ? where goodsname = ?";
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, goods.getGoodsId());
//			preparedStatement.setString(2, goods.getGoodsName());
//			result = preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			try {
//				Util.close(preparedStatement, connection);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}
	
	/**
	 * @descrite 这是通过物品编号来查询物品的相关信息的方法。
	 * @param goodsId
	 * @return
	 */
	public Goods searchOfid(int goodsId) {
		String sql = "select * from goodsform where goodsid = "+goodsId;
		ResultSet resultSet = getResultSet(sql);
		try {
			resultSet.next();
			Goods goods = new Goods(resultSet.getInt(1));
			goods.setGoodsName(resultSet.getString(2));
			goods.setGoodsPrice(resultSet.getDouble(3));
			goods.setGoodsNumber(resultSet.getDouble(4));
			goods.setGoodsDec(resultSet.getString(5));
			goods.setUpLimit(resultSet.getInt(6));
			goods.setDowmLimit(resultSet.getInt(7));
			return goods;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @descrite 这是通过物品名称来查询物品的相关信息的方法。
	 * @param goodsName
	 * @return
	 */
	public TreeSet<Goods> searchOfid(String goodsName) {
		TreeSet<Goods> treeSet = new TreeSet<>();
		String sql = "select * from goodsform where goodsid = "+goodsName;
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				Goods goods = new Goods(resultSet.getInt(1));
				goods.setGoodsName(resultSet.getString(2));
				goods.setGoodsPrice(resultSet.getDouble(3));
				goods.setGoodsNumber(resultSet.getDouble(4));
				goods.setGoodsDec(resultSet.getString(5));
				goods.setUpLimit(resultSet.getInt(6));
				goods.setDowmLimit(resultSet.getInt(7));
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
