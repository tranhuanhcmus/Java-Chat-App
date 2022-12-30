package components;

import java.awt.Color;

public class Chat_Left extends javax.swing.JLayeredPane {

	private Chat_Item txt;

	public Chat_Left() {
		initComponents();
		txt.setBackground(new Color(242, 242, 242));
	}

	public void setText(String text) {
		txt.setText(text);
		txt.setTime("10:30 PM"); // Testing
		txt.sendSuccess();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		txt = new Chat_Item();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(0, 0, 0)));
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables

	// End of variables declaration//GEN-END:variables
}