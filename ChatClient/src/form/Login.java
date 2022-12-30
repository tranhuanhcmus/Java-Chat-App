package form;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import event.EventLogin;
import event.EventMessage;
import event.PublicEvent;
import io.socket.client.Ack;
import model.Model_Login;
import model.Model_Message;
import model.Model_Register;
import model.Model_User_Account;
import service.Service;
import swing.PanelSlide;
import swing.PictureBox;

public class Login extends JPanel {

	public Login() {

		setBorder(new LineBorder(Color.BLACK));
		setBackground(Color.WHITE);
		setLayout(null);

		PictureBox pic = new PictureBox();
		pic.setImage(new ImageIcon("../javachatapp/bin/icon/login_image.png"));
		pic.setBounds(10, 11, 742, 567);
		add(pic);

		JLabel lblNewLabel_1 = new JLabel("Chat Application");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 527, 128, 29);
		pic.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(30, 144, 255));
		lblNewLabel.setBounds(0, 589, 1108, 6);
		add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(795, 90, 291, 421);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 11, 271, 399);
		panel.add(panel_1);
		panel_1.setLayout(null);

		PanelSlide slide = new PanelSlide();
		P_Login login = new P_Login();
		P_Register register = new P_Register();
		slide.setBounds(0, 0, 273, 399);
		panel_1.add(slide);
		slide.init(login, register);

		slide.setBackground(Color.WHITE);
		PublicEvent.getInstance().addEventLogin(new EventLogin() {
			@Override
			public void login(Model_Login data) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						PublicEvent.getInstance().getEventMain().showLoading(true);
						Service.getInstance().getClient().emit("Login", data.toJsonObject(), new Ack() {
							@Override
							public void call(Object... os) {
								if (os.length > 0) {
									boolean action = (Boolean) os[0];
									if (action) {
										Service.getInstance().setUser(new Model_User_Account(os[1]));
										PublicEvent.getInstance().getEventMain().showLoading(false);
										PublicEvent.getInstance().getEventMain().initChat();
									} else {
										// password wrong
										PublicEvent.getInstance().getEventMain().showLoading(false);
									}
								} else {
									PublicEvent.getInstance().getEventMain().showLoading(false);
								}
							}
						});

					}
				}).start();
			}

			@Override
			public void register(Model_Register data, EventMessage message) {
				Service.getInstance().getClient().emit("Register", data.toJsonObject(), new Ack() {
					@Override
					public void call(Object... os) {
						if (os.length > 0) {
							Model_Message ms = new Model_Message((boolean) os[0], os[1].toString());
							message.callMessage(ms);
							if (ms.isAction()) {
								Model_User_Account user = new Model_User_Account(os[2]);
								Service.getInstance().setUser(user);
							}
							message.callMessage(ms);
							// call message back when done register
						}
					}
				});
			}

			@Override
			public void goRegister() {
				slide.show(1);
			}

			@Override
			public void goLogin() {
				// TODO Auto-generated method stub
				slide.show(0);
			}
		});

	}
}
