package components;

import swing.PictureBox;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import event.PublicEvent;

public class Chat_Image extends javax.swing.JLayeredPane {

	/**
	 * Create the panel.
	 */
	public Chat_Image(boolean right) {
		setLayout(new MigLayout("", "0[" + (right ? "right" : "left") + "]0", "3[]3"));
	}

//	 Icon... is multi arguments
	public void addImage(Icon... images) {
		for (Icon i : images) {
			PictureBox pic = new PictureBox();
			pic.setPreferredSize(getAutoSize(i, 200, 200));
			pic.setImage(i);
			addEvent(pic, i);
			add(pic, "wrap");
		}
	}

	public void addEvent(Component com, Icon image) {
		com.setCursor(new Cursor(Cursor.HAND_CURSOR));
		com.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if (SwingUtilities.isLeftMouseButton(me)) {
					PublicEvent.getInstance().getEventImageView().viewImage(image);
					;
				}
			}
		});
	}

	private Dimension getAutoSize(Icon image, int w, int h) {
		int iw = image.getIconWidth();
		int ih = image.getIconHeight();
		double xScale = (double) w / iw;
		double yScale = (double) h / ih;
		double scale = Math.min(xScale, yScale);
		int width = (int) (scale * iw);
		int height = (int) (scale * ih);
		int x = (w - width) / 2;
		int y = (h - height) / 2;
		return new Dimension(width, height);
	}
}
