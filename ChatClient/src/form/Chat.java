package form;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import components.Chat_Body;
import components.Chat_Bottom;
import components.Chat_Title;
import event.EventChat;
import event.PublicEvent;
import net.miginfocom.swing.MigLayout;

public class Chat extends JPanel {

	private Chat_Body chatBody;
	private Chat_Bottom chatBottom;
	private Chat_Title chatTitle;

	public Chat() {
//		initComponents();
		init();
	}

	private void init() {
		setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, bottom]0[shrink 0]0"));
		Chat_Title chatTitle = new Chat_Title();
		Chat_Body chatBody = new Chat_Body();
		Chat_Bottom chatBottom = new Chat_Bottom();
		PublicEvent.getInstance().addEventChat(new EventChat() {
			@Override
			public void sendMessage(String text) {
				chatBody.addItemRight(text);
			}
		});
		add(chatTitle, "wrap");
		add(chatBody, "wrap");
		add(chatBottom, "h ::50%");
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents

	private void initComponents() {

		chatTitle = new Chat_Title();
		chatBottom = new Chat_Bottom();
		chatBody = new Chat_Body();

		setBackground(new Color(249, 249, 249));

		Chat_Bottom chat_Bottom = new Chat_Bottom();
		chat_Bottom.setFocusTraversalKeysEnabled(false);
		chat_Bottom.setFocusable(false);

		GroupLayout chatBottomLayout = new GroupLayout(chatBottom);
		chatBottomLayout.setHorizontalGroup(chatBottomLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(chatBottomLayout.createSequentialGroup().addContainerGap()
						.addComponent(chat_Bottom, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE).addContainerGap()));
		chatBottomLayout
				.setVerticalGroup(chatBottomLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(chatBottomLayout.createSequentialGroup().addContainerGap().addComponent(chat_Bottom,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(13, Short.MAX_VALUE)));
		chatBottom.setLayout(chatBottomLayout);

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
