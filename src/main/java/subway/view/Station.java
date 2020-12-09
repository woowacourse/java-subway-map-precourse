package subway.view;

public enum Station {
	STATION_0(Logger.BASIC.getMessage() + "역 관리 화면"),
	STATION_1(Numbering.ONE.getMessage() + "역 등록"),
	STATION_2(Numbering.TWO.getMessage() + "역 삭제"),
	STATION_3(Numbering.THREE.getMessage() + "역 조회"),
	STATION_B(Numbering.BACK.getMessage() + "돌아가기"),

	REGISTER_MESSAGE(Logger.BASIC.getMessage() + "등록할 역 이름을 입력하세요.");

	final private String message;

	Station(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
