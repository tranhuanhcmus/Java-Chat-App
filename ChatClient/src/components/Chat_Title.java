package components;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Model_User_Account;

public class Chat_Title extends JPanel {

	/**
	 * Creates new form Chat_Title
	 */
	private Model_User_Account user;
	private JLayeredPane layer;
	private JLabel lbName;
	private JLabel lbStatus;

	public Chat_Title() {
		initComponents();
	}

	public Model_User_Account getUser() {
		return this.user;
	}

	public void setUserName(Model_User_Account user) {
		this.user = user;
		lbName.setText(user.getUserName());
		if (user.isStatus()) {
			statusActive();
		} else {
			setStatusText("Offline");
		}
	}

	public void updateUser(Model_User_Account user) {
		if (this.user == user) {
			lbName.setText(user.getUserName());
			if (user.isStatus()) {
				statusActive();
			} else {
				setStatusText("Offline");
			}
		}
	}

	private void statusActive() {
		lbStatus.setText("Active now");
		lbStatus.setForeground(new java.awt.Color(40, 147, 59));
	}

	private void setStatusText(String text) {
		lbStatus.setText(text);
		lbStatus.setForeground(new Color(160, 160, 160));
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		layer = new JLayeredPane();
		lbName = new JLabel();
		lbStatus = new JLabel();

		setBackground(new java.awt.Color(242, 242, 242));

		layer.setLayout(new java.awt.GridLayout(0, 1));

		lbName.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
		lbName.setForeground(new java.awt.Color(66, 66, 66));
		lbName.setText("Name");
		layer.add(lbName);

		lbStatus.setForeground(new java.awt.Color(40, 147, 59));
		lbStatus.setText("Active now ");

		layer.add(lbStatus);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup().addContainerGap().addComponent(layer, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(406, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(3, 3, 3)
						.addComponent(layer, GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE).addGap(3, 3, 3)));
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	// End of variables declaration//GEN-END:variables
}
