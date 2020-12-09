package subway.view;

public enum MainScreen {
	MAIN_0("## 메인 화면 출력"),
	MAIN_1("1. 역 관리"),
	MAIN_2("2. 노선 관리"),
	MAIN_3("3. 구간 관리"),
	MAIN_4("4. 지하철 노선도 출력"),
	MAIN_Q("Q. 종료");

	final private String message;

	MainScreen(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
