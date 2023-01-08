package components;

import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.Icon;
import javax.swing.JScrollBar;

import app.MessageType;
import emoji.Emoji;
import model.Model_Receive_Message;
import model.Model_Send_Message;
import net.miginfocom.swing.MigLayout;

public class Chat_Body extends javax.swing.JPanel {

	private javax.swing.JPanel body;
	private javax.swing.JScrollPane sp;

	public Chat_Body() {
		initComponents();
		init();

	}

	private void init() {
		body.setLayout(new MigLayout("fillx", "", "5[]5"));
		sp.setVerticalScrollBar(new JScrollBar());
		sp.getVerticalScrollBar().setBackground(Color.WHITE);
	}

	public void addItemLeft(String text, String user, Icon... image) {
		Chat_Left_With_Profile item = new Chat_Left_With_Profile();
		item.setText(text);
		item.setImage(image);
		item.setTime();
		item.setUserProfile(user);
		body.add(item, "wrap, w 100::80%");
		// ::80% set max with 80%
		scrollToBottom();
		body.repaint();
		body.revalidate();
	}

	public void addItemLeft(Model_Receive_Message data) {
		if (data.getMessageType() == MessageType.TEXT) {
			Chat_Left_With_Profile item = new Chat_Left_With_Profile();
			item.setText(data.getText());

			item.setTime();

			body.add(item, "wrap, w 100::80%");
			// ::80% set max with 80%
		} else {
			Chat_Left_With_Profile item = new Chat_Left_With_Profile();
			item.setEmoji(Emoji.getInstance().getImoji(Integer.valueOf(data.getText())).getIcon());

			item.setTime();

			body.add(item, "wrap, w 100::80%");
			// ::80% set max with 80%
		}
		scrollToBottom();
		repaint();
		revalidate();
	}

	public void addItemRight(String text, Icon... image) {

		Chat_Right item = new Chat_Right();
		item.setText(text);
		item.setImage(image);
		body.add(item, "wrap, al right, w 100::80%");
		// ::80% set max with 80%
		body.repaint();
		body.revalidate();
		item.setTime();
		scrollToBottom();
	}

	public void clearChat() {
		body.removeAll();
		repaint();
		revalidate();
	}

	public void addItemRight(Model_Send_Message data) {

		if (data.getMessageType() == MessageType.TEXT) {
			Chat_Right item = new Chat_Right();
			item.setText(data.getText());

			item.setTime();

			body.add(item, "wrap, al right,w 100::80%");
			// ::80% set max with 80%
		} else {
			Chat_Right item = new Chat_Right();
			item.setEmoji(Emoji.getInstance().getImoji(Integer.valueOf(data.getText())).getIcon());

			item.setTime();

			body.add(item, "wrap, al right, w 100::80%");
			// ::80% set max with 80%
		}
		repaint();
		revalidate();
		scrollToBottom();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		sp = new javax.swing.JScrollPane();
		body = new javax.swing.JPanel();

		sp.setBorder(null);
		sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		body.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
		body.setLayout(bodyLayout);
		bodyLayout.setHorizontalGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 826, Short.MAX_VALUE));
		bodyLayout.setVerticalGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
				555, Short.MAX_VALUE));

		sp.setViewportView(body);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(sp));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(sp));
	}

	private void scrollToBottom() {
		JScrollBar verticalBar = sp.getVerticalScrollBar();
		AdjustmentListener downScroller = new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				Adjustable adjustable = e.getAdjustable();
				adjustable.setValue(adjustable.getMaximum());
				verticalBar.removeAdjustmentListener(this);
			}
		};
		verticalBar.addAdjustmentListener(downScroller);
	}
}