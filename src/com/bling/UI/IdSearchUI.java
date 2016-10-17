package com.bling.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.bling.bean.Goods;
import com.bling.service.StorageSer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
/**
 * 
 *@author Bling
 * @descrite 这个是通过id和名称进行快速查询的UI
 *
 */
public class IdSearchUI extends JFrame {

	private JPanel contentPane;
	private JTextField goodsIdTextField;
	private JTextField goodsNameTextField;



	/**
	 * Create the frame.
	 */
	public IdSearchUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\2016-6-2.371.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 774, 660);
		
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
		contentPane.setBackground(new Color(255, 255, 255));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("物品编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel.setBounds(331, 59, 102, 33);
		contentPane.add(lblNewLabel);
		
		goodsIdTextField = new JTextField();
		goodsIdTextField.setBounds(437, 52, 143, 40);
		contentPane.add(goodsIdTextField);
		goodsIdTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("物品名称");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(331, 105, 92, 40);
		contentPane.add(lblNewLabel_1);
		
		goodsNameTextField = new JTextField();
		goodsNameTextField.setBounds(437, 105, 143, 40);
		contentPane.add(goodsNameTextField);
		goodsNameTextField.setColumns(10);
		
		JLabel lblYyyymmdd = new JLabel("请正确输入物品编号");
		lblYyyymmdd.setForeground(Color.RED);
		lblYyyymmdd.setFont(new Font("宋体", Font.PLAIN, 20));
		lblYyyymmdd.setBounds(331, 13, 326, 33);
		contentPane.add(lblYyyymmdd);
		lblYyyymmdd.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(331, 188, 411, 342);
		scrollPane.getViewport().setOpaque(false);//将JScrollPane设置为透明  
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setOpaque(false);
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		StorageSer ser = new StorageSer();
		TreeSet<Goods> treeSet = ser.getAllGoodsOfIdAndName();
		for(Iterator<Goods> iterator = treeSet.iterator();iterator.hasNext();){
			Goods goods = iterator.next();
			textArea.append("物品编号 "+goods.getGoodsId()+" 物品名称 "+goods.getGoodsName()+"\n");
		}
		
		JButton button = new JButton("确认查询");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//先清空
				textArea.setText("");
				//先判断id是否为空，
				if(goodsIdTextField.getText().trim().length()>0){
					//抓取用户的错误输入
					try {
						int goodsid = Integer.parseInt(goodsIdTextField
								.getText());
						String goodsName = goodsNameTextField.getText();
						//判断是否存在
						boolean flag = ser.idIsTrue(goodsid);
						if(flag){
							//判断名称是否为空，若不为空则进行对比
							if(goodsNameTextField.getText().trim().length()>0){
								Goods goods = ser.getGoods(goodsid);
								TreeSet<Goods> treeSet = ser.getGoodsId(goodsName);
								for(Iterator<Goods> iterator = treeSet.iterator();iterator.hasNext();){
									Goods tempGoods = iterator.next();
									if(tempGoods.getGoodsId()==goods.getGoodsId()){
										lblYyyymmdd.setVisible(false);
										textArea.setText("物品编号 "+goods.getGoodsId()+" 物品名称 "+goods.getGoodsName()+"\n");
										break;
									}
								}
								if(textArea.getText().trim().length()<=0){
									lblYyyymmdd.setVisible(false);
									textArea.setText("没有相关记录");
								}
							}
							else{
								lblYyyymmdd.setVisible(false);
								Goods goods = ser.getGoods(goodsid);
								textArea.setText("物品编号 "+goods.getGoodsId()+" 物品名称 "+goods.getGoodsName()+"\n");
							}
						}
						else{
							lblYyyymmdd.setVisible(false);
							textArea.setText("");
							textArea.append("没有相关记录");
						}
					} catch (Exception e2) {
						// TODO: handle exception
						lblYyyymmdd.setVisible(true);
					}
				}
				else{
					if(goodsNameTextField.getText().trim().length()>0){
						String goodsName = goodsNameTextField.getText();
						TreeSet<Goods> treeSet = ser.getGoodsId(goodsName);
						if(treeSet!=null){
							textArea.setText("");
							for(Iterator<Goods> iterator = treeSet.iterator();iterator.hasNext();){
								lblYyyymmdd.setVisible(false);
								Goods goods = iterator.next();
								textArea.append("物品编号 "+goods.getGoodsId()+" 物品名称 "+goods.getGoodsName()+"\n");
							}
						}
						else{
							lblYyyymmdd.setVisible(false);
							textArea.setText("");
							textArea.append("没有相关记录");
						}
					}
					else{
						lblYyyymmdd.setText("请输入编号或者名称");
						lblYyyymmdd.setVisible(true);
						TreeSet<Goods> treeSet = ser.getAllGoodsOfIdAndName();
						for(Iterator<Goods> iterator = treeSet.iterator();iterator.hasNext();){
							lblYyyymmdd.setVisible(false);
							Goods goods = iterator.next();
							textArea.append("物品编号 "+goods.getGoodsId()+" 物品名称 "+goods.getGoodsName()+"\n");
						}
					}
				}
			}
		});
		button.setForeground(new Color(85, 107, 47));
		button.setBackground(new Color(255, 255, 255));
		button.setBorder(null);
		button.setOpaque(false);
		button.setFont(new Font("宋体", Font.PLAIN, 23));
		button.setBounds(609, 101, 133, 44);
		contentPane.add(button);
		
		JButton button_1 = new JButton("退出");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		button_1.setBackground(new Color(255, 255, 255));
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setOpaque(false);
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(629, 567, 113, 33);
		contentPane.add(button_1);
		
		
		
		
		
		
	}
}
