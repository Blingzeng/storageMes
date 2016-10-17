package com.bling.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import com.bling.bean.BorrowForm;
import com.bling.bean.InputForm;
import com.bling.bean.outputForm;
import com.bling.bean.returnForm;
import com.bling.service.StorageSer;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;

/**
 * 
 * @author Bling
 * @descrite 这是一个表单查找的UI，输入开始日期和结束日期后会寻找到相关的记录，并且显示
 *
 */
public class FormSearchUI extends JFrame {

	private JPanel contentPane;
	private JTextField startTextField;
	private JTextField EndTextField;



	/**
	 * Create the frame.
	 */
	public FormSearchUI(String type) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\java_work\\storageMes\\src\\2016-6-2.371.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 689);
		
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(new File("src\\2016-6-3-4.png")), 0, 0, this) ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		};
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("开始日期");
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		label.setBounds(292, 97, 116, 40);
		contentPane.add(label);
		
		startTextField = new JTextField();
		startTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		startTextField.setBounds(408, 101, 164, 40);
		contentPane.add(startTextField);
		startTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("结束日期");
		label_1.setFont(new Font("宋体", Font.PLAIN, 23));
		label_1.setBounds(292, 150, 116, 40);
		contentPane.add(label_1);
		
		EndTextField = new JTextField();
		EndTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		EndTextField.setBounds(408, 154, 164, 40);
		contentPane.add(EndTextField);
		EndTextField.setColumns(10);
		
		JLabel lblYyyymmdd = new JLabel("请正确输入，格式为 YYYY-MM-DD");
		lblYyyymmdd.setForeground(Color.RED);
		lblYyyymmdd.setFont(new Font("宋体", Font.PLAIN, 20));
		lblYyyymmdd.setBounds(292, 51, 326, 33);
		contentPane.add(lblYyyymmdd);
		lblYyyymmdd.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);//将JScrollPane设置为透明  
		scrollPane.setBounds(251, 203, 511, 341);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setOpaque(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					Date startDate = Date.valueOf(startTextField.getText());
					Date endDate = Date.valueOf(EndTextField.getText());
					if (!endDate.before(startDate)) {
						StorageSer ser = new StorageSer();
						if (startDate.equals(endDate)) {
							
							
							if (type.equals("入库表")) {
								ArrayList<InputForm> arrayList = ser
										.getInputFormForDate(startDate + "");
								if(arrayList.size()!=0){
									textArea.setText("");
									for (Iterator<InputForm> iterator = arrayList
											.iterator(); iterator.hasNext();) {
										InputForm inputForm = iterator.next();
										textArea.append(inputForm.toString() + "\n");
									}
								}
								else{
									textArea.append("没有相关数据");
								}
							}
							
							if(type.equals("出库表")){
								ArrayList<outputForm> arrayList = ser
										.getOutputForDate(startDate + "");
								if(arrayList.size()!=0){
									textArea.setText("");
									for (Iterator<outputForm> iterator = arrayList
											.iterator(); iterator.hasNext();) {
										outputForm outputForm = iterator.next();
										textArea.append(outputForm.toString() + "\n");
									}
								}
								else{
									textArea.append("没有相关数据");
								}
							}
							
							if(type.equals("借出表")){
								ArrayList<BorrowForm> arrayList = ser
										.getBorrowForDate(startDate + "");
								if(arrayList.size()!=0){
									textArea.setText("");
									for (Iterator<BorrowForm> iterator = arrayList
											.iterator(); iterator.hasNext();) {
										BorrowForm borrowForm = iterator.next();
										textArea.append(borrowForm.toString() + "\n");
									}
								}
								else{
									textArea.append("没有相关数据");
								}
							}
							
							if(type.equals("还库表")){
								ArrayList<returnForm> arrayList = ser
										.getReturnForDate(startDate + "");
								if(arrayList.size()!=0){
									textArea.setText("");
									for (Iterator<returnForm> iterator = arrayList
											.iterator(); iterator.hasNext();) {
										returnForm returnForm = iterator.next();
										textArea.append(returnForm.toString() + "\n");
									}
								}
								else{
									textArea.append("没有相关数据");
								}
							}
							
							
						} 
						
						
						else {

							if (type.equals("入库表")) {
								ArrayList<InputForm> arrayList = ser
										.getInputFormForDate(startDate + "",endDate+"");
								if (arrayList.size() != 0) {
									textArea.setText("");
									for (Iterator<InputForm> iterator = arrayList
											.iterator(); iterator.hasNext();) {
										InputForm inputForm = iterator.next();
										textArea.append(inputForm.toString()
												+ "\n");
									}
								} else {
									textArea.append("没有相关数据");
								}
							}

							if (type.equals("出库表")) {
								ArrayList<outputForm> arrayList = ser
										.getOutputForDate(startDate + "",endDate+"");
								if (arrayList.size() != 0) {
									textArea.setText("");
									for (Iterator<outputForm> iterator = arrayList
											.iterator(); iterator.hasNext();) {
										outputForm outputForm = iterator.next();
										textArea.append(outputForm.toString()
												+ "\n");
									}
								} else {
									textArea.append("没有相关数据");
								}
							}

							if (type.equals("借出表")) {
								ArrayList<BorrowForm> arrayList = ser
										.getBorrowForDate(startDate + "",endDate+"");
								if (arrayList.size() != 0) {
									textArea.setText("");
									for (Iterator<BorrowForm> iterator = arrayList
											.iterator(); iterator.hasNext();) {
										BorrowForm borrowForm = iterator.next();
										textArea.append(borrowForm.toString()
												+ "\n");
									}
								} else {
									textArea.append("没有相关数据");
								}
							}

							if (type.equals("还库表")) {
								ArrayList<returnForm> arrayList = ser
										.getReturnForDate(startDate + "",endDate+"");
								if (arrayList.size() != 0) {
									textArea.setText("");
									for (Iterator<returnForm> iterator = arrayList
											.iterator(); iterator.hasNext();) {
										returnForm returnForm = iterator.next();
										textArea.append(returnForm.toString()
												+ "\n");
									}
								} else {
									textArea.append("没有相关数据");
								}
							}

						}

					} else {
						lblYyyymmdd.setText("输入的日期不符合，请重新输入");
						lblYyyymmdd.setVisible(true);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					lblYyyymmdd.setVisible(true);
				}
				
				
				
			
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 23));
		btnNewButton.setBounds(649, 151, 113, 38);
		contentPane.add(btnNewButton);
		
		
		
		JButton button = new JButton("返回");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				FormUI formUI = new FormUI();
				formUI.setVisible(true);
				formUI.setLocationRelativeTo(null);
			}
		});
		button.setBackground(new Color(255, 255, 255));
		button.setOpaque(false);
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		button.setBounds(656, 610, 113, 40);
		contentPane.add(button);
	}
}
