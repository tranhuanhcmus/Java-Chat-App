package event;

public class PublicEvent {
	private static PublicEvent instance;
	private EventImageView eventImageView;
	private EventChat eventChat;
	private EventLogin eventLogin;
	private EventMain eventMain;
	
	public static PublicEvent getInstance() {
		if (instance == null) {
			instance = new PublicEvent();
		}
		return instance;
	}
	
	public void addEventMain(EventMain event) {
		this.eventMain = event;
	}

	private PublicEvent() {

	}

	public void addEventImageView(EventImageView event) {
		this.eventImageView = event;
	}

	public void addEventChat(EventChat e) {
		this.eventChat = e;

	}

	public EventImageView getEventImageView() {
		return eventImageView;
	}
	
	public void addEventLogin(EventLogin event) {
		this.eventLogin = event;
	}
	
	public EventChat getEventChat() {
		return eventChat;
	}
	
	public EventLogin getEventLogin() {
		return eventLogin;
	}
	
	public EventMain getEventMain() {
		return eventMain;
	}
}
