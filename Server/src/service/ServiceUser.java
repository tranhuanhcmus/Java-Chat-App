package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.DatabaseConnection;
import model.Model_Client;
import model.Model_Login;
import model.Model_Message;
import model.Model_Register;
import model.Model_User_Account;

public class ServiceUser {

	// Instance
	private final Connection con;

	public ServiceUser() {
		this.con = DatabaseConnection.getInstance().getConnection();
	}

	public Model_Message register(Model_Register data) {

		Model_Message message = new Model_Message();

		try {
			PreparedStatement p = con.prepareStatement("SELECT * FROM user WHERE username = ? LIMIT 1");
			p.setString(1, data.getUserName());
			ResultSet r = p.executeQuery();

			if (r.next()) {
				message.setAction(false);
				message.setMessage("User Already Exist");
			} else {
				message.setAction(true);
			}
			r.close();
			p.close();
			if (message.isAction()) {
				// Insert User Register
				con.setAutoCommit(false);
				p = con.prepareStatement("INSERT INTO test.user (username, password) VALUES (?, ?)",
						PreparedStatement.RETURN_GENERATED_KEYS);
				p.setString(1, data.getUserName());
				p.setString(2, data.getPassword());
				p.execute();
				r = p.getGeneratedKeys();
				r.first();
				int userid = r.getInt(1);
				r.close();
				p.close();
				// insert User Account
				p = con.prepareStatement(
						"INSERT INTO test.user_account (userid, username,name,address,birth,gender) values (?,?,?,?,?,?)",
						ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				p.setInt(1, userid);
				p.setString(2, data.getUserName());
				p.setString(3, data.getName());
				p.setString(4, data.getAddress());
				p.setDate(5, data.getBirth());
				p.setString(6, "men");

				p.execute();
				p.close();
				con.commit();
				con.setAutoCommit(true);
				message.setAction(true);
				message.setMessage("Ok");
				message.setData(new Model_User_Account(userid, data.getUserName(), data.getName(), data.getBirth(),
						data.getAddress(), true));
			}

		} catch (SQLException e) {
			System.out.println(e);
			message.setAction(false);
			message.setMessage("Server Error");
			try {
				if (con.getAutoCommit() == false) {
					con.rollback();
					con.setAutoCommit(true);
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return message;
	}

	public List<Model_User_Account> getUser(int exitUser) throws SQLException {

		List<Model_User_Account> list = new ArrayList<>();
		PreparedStatement p = con.prepareStatement(
				"select userid, username, name, birth,address from user_account where user_account.status ='1' and userid<>?");
		p.setInt(1, exitUser);
		ResultSet r = p.executeQuery();
		while (r.next()) {
			int userid = r.getInt(1);
			String userName = r.getString(2);
			String name = r.getString(3);

			Date birth = r.getDate(4);
			String address = r.getString(5);
			list.add(new Model_User_Account(userid, userName, name, birth, address, checkUserStatus(userid)));
		}
		r.close();
		p.close();
		return list;
	}

	public Model_User_Account login(Model_Login login) throws SQLException {
		Model_User_Account data = null;
		PreparedStatement p = con.prepareStatement(
				"select userid, user_account.username, name, birth,address from user join user_account using (userid) where"
						+ " user.username = BINARY(?) and user.password = BINARY(?) and user_account.status='1'");

		p.setString(1, login.getUserName());
		p.setString(2, login.getPassword());
		ResultSet r = p.executeQuery();
		if (r.next()) {
			int userID = r.getInt(1);
			String userName = r.getString(2);
			String name = r.getString(3);
			Date birth = r.getDate(4);
			String address = r.getString(5);
			data = new Model_User_Account(userID, userName, name, birth, address, checkUserStatus(userID));

		}
		r.close();
		p.close();
		return data;
	}

	private boolean checkUserStatus(int userID) {
		List<Model_Client> clients = Service.getInstance(null).getListClient();
		for (Model_Client c : clients) {
			if (c.getUser().getUserID() == userID) {
				return true;
			}
		}
		return false;
	}

}
