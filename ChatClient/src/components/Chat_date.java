package components;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import swing.Line;

public class Chat_date extends JLayeredPane {

	private JLabel lbDate;
	private Line line1;
	private Line line2;

	public Chat_date() {
		initComponents();
	}

	public void setDate(String date) {
		lbDate.setText(date);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		lbDate = new JLabel();
		line1 = new Line();
		line2 = new Line();

		lbDate.setForeground(new Color(191, 191, 191));
		lbDate.setHorizontalAlignment(SwingConstants.CENTER);
		lbDate.setText("06/06/2021");

		line1.setForeground(new Color(191, 191, 191));

		line2.setForeground(new Color(191, 191, 191));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(line1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(lbDate)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(line2, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(10, 10, 10)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(line2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lbDate)
								.addComponent(line1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
				.addGap(10, 10, 10)));
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables

	// End of variables declaration//GEN-END:variables
}
