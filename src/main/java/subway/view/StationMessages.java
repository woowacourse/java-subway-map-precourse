package subway.view;

import subway.domain.Station;

public enum StationMessages {
	STATION_0(GeneralMessages.BASIC.getMessage() + "역 관리 화면"),
	STATION_1(GeneralMessages.ONE.getMessage() + "역 등록"),
	STATION_2(GeneralMessages.TWO.getMessage() + "역 삭제"),
	STATION_3(GeneralMessages.THREE.getMessage() + "역 조회"),
	STATION_B(GeneralMessages.BACK.getMessage() + "돌아가기"),


	REGISTER_NAME(GeneralMessages.BASIC.getMessage() + "등록할 역 이름을 입력하세요."),
	REGISTER_COMPLETE(GeneralMessages.INFO.getMessage() + "지하철 역이 등록되었습니다."),
	DELETE_NAME(GeneralMessages.BASIC.getMessage() + "삭제할 역 이름을 입력하세요."),
	DELETE_COMPLETE(GeneralMessages.INFO.getMessage() + "지하철 역이 삭제되었습니다."),
	REFERENCE(GeneralMessages.BASIC.getMessage() + "역 목록"),

	DUPLICATE_NAME_ERROR(GeneralMessages.ERROR.getMessage() + "이미 등록된 역 이름입니다"),
	NAME_LENGTH_ERROR(GeneralMessages.ERROR.getMessage() + "역 이름은 "
			+ Station.NAME_LENGTH_LOWER_BOUND + "이상이어야 합니다."),
	UNREGISTERED_NAME_ERROR(GeneralMessages.ERROR.getMessage() + "등록되지 않은 역입니다.");

	final private String message;

	StationMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
