package subway.view;

public enum General {
	BASIC("## "),
	INFO("[INFO] "),
	ERROR("[ERROR] "),

	ONE("1. "),
	TWO("2. "),
	THREE("3. "),
	FOUR("4. "),
	BACK("B. "),
	QUIT("Q. "),

	CHOICE(BASIC.getMessage() + "원하시는 기능을 입력하세요");

	final private String message;

	General(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
