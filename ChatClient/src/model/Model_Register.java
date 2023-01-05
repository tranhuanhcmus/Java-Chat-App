package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_Register {

	public Model_Register() {
	}

	private String userName;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public java.sql.Date getBirth() {
		return birth;
	}

	public void setBirth(java.sql.Date birth) {
		this.birth = birth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String name;

	public Model_Register(String userName, String name, String address, Date birth, String password) {

		this.userName = userName;
		this.name = name;
		this.address = address;
		this.birth = birth;
		this.password = password;
	}

	private String address;
	private java.sql.Date birth;
	private String password;

	public JSONObject toJsonObject() {
		try {

			JSONObject json = new JSONObject();
			json.put("userName", userName);
			json.put("password", password);
			json.put("name", name);
			json.put("address", address);
			json.put("birth", birth);
			json.put("gender", "men");

			return json;
		} catch (JSONException e) {
			return null;
		}
	}
}