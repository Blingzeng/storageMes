package com.bling.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bling.bean.BorrowForm;
import com.bling.bean.returnForm;
import com.bling.bean.returnForm;
import com.bling.util.Util;

public class ReturnDao extends StorageDao {

	/**
	 * @descrite 新增还库操作
	 * @param returnForm
	 * @return
	 */
	public int addReturn(returnForm returnForm) {
		int result = 0;
		String sql = "insert into returnForm values(?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, returnForm.getGoodsID());
			preparedStatement.setString(2, returnForm.getGoodsName());
			preparedStatement.setDate(3, returnForm.getRerurnTime());
			preparedStatement.setDouble(4, returnForm.getReturnNumber());
			preparedStatement.setString(5, returnForm.getReturnDec());
			preparedStatement.setString(6, returnForm.getMainSpond());
			preparedStatement.setString(7, returnForm.getReturner());
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
	 * @descrite 这是一个查找方法，按照日期来查找
	 * @param date
	 * @return
	 */
	public ArrayList<returnForm> getReturnForms(String date) {
		ArrayList<returnForm> returnForms = new ArrayList<returnForm>();
		String sql = "select * from borrowform where borrowTime = date('"+date+"')";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				returnForm returnForm =new returnForm(resultSet.getInt(1));
				returnForm.setGoodsName(resultSet.getString(2));
				returnForm.setReturnTime(resultSet.getDate(3));
				returnForm.setReturnNumber(resultSet.getDouble(4));
				returnForm.setReturnDec(resultSet.getString(5));
				returnForm.setMainSpond(resultSet.getString(6));
				returnForm.setReturner(resultSet.getString(7));
				returnForms.add(returnForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnForms;
	}
	
	/**
	 * @descrite 这是一个查找方法，按照日期范围来查找
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public ArrayList<returnForm> getReturnForms(String dateStart,String dateEnd) {
		ArrayList<returnForm> returnForms = new ArrayList<>();;
		String sql = "select * from borrowform where borrowTime >= date('"+dateStart+"') and borrowTime <= date('"+dateEnd+"')";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				returnForm returnForm =new returnForm(resultSet.getInt(1));
				returnForm.setGoodsName(resultSet.getString(2));
				returnForm.setReturnTime(resultSet.getDate(3));
				returnForm.setReturnNumber(resultSet.getDouble(4));
				returnForm.setReturnDec(resultSet.getString(5));
				returnForm.setMainSpond(resultSet.getString(6));
				returnForm.setReturner(resultSet.getString(7));
				returnForms.add(returnForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnForms;
	}
	
	/**
	 * @descrite 这是一个查找方法，按照编号来来查找
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public ArrayList<returnForm> getReturnForms(int goodsId) {
		ArrayList<returnForm> returnForms = new ArrayList<>();
		String sql = "select * from borrowform where goodsid='"+goodsId+"'";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				returnForm returnForm =new returnForm(resultSet.getInt(1));
				returnForm.setGoodsName(resultSet.getString(2));
				returnForm.setReturnTime(resultSet.getDate(3));
				returnForm.setReturnNumber(resultSet.getDouble(4));
				returnForm.setReturnDec(resultSet.getString(5));
				returnForm.setMainSpond(resultSet.getString(6));
				returnForm.setReturner(resultSet.getString(7));
				returnForms.add(returnForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnForms;
	}
	
	/**
	 * @descrite 返回表中的全部
	 * @return
	 */
	
	public ArrayList<returnForm> getAllReturnForms() {
		ArrayList<returnForm> returnForms = new ArrayList<>();
		String sql = "select * from borrowform ";
		ResultSet resultSet = getResultSet(sql);
		returnForm borrowForm =null;
		try {
			while(resultSet.next()){
				returnForm returnForm =new returnForm(resultSet.getInt(1));
				returnForm.setGoodsName(resultSet.getString(2));
				returnForm.setReturnTime(resultSet.getDate(3));
				returnForm.setReturnNumber(resultSet.getDouble(4));
				returnForm.setReturnDec(resultSet.getString(5));
				returnForm.setMainSpond(resultSet.getString(6));
				returnForm.setReturner(resultSet.getString(7));
				returnForms.add(returnForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnForms;
	}

	
	
}
