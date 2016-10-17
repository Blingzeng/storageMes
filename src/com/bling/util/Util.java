package com.bling.util;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.bling.bean.returnForm;



public class Util {
	
	//数据库地址，并且指定编码方式，预防在操作数据库是出现乱码情况
	private static String url = "jdbc:mysql://localhost:3306/storagemessage?useUnicode=true&characterEncoding=utf-8";
	// 用户名
	private static String userName = "root";
	// 用户密码
	private static String password = "1234567";
	//驱动名称
	private static String jdbcName = "com.mysql.jdbc.Driver";
	

	/**
	 * @author Bling
	 * @descrite 获取连接
	 * @return
	 */
	public static Connection getConnection ()
	{
		try {
			Class.forName(jdbcName);
			try {
				Connection connection = DriverManager.getConnection(url, userName, password);
				return connection; 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @author Bling
	 * @descrite 关闭资源,先关闭preparedStatement，后关connection。
	 * @param connection
	 * @throws SQLException
	 */
	public static void close(PreparedStatement p,Connection connection) throws SQLException
	{
		if(p!=null){
			p.close();
			if(connection!=null)
			{
				connection.close();
			}
		}
		
	}
	
	/**
	 * @author Bling
	 * @descrite 放回一个当前系统时间
	 * @return
	 */
	public static Date getDate()
	{
//		Date date = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
//		String dateString = dateFormat.format(date);
//		return dateString;
		Date date = new Date(System.currentTimeMillis());
		return date;
	}
	
	
}
