package com.bling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bling.bean.outputForm;
import com.bling.bean.outputForm;
import com.bling.util.Util;

public class OutputDao extends StorageDao{
	
	
	/**
	 * @descrite 新增出库操作
	 * @param outputForm
	 * @return
	 */
	public int addOutput(outputForm outputForm) {
		int result = 0;
		try {
			String usingFormSql = "insert into outputForm values(?,?,?,?,?,?) ";
			preparedStatement = connection.prepareStatement(usingFormSql);
			preparedStatement.setInt(1, outputForm.getGoodsID());
			preparedStatement.setString(2, outputForm.getGoodsName());
			preparedStatement.setDate(3, outputForm.getOutputTime());
			preparedStatement.setDouble(4, outputForm.getOutputNumber());
			preparedStatement.setString(5, outputForm.getOutputDec());
			preparedStatement.setString(6, outputForm.getMainSpond());
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
	 * @descrite 这是一个查找方法，按照日期来查找，日期的格式是yyyy-mm-dd
	 * @param date
	 * @return
	 */
	public ArrayList<outputForm> getOutputForms(String date) {
		ArrayList<outputForm> outputForms = new ArrayList<>();
		String sql = "select * from outputform where outputtime = date('"+date+"')";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				outputForm outputForm =new outputForm(resultSet.getInt(1));
				outputForm.setGoodsName(resultSet.getString(2));
				outputForm.setOutputTime(resultSet.getDate(3));
				outputForm.setOutputNumber(resultSet.getDouble(4));
				outputForm.setOutputDec(resultSet.getString(5));
				outputForm.setMainSpond(resultSet.getString(6));
				outputForms.add(outputForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputForms;
	}
	
	/**
	 * @descrite 这是一个查找方法，按照日期范围来查找
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public ArrayList<outputForm> getOutputForms(String dateStart,String dateEnd) {
		ArrayList<outputForm> outputForms = new ArrayList<>();
		String sql = "select * from outputform where outputtime >= date('"+dateStart+"') and outputtime <= date('"+dateEnd+"')";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				outputForm outputForm =new outputForm(resultSet.getInt(1));
				outputForm.setGoodsName(resultSet.getString(2));
				outputForm.setOutputTime(resultSet.getDate(3));
				outputForm.setOutputNumber(resultSet.getDouble(4));
				outputForm.setOutputDec(resultSet.getString(5));
				outputForm.setMainSpond(resultSet.getString(6));
				outputForms.add(outputForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputForms;
	}
	
	/**
	 * @descrite 这是一个查找方法，按照编号来来查找
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 * 
	 */
	public ArrayList<outputForm> getOutputForms(int goodsId) {
		ArrayList<outputForm> outputForms = null;
		String sql = "select * from outputform where goodsid='"+goodsId+"'";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				outputForm outputForm =new outputForm(resultSet.getInt(1));
				outputForm.setGoodsName(resultSet.getString(2));
				outputForm.setOutputTime(resultSet.getDate(3));
				outputForm.setOutputNumber(resultSet.getDouble(4));
				outputForm.setOutputDec(resultSet.getString(5));
				outputForm.setMainSpond(resultSet.getString(6));
				outputForms.add(outputForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputForms;
	}
	
	/**
	 * @descrite 返回表中的全部
	 * @return
	 * 
	 */
	
	public ArrayList<outputForm> getAllOutputForms() {
		ArrayList<outputForm> outputForms = null;
		String sql = "select * from outputform ";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				outputForm outputForm =new outputForm(resultSet.getInt(1));
				outputForm.setGoodsName(resultSet.getString(2));
				outputForm.setOutputTime(resultSet.getDate(3));
				outputForm.setOutputNumber(resultSet.getDouble(4));
				outputForm.setOutputDec(resultSet.getString(5));
				outputForm.setMainSpond(resultSet.getString(6));
				outputForms.add(outputForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputForms;
	}
}
