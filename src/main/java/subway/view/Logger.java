package subway.view;

public enum Logger {
	BASIC("## "),
	INFO("[INFO] "),
	ERROR("[ERROR] ");

	final private String message;

	Logger(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
