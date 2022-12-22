package form;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;

import components.Item_people;
import components.MenuButton;
import net.miginfocom.swing.MigLayout;

public class Menu_left extends javax.swing.JPanel {

	private JLayeredPane menu;
	private MenuButton menuMessage;
	private MenuButton menuGroup;
	private MenuButton menuBox;
	private JLayeredPane menuList;
	private JScrollPane sp;

	public Menu_left() {
		initComponents();
		init();
	}

	private void init() {
		sp.setVerticalScrollBar(new JScrollBar());
		menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
		showMessage();
	}

	private void showMessage() {
		// test data
		menuList.removeAll();
		for (int i = 0; i < 20; i++) {
			menuList.add(new Item_people("People " + i), "wrap");
		}
		refreshMenuList();
	}

	private void showGroup() {
		// test data
		menuList.removeAll();
		for (int i = 0; i < 5; i++) {
			menuList.add(new Item_people("Group " + i), "wrap");
		}
		refreshMenuList();
	}

	private void showBox() {
		// test data
		menuList.removeAll();
		for (int i = 0; i < 10; i++) {
			menuList.add(new Item_people("Box " + i), "wrap");
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