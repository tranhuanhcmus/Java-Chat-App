package components;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import event.PublicEvent;
import event.accepted;
import io.socket.client.Ack;
import model.Model_Addfriend;
import model.Model_User_Account;
import service.Service;

public class Item_addFriend extends javax.swing.JPanel {

	private MenuButton buttonAdd;
	private JLayeredPane menu;
	private swing.ImageAvatar imageAvatar1;
	private JLabel lb;

	private boolean mouseOver;

	public Model_User_Account getUser() {
		return user;
	}

	private Model_User_Account user;

	public Item_addFriend(Model_User_Account user) {
		this.user = user;
		initComponents();
		lb.setText(user.getUserName());
	}

	private void initComponents() {

		imageAvatar1 = new swing.ImageAvatar();
		lb = new javax.swing.JLabel();
		PublicEvent.getInstance().addEventExccept(new accepted() {
			@Override
			public void addFriend(Model_Addfriend data) {
				// TODO Auto-generated method stub
				Service.getInstance().getClient().emit("Accept", data.toJsonObject(), new Ack() {
					@Override
					public void call(Object... os) {
						boolean action = (boolean) os[0];
						System.out.println(os[0]);

					}
				});

			}

		});

		menu = new JLayeredPane();
		menu.setBackground(new Color(242, 242, 242));
		menu.setOpaque(true);
		menu.setLayout(new BoxLayout(menu, javax.swing.BoxLayout.LINE_AXIS));

		setBackground(new java.awt.Color(242, 242, 242));

		imageAvatar1.setBorderSize(0);
		imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("../icon/user.png"))); // NOI18N

		lb.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		lb.setText("Name");

		buttonAdd = new MenuButton();
		buttonAdd.setIconSelected(new ImageIcon(getClass().getResource("../icon/add-selected.png")));
		buttonAdd.setIconSimple(new ImageIcon(getClass().getResource("../icon/add-simple.png")));

		buttonAdd.setSelected(false);
		buttonAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				Model_Addfriend a = new Model_Addfriend(Service.getInstance().getUser().getUserName(),
						user.getUserName());
				System.out.println(a.getUserName1());
				System.out.println(a.getUserName2());
				PublicEvent.getInstance().getEventAccept().addFriend(a);

			}

		});
		menu.add(buttonAdd);
		buttonAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				buttonAdd.setSelected(true);
				mouseOver = true;
			}

			@Override
			public void mouseExited(MouseEvent me) {
				buttonAdd.setSelected(false);
				mouseOver = false;
			}

		});
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(imageAvatar1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(lb, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING,
										layout.createSequentialGroup()
												.addComponent(menu, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(57)))));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				layout.createSequentialGroup().addGap(3)
						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(imageAvatar1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addComponent(lb).addGap(6).addComponent(menu,
										GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(8, Short.MAX_VALUE)));
		this.setLayout(layout);

	}
}