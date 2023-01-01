package form;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Loading extends JPanel {

	public Loading() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("../icon/loading.gif"));
		lblNewLabel.setBounds(10, 11, 1060, 665);
		add(lblNewLabel);

	}

	protected void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setColor(new Color(255, 255, 255, 200));
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(grphcs);
	}
}
