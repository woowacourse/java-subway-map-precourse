package subway.view;

public enum Main {
	MAIN_0(Logger.BASIC.getMessage() + "메인 화면 출력"),
	MAIN_1(Numbering.ONE.getMessage() + "역 관리"),
	MAIN_2(Numbering.TWO.getMessage() + "노선 관리"),
	MAIN_3(Numbering.THREE.getMessage() + "구간 관리"),
	MAIN_4(Numbering.FOUR.getMessage() + "지하철 노선도 출력"),
	MAIN_Q(Numbering.QUIT.getMessage() + "종료");



	final private String message;

	Main(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
