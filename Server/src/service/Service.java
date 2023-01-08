package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

import model.Model_Addfriend;
import model.Model_Client;
import model.Model_Login;
import model.Model_Message;
import model.Model_Receive_Message;
import model.Model_Register;
import model.Model_Send_Message;
import model.Model_User_Account;

public class Service {

	private static Service instance;
	private SocketIOServer server;
	private ServiceUser serviceUser;
	private JTextArea textArea;
	private List<Model_Client> list;
	private final int PORT_NUMBER = 9999;

	public static Service getInstance(JTextArea textArea) {
		if (instance == null) {
			instance = new Service(textArea);
		}
		return instance;
	}

	private Service(JTextArea textArea) {
		this.textArea = textArea;
		serviceUser = new ServiceUser();
		list = new ArrayList<>();
	}

	public void startServer() {
		Configuration config = new Configuration();
		config.setPort(PORT_NUMBER);
		server = new SocketIOServer(config);
		server.addConnectListener(new ConnectListener() {
			@Override
			public void onConnect(SocketIOClient sioc) {
				textArea.append("One client connected\n");
			}
		});
		server.addEventListener("Register", Model_Register.class, new DataListener<Model_Register>() {
			@Override
			public void onData(SocketIOClient sioc, Model_Register t, AckRequest ar) throws Exception {
				Model_Message message = serviceUser.register(t);
				ar.sendAckData(message.isAction(), message.getMessage(), message.getData());
				if (message.isAction()) {
					Model_User_Account user_account = (Model_User_Account) message.getData();
					textArea.append("User has Register :" + t.getUserName() + " Pass :" + t.getPassword() + "\n");
					server.getBroadcastOperations().sendEvent("list_user", user_account);
					addClient(sioc, (Model_User_Account) user_account);
				}
			}
		});
		server.addEventListener("Login", Model_Login.class, new DataListener<Model_Login>() {
			@Override
			public void onData(SocketIOClient sioc, Model_Login t, AckRequest ar) throws Exception {
				Model_User_Account login = serviceUser.login(t);
				if (login != null && serviceUser.writeLog(login)) {
					ar.sendAckData(true, login);
					addClient(sioc, login);
					userConnect(login.getUserID());

				} else {
					ar.sendAckData(false);
				}
			}
		});
		server.addEventListener("Add", Model_Addfriend.class, new DataListener<Model_Addfriend>() {
			@Override
			public void onData(SocketIOClient sioc, Model_Addfriend t, AckRequest ar) throws Exception {
				System.out.print(t.getUserName1());
				System.out.print(t.getUserName2());
				if (serviceUser.add(t)) {

					ar.sendAckData(true);
				} else {
					ar.sendAckData(false);
				}

			}

		});
		server.addEventListener("Accept", Model_Addfriend.class, new DataListener<Model_Addfriend>() {
			@Override
			public void onData(SocketIOClient sioc, Model_Addfriend t, AckRequest ar) throws Exception {
				System.out.print(t.getUserName1());
				System.out.print(t.getUserName2());
				if (serviceUser.update(t)) {

					ar.sendAckData(true);
				} else {
					ar.sendAckData(false);
				}

			}

		});
		server.addEventListener("list_user", Integer.class, new DataListener<Integer>() {
			@Override
			public void onData(SocketIOClient sioc, Integer userID, AckRequest ar) throws Exception {
				try {
					List<Model_User_Account> list = serviceUser.getUser(userID);

					sioc.sendEvent("list_user", list.toArray());

				} catch (SQLException e) {
					System.err.println(e);
				}
			}
		});

		server.addEventListener("list_addfriend", String.class, new DataListener<String>() {
			@Override
			public void onData(SocketIOClient sioc, String userID, AckRequest ar) throws Exception {
				try {
					List<Model_User_Account> list = serviceUser.getAddfriend(userID);

					sioc.sendEvent("list_addfriend", list.toArray());

				} catch (SQLException e) {
					System.err.println(e);
				}
			}
		});

		server.addEventListener("reset_Password", String.class, new DataListener<String>() {

			@Override
			public void onData(SocketIOClient sioc, String arg1, AckRequest arg2) throws Exception {
				// TODO Auto-generated method stub

				List<String> data = serviceUser.resetPassword(arg1);

				sioc.sendEvent("reset_Password", data.toArray());

			}
		});
		server.addEventListener("send_to_user", Model_Send_Message.class, new DataListener<Model_Send_Message>() {

			@Override
			public void onData(SocketIOClient arg0, Model_Send_Message arg1, AckRequest arg2) throws Exception {
				sendToClient(arg1);

			}
		});

		server.addDisconnectListener(new DisconnectListener() {
			@Override
			public void onDisconnect(SocketIOClient sioc) {
				int userID = removeClient(sioc);
				if (userID != 0) {
					// removed
					userDisconnect(userID);
				}
			}
		});
		server.start();
		textArea.append("Server has Start on port : " + PORT_NUMBER + "\n");
	}

	private void userConnect(int userID) {
		server.getBroadcastOperations().sendEvent("user_status", userID, true);
	}

	private void userDisconnect(int userID) {
		server.getBroadcastOperations().sendEvent("user_status", userID, false);
	}

	private void addClient(SocketIOClient client, Model_User_Account user) {
		list.add(new Model_Client(client, user));
	}

	private void sendToClient(Model_Send_Message data) {
		for (Model_Client c : list) {
			if (c.getUser().getUserID() == data.getToUserID()) {

				c.getClient().sendEvent("receive_ms",
						new Model_Receive_Message(data.getMessageType(), data.getFromUserID(), data.getText()));
			}
		}
	}

	public int removeClient(SocketIOClient client) {
		for (Model_Client d : list) {
			if (d.getClient() == client) {
				list.remove(d);
				textArea.append(d.getUser().getUserName() + " has left...\n");
				return d.getUser().getUserID();
			}
		}
		return 0;
	}

	public List<Model_Client> getListClient() {
		return list;
	}
}
