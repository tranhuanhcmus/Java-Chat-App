package model;

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_User_Account {

	public Model_User_Account(int userID, String userName, String name, Date birth, String address, boolean status) {

		this.userID = userID;
		this.userName = userName;
		this.name = name;
		this.gender = "men";
		this.birth = birth;
		this.address = address;
		this.status = status;
	}

	public Model_User_Account(String userName, boolean status) {

		this.userName = userName;
		this.status = status;
	}

	private int userID;
	private String userName;
	private String name;
	private String gender;
	private Date birth;
	private String address;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private boolean status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Model_User_Account(Object json) {
		JSONObject obj = (JSONObject) json;
		try {
			birth = new Date(System.currentTimeMillis());

			userID = obj.getInt("userID");
			userName = obj.getString("userName");
			status = obj.getBoolean("status");
			name = obj.getString("name");
			address = obj.getString("address");
			email = obj.getString("email");

		} catch (JSONException e) {
			System.err.println(e);
		}
	}

}