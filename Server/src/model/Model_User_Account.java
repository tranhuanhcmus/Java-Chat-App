package model;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_User_Account {

	public Model_User_Account() {
	}

	private int userID;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	private String userName;

	public Model_User_Account(int userID, String userName, String name, String gender, Date birth, String address,
			boolean status) {

		this.userID = userID;
		this.userName = userName;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.address = address;
		this.status = status;
	}

	public Model_User_Account(int userID, String userName, String name, Date birth, String address, boolean status) {

		this.userID = userID;
		this.userName = userName;
		this.name = name;
		this.gender = "men";
		this.birth = birth;
		this.address = address;
		this.status = status;
	}

	private String name;
	private String gender;
	private Date birth;
	private String address;
	private boolean status;

}