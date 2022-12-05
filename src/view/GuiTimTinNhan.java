package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiTimTinNhan extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTimTinNhan frame = new GuiTimTinNhan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiTimTinNhan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 434, 261);
		contentPane.add(contentPane_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		contentPane_1.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Hệ thống");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Đăng xuất");
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Thoát");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Danh sách bạn bè");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Danh sách bạn bè");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Chat");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Chat với bạn");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Nhóm chat");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(111, 60, 2, 177);
		contentPane_1.add(separator_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(125, 87, 299, 121);
		contentPane_1.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(123, 60, 301, 28);
		contentPane_1.add(panel);
		
		JButton btnNewButton_1 = new JButton("Tim");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(235, 0, 56, 22);
		panel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(25, 1, 200, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Long");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(254, 33, 46, 14);
		contentPane_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(-2, 60, 115, 177);
		contentPane_1.add(scrollPane);
		
		JTextArea txtrLucLongHuy = new JTextArea();
		txtrLucLongHuy.setText("Luc\r\nLong \r\nHuy\r\nPhu \r\nTrường\r\nKien \r\nKiet\r\nLong \r\nHuan\r\nLuc\r\nLong \r\nHuy\r\nPhu \r\nTrường\r\nKien \r\nKiet\r\nLong \r\nHuan\r\nLuc\r\nLong \r\nHuy\r\nPhu \r\nTrường\r\nKien \r\nKiet\r\nLong \r\nHuan\r\nLuc\r\nLong \r\nHuy\r\nPhu \r\nTrường\r\nKien \r\nKiet\r\nLong \r\nHuan\r\n");
		txtrLucLongHuy.setEditable(false);
		scrollPane.setViewportView(txtrLucLongHuy);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(10, 33, 89, 23);
		contentPane_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(123, 215, 196, 20);
		contentPane_1.add(textField);
		
		JButton btnNewButton_2 = new JButton("Send");
		btnNewButton_2.setBounds(329, 214, 89, 23);
		contentPane_1.add(btnNewButton_2);
	}

}
