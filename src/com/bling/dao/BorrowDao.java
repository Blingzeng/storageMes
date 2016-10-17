package com.bling.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bling.bean.Goods;
import com.bling.bean.BorrowForm;
import com.bling.bean.returnForm;
import com.bling.util.Util;

public class BorrowDao extends StorageDao {

	/**
	 * @descrite 新增借出表记录操作
	 * @param BorrowForm
	 * @return
	 */
	public int addBorrow(BorrowForm BorrowForm) {
		int result = 0;
		try {
			String usingFormSql = "insert into borrowform values(?,?,?,?,?,?,?) ";
			preparedStatement = connection.prepareStatement(usingFormSql);
			preparedStatement.setInt(1, BorrowForm.getGoodsID());
			preparedStatement.setString(2, BorrowForm.getGoodsName());
			preparedStatement.setDate(3, BorrowForm.getBorrowTime());
			preparedStatement.setDouble(4, BorrowForm.getBorrowNumber());
			preparedStatement.setString(5, BorrowForm.getBorrowDec());
			preparedStatement.setString(6, BorrowForm.getMainSpond());
			preparedStatement.setString(7, BorrowForm.getBorrower());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(849);
			return 0;
		} finally {
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
	 * @descrite 这是一个查找方法，按照日期来查找
	 * @param date
	 * @return
	 */
	public ArrayList<BorrowForm> getBorrowForms(String date) {
		ArrayList<BorrowForm> BorrowForms = new ArrayList<>();
		String sql = "select * from borrowform where borrowTime = date('"+date+"')";
		ResultSet resultSet = getResultSet(sql);
	
		try {
			while(resultSet.next()){
				BorrowForm BorrowForm =new BorrowForm(resultSet.getInt(1));
				BorrowForm.setGoodsName(resultSet.getString(2));
				BorrowForm.setBorrowTime(resultSet.getDate(3));
				BorrowForm.setBorrowNumber(resultSet.getDouble(4));
				BorrowForm.setBorrowDec(resultSet.getString(5));
				BorrowForm.setMainSpond(resultSet.getString(6));
				BorrowForm.setBorrower(resultSet.getString(7));
				BorrowForms.add(BorrowForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BorrowForms;
	}
	
	/**
	 * @descrite 这是一个查找方法，按照日期范围来查找
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public ArrayList<BorrowForm> getBorrowForms(String dateStart,String dateEnd) {
		ArrayList<BorrowForm> BorrowForms = new ArrayList<>();
		String sql = "select * from borrowform where borrowTime >= date('"+dateStart+"') and borrowTime <= date('"+dateEnd+"')";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				BorrowForm BorrowForm =new BorrowForm(resultSet.getInt(1));
				BorrowForm.setGoodsName(resultSet.getString(2));
				BorrowForm.setBorrowTime(resultSet.getDate(3));
				BorrowForm.setBorrowNumber(resultSet.getDouble(4));
				BorrowForm.setBorrowDec(resultSet.getString(5));
				BorrowForm.setMainSpond(resultSet.getString(6));
				BorrowForm.setBorrower(resultSet.getString(7));
				BorrowForms.add(BorrowForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BorrowForms;
	}
	
	/**
	 * @descrite 这是一个查找方法，按照编号来来查找
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public ArrayList<BorrowForm> getBorrowForms(int goodsId) {
		ArrayList<BorrowForm> BorrowForms = new ArrayList<>();
		String sql = "select * from borrowform where goodsid='"+goodsId+"'";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				BorrowForm BorrowForm =new BorrowForm(resultSet.getInt(1));
				BorrowForm.setGoodsName(resultSet.getString(2));
				BorrowForm.setBorrowTime(resultSet.getDate(3));
				BorrowForm.setBorrowNumber(resultSet.getDouble(4));
				BorrowForm.setBorrowDec(resultSet.getString(5));
				BorrowForm.setMainSpond(resultSet.getString(6));
				BorrowForm.setBorrower(resultSet.getString(7));
				BorrowForms.add(BorrowForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BorrowForms;
	}
	
	/**
	 * @descrite 返回表中的全部
	 * @return
	 */
	
	public ArrayList<BorrowForm> getAllBorrowForms() {
		ArrayList<BorrowForm> borrowForms = new ArrayList<>();
		String sql = "select * from borrowform ";
		ResultSet resultSet = getResultSet(sql);
		BorrowForm borrowForm =null;
		try {
			while(resultSet.next()){
				borrowForm =new BorrowForm(resultSet.getInt(1));
				borrowForm.setGoodsName(resultSet.getString(2));
				borrowForm.setBorrowTime(resultSet.getDate(3));
				borrowForm.setBorrowNumber(resultSet.getDouble(4));
				borrowForm.setBorrowDec(resultSet.getString(5));
				borrowForm.setMainSpond(resultSet.getString(6));
				borrowForm.setBorrower(resultSet.getString(7));
				borrowForms.add(borrowForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return borrowForms;
	}
	
	
}
