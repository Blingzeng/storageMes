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
import com.bling.service.StorageSer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
/**
 * 
 * @author Bling
 * @descrite 这是一个确认的UI，当你在查看，删除，修改操作之前的确认
 *
 */
public class SureDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField goodsIdtextField;
	private JTextField goodsPricetextField;
	private JTextField goodsLimittextField;
	private JTextField goodsNametextField;
	private JTextField goodsNumbertextField;
	private JTextField goodsUptextField;

	

	/**
	 * Create the dialog.
	 */
	public SureDialog(String type, int goodsId) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\2016-6-2.371.png"));

		GoodsDao goodsDao = new GoodsDao();
		Goods goods = goodsDao.searchOfid(goodsId);

		setBounds(100, 100, 826, 418);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel goodsIdlabel = new JLabel("物品编号");
		goodsIdlabel.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsIdlabel.setBounds(43, 63, 87, 24);
		contentPanel.add(goodsIdlabel);

		JLabel goodsPricelabel = new JLabel("物品单价");
		goodsPricelabel.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsPricelabel.setBounds(43, 111, 87, 24);
		contentPanel.add(goodsPricelabel);

		JLabel goodsLimitlabel = new JLabel("物品下限");
		goodsLimitlabel.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsLimitlabel.setBounds(43, 170, 87, 24);
		contentPanel.add(goodsLimitlabel);

		JLabel goodsNamelabel = new JLabel("物品名称");
		goodsNamelabel.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsNamelabel.setBounds(357, 63, 87, 24);
		contentPanel.add(goodsNamelabel);

		JLabel goodsNumberlabel = new JLabel("物品数量");
		goodsNumberlabel.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsNumberlabel.setBounds(357, 111, 87, 24);
		contentPanel.add(goodsNumberlabel);

		JLabel goodsUplabel = new JLabel("物品上限");
		goodsUplabel.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsUplabel.setBounds(357, 170, 87, 24);
		contentPanel.add(goodsUplabel);

		JLabel goodsDeclabel = new JLabel("物品描述");
		goodsDeclabel.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsDeclabel.setBounds(43, 227, 87, 24);
		contentPanel.add(goodsDeclabel);

		goodsIdtextField = new JTextField();
		goodsIdtextField.setEditable(false);
		goodsIdtextField.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsIdtextField.setBounds(144, 63, 153, 26);
		contentPanel.add(goodsIdtextField);
		goodsIdtextField.setColumns(10);
		goodsIdtextField.setText(goods.getGoodsId() + "");

		goodsPricetextField = new JTextField();
		goodsPricetextField.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsPricetextField.setColumns(10);
		goodsPricetextField.setBounds(144, 113, 153, 26);
		contentPanel.add(goodsPricetextField);
		goodsPricetextField.setText(goods.getGoodsPrice() + "");

		goodsLimittextField = new JTextField();
		goodsLimittextField.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsLimittextField.setColumns(10);
		goodsLimittextField.setBounds(144, 172, 153, 26);
		contentPanel.add(goodsLimittextField);
		goodsLimittextField.setText(goods.getDowmLimit() + "");

		goodsNametextField = new JTextField();
		goodsNametextField.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsNametextField.setColumns(10);
		goodsNametextField.setBounds(457, 65, 153, 26);
		contentPanel.add(goodsNametextField);
		goodsNametextField.setText(goods.getGoodsName());

		goodsNumbertextField = new JTextField();
		goodsNumbertextField.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsNumbertextField.setColumns(10);
		goodsNumbertextField.setBounds(458, 113, 153, 26);
		contentPanel.add(goodsNumbertextField);
		goodsNumbertextField.setText(goods.getGoodsNumber() + "");

		goodsUptextField = new JTextField();
		goodsUptextField.setFont(new Font("宋体", Font.PLAIN, 20));
		goodsUptextField.setColumns(10);
		goodsUptextField.setBounds(457, 172, 153, 26);
		contentPanel.add(goodsUptextField);
		goodsUptextField.setText(goods.getUpLimit() + "");

		JTextPane goodsDectextPane = new JTextPane();
		goodsDectextPane.setBounds(144, 227, 466, 94);
		contentPanel.add(goodsDectextPane);
		goodsDectextPane.setText(goods.getGoodsDec());
		JButton sureNewButton = new JButton("确认删除");
		if (type.equals("确认删除")) {
			goodsNametextField.setEditable(false);
			goodsNumbertextField.setEditable(false);
			goodsPricetextField.setEditable(false);
			goodsLimittextField.setEditable(false);
			goodsUptextField.setEditable(false);
			goodsDectextPane.setEditable(false);
		}

		if (type.equals("确认查找")) {
			goodsNametextField.setEditable(false);
			goodsNumbertextField.setEditable(false);
			goodsPricetextField.setEditable(false);
			goodsLimittextField.setEditable(false);
			goodsUptextField.setEditable(false);
			goodsDectextPane.setEditable(false);
			sureNewButton.setText("确认");
		}

		if (type.equals("确认修改")) {
			sureNewButton.setText("确认修改");
		}

		sureNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// 根据空格信息，在创建一个新的物品对象
				goods.setGoodsName(goodsNametextField.getText());
				goods.setGoodsDec(goodsDectextPane.getText());

				int goodsDownLimit;
				int goodsUpLimit;
				double goodsNumber;
				double goodsPrice;
				try {
					goodsDownLimit = Integer.parseInt(goodsLimittextField
							.getText());
					goodsUpLimit = Integer.parseInt(goodsUptextField.getText());
					goodsNumber = Double.parseDouble(goodsNumbertextField
							.getText());
					goodsPrice = Double.parseDouble(goodsPricetextField
							.getText());
					goods.setGoodsPrice(goodsPrice);
					goods.setGoodsNumber(goodsNumber);
					goods.setDowmLimit(goodsDownLimit);
					goods.setUpLimit(goodsUpLimit);
				} catch (Exception e1) {
					// TODO: handle exception
					// 输入错误的时候怎么办
				}

				StorageSer ser = new StorageSer();
				if (type.equals("确认删除")) {

					if (ser.deleteGoods(goods)) {
						TipUI tipUI = new TipUI("恭喜你，删除成功");
						tipUI.setVisible(true);
						tipUI.setLocationRelativeTo(null);
						dispose();
					} else {
						TipUI tipUI = new TipUI("很抱歉，删除失败");
						tipUI.setVisible(true);
						tipUI.setLocationRelativeTo(null);
					}
				}

				if (type.equals("确认查找")) {
					dispose();
				}

				if (type.equals("确认修改")) {
					if (ser.update(goods)) {
						TipUI tipUI = new TipUI("恭喜你，修改成功");
						tipUI.setVisible(true);
						tipUI.setLocationRelativeTo(null);
						dispose();
					} else {
						TipUI tipUI = new TipUI("很抱歉，修改失败");
						tipUI.setVisible(true);
						tipUI.setLocationRelativeTo(null);
					}
				}

			}
		});
		sureNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		sureNewButton.setBounds(655, 323, 139, 35);
		contentPanel.add(sureNewButton);
	}
}
