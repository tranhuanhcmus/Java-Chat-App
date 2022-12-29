package form;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import event.PublicEvent;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class P_Login extends JPanel {
	private JTextField usertxt;
	private JTextField passwdtxt;

	/**
	 * Create the panel.
	 */
	public P_Login() {
		setBorder(new LineBorder(Color.PINK));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 271, 44);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(10, 67, 251, 14);
		add(lblNewLabel_1);
		
		usertxt = new JTextField();
		usertxt.setBounds(10, 81, 251, 30);
		add(usertxt);
		usertxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(10, 112, 251, 14);
		add(lblNewLabel_2);
		
		passwdtxt = new JTextField();
		passwdtxt.setBounds(10, 137, 251, 30);
		add(passwdtxt);
		passwdtxt.setColumns(10);
		
		JButton cmdLogin = new JButton("Login");
		cmdLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublicEvent.getInstance().getEventMain().showLoading(true);
				try {
					Thread.sleep(1000);
				} catch (Exception e2) {
					
				}
				PublicEvent.getInstance().getEventMain().initChat();
				PublicEvent.getInstance().getEventLogin().login();
			}
		});
		cmdLogin.setBounds(10, 194, 251, 23);
		add(cmdLogin);
		
		JButton cmdRegister = new JButton("Register");
		cmdRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublicEvent.getInstance().getEventLogin().goRegister();
			}
		});
		cmdRegister.setBounds(10, 242, 251, 23);
		add(cmdRegister);

	}
}
