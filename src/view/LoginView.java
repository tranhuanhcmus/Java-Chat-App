package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class LoginView extends JFrame implements ActionListener {

	private JLabel userNameLabel;
	private JLabel passwordlabel;
	private JPasswordField passwordField;
	private JTextField userNameField;
	private JButton loginBtn;

	public LoginView() {
		// TODO Auto-generated constructor stub
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		userNameLabel = new JLabel("User Name");
		passwordlabel = new JLabel("PassWord");
		userNameField = new JTextField(15);
		passwordField = new JPasswordField(15);
		loginBtn = new JButton();

		loginBtn.setText("Login");
		loginBtn.addActionListener(this);

		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel();

		// tạo đối tượng panel để chứa các thành phần của màn hình login
		panel.setSize(400, 300);
		panel.setLayout(layout);
		panel.add(userNameLabel);
		panel.add(passwordlabel);
		panel.add(userNameField);
		panel.add(passwordField);
		panel.add(loginBtn);

		// cài đặt vị trí các thành phần trên màn hình login
		layout.putConstraint(SpringLayout.WEST, userNameLabel, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, userNameLabel, 80, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, passwordlabel, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, passwordlabel, 105, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, userNameField, 80, SpringLayout.WEST, userNameLabel);
		layout.putConstraint(SpringLayout.NORTH, userNameField, 80, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, passwordField, 80, SpringLayout.WEST, passwordlabel);
		layout.putConstraint(SpringLayout.NORTH, passwordField, 105, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, loginBtn, 80, SpringLayout.WEST, passwordlabel);
		layout.putConstraint(SpringLayout.NORTH, loginBtn, 130, SpringLayout.NORTH, panel);

		// add panel tới JFrame
		this.add(panel, BorderLayout.CENTER);

		// add title for Jrame
		JLabel title = new JLabel("Admin Sign In".toUpperCase(), SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 32));
		title.setForeground(Color.RED);
		this.add(title, BorderLayout.NORTH);

		// cài đặt các thuộc tính cho JFrame
		this.setTitle("Login");
		this.setLocationRelativeTo(null);
		this.setSize(400, 300);
		this.setResizable(false);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new LoginView();
			}
		});
	}
}
