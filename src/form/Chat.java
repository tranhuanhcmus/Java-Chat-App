package form;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import components.Chat_Body;
import components.Chat_Bottom;
import components.Chat_Title;

public class Chat extends JPanel {

	private Chat_Body chatBody;
	private Chat_Bottom chatBottom;
	private Chat_Title chatTitle;

	public Chat() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents

	private void initComponents() {

		chatTitle = new Chat_Title();
		chatBottom = new Chat_Bottom();
		chatBody = new Chat_Body();

		setBackground(new Color(249, 249, 249));

		GroupLayout chatBottomLayout = new GroupLayout(chatBottom);
		chatBottom.setLayout(chatBottomLayout);
		chatBottomLayout.setHorizontalGroup(
				chatBottomLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		chatBottomLayout.setVerticalGroup(
				chatBottomLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(chatBottom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(chatBody, GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
				.addComponent(chatTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(chatTitle, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0).addComponent(chatBody, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
						.addGap(0, 0, 0).addComponent(chatBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));
	}
}
