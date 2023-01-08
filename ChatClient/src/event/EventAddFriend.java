package event;

import model.Model_Addfriend;

public interface EventAddFriend {

	public void showMessage(String message);

	public void addFriend(Model_Addfriend data);
}
