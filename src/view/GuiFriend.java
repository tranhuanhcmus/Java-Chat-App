package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;

public class GuiFriend extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiFriend frame = new GuiFriend();
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
	public GuiFriend() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 532, 22);
		contentPane.add(menuBar);
		
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
		separator_1.setBounds(97, 62, 2, 175);
		contentPane.add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(109, 64, 413, 175);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nguyễn Văn A");
		lblNewLabel_1.setBounds(10, 8, 80, 16);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Hủy kết bạn");
		btnNewButton.setBounds(105, 6, 91, 23);
		panel.add(btnNewButton);
		
		JButton btnChat = new JButton("Chat");
		btnChat.setBounds(227, 6, 66, 23);
		panel.add(btnChat);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nguyễn Văn A");
		lblNewLabel_1_2.setBounds(10, 49, 80, 16);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBackground(Color.LIGHT_GRAY);
		panel.add(lblNewLabel_1_2);
		
		JButton btnNewButton_2 = new JButton("Hủy kết bạn");
		btnNewButton_2.setBounds(105, 47, 91, 23);
		panel.add(btnNewButton_2);
		
		JButton btnChat_2 = new JButton("Chat");
		btnChat_2.setBounds(227, 47, 66, 23);
		panel.add(btnChat_2);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(385, 8, 17, 156);
		panel.add(scrollBar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nguyễn Văn A");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setBounds(10, 90, 80, 16);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("Hủy kết bạn");
		btnNewButton_1.setBounds(105, 88, 91, 23);
		panel.add(btnNewButton_1);
		
		JButton btnChat_1 = new JButton("Chat");
		btnChat_1.setBounds(227, 88, 66, 23);
		panel.add(btnChat_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nguyễn Văn A");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_2_1.setBounds(10, 131, 80, 16);
		panel.add(lblNewLabel_1_2_1);
		
		JButton btnNewButton_2_1 = new JButton("Hủy kết bạn");
		btnNewButton_2_1.setBounds(105, 129, 91, 23);
		panel.add(btnNewButton_2_1);
		
		JButton btnChat_2_1 = new JButton("Chat");
		btnChat_2_1.setBounds(227, 129, 66, 23);
		panel.add(btnChat_2_1);
		
		JLabel lblNewLabel = new JLabel("Danh sách bạn");
		lblNewLabel.setBounds(16, 120, 71, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("User name:");
		lblNewLabel_2.setBounds(45, 37, 73, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(133, 33, 91, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Add");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(267, 30, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
