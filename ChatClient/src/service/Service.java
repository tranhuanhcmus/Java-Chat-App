package service;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import event.PublicEvent;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import model.Model_Receive_Message;
import model.Model_User_Account;

public class Service {
	private static Service instance;
	private Socket client;
	private final int PORT_NUMBER = 9999;
	private final String IP = "localhost";
	private Model_User_Account user;

	public static Service getInstance() {
		if (instance == null) {
			instance = new Service();
		}
		return instance;
	}

	private Service() {
	}

	public void startServer() {
		try {
			client = IO.socket("http://" + IP + ":" + PORT_NUMBER);
			client.on("list_user", new Emitter.Listener() {
				@Override
				public void call(Object... os) {
					// list user
					List<Model_User_Account> users = new ArrayList<>();
					for (Object o : os) {
						Model_User_Account u = new Model_User_Account(o);
						if (u.getUserID() != user.getUserID()) {
							users.add(u);
						}
					}
					PublicEvent.getInstance().getEventMenuLeft().newUser(users);
				}
			});
			client.on("reset_Password", new Emitter.Listener() {
				@Override
				public void call(Object... os) {
					// list user

					String newPassword = (String) os[0];
					String email = (String) os[1];
					if (newPassword.equals("error...error")) {
						PublicEvent.getInstance().getEventLogin().showMessage("Not exist username!");
					} else {

						// send Email

						String msg = "New Password: " + newPassword;
						try {
							SendEmail.send(msg, email);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						PublicEvent.getInstance().getEventLogin().showMessage("Check at : " + email);
					}
				}
			});
			client.on("user_status", new Emitter.Listener() {
				@Override
				public void call(Object... os) {
					int userID = (Integer) os[0];
					boolean status = (Boolean) os[1];

					if (status) {
						// connect
						PublicEvent.getInstance().getEventMenuLeft().userConnect(userID);
					} else {
						// disconnect
						PublicEvent.getInstance().getEventMenuLeft().userDisconnect(userID);
					}
				}
			});
			client.on("receive_ms", new Emitter.Listener() {
				@Override
				public void call(Object... os) {
					Model_Receive_Message message = new Model_Receive_Message(os[0]);
					PublicEvent.getInstance().getEventChat().receiveMessage(message);
				}
			});
			client.open();
		} catch (URISyntaxException e) {
			error(e);
		}
	}

	public Socket getClient() {
		return client;
	}

	public Model_User_Account getUser() {
		return user;
	}

	public void setUser(Model_User_Account user) {
		this.user = user;
	}

	private void error(Exception e) {
		System.err.println(e);
	}

}
