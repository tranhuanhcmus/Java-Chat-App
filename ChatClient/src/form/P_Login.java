package form;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import event.PublicEvent;
import model.Model_Login;
import swing.PictureBox;

public class P_Login extends JPanel {
	private JTextField usertxt;
	private JPasswordField passwdtxt;
	public JLabel lbError;

	/**
	 * Create the panel.
	 */
	public P_Login() {
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

		passwdtxt = new JPasswordField();
		passwdtxt.setBounds(10, 137, 251, 30);
		add(passwdtxt);
		passwdtxt.setColumns(10);

		JButton cmdLogin = new JButton("Login");
		cmdLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublicEvent.getInstance().getEventLogin()
						.login(new Model_Login(usertxt.getText(), String.valueOf(passwdtxt.getPassword())));
			}
		});
		cmdLogin.setBounds(10, 418, 251, 23);
		add(cmdLogin);

		JButton cmdRegister = new JButton("Register");
		cmdRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublicEvent.getInstance().getEventLogin().goRegister();
			}
		});
		cmdRegister.setBounds(10, 453, 251, 23);
		add(cmdRegister);

		JButton btnForgetAccount = new JButton("Forget Account");
		btnForgetAccount.setBounds(10, 187, 251, 23);
		add(btnForgetAccount);

		lbError = new JLabel("");
		lbError.setForeground(new Color(255, 0, 0));
		lbError.setHorizontalAlignment(SwingConstants.CENTER);
		lbError.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbError.setBounds(20, 208, 232, 36);
		lbError.setVisible(true);
		add(lbError);

		PictureBox lblNewLabel_4 = new PictureBox();
		lblNewLabel_4.setBounds(-4, 242, 277, 166);

		lblNewLabel_4
				.setImage(new ImageIcon(P_Login.class.getResource("/icon/micah-williams-lmFJOx7hPc4-unsplash.png")));
		add(lblNewLabel_4);

	}
}
