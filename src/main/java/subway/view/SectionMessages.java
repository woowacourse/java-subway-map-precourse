package subway.view;

import subway.domain.Sections;

public enum SectionMessages {
	SECTION_0(GeneralMessages.BASIC.getMessage() + "구간 관리 화면"),
	SECTION_1(GeneralMessages.ONE.getMessage() + "구간 등록"),
	SECTION_2(GeneralMessages.TWO.getMessage() + "구간 삭제"),
	SECTION_B(GeneralMessages.BACK.getMessage() + "돌아가기"),

	LINE_NAME_TO_REGISTER(GeneralMessages.BASIC.getMessage() + "노선을 입력하세요."),
	STATION_NAME_TO_REGISTER(GeneralMessages.BASIC.getMessage() + "역이름을 입력하세요."),
	LOCATION(GeneralMessages.BASIC.getMessage() + "순서를 입력하세요."),
	REGISTER_COMPLETE(GeneralMessages.INFO.getMessage() + "구간이 등록되었습니다."),
	LINE_NAME_TO_DELETE(GeneralMessages.BASIC.getMessage() + "삭제할 노선 이름을 입력하세요."),
	STATION_NAME_TO_DELETE(GeneralMessages.BASIC.getMessage() + "삭제할 구간의 역을 입력하세요."),
	DELETE_COMPLETE(GeneralMessages.INFO.getMessage() + "구간이 삭제되었습니다."),

	NON_POSITIVE_INTEGER_LOCATION_ERROR(GeneralMessages.ERROR.getMessage() + "위치는 양의 정수만 입력 가능합니다."),
	LOCATION_OUT_OF_RANGE_ERROR(GeneralMessages.ERROR.getMessage() + "올바른 구간 위치를 입력해주세요."),
	DUPLICATE_NAME_ERROR(GeneralMessages.ERROR.getMessage() + "이미 등록된 구간입니다"),
	MINIMUM_SECTION_LENGTH_ERROR(GeneralMessages.ERROR.getMessage() + "노선에 역이 "
			+ Sections.MINIMUM_SECTION_LENGTH
			+ "개밖에 없습니다."),
	UNREGISTERED_STATION_NAME_ERROR(GeneralMessages.ERROR.getMessage() + "해당 노선에 등록되지 않은 역입니다."),
	UNREGISTERED_LINE_NAME_ERROR(GeneralMessages.ERROR.getMessage() + "등록되지 않은 노선입니다.");

	final private String message;

	SectionMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
