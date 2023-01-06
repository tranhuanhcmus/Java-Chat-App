package form;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
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
		pic.setImage(new ImageIcon(Login.class.getResource("/icon/istockphoto-1281150061-612x612.png")));
		pic.setBounds(10, 11, 775, 622);
		add(pic);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(795, 70, 291, 508);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(10, 11, 271, 487);
		panel.add(panel_1);

		PanelSlide slide = new PanelSlide();
		P_Login login = new P_Login();
		P_Register register = new P_Register();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		panel_1.add(slide);
		slide.init(login, register);

		slide.setBackground(Color.WHITE);
		PublicEvent.getInstance().addEventLogin(new EventLogin() {
			@Override
			public void login(Model_Login data) {
				new Thread(new Runnable() {
					@Override
					public void run() {

						Service.getInstance().getClient().emit("Login", data.toJsonObject(), new Ack() {
							@Override
							public void call(Object... os) {
								if (os.length > 0) {
									boolean action = (Boolean) os[0];

									if (action) {
										Service.getInstance().setUser(new Model_User_Account(os[1]));
										PublicEvent.getInstance().getEventLogin().showMessage("Success");
										PublicEvent.getInstance().getEventMain().initChat();
									} else {
										// password wrong
										PublicEvent.getInstance().getEventLogin().showMessage("No Account Exists");
									}
								} else {
									PublicEvent.getInstance().getEventLogin().showMessage("Error");
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

			@Override
			public void showMessage(String message) {
				// TODO Auto-generated method stub
				login.lbError.setText(message);
				login.lbError.setVisible(true);
			}

			@Override
			public void forgotPassword(String userName) {
				Service.getInstance().getClient().emit("reset_Password", userName);
			}
		});

	}
}
