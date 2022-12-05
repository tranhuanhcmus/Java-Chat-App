package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class UserManagement extends JFrame {

	private boolean userTableMode = true;

	private static final long serialVersionUID = 1L;
	private JButton addBtn;
	private JButton editBtn;
	private JButton deleteBtn;
	private JButton clearBtn;
	private JButton lockBtn;
	private JButton updatePassBtn;

	private JButton sortNameBtn;
	private JButton sortDateBtn;
	private JButton historyBtn;
	private JButton friendBtn;

	private JScrollPane jScrollPaneuserTable;
	private JTable userTable;

	private JLabel userLabel;
	private JLabel nameLabel;
	private JLabel dateLabel;
	private JLabel addressLabel;
	private JLabel emailLabel;
	private JLabel genderLabel;

	private JTextField userField;
	private JTextField nameField;
	private JTextField dateField;
	private JTextArea addressTA;
	private JTextField emailField;
	private JTextField genderField;

	// định nghĩa các cột của bảng user
	private String[] columnNames = new String[] { "UserName", "Name", "CreateDay", "Address", "Email", "Gender" };
	private String[] columnHistory = new String[] { "UserName", "Name", "Date" };
	// định nghĩa dữ liệu mặc định của bẳng user là rỗng
	private Object[][] userData = { { "cunconbs000", "Smith", new Date(), "Binh Dinh", "tranhuan@gmail.com", "Nam" },
			{ "vitcon1230", "harry", new Date(), "TP HCM", "convit@gmail.com", "Nu" },
			{ "heocon1230", "Ut it", new Date(), "Nghe An", "conheo@gmail.com", "Nu" },
			{ "Conga123", "Chicken", new Date(), "TP HCM", "conga@gmail.com", "Nam" },

	};
	private Object[][] historyData = { { "cunconbs000", "Smith", new Date() }, { "vitcon1230", "harry", new Date() },
			{ "heocon1230", "Ut it", new Date() }, { "Conga123", "Chicken", new Date() },

	};
	private Object[][] data = userData;

	public UserManagement() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// khởi tạo các phím chức năng
		addBtn = new JButton("Add");
		editBtn = new JButton("Edit");
		deleteBtn = new JButton("Delete");
		clearBtn = new JButton("Clear");
		lockBtn = new JButton("Lock");
		updatePassBtn = new JButton("Update PassWord");

		sortNameBtn = new JButton("Sort By Name");
		sortDateBtn = new JButton("Sort By Date");
		historyBtn = new JButton("Show History");
		friendBtn = new JButton("Show Friend List");

		// khởi tạo bảng user
		jScrollPaneuserTable = new JScrollPane();
		userTable = new JTable();

		// khởi tạo các label
		userLabel = new JLabel("UserName");
		nameLabel = new JLabel("Name");
		dateLabel = new JLabel("CreateDay");
		addressLabel = new JLabel("Address");
		emailLabel = new JLabel("Email");
		genderLabel = new JLabel("Gender");

		// khởi tạo các trường nhập dữ liệu cho user
		userField = new JTextField(15);

		nameField = new JTextField(15);
		dateField = new JTextField(6);
		addressTA = new JTextArea();
		addressTA.setColumns(15);
		addressTA.setRows(3);
		emailField = new JTextField(15);
		genderField = new JTextField(5);

		// cài đặt các cột và data cho bảng user
		userTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
		userTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jScrollPaneuserTable.setViewportView(userTable);
		jScrollPaneuserTable.setPreferredSize(new Dimension(800, 300));

		// tạo spring layout
		SpringLayout layout = new SpringLayout();
		// tạo đối tượng panel để chứa các thành phần của màn hình quản lý user
		JPanel panel = new JPanel();
		panel.setSize(800, 420);
		panel.setLayout(layout);
		panel.add(jScrollPaneuserTable);

		panel.add(addBtn);
		panel.add(editBtn);
		panel.add(deleteBtn);
		panel.add(clearBtn);
		panel.add(lockBtn);
		panel.add(updatePassBtn);

		panel.add(sortNameBtn);
		panel.add(sortDateBtn);
		panel.add(historyBtn);
		panel.add(friendBtn);

		panel.add(userLabel);
		panel.add(nameLabel);
		panel.add(dateLabel);
		panel.add(addressLabel);
		panel.add(emailLabel);
		panel.add(genderLabel);

		panel.add(userField);
		panel.add(nameField);
		panel.add(dateField);
		panel.add(emailField);
		panel.add(genderField);

		// cài đặt vị trí các thành phần trên màn hình login
		layout.putConstraint(SpringLayout.WEST, userLabel, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, userLabel, 10, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, dateLabel, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, dateLabel, 70, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, addressLabel, 100, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, genderLabel, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, genderLabel, 165, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, emailLabel, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, emailLabel, 200, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, userField, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, userField, 10, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, dateField, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, dateField, 70, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, addressTA, 100, SpringLayout.WEST, panel);
//		layout.putConstraint(SpringLayout.NORTH, addressTA, 150, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, genderField, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, genderField, 165, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, emailField, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, emailField, 200, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, jScrollPaneuserTable, 300, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jScrollPaneuserTable, 10, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, addBtn, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, addBtn, 240, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, editBtn, 60, SpringLayout.WEST, addBtn);
		layout.putConstraint(SpringLayout.NORTH, editBtn, 240, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, deleteBtn, 60, SpringLayout.WEST, editBtn);

		layout.putConstraint(SpringLayout.NORTH, clearBtn, 240, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteBtn);

		layout.putConstraint(SpringLayout.NORTH, lockBtn, 10, SpringLayout.SOUTH, clearBtn);
		layout.putConstraint(SpringLayout.WEST, lockBtn, 0, SpringLayout.WEST, clearBtn);

		layout.putConstraint(SpringLayout.NORTH, updatePassBtn, 10, SpringLayout.SOUTH, clearBtn);
		layout.putConstraint(SpringLayout.WEST, updatePassBtn, 0, SpringLayout.WEST, addBtn);

		layout.putConstraint(SpringLayout.NORTH, deleteBtn, 240, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, sortNameBtn, 300, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, sortNameBtn, 330, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, sortDateBtn, 10, SpringLayout.EAST, sortNameBtn);
		layout.putConstraint(SpringLayout.NORTH, sortDateBtn, 330, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, historyBtn, 10, SpringLayout.EAST, sortDateBtn);
		layout.putConstraint(SpringLayout.NORTH, historyBtn, 330, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, friendBtn, 10, SpringLayout.EAST, historyBtn);
		layout.putConstraint(SpringLayout.NORTH, friendBtn, 330, SpringLayout.NORTH, panel);

		// setting btn
		historyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (userTableMode) {
					data = historyData;
					userTable.setModel(new DefaultTableModel((Object[][]) data, columnHistory));
				} else {
					data = userData;
					userTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
				}
				userTableMode = !userTableMode;

			}
		});

		userTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// do some actions here, for example
				// print first column value from selected row
				editBtn.setEnabled(true);
				deleteBtn.setEnabled(true);
				lockBtn.setEnabled(true);
				updatePassBtn.setEnabled(true);
				friendBtn.setEnabled(true);
			}
		});

		this.add(panel);
		this.pack();

		this.setTitle("user Manager");

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int vh = (int) dimension.getHeight();
		int vw = (int) dimension.getWidth();
		this.setSize(vw * 3 / 4, vh / 2);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		// disable Edit and Delete buttons
		editBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		lockBtn.setEnabled(false);
		updatePassBtn.setEnabled(false);
		friendBtn.setEnabled(false);
		// enable Add button
		addBtn.setEnabled(true);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Hi");
				new UserManagement();
			}
		});
	}

}
