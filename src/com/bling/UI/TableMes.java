package com.bling.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.function.DoublePredicate;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

import com.bling.bean.BorrowForm;
import com.bling.bean.Goods;
import com.bling.bean.InputForm;
import com.bling.bean.InputForm;
import com.bling.bean.InputForm;




import com.bling.bean.outputForm;
import com.bling.bean.returnForm;
import com.bling.service.StorageSer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

/**
 * 
 * @author Bling
 * @descrite 这是一个表格UI，库单的填写
 *
 */
public class TableMes extends JFrame {

	private JPanel contentPane;
	private JTextField goodsIdTextField;
	private JTextField timeTextField;
	private JTextField goodsNameTextField;
	private JTextField numberTextField;
	private JTextField borrowerTextField;
	private JTextField mainSpondTextField;
	private JTextField goodsPricetextField;
	private JTextField dowmLimittextField;
	private JTextField upLimittextField;

	

	/**
	 * Create the frame.
	 */
	public TableMes(String formName) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\2016-6-2.371.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 914, 645);
		
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(new File("src\\2016-6-2.9.jpg")), 0, 0, this) ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		};
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("仓库管理系统");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("方正姚体", Font.PLAIN, 56));
		label.setBounds(271, 13, 393, 85);
		contentPane.add(label);
		
		JLabel lblWarehouseManagementSystem = new JLabel("Warehouse Management System");
		lblWarehouseManagementSystem.setFont(new Font("Segoe UI Historic", Font.PLAIN, 19));
		lblWarehouseManagementSystem.setBounds(304, 98, 340, 42);
		contentPane.add(lblWarehouseManagementSystem);
		
		JLabel lblNewLabel = new JLabel(formName);
		lblNewLabel.setForeground(new Color(127, 255, 212));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 50));
		lblNewLabel.setBounds(314, 143, 273, 42);
		contentPane.add(lblNewLabel);
		
		JLabel goodsIdLabel = new JLabel("物品编号");
		goodsIdLabel.setForeground(new Color(128, 0, 0));
		goodsIdLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		goodsIdLabel.setBounds(50, 246, 92, 42);
		contentPane.add(goodsIdLabel);
		
		goodsIdTextField = new JTextField();
		goodsIdTextField.setBounds(167, 255, 112, 33);
		contentPane.add(goodsIdTextField);
		goodsIdTextField.setColumns(10);
		
		JLabel timeLabel = new JLabel("日    期");
		timeLabel.setForeground(new Color(128, 0, 0));
		timeLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		timeLabel.setBounds(50, 321, 99, 21);
		contentPane.add(timeLabel);
		
		timeTextField = new JTextField();
		timeTextField.setBounds(167, 319, 112, 33);
		contentPane.add(timeTextField);
		timeTextField.setColumns(10);
		
		JLabel goodsNameLabel = new JLabel("物品名称");
		goodsNameLabel.setForeground(new Color(128, 0, 0));
		goodsNameLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		goodsNameLabel.setBounds(589, 258, 99, 30);
		contentPane.add(goodsNameLabel);
		
		goodsNameTextField = new JTextField();
		goodsNameTextField.setBounds(706, 255, 112, 33);
		contentPane.add(goodsNameTextField);
		goodsNameTextField.setColumns(10);
		
		JLabel numberLabel = new JLabel("数    量");
		numberLabel.setForeground(new Color(128, 0, 0));
		numberLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		numberLabel.setBounds(589, 321, 99, 27);
		contentPane.add(numberLabel);
		
		numberTextField = new JTextField();
		numberTextField.setBounds(706, 319, 112, 33);
		contentPane.add(numberTextField);
		numberTextField.setColumns(10);
		
		JLabel decTabel = new JLabel("描    述");
		decTabel.setForeground(new Color(128, 0, 0));
		decTabel.setFont(new Font("宋体", Font.PLAIN, 23));
		decTabel.setBounds(50, 385, 99, 33);
		contentPane.add(decTabel);
		
		JTextPane decTextPane = new JTextPane();
		decTextPane.setBounds(167, 385, 651, 64);
		contentPane.add(decTextPane);
		
		JLabel borrowerLabel = new JLabel("借 款 人");
		borrowerLabel.setForeground(new Color(128, 0, 0));
		borrowerLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		borrowerLabel.setBounds(50, 480, 99, 21);
		contentPane.add(borrowerLabel);
		borrowerLabel.setVisible(false);
		
		
		borrowerTextField = new JTextField();
		borrowerTextField.setBounds(167, 477, 112, 34);
		contentPane.add(borrowerTextField);
		borrowerTextField.setColumns(10);
		borrowerTextField.setVisible(false);
		
		if(formName.equals("借出表")){
			borrowerLabel.setVisible(true);
			borrowerTextField.setVisible(true);
		}
		if(formName.equals("还库表")){
			borrowerLabel.setText("还 款 人");
			borrowerLabel.setVisible(true);
			borrowerTextField.setVisible(true);
		}
		
		JLabel mainSpondLabel = new JLabel("负 责 人");
		mainSpondLabel.setForeground(new Color(128, 0, 0));
		mainSpondLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		mainSpondLabel.setBounds(589, 483, 99, 28);
		contentPane.add(mainSpondLabel);
		
		mainSpondTextField = new JTextField();
		mainSpondTextField.setBounds(706, 477, 112, 34);
		contentPane.add(mainSpondTextField);
		mainSpondTextField.setColumns(10);
		
		JLabel goodsPricelabel = new JLabel("物品单价");
		goodsPricelabel.setForeground(new Color(128, 0, 0));
		goodsPricelabel.setFont(new Font("宋体", Font.PLAIN, 23));
		goodsPricelabel.setBounds(339, 313, 92, 42);
		contentPane.add(goodsPricelabel);
		goodsPricelabel.setVisible(false);
		
		goodsPricetextField = new JTextField();
		goodsPricetextField.setColumns(10);
		goodsPricetextField.setBounds(449, 319, 112, 33);
		contentPane.add(goodsPricetextField);
		goodsPricetextField.setVisible(false);
		
		JLabel dowmLimitlabel_2 = new JLabel("物品下限");
		dowmLimitlabel_2.setForeground(new Color(128, 0, 0));
		dowmLimitlabel_2.setFont(new Font("宋体", Font.PLAIN, 23));
		dowmLimitlabel_2.setBounds(43, 480, 99, 21);
		contentPane.add(dowmLimitlabel_2);
		dowmLimitlabel_2.setVisible(false);
		
		dowmLimittextField = new JTextField();
		dowmLimittextField.setColumns(10);
		dowmLimittextField.setBounds(167, 478, 112, 33);
		contentPane.add(dowmLimittextField);
		dowmLimittextField.setVisible(false);
		
		upLimittextField = new JTextField();
		upLimittextField.setColumns(10);
		upLimittextField.setBounds(449, 482, 112, 33);
		contentPane.add(upLimittextField);
		upLimittextField.setVisible(false);
		
		JLabel upLimitlabel = new JLabel("物品上限");
		upLimitlabel.setForeground(new Color(128, 0, 0));
		upLimitlabel.setFont(new Font("宋体", Font.PLAIN, 23));
		upLimitlabel.setBounds(339, 476, 92, 42);
		contentPane.add(upLimitlabel);
		upLimitlabel.setVisible(false);
		
		JLabel errorLabel = new JLabel("New label");
		errorLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(339, 217, 192, 42);
		contentPane.add(errorLabel);
		errorLabel.setVisible(false);
		
		if(formName.equals("新品入库表")){
			goodsPricelabel.setVisible(true);
			goodsPricetextField.setVisible(true);
			dowmLimitlabel_2.setVisible(true);
			dowmLimittextField.setVisible(true);
			upLimitlabel.setVisible(true);
			upLimittextField.setVisible(true);
		}
		
		JButton sureButton = new JButton("确认提交");
		sureButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int goodsId = Integer.parseInt(goodsIdTextField.getText());
					
					String goodsName = goodsNameTextField.getText();
					
					try {
						
						Date date = Date.valueOf(timeTextField.getText());
						
						try {
							
							int number = Integer.parseInt(numberTextField.getText());
							String dec = decTextPane.getText();
							String mainSpond = mainSpondTextField.getText();
							String tempMan = borrowerTextField.getText();
							
							StorageSer ser = new StorageSer();

							if(formName.equals("新品入库表")){
								Goods goods = new Goods(goodsId);
								goods.setGoodsName(goodsName);
								goods.setGoodsNumber(number);
								goods.setGoodsDec(dec);
								
								//抓取单价错误
								
								try {
									 double goodsPrice = Double.parseDouble(goodsPricetextField.getText());
									 goods.setGoodsPrice(goodsPrice);
								} catch (Exception e2) {
									// TODO: handle exception
									errorLabel.setText("物品单价错误");
									errorLabel.setVisible(true);
								}
								
								//抓取下限错误
								try {
									int downLimit = Integer .parseInt(dowmLimittextField.getText());
									goods.setDowmLimit(downLimit);
								} catch (Exception e2) {
									// TODO: handle exception
									errorLabel.setText("物品下限错误");
									errorLabel.setVisible(true);
								}
								
								
								//抓取上限错误
								try {
									int upLimit = Integer .parseInt(upLimittextField.getText());
									goods.setUpLimit(upLimit);
								} catch (Exception e2) {
									// TODO: handle exception
									errorLabel.setText("物品上限错误");
									errorLabel.setVisible(true);
								}
							
								
								goods.setDowmLimit(1);
								goods.setUpLimit(1000);
								
								
								InputForm inputForm = new InputForm(goodsId);
								inputForm.setGoodsName(goodsName);
								inputForm.setInputTime(date);
								inputForm.setInputNumber(number);
								inputForm.setInputDec(dec);
								if (mainSpond.length() >= 0) {
									inputForm.setMainSpond(mainSpond);
									ser.add(goods, inputForm);
									TipUI tipUI = new TipUI("恭喜你，操作成功");
									tipUI.setVisible(true);
									tipUI.setLocationRelativeTo(null);
									}
								else{
									errorLabel.setText("负责人不能为空");
								}
								
								
							}
							
							if(formName.equals("入库表")){
								InputForm inputForm = new InputForm(goodsId);
								inputForm.setGoodsName(goodsName);
								inputForm.setInputTime(date);
								inputForm.setInputNumber(number);
								inputForm.setInputDec(dec);
								if (mainSpond.length() >= 0) {
									inputForm.setMainSpond(mainSpond);
									ser.addInputform(inputForm);
									TipUI tipUI = new TipUI("恭喜你，操作成功");
									tipUI.setVisible(true);
									tipUI.setLocationRelativeTo(null);
								}
								else{
									errorLabel.setText("负责人不能为空");
								}
								
							}
							
							if(formName.equals("出库表")){
								outputForm outputForm = new outputForm(goodsId);
								outputForm.setGoodsName(goodsName);
								outputForm.setOutputTime(date);
								outputForm.setOutputNumber(number);
								outputForm.setOutputDec(dec);
								
								if (mainSpond.length() >= 0) {
									outputForm.setMainSpond(mainSpond);
									ser.addOutputForm(outputForm);
									TipUI tipUI = new TipUI("恭喜你，操作成功");
									tipUI.setVisible(true);
									tipUI.setLocationRelativeTo(null);
								}
								else{
									errorLabel.setText("负责人不能为空");
								}
								
							}
							
							if(formName.equals("借出表")){
								BorrowForm borrowForm = new BorrowForm(goodsId);
								borrowForm.setGoodsName(goodsName);
								borrowForm.setBorrowTime(date);
								borrowForm.setBorrowNumber(number);
								borrowForm.setBorrowDec(dec);
								if (mainSpond.length() >= 0) {
									borrowForm.setMainSpond(mainSpond);
									if (mainSpond.length() >= 0) {
										borrowForm.setBorrower(tempMan);
										ser.addBorrowForm(borrowForm);
										TipUI tipUI = new TipUI("恭喜你，操作成功");
										tipUI.setVisible(true);
										tipUI.setLocationRelativeTo(null);
									} else {
										errorLabel.setText("借款人不能为空");
									}
								} else {
									errorLabel.setText("负责人不能为空");
								}
								
								
								
								
								
							}
							
							if(formName.equals("还库表")){
								returnForm returnForm  = new returnForm(goodsId);
								returnForm.setGoodsName(goodsName);
								returnForm.setReturnTime(date);
								returnForm.setReturnNumber(number);
								returnForm .setReturnDec(dec);
								if (mainSpond.length() >= 0) {
									returnForm.setMainSpond(mainSpond);
									if (mainSpond.length() >= 0) {
										returnForm.setReturner(tempMan);
										ser.addReturnForm(returnForm);
										TipUI tipUI = new TipUI("恭喜你，操作成功");
										tipUI.setVisible(true);
										tipUI.setLocationRelativeTo(null);
									} else {
										errorLabel.setText("还款人不能为空");
									}
								} else {
									errorLabel.setText("负责人不能为空");
								}
								
								
								
								
								
							}
							
						} catch (Exception e2) {
							// TODO: handle exception
							errorLabel.setText("数量输入错误");
							errorLabel.setVisible(true);
						}	
					} catch (Exception e2) {
						// TODO: handle exception
						//捕捉在日期上的输入错误
						errorLabel.setText("日期输入错误");
						errorLabel.setVisible(true);
					}
				
				} catch (Exception e2) {
					// TODO: handle exception
					//捕捉在编号上的输入错误
					errorLabel.setText("编号输入错误");
					errorLabel.setVisible(true);
				}
				
				
			}
		});
		sureButton.setFont(new Font("宋体", Font.PLAIN, 23));
		sureButton.setBounds(516, 543, 128, 42);
		contentPane.add(sureButton);
		
		JButton btnNewButton = new JButton("取    消");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(formName.equals("新品入库表")){
					dispose();
					GoodsUI goodsUI = new GoodsUI();
					goodsUI.setVisible(true);
					goodsUI.setLocationRelativeTo(null);
				}
				else{
					dispose();
					FormUI formUI = new FormUI();
					formUI.setVisible(true);
					formUI.setLocationRelativeTo(null);
				}
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 23));
		btnNewButton.setBounds(690, 543, 128, 42);
		contentPane.add(btnNewButton);
		
		
		
		
	}
}
