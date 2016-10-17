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
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 *  @author Bling
 * @descrite 这是一个欢迎UI，是进入菜单界面之前的一个界面。
 *
 */
public class WelcomeUI extends JFrame {

	String PictureUrl = "F:\\java_work\\storageMes\\src\\2016-6-2-11.jpg";
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeUI frame = new WelcomeUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WelcomeUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\2016-6-2.371.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(new File("src\\2016-6-2-7.jpg")), 0, 0, this) ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		};
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("仓库管理系统");
		lblNewLabel.setBounds(619, 260, 349, 65);
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("方正姚体", Font.PLAIN, 56));
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(432, 253, 0, 0);
		contentPane.add(label);
		contentPane.add(lblNewLabel);
		
		JLabel lblWarehouseManagementSystem = new JLabel("Warehouse Management System");
		lblWarehouseManagementSystem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblWarehouseManagementSystem.setBounds(629, 338, 328, 35);
		contentPane.add(lblWarehouseManagementSystem);
		
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
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(new Color(211, 211, 211));
		button.setForeground(new Color(0, 255, 255));
		button.setOpaque(false);
		button.setIcon(new ImageIcon("src\\row.png"));
		button.setBounds(833, 386, 135, 59);
		contentPane.add(button);
	}
}
