package com.bling.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
/**
 * 
 * @author Bling
 * @descrite 这是一个物品UI，进入这个界面之后，你可以进行对物品的增删改查
 *
 */
public class GoodsUI extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public GoodsUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\2016-6-2.371.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 818, 596);
		
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(new File("src\\2016-6-3-1.jpg")), 0, 0, this) ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		};
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("增加物品");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			//增加物品就是填写入库单，并且在物品的数据库哪里添加一条记录
			public void mouseClicked(MouseEvent e) {
				TableMes tableMes = new TableMes("新品入库表");
				tableMes.setVisible(true);
				tableMes.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(65, 105, 225));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 34));
		btnNewButton.setBounds(14, 45, 182, 63);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("删除商品");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GoodsDialog goodsDialog = new GoodsDialog("deleteGoods");
				goodsDialog.setVisible(true);
				goodsDialog.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(65, 105, 225));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 34));
		btnNewButton_1.setBounds(134, 139, 182, 69);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("查找商品");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GoodsDialog goodsDialog = new GoodsDialog("searchGoods");
				goodsDialog.setVisible(true);
				goodsDialog.setLocationRelativeTo(null);
			}
		});
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setForeground(new Color(65, 105, 225));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 34));
		btnNewButton_2.setBounds(14, 250, 182, 63);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("改变商品");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GoodsDialog goodsDialog = new GoodsDialog("changeGoods");
				goodsDialog.setVisible(true);
				goodsDialog.setLocationRelativeTo(null);
			}
		});
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setForeground(new Color(65, 105, 225));
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 34));
		btnNewButton_3.setBounds(134, 342, 182, 69);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("退   出");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MeunUI meunUI = new MeunUI();
				meunUI.setVisible(true);
				meunUI.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setForeground(new Color(65, 105, 225));
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setFont(new Font("微软雅黑", Font.PLAIN, 34));
		btnNewButton_4.setBounds(14, 441, 165, 69);
		contentPane.add(btnNewButton_4);
	}

}
