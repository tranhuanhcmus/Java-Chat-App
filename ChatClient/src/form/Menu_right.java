package form;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import components.MenuButton;
import event.EventAddFriend;
import event.PublicEvent;
import io.socket.client.Ack;
import model.Model_Addfriend;
import service.Service;

public class Menu_right extends javax.swing.JPanel {
	private JTextField textField;
	private MenuButton buttonAdd;

	JLabel lblNewLabel = new JLabel("");

	public Menu_right() {
		initComponents();
	}

	private void initComponents() {

		setBackground(new java.awt.Color(249, 249, 249));
		PublicEvent.getInstance().addEventAdd(new EventAddFriend() {
			@Override
			public void addFriend(Model_Addfriend data) {
				// TODO Auto-generated method stub
				Service.getInstance().getClient().emit("Add", data.toJsonObject(), new Ack() {
					@Override
					public void call(Object... os) {
						boolean action = (boolean) os[0];
						System.out.println(action);
						if (action) {

							PublicEvent.getInstance().getEventAdd().showMessage("Success");
							lblNewLabel.setForeground(Color.GREEN);
							textField.setText("");
						} else {
							// password wrong
							PublicEvent.getInstance().getEventAdd().showMessage("No Account Exists");
							lblNewLabel.setForeground(Color.RED);
							textField.setText("");
						}

					}
				});

			}

			@Override
			public void showMessage(String message) {
				lblNewLabel.setText(message);

				lblNewLabel.setVisible(true);
			}

		});

		textField = new JTextField();
		textField.setColumns(10);
		buttonAdd = new MenuButton();
		buttonAdd.setIconSelected(new ImageIcon(getClass().getResource("../icon/add-selected.png")));
		buttonAdd.setIconSimple(new ImageIcon(getClass().getResource("../icon/add-simple.png")));

		buttonAdd.setSelected(false);
		buttonAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String b = textField.getText();

				Model_Addfriend a = new Model_Addfriend(Service.getInstance().getUser().getUserName(), b);
				PublicEvent.getInstance().getEventAdd().addFriend(a);
				System.out.println(b);
				System.out.println(a.getUserName1());

			}

		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(49).addComponent(lblNewLabel)))
						.addContainerGap(36, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(textField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(16).addComponent(lblNewLabel).addContainerGap(229, Short.MAX_VALUE)));
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents
}
