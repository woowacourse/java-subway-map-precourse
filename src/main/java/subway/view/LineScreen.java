package subway.view;

public enum LineScreen {
	LINE_0("## 노선 관리 화면"),
	LINE_1("1. 노선 등록"),
	LINE_2("2. 노선 삭제"),
	LINE_3("3. 노선 조회"),
	LINE_B("B. 돌아가기");

	final private String message;

	LineScreen(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
