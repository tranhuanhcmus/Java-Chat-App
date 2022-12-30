package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import event.PublicEvent;
import swing.PictureBox;

public class View_Image extends JComponent {

	/**
	 * Create the panel.
	 */
	PictureBox pic = new PictureBox();
	private Icon image;

	public View_Image() {
		pic.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!SwingUtilities.isLeftMouseButton(e)) {
					setVisible(false);
				}
			}
		});
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setLayout(new BorderLayout(0, 0));
		add(pic, BorderLayout.CENTER);
		GridBagLayout gbl_pic = new GridBagLayout();
		gbl_pic.columnWidths = new int[] { 954, 0 };
		gbl_pic.rowHeights = new int[] { 647, 0 };
		gbl_pic.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pic.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pic.setLayout(gbl_pic);

		JButton cmdSave = new JButton("");
		cmdSave.setForeground(Color.DARK_GRAY);
		cmdSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublicEvent.getInstance().getEventImageView().saveImage(image);
			}
		});
		cmdSave.setIcon(new ImageIcon(View_Image.class.getResource("../icon/save.png")));
		cmdSave.setFocusable(false);

		cmdSave.setBackground(Color.BLACK);

		GridBagConstraints gbc_cmdSave = new GridBagConstraints();
		gbc_cmdSave.anchor = GridBagConstraints.SOUTHEAST;
		gbc_cmdSave.gridx = 0;
		gbc_cmdSave.gridy = 0;
		pic.add(cmdSave, gbc_cmdSave);

	}

	public void viewImage(Icon image) {
		this.image = image;
		pic.setImage(this.image);
		setVisible(true);
	}

	public void saveImage(Icon image) {
		// update later
	}

	protected void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setColor(new Color(0, 0, 0, 100));
		g2.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(grphcs);
	}
}
