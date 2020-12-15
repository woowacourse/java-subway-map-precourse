package subway.view;

import subway.domain.Station;

public enum LineMessages {
	LINE_0(GeneralMessages.BASIC.getMessage() + "노선 관리 화면"),
	LINE_1(GeneralMessages.ONE.getMessage() + "노선 등록"),
	LINE_2(GeneralMessages.TWO.getMessage() + "노선 삭제"),
	LINE_3(GeneralMessages.THREE.getMessage() + "노선 조회"),
	LINE_B(GeneralMessages.BACK.getMessage() + "돌아가기"),

	REGISTER_NAME(GeneralMessages.BASIC.getMessage() + "등록할 노선 이름을 입력하세요."),
	UPWARD_DESTINATION_NAME(GeneralMessages.BASIC.getMessage() + "등록할 노선의 상행 종점역 이름을 입력하세요."),
	DOWNWARD_DESTINATION_NAME(GeneralMessages.BASIC.getMessage() + "등록할 노선의 하행 종점역 이름을 입력하세요."),
	REGISTER_COMPLETE(GeneralMessages.INFO.getMessage() + "지하철 노선이 등록되었습니다."),
	DELETE_NAME(GeneralMessages.BASIC.getMessage() + "삭제할 노선 이름을 입력하세요."),
	DELETE_COMPLETE(GeneralMessages.INFO.getMessage() + "지하철 노선이 삭제되었습니다."),
	REFERENCE(GeneralMessages.BASIC.getMessage() + "노선 목록"),

	DUPLICATE_NAME_ERROR(GeneralMessages.ERROR.getMessage() + "이미 등록된 노선 이름입니다"),
	DESTINATION_DUPLICATE_ERROR(GeneralMessages.ERROR.getMessage() + "상행 종점과 하행 종점이 같을 수 없습니다."),
	NAME_LENGTH_ERROR(GeneralMessages.ERROR.getMessage() + "노선 이름은 "
			+ Station.NAME_LENGTH_LOWER_BOUND + "이상이어야 합니다."),
	UNREGISTERED_NAME_ERROR(GeneralMessages.ERROR.getMessage() + "등록되지 않은 노선입니다.");

	final private String message;

	LineMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
