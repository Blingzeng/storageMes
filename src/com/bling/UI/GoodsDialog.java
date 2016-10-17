package com.bling.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.bling.bean.Goods;
import com.bling.dao.GoodsDao;
import com.bling.dao.IdSerch;
import com.bling.dao.StorageDao;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
/**
 * 
 *@author Bling
 * @descrite 这是一个按照编号来进行查看，修改，删除操作之前的UI，
 *
 */
public class GoodsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;




	/**
	 * Create the dialog.
	 */
	public GoodsDialog(String type) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\2016-6-2.371.png"));
		setBounds(100, 100, 467, 335);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(169, 169, 169));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("物品编号");
			label.setFont(new Font("宋体", Font.PLAIN, 23));
			label.setBounds(14, 34, 105, 28);
			contentPanel.add(label);
		}
		{
			textField = new JTextField();
			textField.setBounds(125, 34, 156, 30);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JTextPane textPane = new JTextPane();
			textPane.setFont(new Font("宋体", Font.PLAIN, 20));
			textPane.setForeground(new Color(255, 0, 0));
			textPane.setBackground(new Color(169, 169, 169));
			textPane.setText("温馨提示：\r\n\t若删除成功，则会将该物品的所有数据一并删除。");
			textPane.setBounds(52, 92, 229, 102);
			contentPanel.add(textPane);
			textPane.setVisible(false);
			
			
			if(type.equals("deleteGoods")){
				textPane.setVisible(true);
			}
			
			if(type.equals("searchGoods")||type.equals("changeGoods")){
				textPane.setText("请入正确的物品编码");
				textPane.setForeground(new Color(0, 0, 0));
				textPane.setVisible(true);
			}
			
		}
		{
			JButton button = new JButton("确认删除");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int goodsId = 0;
					try {
						goodsId = Integer.parseInt(textField.getText());
					} catch (Exception e2) {
						// TODO: handle exception
						//捕捉用户输入错误
					}
					IdSerch idSerch =new IdSerch();
					Goods goods = idSerch.searchOfid(goodsId);
					if(goods!=null){
						if(type.equals("deleteGoods")){
							SureDialog sureDialog = new SureDialog("确认删除",goodsId);
							sureDialog.setVisible(true);
							sureDialog.setLocationRelativeTo(null);
							dispose();
						}
						
						if(type.equals("searchGoods")){
							SureDialog sureDialog = new SureDialog("确认查找",goodsId);
							sureDialog.setVisible(true);
							sureDialog.setLocationRelativeTo(null);
							dispose();
						}
						
						if(type.equals("changeGoods")){
							SureDialog sureDialog = new SureDialog("确认修改",goodsId);
							sureDialog.setVisible(true);
							sureDialog.setLocationRelativeTo(null);
							dispose();
						}
					else{
						//没有找到物品怎么办
					}
					
					}
				}
			});
			
			//如果不是删除，就是修改和查找，都需要先确认编号
			if(!type.equals("deleteGoods")){
				button.setText("确认查找");
			}
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			button.setFont(new Font("宋体", Font.PLAIN, 23));
			button.setBounds(301, 221, 134, 54);
			contentPanel.add(button);
		}
	}

}
