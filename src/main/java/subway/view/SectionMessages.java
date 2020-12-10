package subway.view;

import subway.domain.Station;

public enum SectionMessages {
	SECTION_0(General.BASIC.getMessage() + "구간 관리 화면"),
	SECTION_1(General.ONE.getMessage() + "구간 등록"),
	SECTION_2(General.TWO.getMessage() + "구간 삭제"),
	SECTION_B(General.BACK.getMessage() + "돌아가기"),

	LINE_NAME_TO_REGISTER(General.BASIC.getMessage() + "노선을 입력하세요."),
	STATION_NAME_TO_REGISTER(General.BASIC.getMessage() + "역이름을 입력하세요."),
	SECTION_LOCATION(General.BASIC.getMessage() + "순서를 입력하세요."),
	REGISTER_COMPLETE(General.INFO.getMessage() + "구간이 등록되었습니다."),
	LINE_NAME_TO_DELETE(General.BASIC.getMessage() + "삭제할 노선 이름을 입력하세요."),
	STATION_NAME_TO_DELETE(General.INFO.getMessage() + "삭제할 구간의 역을 입력하세요."),
	DELETE_COMPLETE(General.INFO.getMessage() + "구간이 삭제되었습니다."),

	NON_POSITIVE_INTEGER_LOCATION_ERROR(General.ERROR.getMessage() + "위치는 양의 정수만 입력 가능합니다."),
	LOCATION_OUT_OF_RANGE_ERROR(General.ERROR.getMessage() + "노선의 총 범위 내의 구간 위치를 입력해주세요."),
	DUPLICATE_NAME_ERROR(General.ERROR.getMessage() + "이미 등록된 구간입니다"),
	UNREGISTERED_STATION_NAME_ERROR(General.ERROR.getMessage() + "등록되지 않은 역입니다."),
	UNREGISTERED_LINE_NAME_ERROR(General.ERROR.getMessage() + "등록되지 않은 노선입니다.");

	final private String message;

	SectionMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
