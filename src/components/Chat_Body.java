package components;

import java.awt.Color;

import javax.swing.JScrollBar;

import net.miginfocom.swing.MigLayout;

public class Chat_Body extends javax.swing.JPanel {

	private javax.swing.JPanel body;
	private javax.swing.JScrollPane sp;

	public Chat_Body() {
		initComponents();
		init();
		addItemRight(
				"Send a text message to a group of contacts. Include photos, personalize your texts, and track who clicked your links.");
		addItemRight("hello\nHi");
		addItemLeft(
				"Simpletext started as a passion project because I couldn’t find what I was looking for. Most apps were trying to do too much and ended up bloated with features I don’t need. So I built Simpletext based on a simple premise — what if there’s an app that refuses to do more, choosing instead to do just one thing, and do it well? For Simpletext, that one thing is writing.",
				"aa");
		addItemLeft("hello\nerererew\newewe", "aaa");
		addItemRight("hello\nerererew\newewe");
		addItemLeft(
				"Simpletext started as a passion project because I couldn’t find what I was looking for. Most apps were trying to do too much and ended up bloated with features I don’t need. So I built Simpletext based on a simple premise — what if there’s an app that refuses to do more, choosing instead to do just one thing, and do it well? For Simpletext, that one thing is writing.",
				"aa");
		addDate("23/12/2022");
		addItemLeft("hello\nerererew\newewe", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		addItemRight("hello\nerererew\newewe");

	}

	private void init() {
		body.setLayout(new MigLayout("fillx", "", "5[]5"));
		sp.setVerticalScrollBar(new JScrollBar());
		sp.getVerticalScrollBar().setBackground(Color.WHITE);
	}

	public void addItemLeft(String text, String user) {
		Profile_left item = new Profile_left();
		item.setText(text);
		item.setUserProfile(user);
		body.add(item, "wrap, w ::80%");
		// ::80% set max with 80%
		body.repaint();
		body.revalidate();
	}

	public void addItemRight(String text) {
		Chat_Right item = new Chat_Right();
		item.setText(text);
		body.add(item, "wrap, al right, w ::80%");
		// ::80% set max with 80%
		body.repaint();
		body.revalidate();
	}

	public void addDate(String date) {
		Chat_date item = new Chat_date();
		item.setDate(date);
		body.add(item, "wrap, al center");
		body.repaint();
		body.revalidate();
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
}