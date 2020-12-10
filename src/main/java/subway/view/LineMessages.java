package subway.view;

public enum LineMessages {
	LINE_0(General.BASIC.getMessage() + "노선 관리 화면"),
	LINE_1(General.ONE.getMessage() + "노선 등록"),
	LINE_2(General.TWO.getMessage() + "노선 삭제"),
	LINE_3(General.THREE.getMessage() + "노선 조회"),
	LINE_B(General.BACK.getMessage() + "돌아가기");



	final private String message;

	LineMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
