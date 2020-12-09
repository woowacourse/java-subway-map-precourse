package subway.view;

public enum Line {
	LINE_0(Logger.BASIC.getMessage() + "노선 관리 화면"),
	LINE_1(Numbering.ONE.getMessage() + "노선 등록"),
	LINE_2(Numbering.TWO.getMessage() + "노선 삭제"),
	LINE_3(Numbering.THREE.getMessage() + "노선 조회"),
	LINE_B(Numbering.BACK.getMessage() + "돌아가기");

	final private String message;

	Line(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
