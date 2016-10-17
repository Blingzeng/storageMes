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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

/**
 * 
 *@author Bling
 * @descrite 这是一个表单的UI，进入这个界面可以增加和查看表单
 *
 */
public class FormUI extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public FormUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\2016-6-2.371.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 777, 586);
		
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(new File("src\\2016-6-3-2.jpg")), 0, 0, this) ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		};
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setOpaque(false);
		
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar inputMenuBar = new JMenuBar();
		inputMenuBar.setBounds(457, 94, 100, 68);
		inputMenuBar.setOpaque(false);
		inputMenuBar.setBackground(new Color(255, 255, 255));
		inputMenuBar.setPreferredSize(new Dimension(0, 1));
		
		JMenu inputMenu = new JMenu("入库表");
		inputMenu.setForeground(new Color(65, 105, 225));
		inputMenu.setBackground(new Color(255, 255, 255));
		inputMenuBar.add(inputMenu);
		inputMenu.setSelectedIcon(new ImageIcon("F:\\java_work\\storageMes\\src\\2016-6-2.39.jpg"));
		inputMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		
		JMenuItem inputMenuItemAdd = new JMenuItem("增  加");
		inputMenuItemAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableMes tableMes = new TableMes("入库表");
				tableMes.setVisible(true);
				tableMes.setLocationRelativeTo(null);
				dispose();
			}
		});
		inputMenuItemAdd.setForeground(new Color(0, 0, 0));
		inputMenuItemAdd.setBorder(null);
		inputMenuItemAdd.setBackground(new Color(192, 192, 192));
		inputMenuItemAdd.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		inputMenu.add(inputMenuItemAdd);
		
		JMenuItem inputMenuItemUpdate = new JMenuItem("查  看");
		inputMenuItemUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FormSearchUI formSearchUI = new FormSearchUI("入库表");
				formSearchUI.setVisible(true);
				formSearchUI.setLocationRelativeTo(null);
			}
		});
		inputMenuItemUpdate.setBackground(new Color(255, 255, 255));
		inputMenuItemUpdate.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		inputMenu.add(inputMenuItemUpdate);
		contentPane.add(inputMenuBar);
		
		JMenuBar outputMenuBar = new JMenuBar();
		outputMenuBar.setOpaque(false);
		outputMenuBar.setBounds(558, 202, 100, 68);
		contentPane.add(outputMenuBar);
		
		JMenu outputMenu = new JMenu("出库表");
		outputMenu.setForeground(new Color(65, 105, 225));
		outputMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		outputMenuBar.add(outputMenu);
		
		JMenuItem outputMenuItemAdd = new JMenuItem("增  加");
		outputMenuItemAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableMes tableMes = new TableMes("出库表");
				tableMes.setVisible(true);
				tableMes.setLocationRelativeTo(null);
				dispose();
			}
		});
		outputMenuItemAdd.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		outputMenu.add(outputMenuItemAdd);
		
		JMenuItem outputMenuItemUpdate = new JMenuItem("查  看");
		outputMenuItemUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FormSearchUI formSearchUI = new FormSearchUI("出库表");
				formSearchUI.setVisible(true);
				formSearchUI.setLocationRelativeTo(null);
			}
		});
		outputMenuItemUpdate.setBackground(new Color(255, 255, 240));
		outputMenuItemUpdate.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		outputMenu.add(outputMenuItemUpdate);
		
		JMenuBar borrowMenuBar = new JMenuBar();
		borrowMenuBar.setOpaque(false);
		borrowMenuBar.setBounds(457, 310, 100, 68);
		contentPane.add(borrowMenuBar);
		
		JMenu borrowMenu = new JMenu("借出表");
		borrowMenu.setForeground(new Color(65, 105, 225));
		borrowMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		borrowMenuBar.add(borrowMenu);
		
		JMenuItem borrowMenuItemAdd = new JMenuItem("增  加");
		borrowMenuItemAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableMes tableMes = new TableMes("借出表");
				tableMes.setVisible(true);
				tableMes.setLocationRelativeTo(null);
				dispose();
			}
		});
		borrowMenuItemAdd.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		borrowMenu.add(borrowMenuItemAdd);
		
		JMenuItem borrowMenuItemUpdate = new JMenuItem("查  看");
		borrowMenuItemUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FormSearchUI formSearchUI = new FormSearchUI("借出表");
				formSearchUI.setVisible(true);
				formSearchUI.setLocationRelativeTo(null);
			}
		});
		borrowMenuItemUpdate.setBackground(new Color(255, 255, 240));
		borrowMenuItemUpdate.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		borrowMenu.add(borrowMenuItemUpdate);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MeunUI meunUI = new MeunUI();
				meunUI.setVisible(true);
				meunUI.setLocationRelativeTo(null);
				dispose();
			}
		});
		button.setIcon(new ImageIcon("F:\\java_work\\storageMes\\src\\row.png"));
		button.setOpaque(false);
		button.setForeground(Color.CYAN);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(new Color(255, 255, 255));
		button.setBounds(634, 496, 135, 59);
		contentPane.add(button);
		
		JMenuBar returnMenuBar = new JMenuBar();
		returnMenuBar.setOpaque(false);
		returnMenuBar.setBounds(558, 391, 100, 68);
		contentPane.add(returnMenuBar);
		
		JMenu returnMenu = new JMenu("还库表");
		returnMenu.setForeground(new Color(65, 105, 225));
		returnMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		returnMenuBar.add(returnMenu);
		
		JMenuItem returnMenuItemAdd = new JMenuItem("增  加");
		returnMenuItemAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableMes tableMes = new TableMes("还库表");
				tableMes.setVisible(true);
				tableMes.setLocationRelativeTo(null);
				dispose();
			}
		});
		returnMenuItemAdd.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		returnMenu.add(returnMenuItemAdd);
		
		JMenuItem returnMenuItemUpdate = new JMenuItem("查  看");
		returnMenuItemUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FormSearchUI formSearchUI = new FormSearchUI("还库表");
				formSearchUI.setVisible(true);
				formSearchUI.setLocationRelativeTo(null);
			}
		});
		returnMenuItemUpdate.setBackground(new Color(255, 255, 240));
		returnMenuItemUpdate.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
		returnMenu.add(returnMenuItemUpdate);
		
		
		
	}
}
