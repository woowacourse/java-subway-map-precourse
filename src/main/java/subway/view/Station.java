package subway.view;

public enum Station {
	STATION_0(General.BASIC.getMessage() + "역 관리 화면"),
	STATION_1(General.ONE.getMessage() + "역 등록"),
	STATION_2(General.TWO.getMessage() + "역 삭제"),
	STATION_3(General.THREE.getMessage() + "역 조회"),
	STATION_B(General.BACK.getMessage() + "돌아가기"),

	REGISTER_MESSAGE(General.BASIC.getMessage() + "등록할 역 이름을 입력하세요."),
	REGISTER_COMPLETE_MESSAGE(General.INFO.getMessage() + "지하철 역이 등록되었습니다."),
	DELETE_MESSAGE(General.BASIC.getMessage() + "삭제할 역 이름을 입력하세요."),
	REGISTER_DELETE_MESSAGE(General.INFO.getMessage() + "지하철 역이 삭제되었습니다.");

	final private String message;

	Station(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
