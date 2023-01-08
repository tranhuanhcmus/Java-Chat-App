package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_Addfriend {

	private String userName1;
	private String userName2;

	public JSONObject toJsonObject() {
		try {
			JSONObject obj = new JSONObject();
			obj.put("userName1", userName1);
			obj.put("userName2", userName2);
			return obj;
		} catch (JSONException e) {
			return null;
		}
	}

	public String getUserName1() {
		return userName1;
	}

	public String getUserName2() {
		return userName2;
	}

	public Model_Addfriend(String userName1, String username2) {
		this.userName1 = userName1;
		this.userName2 = username2;
	}

	public Model_Addfriend() {
	}

}