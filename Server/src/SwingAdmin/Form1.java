package SwingAdmin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Connection.DatabaseConnection;

public class Form1 extends JFrame {

	private JPanel contentPane;

	private JTable table_1;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JButton btnForm;
	private JTextField textForm;

	/**
	 * Launch the application.
	 * 
	 * 
	 * /** Create the frame.
	 */

	public Form1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textForm = new JTextField();
		textForm.setBounds(400, 10, 200, 29);

		btnForm = new JButton("Find");
		btnForm.setBounds(610, 10, 80, 29);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "username", "userid", "birth" }));
		comboBox.setBounds(167, 13, 144, 22);
		contentPane.add(comboBox);

		contentPane.add(btnForm);
		contentPane.add(textForm);
		DatabaseConnection co = new DatabaseConnection();
		try {
			co.connectToDatabase();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Connection conn = co.getConnection();

		btnForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
				tableModel.setRowCount(0);
				try {

					PreparedStatement stmt = conn
							.prepareStatement("select * from user_account WHERE userid = ? or username = ? ");
					int i = 1;

					stmt.setString(1, textForm.getText());

					stmt.setString(2, textForm.getText());

					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {

						Object[] row = { i, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8) };

						tableModel.addRow(row);
						i++;

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		table_1 = new JTable();
		table_1.setColumnSelectionAllowed(false);
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "UserID", "UserName", "Gender", "Status", "Name", "Address", "Birth", "Email" }) {
			/**
							 * 
							 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(2).setPreferredWidth(124);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(96);
		table_1.setBounds(35, 67, 1011, 335);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 52, 1021, 320);
		scrollPane.setViewportView(table_1);
		contentPane.add(scrollPane);

		btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread th = new Thread() {
					public void run() {

						try {
							Form2 frame = new Form2();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				};
				th.start();

			}
		});
		btnNewButton.setBounds(919, 399, 85, 21);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
				tableModel.setRowCount(0);

				try {
					int i = 1;
					String typess = (String) comboBox.getSelectedItem().toString();
					PreparedStatement stmt = conn.prepareStatement("select * from user_account order by " + typess);

					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {

						Object[] row = { i, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8) };

						tableModel.addRow(row);
						i++;

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel rowSM = table_1.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// Ignore extra messages.
				if (e.getValueIsAdjusting()) {
					return;
				}
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (lsm.isSelectionEmpty()) {
					System.out.println("No rows are selected.");
				} else {
					int selectedRow = lsm.getMinSelectionIndex();
					System.out.println("Row " + selectedRow + " is now selected.");
					// Display data from column
					// selected
					System.out.println(table_1.getValueAt(table_1.getSelectedRow(), 2));

				}
			}
		});
		btnNewButton_1.setBounds(26, 20, 85, 21);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement stmt;
				try {
					String a = (String) table_1.getValueAt(table_1.getSelectedRow(), 1);

					stmt = conn.prepareStatement("DELETE FROM user_account WHERE userid = ?");
					stmt.setString(1, a);
					stmt.execute();
					stmt = conn.prepareStatement("DELETE FROM user WHERE userid = ?");
					stmt.setString(1, a);
					stmt.execute();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block

					e1.printStackTrace();
				}

			}
		});
		btnNewButton_2.setBounds(805, 398, 89, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Login History");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread th = new Thread() {
					public void run() {

						try {
							Form_History frame = new Form_History();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				};
				th.start();
			}
		});
		btnNewButton_3.setBounds(898, 14, 116, 21);
		contentPane.add(btnNewButton_3);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form1 frame = new Form1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
