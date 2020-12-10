package subway.view;

import subway.domain.Station;

public enum StationMessages {
	STATION_0(General.BASIC.getMessage() + "역 관리 화면"),
	STATION_1(General.ONE.getMessage() + "역 등록"),
	STATION_2(General.TWO.getMessage() + "역 삭제"),
	STATION_3(General.THREE.getMessage() + "역 조회"),
	STATION_B(General.BACK.getMessage() + "돌아가기"),

	REGISTER_MESSAGE(General.BASIC.getMessage() + "등록할 역 이름을 입력하세요."),
	DUPLICATE_NAME_ERROR_MESSAGE(General.ERROR.getMessage() + "이미 존재하는 역 이름입니다"),
	NAME_LENGTH_ERROR_MESSAGE(General.ERROR.getMessage() + "역 이름은 "
			+ Station.NAME_LENGTH_LOWER_BOUND + "이상이어야 합니다."),
	REGISTER_COMPLETE_MESSAGE(General.INFO.getMessage() + "지하철 역이 등록되었습니다."),

	DELETE_MESSAGE(General.BASIC.getMessage() + "삭제할 역 이름을 입력하세요."),
	REGISTER_DELETE_MESSAGE(General.INFO.getMessage() + "지하철 역이 삭제되었습니다.");

	final private String message;

	StationMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
