package components;

import java.awt.Color;

import javax.swing.Icon;

public class Chat_Right extends javax.swing.JLayeredPane {

	private Chat_Item txt;

	public Chat_Right() {
		initComponents();
		txt.setBackground(new Color(179, 233, 255));
	}

	public void setText(String text) {
		if (text.equals("")) {
			txt.hideText();
		}
		txt.setText(text);

	}

	public void setTime() {
		txt.setTime("10:35 PM"); // Testing
	}

	public void setImage(Icon... images) {
		txt.setImage(true, images);
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		txt = new Chat_Item();

		setLayer(txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(txt,
				javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
	}
}
