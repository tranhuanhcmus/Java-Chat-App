package form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import event.EventMessage;
import event.PublicEvent;
import model.Model_Message;
import model.Model_Register;

public class P_Register extends JPanel {
	private JTextField usertxt;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField emailField;

	/**
	 * Create the panel.
	 */
	public P_Register() {
		setMaximumSize(new Dimension(32767, 32800));
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 269, 44);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(10, 55, 259, 14);
		add(lblNewLabel_1);

		usertxt = new JTextField();
		usertxt.setBounds(10, 71, 249, 23);
		add(usertxt);
		usertxt.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(10, 101, 259, 14);
		add(lblNewLabel_2);

		JLabel lbError = new JLabel("New label");
		lbError.setHorizontalAlignment(SwingConstants.CENTER);
		lbError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbError.setForeground(new Color(255, 0, 0));
		lbError.setBounds(10, 372, 249, 36);
		lbError.setVisible(false);
		add(lbError);

		JButton cmdRegister = new JButton("Register");
		cmdRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = usertxt.getText().trim();

				String password = String.valueOf(passwordField.getPassword());
				String cpassword = String.valueOf(passwordField_1.getPassword());
				String name = String.valueOf(nameField.getText());
				String email = String.valueOf(emailField.getText());
				String address = String.valueOf(addressField.getText());

				if (userName.equals("")) {
					usertxt.grabFocus();
				} else if (password.equals("")) {
					passwordField.grabFocus();
				} else if (name.equals("")) {
					nameField.grabFocus();
				} else if (email.equals("") || !isEmail(email)) {
					emailField.grabFocus();
				} else if (!password.equals(cpassword)) {
					passwordField.grabFocus();
				} else {

					Date date = new Date(System.currentTimeMillis());
					Model_Register data = new Model_Register(userName, name, address, date, password);
					PublicEvent.getInstance().getEventLogin().register(data, new EventMessage() {
						public void callMessage(Model_Message message) {
							if (!message.isAction()) {
								lbError.setText(message.getMessage());
								lbError.setVisible(true);
							} else {
								PublicEvent.getInstance().getEventMain().initChat();
							}
						}
					});
				}

			}
		});
		cmdRegister.setBounds(10, 453, 249, 23);
		add(cmdRegister);

		JLabel lblNewLabel_2_1 = new JLabel("Confirm Password");
		lblNewLabel_2_1.setBounds(10, 159, 259, 14);
		add(lblNewLabel_2_1);

		JButton Back = new JButton("Back Login");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublicEvent.getInstance().getEventLogin().goLogin();
				;
			}
		});
		Back.setBounds(10, 418, 249, 25);
		add(Back);

		passwordField = new JPasswordField();
		passwordField.setBounds(10, 118, 249, 23);
		add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(10, 183, 249, 23);
		add(passwordField_1);

		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setBounds(10, 206, 45, 13);
		add(lblNewLabel_3);

		nameField = new JTextField();
		nameField.setBounds(10, 227, 249, 23);
		add(nameField);
		nameField.setColumns(10);

		addressField = new JTextField();
		addressField.setBounds(10, 283, 249, 23);
		add(addressField);
		addressField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(10, 260, 45, 13);
		add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setBounds(10, 316, 45, 13);
		add(lblNewLabel_6);

		emailField = new JTextField();
		emailField.setBounds(10, 339, 249, 23);
		add(emailField);
		emailField.setColumns(10);

	}

	public static boolean isEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
}
