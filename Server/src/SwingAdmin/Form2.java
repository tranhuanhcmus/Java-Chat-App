package SwingAdmin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Connection.DatabaseConnection;
import model.Model_User_Account;

public class Form2 extends JFrame {

	private Model_User_Account person;
	private JPanel contentPane;
	private JTextField IdField;
	private JTextField UserNameField;
	private JLabel UserNameLabel;
	private JTextField genderField;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_7;
	private JTextField StatusField;
	private JPasswordField PasswordField;
	private JTextField nameField;
	private JTextField textField;
	private JTextField birthField;
	private JTextField EmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form2 frame = new Form2();
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

	public Form2() {
//		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 443);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("EditInf");
		lblNewLabel.setBounds(437, 27, 100, 29);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(56, 95, 53, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);

		IdField = new JTextField();
		IdField.setBounds(198, 95, 202, 25);
		contentPane.add(IdField);
		IdField.setColumns(10);

		UserNameField = new JTextField();
		UserNameField.setColumns(10);
		UserNameField.setBounds(198, 154, 202, 25);
		contentPane.add(UserNameField);

		UserNameLabel = new JLabel("username");
		UserNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserNameLabel.setBounds(56, 154, 132, 25);
		contentPane.add(UserNameLabel);

		genderField = new JTextField();
		genderField.setColumns(10);
		genderField.setBounds(198, 207, 202, 25);
		contentPane.add(genderField);

		lblNewLabel_4 = new JLabel("gender");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(56, 203, 132, 25);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_7 = new JLabel("status");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(437, 95, 138, 25);
		contentPane.add(lblNewLabel_7);
		DatabaseConnection co = new DatabaseConnection();
		try {
			co.connectToDatabase();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Connection conn = co.getConnection();

		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String s = e.getActionCommand();
				if (!s.equals(null)) {
					String Id = IdField.getText();
					int id = Integer.parseInt(Id);
					String name = UserNameField.getText();

//					String sDate1 = date.getText();
//					Date date1 = null;
//					try {
//						date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
//					} catch (ParseException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					String gender = genderField.getText();
					String status = StatusField.getText();
					String password = String.valueOf(PasswordField.getPassword());

					String nameofpeople = nameField.getText();
					String address = textField.getText();
					String email = EmailField.getText();

					String sDate1 = birthField.getText();
					Date date1 = null;
					try {
						date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String query = "INSERT INTO user_account "
							+ "(userid,username,gender,status,name,address,birth,email)" + " VALUES(?,?,?,?,?,?,?,?) ";

					PreparedStatement mystmt;
					try {
						mystmt = conn.prepareStatement("select * from user WHERE userid = ? ");
						mystmt.setInt(1, id);
						ResultSet rs = mystmt.executeQuery();
						if (rs.next()) {
							try {
								mystmt = conn.prepareStatement(
										"Update user set username = ? , password =? where userid = ? ");
								mystmt.setString(1, name);
								mystmt.setString(2, password);
								mystmt.setInt(3, id);

								mystmt.execute();

								mystmt = conn.prepareStatement("Update user_account set username = ?, gender = ? ,"
										+ "status = ? , name = ? , address = ? ,birth = ? , email = ? where userid = ?");
								mystmt.setString(1, name);
								mystmt.setString(2, gender);
								mystmt.setString(3, status);
								mystmt.setString(4, nameofpeople);
								mystmt.setString(5, address);
								mystmt.setDate(6, new java.sql.Date(date1.getTime()));
								mystmt.setString(7, email);

								mystmt.setInt(8, id);

								mystmt.execute();
								mystmt.close();

							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "update Successfully", "Msg",
									JOptionPane.PLAIN_MESSAGE);
							setVisible(false);
						} else {
							try {
								mystmt = conn.prepareStatement(
										"INSERT INTO user " + "(userid,username,password)" + " VALUES(?,?,?) ");
								mystmt.setInt(1, id);
								mystmt.setString(2, name);
								mystmt.setString(3, password);

								mystmt.execute();

								mystmt = conn.prepareStatement(query);
								mystmt.setInt(1, id);
								mystmt.setString(2, name);
								mystmt.setString(3, gender);
								mystmt.setString(4, status);
								mystmt.setString(5, nameofpeople);
								mystmt.setString(6, address);
								mystmt.setDate(7, new java.sql.Date(date1.getTime()));
								mystmt.setString(8, email);

								mystmt.execute();
								mystmt.close();

							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							JOptionPane.showMessageDialog(null, "Add successfully ", "Msg", JOptionPane.PLAIN_MESSAGE);
							setVisible(false);
						}

					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				}
			}
		});
		btnNewButton.setBounds(670, 366, 126, 27);
		contentPane.add(btnNewButton);

		StatusField = new JTextField();
		StatusField.setColumns(10);
		StatusField.setBounds(540, 95, 202, 25);
		contentPane.add(StatusField);

		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordLabel.setBounds(437, 150, 93, 25);
		contentPane.add(passwordLabel);

		PasswordField = new JPasswordField();
		PasswordField.setColumns(10);
		PasswordField.setBounds(540, 150, 202, 25);
		contentPane.add(PasswordField);

		JLabel NameLabel = new JLabel("name");
		NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NameLabel.setBounds(437, 203, 93, 25);
		contentPane.add(NameLabel);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(540, 200, 202, 25);
		contentPane.add(nameField);

		JLabel lblAddress = new JLabel("address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(437, 254, 93, 25);
		contentPane.add(lblAddress);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(540, 256, 202, 25);
		contentPane.add(textField);

		JLabel lblBirth = new JLabel("birth");
		lblBirth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBirth.setBounds(56, 254, 93, 25);
		contentPane.add(lblBirth);

		birthField = new JTextField();
		birthField.setColumns(10);
		birthField.setBounds(198, 258, 202, 25);
		contentPane.add(birthField);

		JLabel EmailLabel = new JLabel("email");
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EmailLabel.setBounds(437, 314, 93, 25);
		contentPane.add(EmailLabel);

		EmailField = new JTextField();
		EmailField.setColumns(10);
		EmailField.setBounds(540, 312, 202, 25);
		contentPane.add(EmailField);

	}
}
