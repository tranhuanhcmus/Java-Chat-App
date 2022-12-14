package Main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;

import event.EventMain;
import event.PublicEvent;
import form.Home;
import form.Login;
import form.View_Image;
import model.Model_User_Account;
import service.Service;
import swing.Resizerwindow;

public class main extends JFrame {

	private JPanel background;
	private JLayeredPane body;
	private JPanel border;
	private JButton cmdClose;
	private JButton cmdMinimize;
	private Home home1;
	private JPanel title;
	private View_Image view_Image;
	private Login login;

	public main() {
		initComponents();
		init();
	}

	private void init() {
		setIconImage(new ImageIcon(getClass().getResource("../icon/icon.png")).getImage());
		Resizerwindow com = new Resizerwindow();
		com.registerComponent(this);
		com.setMinimumSize(new Dimension(800, 500));
		com.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
		com.setSnapSize(new Dimension(10, 10));
		view_Image.setVisible(false);
		home1.setVisible(false);
		login.setVisible(true);

		initEvent();
		Service.getInstance().startServer();
	}

	private void initEvent() {
		PublicEvent.getInstance().addEventMain(new EventMain() {

			@Override
			public void initChat() {
				if (!Service.getInstance().getUser().equals(null)) {
					int userId = Service.getInstance().getUser().getUserID();
					Service.getInstance().getClient().emit("list_user", userId);
					Service.getInstance().getClient().emit("list_addfriend",
							Service.getInstance().getUser().getUserName());
				}
				home1.setVisible(true);
				login.setVisible(false);
			}

			@Override
			public void selectUser(Model_User_Account user) {

				home1.setUser(user);
			}

			@Override
			public void updateUser(Model_User_Account user) {
				home1.updateUser(user);

			}
		});

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		border = new JPanel();
		background = new JPanel();
		title = new JPanel();
		cmdMinimize = new JButton();
		cmdClose = new JButton();
		body = new JLayeredPane();
		home1 = new form.Home();
		body.setLayer(home1, 5);
		login = new Login();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		border.setBackground(new Color(229, 229, 229));

		background.setBackground(new Color(255, 255, 255));

		title.setBackground(new Color(229, 229, 229));
		title.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				titleMouseDragged(evt);
			}
		});
		title.addMouseListener((MouseListener) new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				titleMousePressed(evt);
			}
		});

		cmdMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minimize.png"))); // NOI18N
		cmdMinimize.setBorder(null);
		cmdMinimize.setContentAreaFilled(false);
		cmdMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		cmdMinimize.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdMinimizeActionPerformed(evt);
			}
		});

		cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("../icon/close.png"))); // NOI18N
		cmdClose.setBorder(null);
		cmdClose.setContentAreaFilled(false);
		cmdClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		cmdClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdCloseActionPerformed(evt);
			}
		});

		GroupLayout titleLayout = new GroupLayout(title);
		titleLayout.setHorizontalGroup(titleLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(titleLayout.createSequentialGroup().addContainerGap(1176, Short.MAX_VALUE)
						.addComponent(cmdMinimize).addPreferredGap(ComponentPlacement.RELATED).addComponent(cmdClose)
						.addContainerGap()));
		titleLayout.setVerticalGroup(titleLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(titleLayout.createSequentialGroup().addGap(0)
						.addGroup(titleLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cmdClose, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
								.addComponent(cmdMinimize, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
						.addGap(0)));
		title.setLayout(titleLayout);
		body.setLayout(new CardLayout(0, 0));
		body.add(home1, "name_520431889883800");

		GroupLayout backgroundLayout = new GroupLayout(background);
		backgroundLayout.setHorizontalGroup(backgroundLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(title, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(backgroundLayout.createSequentialGroup().addGap(10)
						.addComponent(body, GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE).addGap(10)));
		backgroundLayout.setVerticalGroup(backgroundLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(backgroundLayout.createSequentialGroup().addGap(0)
						.addComponent(title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(body, GroupLayout.PREFERRED_SIZE, 631, Short.MAX_VALUE).addContainerGap()));
		background.setLayout(backgroundLayout);

		view_Image = new View_Image();
		view_Image.setAutoscrolls(true);
		body.setLayer(view_Image, 10);

		body.add(view_Image, "name_520431915700500");

		body.setLayer(login, 0);
		body.add(login, "name_169739866587700");
		login.setLayout(null);

		GroupLayout borderLayout = new GroupLayout(border);
		border.setLayout(borderLayout);
		borderLayout.setHorizontalGroup(borderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(borderLayout.createSequentialGroup().addGap(1, 1, 1)
						.addComponent(background, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(1, 1, 1)));
		borderLayout.setVerticalGroup(borderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(borderLayout.createSequentialGroup().addGap(1, 1, 1)
						.addComponent(background, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(1, 1, 1)));

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(border,
				GroupLayout.DEFAULT_SIZE, 1232, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(border,
				GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE));
		getContentPane().setLayout(layout);

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private int pX;
	private int pY;

	private void titleMouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_titleMouseDragged
		this.setLocation(this.getLocation().x + evt.getX() - pX, this.getLocation().y + evt.getY() - pY);
	}// GEN-LAST:event_titleMouseDragged

	private void titleMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_titleMousePressed
		pX = evt.getX();
		pY = evt.getY();
	}// GEN-LAST:event_titleMousePressed

	private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmdCloseActionPerformed
		System.exit(0);
	}// GEN-LAST:event_cmdCloseActionPerformed

	private void cmdMinimizeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmdMinimizeActionPerformed
		this.setState(JFrame.ICONIFIED);
	}// GEN-LAST:event_cmdMinimizeActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		FlatArcIJTheme.setup();
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Map.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Map.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Map.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Map.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new main().setVisible(true);
			}
		});
	}
}
