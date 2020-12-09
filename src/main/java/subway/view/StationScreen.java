package subway.view;

public enum StationScreen {
	STATION_0("## 역 관리 화면"),
	STATION_1("1. 역 등록"),
	STATION_2("2. 역 삭제"),
	STATION_3("3. 역 조회"),
	STATION_B("B. 돌아가기");

	final private String message;

	StationScreen(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
