package components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

import model.Model_User_Account;
import service.Service;
import swing.ImageAvatar;

public class Chat_Left_With_Profile extends JLayeredPane {

	private swing.ImageAvatar IaImage;
	private JLayeredPane jLayeredPane1;
	private Chat_Item txt;

	public Chat_Left_With_Profile() {
		initComponents();
		txt.setBackground(new Color(242, 242, 242));
	}

	public void setUserProfile(String user) {
		txt.setUserProfile(user);
	}

	public void setImageProfile(Icon image) {
		IaImage.setImage(image);
	}

	public void setText(String text) {
		if (text.equals("")) {
			txt.hideText();
		} else {
			txt.setText(text);
		}

	}

	public void setImage(Icon... image) {
		txt.setImage(false, image);
	}

	public void setEmoji(Icon icon) {
		txt.hideText();
		txt.setEmoji(false, icon);
	}

	public void setTime() {
		txt.setTime(); // Testing
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLayeredPane1 = new JLayeredPane();
		IaImage = new ImageAvatar();
		txt = new Chat_Item();

		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		IaImage.setBorderSize(0);

		IaImage.setImage(new ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
		IaImage.setMaximumSize(new Dimension(31, 31));
		IaImage.setMinimumSize(new Dimension(31, 31));
		IaImage.setPreferredSize(new Dimension(31, 31));

		jLayeredPane1.setLayer(IaImage, JLayeredPane.DEFAULT_LAYER);

		GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
		jLayeredPane1.setLayout(jLayeredPane1Layout);
		jLayeredPane1Layout
				.setHorizontalGroup(
						jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jLayeredPane1Layout
										.createSequentialGroup().addComponent(IaImage, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		jLayeredPane1Layout.setVerticalGroup(jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						jLayeredPane1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(IaImage,
								GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)));

		add(jLayeredPane1);
		add(txt);
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables

	// End of variables declaration//GEN-END:variables
}