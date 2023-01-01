package components;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import swing.ImageAvatar;

public class Item_people extends JPanel {

	private ImageAvatar imageAvatar1;
	private JLabel lb;

	public Item_people(String name) {
		initComponents();
		lb.setText(name);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				setBackground(new Color(230, 230, 230));
			}

			@Override
			public void mouseExited(MouseEvent me) {
				setBackground(new Color(242, 242, 242));
			}
		});
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		imageAvatar1 = new ImageAvatar();
		lb = new JLabel();

		setBackground(new Color(242, 242, 242));

		imageAvatar1.setBorderSize(0);
		imageAvatar1.setImage(new ImageIcon(getClass().getResource("../icon/profile.png"))); // NOI18N

		lb.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		lb.setText("Name");

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(imageAvatar1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lb, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(imageAvatar1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap()
								.addComponent(lb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables

	// End of variables declaration//GEN-END:variables
}