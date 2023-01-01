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

import model.Model_Client;
import model.Model_Login;
import model.Model_Message;
import model.Model_Register;
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
					textArea.append("User has Register :" + t.getUserName() + " Pass :" + t.getPassword() + "\n");
					server.getBroadcastOperations().sendEvent("list_user", (Model_User_Account) message.getData());
					addClient(sioc, (Model_User_Account) message.getData());
				}
			}
		});
		server.addEventListener("Login", Model_Login.class, new DataListener<Model_Login>() {
			@Override
			public void onData(SocketIOClient sioc, Model_Login t, AckRequest ar) throws Exception {
				Model_User_Account login = serviceUser.login(t);
				if (login != null) {
					ar.sendAckData(true, login);
					addClient(sioc, login);
					userConnect(login.getUserID());
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

	public int removeClient(SocketIOClient client) {
		for (Model_Client d : list) {
			if (d.getClient() == client) {
				list.remove(d);
				return d.getUser().getUserID();
			}
		}
		return 0;
	}

	public List<Model_Client> getListClient() {
		return list;
	}
}
