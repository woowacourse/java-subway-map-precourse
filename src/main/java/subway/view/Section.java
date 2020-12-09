package subway.view;

public enum Section {
	SECTION_0(Logger.BASIC.getMessage() + "구간 관리 화면"),
	SECTION_1(Numbering.ONE.getMessage() + "구간 등록"),
	SECTION_2(Numbering.TWO.getMessage() + "구간 삭제"),
	SECTION_B(Numbering.THREE.getMessage() + "돌아가기");

	final private String message;

	Section(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
