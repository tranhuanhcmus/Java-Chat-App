package form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import event.EventMessage;
import event.PublicEvent;
import model.Model_Message;
import model.Model_Register;
import java.awt.Dimension;

public class P_Register extends JPanel {
	private JTextField usertxt;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lbError;
	/**
	 * Create the panel.
	 */
	public P_Register() {
		setMaximumSize(new Dimension(32767, 32800));
		setBorder(new LineBorder(Color.PINK));
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
		usertxt.setBounds(10, 71, 249, 30);
		add(usertxt);
		usertxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(10, 101, 259, 14);
		add(lblNewLabel_2);
		
		JButton cmdRegister = new JButton("Register");
		cmdRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = usertxt.getText().trim();
				
				String password = String.valueOf(passwordField.getPassword());
				String cpassword = String.valueOf(passwordField_1.getPassword());
				if(userName.equals("")) {
					usertxt.grabFocus();
				}
				else if(password.equals("")) {
					passwordField.grabFocus();
				}
				else if (!password.equals(cpassword)) {
					passwordField.grabFocus();
				}
				else {
					Model_Register data = new Model_Register(userName, password);
		            PublicEvent.getInstance().getEventLogin().register(data, new EventMessage() {
		                public void callMessage(Model_Message message) {
	                    if (!message.isAction()) {
	                        lbError.setText(message.getMessage());
		                    } else {
		                        PublicEvent.getInstance().getEventLogin().login();
		                    }
		                }
		            });
				}
				
			}
		});
		cmdRegister.setBounds(10, 222, 249, 23);
		add(cmdRegister);
		
		JLabel lblNewLabel_2_1 = new JLabel("Confirm Password");
		lblNewLabel_2_1.setBounds(10, 156, 259, 14);
		add(lblNewLabel_2_1);
		
		JButton Back = new JButton("Back Login");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublicEvent.getInstance().getEventLogin().goLogin();;
			}
		});
		Back.setBounds(10, 256, 249, 23);
		add(Back);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 122, 249, 23);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(10, 173, 249, 23);
		add(passwordField_1);
		
		lbError = new JLabel("");
		lbError.setForeground(Color.RED);
		lbError.setHorizontalAlignment(SwingConstants.CENTER);
		lbError.setBounds(10, 197, 249, 14);
		add(lbError);

	}
}
