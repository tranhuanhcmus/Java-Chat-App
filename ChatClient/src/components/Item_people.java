package components;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import model.Model_User_Account;
import swing.ActiveStatus;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import event.PublicEvent;

public class Item_people extends javax.swing.JPanel {

	private ActiveStatus activeStatus;
	private swing.ImageAvatar imageAvatar1;
	private JLabel lb;
	private JLabel lbStatus;

	private boolean mouseOver;

	public Model_User_Account getUser() {
		return user;
	}

	private Model_User_Account user;

	public Item_people(Model_User_Account user) {
		this.user = user;
		initComponents();
		lb.setText(user.getUserName());
		activeStatus.setActive(user.isStatus());
		init();
	}

	public void updateStatus() {
		activeStatus.setActive(user.isStatus());
	}

	private void init() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				setBackground(new Color(230, 230, 230));
				mouseOver = true;
			}

			@Override
			public void mouseExited(MouseEvent me) {
				setBackground(new Color(242, 242, 242));
				mouseOver = false;
			}

			@Override
			public void mouseReleased(MouseEvent me) {
				if (mouseOver) {
					PublicEvent.getInstance().getEventMain().selectUser(user);
				}
			}
		});
	}

	private void initComponents() {

		imageAvatar1 = new swing.ImageAvatar();
		lb = new javax.swing.JLabel();
		lbStatus = new javax.swing.JLabel();
		activeStatus = new swing.ActiveStatus();

		setBackground(new java.awt.Color(242, 242, 242));

		imageAvatar1.setBorderSize(0);
		imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("../icon/user.png"))); // NOI18N

		lb.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		lb.setText("Name");

		lbStatus.setFont(new java.awt.Font("sansserif", 2, 12)); // NOI18N
		lbStatus.setForeground(new java.awt.Color(117, 117, 117));
		lbStatus.setText("New User");

		activeStatus.setActive(true);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addComponent(imageAvatar1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(lb, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
								.addComponent(lbStatus, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(activeStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(0, 349, Short.MAX_VALUE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup().addGap(3)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(lb).addGap(6)
										.addGroup(layout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lbStatus, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
												.addComponent(activeStatus, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														31, Short.MAX_VALUE)))
								.addComponent(imageAvatar1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGap(3)));
		this.setLayout(layout);
	}
}