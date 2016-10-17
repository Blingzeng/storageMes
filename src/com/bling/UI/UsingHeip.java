package com.bling.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
/**
 * 
 *  @author Bling
 * @descrite 这是一个使用帮助的UI，进入这个界面之后，你就可以知道使用帮助
 *
 */
public class UsingHeip extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	/**
	 * Create the dialog.
	 */
	public UsingHeip() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\2016-6-2.371.png"));
		setBounds(100, 100, 762, 476);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(175, 238, 238));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			okButton.setFont(new Font("宋体", Font.PLAIN, 30));
			okButton.setBounds(675, 382, 69, 37);
			contentPanel.add(okButton);
			okButton.setBorder(null);
			okButton.setBackground(new Color(255, 255, 255));
			okButton.setOpaque(false);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JTextPane textPane = new JTextPane();
			textPane.setEditable(false);
			textPane.setFont(new Font("宋体", Font.PLAIN, 20));
			textPane.setBackground(new Color(224, 255, 255));
			textPane.setText("1）在主菜单上有 “物品” “库单” 查询帮助“ 三个选项。\r\n       物品选项是对物品进行增删该查的功能；\r\n       库单选项是对入库单，出库单，借出单，还库单的增加和查找功能；\r\n       查询帮助可以通过物品编号或者物品名称来快速查询物品的名称和编号；\r\n2）使用查询帮助\r\n\t一：当你的知道物品的名称但是不知道编号的时候，可以通过查询帮助来查找，\r\n\t二：当你知道物品的编号但是不知道名称的时候，也可以通过查询帮助来查找。\r\n\t三：当你不知道物品的编号和名称的时候，你可以通过看全部物品来查找你需要的信息");
			textPane.setBounds(14, 50, 716, 319);
			contentPanel.add(textPane);
		}
		{
			JLabel label = new JLabel("使用帮助：");
			label.setFont(new Font("宋体", Font.PLAIN, 20));
			label.setBounds(14, 13, 147, 24);
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
