package subway.view;

public enum GeneralMessages {
	BASIC("## "),
	INFO("[INFO] "),
	ERROR("[ERROR] "),

	ONE("1. "),
	TWO("2. "),
	THREE("3. "),
	FOUR("4. "),
	BACK("B. "),
	QUIT("Q. "),

	CHOICE(BASIC.getMessage() + "원하시는 기능을 입력하세요."),
	NOT_AVAILABLE_OPTION_ERROR(GeneralMessages.ERROR.getMessage() + "선택할 수 없는 기능입니다."),
	MAP(BASIC.getMessage() + "지하철 노선도"),
	DIVISION_LINE(INFO.getMessage() + "---");

	final private String message;

	GeneralMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
