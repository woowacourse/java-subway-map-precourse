package subway.view;

public enum Numbering {
	ONE("1. "),
	TWO("2. "),
	THREE("3. "),
	FOUR("4. "),
	BACK("B. "),
	QUIT("Q. ");

	final private String message;

	Numbering(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
