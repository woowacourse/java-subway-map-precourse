package subway.view;

public enum MainMessages {
	MAIN_0(General.BASIC.getMessage() + "메인 화면 출력"),
	MAIN_1(General.ONE.getMessage() + "역 관리"),
	MAIN_2(General.TWO.getMessage() + "노선 관리"),
	MAIN_3(General.THREE.getMessage() + "구간 관리"),
	MAIN_4(General.FOUR.getMessage() + "지하철 노선도 출력"),
	MAIN_Q(General.QUIT.getMessage() + "종료");

	final private String message;

	MainMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
