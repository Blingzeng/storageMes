package com.bling.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Bling
 * @descrite 这是一个主菜单UI
 *
 */
public class MeunUI extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MeunUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\2016-6-2.371.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 551);
		
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(new File("F:\\java_work\\storageMes\\src\\2016-6-2.41.jpg")), 0, 0, this) ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		};
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("商  品");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GoodsUI goodsUI = new GoodsUI();
				goodsUI.setVisible(true);
				goodsUI.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 224));
		btnNewButton.setOpaque(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 34));
		btnNewButton.setBounds(36, 439, 150, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("库  单");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormUI formUI = new FormUI();
				formUI.setVisible(true);
				formUI.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 240));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 34));
		btnNewButton_1.setBounds(219, 399, 150, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("使用帮助");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UsingHeip usingHeip = new UsingHeip();
				usingHeip.setVisible(true);
				usingHeip.setLocationRelativeTo(null);
			}
		});
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setForeground(new Color(255, 255, 240));
		btnNewButton_2.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 34));
		btnNewButton_2.setBounds(790, 439, 175, 52);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("查询帮助");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IdSearchUI idSearchUI = new IdSearchUI();
				idSearchUI.setVisible(true);
				idSearchUI.setLocationRelativeTo(null);
			}
		});
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setForeground(new Color(255, 255, 240));
		btnNewButton_3.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 34));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(594, 405, 150, 52);
		contentPane.add(btnNewButton_3);
		
		JLabel lblYouAreWelcome = new JLabel("You are welcome");
		lblYouAreWelcome.setForeground(new Color(255, 255, 240));
		lblYouAreWelcome.setFont(new Font("Yu Gothic Light", Font.PLAIN, 39));
		lblYouAreWelcome.setBounds(341, 90, 354, 60);
		contentPane.add(lblYouAreWelcome);
	}
}
