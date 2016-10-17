package com.bling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bling.bean.InputForm;
import com.bling.bean.InputForm;
import com.bling.bean.returnForm;
import com.bling.util.Util;

public class InputDao extends StorageDao{

	
	/**
	 * @descrite 新增入库操作
	 * @param inputForm
	 * @return
	 */
	public int addIput(InputForm inputForm) {
		int result = 0;
		try {
			String usingFormSql = "insert into inputForm values(?,?,?,?,?,?) ";
			preparedStatement = connection.prepareStatement(usingFormSql);
			preparedStatement.setInt(1, inputForm.getGoodsID());
			preparedStatement.setString(2, inputForm.getGoodsName());
			preparedStatement.setDate(3, inputForm.getInputTime());
			preparedStatement.setDouble(4, inputForm.getInputNumber());
			preparedStatement.setString(5, inputForm.getInputDec());
			preparedStatement.setString(6, inputForm.getMainSpond());
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
	public ArrayList<InputForm> getInputForms(String date) {
		ArrayList<InputForm> inputForms = new ArrayList<>();
		String sql = "select * from inputform where inputtime = date('"+date+"')";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				InputForm inputForm =new InputForm(resultSet.getInt(1));
				inputForm.setGoodsName(resultSet.getString(2));
				inputForm.setInputTime(resultSet.getDate(3));
				inputForm.setInputNumber(resultSet.getDouble(4));
				inputForm.setInputDec(resultSet.getString(5));
				inputForm.setMainSpond(resultSet.getString(6));
				inputForms.add(inputForm);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return inputForms;
	}
	
	/**
	 * @descrite 这是一个查找方法，按照日期范围来查找
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public ArrayList<InputForm> getInputForms(String dateStart,String dateEnd) {
		ArrayList<InputForm> inputForms = new ArrayList<>();
		String sql = "select * from inputform where inputtime >= date('"+dateStart+"') and inputtime <= date('"+dateEnd+"')";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				InputForm inputForm =new InputForm(resultSet.getInt(1));
				inputForm.setGoodsName(resultSet.getString(2));
				inputForm.setInputTime(resultSet.getDate(3));
				inputForm.setInputNumber(resultSet.getDouble(4));
				inputForm.setInputDec(resultSet.getString(5));
				inputForm.setMainSpond(resultSet.getString(6));
				inputForms.add(inputForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputForms;
	}
	
	/**
	 * @descrite 这是一个查找方法，按照编号来来查找
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public ArrayList<InputForm> getInputForms(int goodsId) {
		ArrayList<InputForm> inputForms =new ArrayList<>();
		String sql = "select * from inputform where goodsid='"+goodsId+"'";
		ResultSet resultSet = getResultSet(sql);
		try {
			while(resultSet.next()){
				InputForm inputForm =new InputForm(resultSet.getInt(1));
				inputForm.setGoodsName(resultSet.getString(2));
				inputForm.setInputTime(resultSet.getDate(3));
				inputForm.setInputNumber(resultSet.getDouble(4));
				inputForm.setInputDec(resultSet.getString(5));
				inputForm.setMainSpond(resultSet.getString(6));
				inputForms.add(inputForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputForms;
	}
	
	/**
	 * @descrite 返回表中的全部
	 * @return
	 */
	
	public ArrayList<InputForm> getAllInputForms() {
		ArrayList<InputForm> inputForms = new ArrayList<>();
		String sql = "select * from inputform ";
		ResultSet resultSet = getResultSet(sql);
		InputForm borrowForm =null;
		try {
			while(resultSet.next()){
				InputForm inputForm =new InputForm(resultSet.getInt(1));
				inputForm.setGoodsName(resultSet.getString(2));
				inputForm.setInputTime(resultSet.getDate(3));
				inputForm.setInputNumber(resultSet.getDouble(4));
				inputForm.setInputDec(resultSet.getString(5));
				inputForm.setMainSpond(resultSet.getString(6));
				inputForms.add(inputForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputForms;
	}
	
	
	
	
}
