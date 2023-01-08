package model;

public class Model_Addfriend {

	private String userName1;
	private String userName2;

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