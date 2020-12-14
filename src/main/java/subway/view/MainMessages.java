package subway.view;

public enum MainMessages {
	MAIN_0(GeneralMessages.BASIC.getMessage() + "메인 화면"),
	MAIN_1(GeneralMessages.ONE.getMessage() + "역 관리"),
	MAIN_2(GeneralMessages.TWO.getMessage() + "노선 관리"),
	MAIN_3(GeneralMessages.THREE.getMessage() + "구간 관리"),
	MAIN_4(GeneralMessages.FOUR.getMessage() + "지하철 노선도 출력"),
	MAIN_Q(GeneralMessages.QUIT.getMessage() + "종료"),

	QUIT(GeneralMessages.BASIC.getMessage() + "종료합니다.");

	final private String message;

	MainMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
