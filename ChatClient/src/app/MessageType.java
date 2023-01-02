package app;

public enum MessageType {
	TEXT(1), EMOJI(2);

	int value;

	public int getValue() {
		return value;
	}

	private MessageType(int value) {
		this.value = value;
	}

	public static MessageType toMessageType(int value) {
		if (value == 1) {
			return TEXT;
		} else {
			return EMOJI;
		}
	}
}
