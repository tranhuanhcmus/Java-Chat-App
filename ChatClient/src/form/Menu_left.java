package form;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;

import components.Item_addFriend;
import components.Item_people;
import components.MenuButton;
import event.EventMenuLeft;
import event.PublicEvent;
import model.Model_User_Account;
import net.miginfocom.swing.MigLayout;
import swing.ScrollBar;

public class Menu_left extends javax.swing.JPanel {

	private JLayeredPane menu;
	private MenuButton menuMessage;
	private MenuButton menuGroup;
	private MenuButton menuBox;
	private JLayeredPane menuList;
	private JScrollPane sp;
	private List<Model_User_Account> userAccount;
	private List<Model_User_Account> userAddFriend;

	public Menu_left() {
		initComponents();
		init();
	}

	private void init() {
		sp.setVerticalScrollBar(new ScrollBar());
		menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
		userAccount = new ArrayList<>();
		userAddFriend = new ArrayList<>();
		PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
			@Override
			public void newUser(List<Model_User_Account> users) {
				for (Model_User_Account d : users) {
					userAccount.add(d);
					menuList.add(new Item_people(d), "wrap");
					refreshMenuList();
				}
			}

			@Override
			public void userConnect(int userID) {
				for (Model_User_Account u : userAccount) {
					if (u.getUserID() == userID) {
						u.setStatus(true);
						PublicEvent.getInstance().getEventMain().updateUser(u);
						break;
					}
				}
				if (menuMessage.isSelected()) {
					for (Component com : menuList.getComponents()) {
						Item_people item = (Item_people) com;
						if (item.getUser().getUserID() == userID) {
							item.updateStatus();
							break;
						}
					}
				}
			}

			@Override
			public void userDisconnect(int userID) {
				for (Model_User_Account u : userAccount) {
					if (u.getUserID() == userID) {
						u.setStatus(false);
						PublicEvent.getInstance().getEventMain().updateUser(u);
						break;
					}
				}
				if (menuMessage.isSelected()) {
					for (Component com : menuList.getComponents()) {
						Item_people item = (Item_people) com;
						if (item.getUser().getUserID() == userID) {
							item.updateStatus();
							break;
						}
					}
				}
			}

			@Override
			public void newAddFriend(List<Model_User_Account> users) {
				for (Model_User_Account d : users) {
					userAddFriend.add(d);
				}

			}
		});
		showMessage();
	}

	private void showMessage() {
		// test data
		menuList.removeAll();
		for (Model_User_Account d : userAccount) {
			menuList.add(new Item_people(d), "wrap");
		}
		refreshMenuList();
	}

	private void showGroup() {
		// test data
		menuList.removeAll();
		Model_User_Account a = new Model_User_Account("chua cai dat", true);
		for (int i = 0; i < 5; i++) {
			menuList.add(new Item_people(a), "wrap");
		}
		refreshMenuList();
	}

	private void showBox() {
		// test data
		menuList.removeAll();
		for (Model_User_Account d : userAddFriend) {
			menuList.add(new Item_addFriend(d), "wrap");
		}
		refreshMenuList();
	}

	private void refreshMenuList() {
		menuList.repaint();
		menuList.revalidate();
	}

	private void menuMessageActionPerformed(ActionEvent evt) {// GEN-FIRST:event_menuMessageActionPerformed
		if (!menuMessage.isSelected()) {
			menuMessage.setSelected(true);
			menuGroup.setSelected(false);
			menuBox.setSelected(false);
			showMessage();
		}
	}// GEN-LAST:event_menuMessageActionPerformed

	private void menuGroupActionPerformed(ActionEvent evt) {// GEN-FIRST:event_menuGroupActionPerformed
		if (!menuGroup.isSelected()) {
			menuMessage.setSelected(false);
			menuGroup.setSelected(true);
			menuBox.setSelected(false);
			showGroup();
		}
	}// GEN-LAST:event_menuGroupActionPerformed

	private void menuBoxActionPerformed(ActionEvent evt) {// GEN-FIRST:event_menuBoxActionPerformed
		if (!menuBox.isSelected()) {
			menuMessage.setSelected(false);
			menuGroup.setSelected(false);
			menuBox.setSelected(true);
			showBox();

		}
	}// GEN-LAST:event_menuBoxActionPerforme

	@SuppressWarnings("unchecked")

	private void initComponents() {

		menu = new JLayeredPane();
		menuMessage = new MenuButton();
		menuGroup = new MenuButton();
		menuBox = new MenuButton();
		menuList = new JLayeredPane();
		sp = new JScrollPane();

		menu.setBackground(new Color(242, 242, 242));
		menu.setOpaque(true);
		menu.setLayout(new BoxLayout(menu, javax.swing.BoxLayout.LINE_AXIS));

		menuMessage.setIconSelected(new ImageIcon(getClass().getResource("../icon/message_selected.png")));

		menuMessage.setIconSimple(new ImageIcon(getClass().getResource("../icon/message.png"))); // NOI18N
		menuMessage.setSelected(true);
		menuMessage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuMessageActionPerformed(evt);
			}
		});
		menu.add(menuMessage);

		menuGroup.setIconSelected(new ImageIcon(getClass().getResource("../icon/group_selected.png")));

		menuGroup.setIconSimple(new ImageIcon(getClass().getResource("../icon/group.png"))); // NOI18N
		menuGroup.setSelected(false);
		menuGroup.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuGroupActionPerformed(evt);
			}
		});
		menu.add(menuGroup);

		menuBox.setIconSelected(new ImageIcon(getClass().getResource("../icon/box_selected.png")));
		menuBox.setIconSimple(new ImageIcon(getClass().getResource("../icon/box.png")));
		menuBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuBoxActionPerformed(evt);
			}
		});
		menuBox.setSelected(false);
		menu.add(menuBox);

		javax.swing.GroupLayout menuListLayout = new GroupLayout(menuList);
		menuList.setLayout(menuListLayout);
		menuListLayout.setHorizontalGroup(
				menuListLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		menuListLayout.setVerticalGroup(
				menuListLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 576, Short.MAX_VALUE));

		sp.setBackground(new Color(242, 242, 242));
		sp.setBorder(null);

		sp.setViewportView(menuList);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(menu, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(sp).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(menu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(sp).addContainerGap()));

	}
}