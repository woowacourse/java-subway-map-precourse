package subway.view;

public enum SectionScreen {
	SECTION_0("## 구간 관리 화면"),
	SECTION_1("1. 구간 등록"),
	SECTION_2("2. 구간 삭제"),
	SECTION_B("B. 돌아가기");

	final private String message;

	SectionScreen(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
