package subway.view;

import subway.domain.Station;

public enum LineMessages {
	LINE_0(General.BASIC.getMessage() + "노선 관리 화면"),
	LINE_1(General.ONE.getMessage() + "노선 등록"),
	LINE_2(General.TWO.getMessage() + "노선 삭제"),
	LINE_3(General.THREE.getMessage() + "노선 조회"),
	LINE_B(General.BACK.getMessage() + "돌아가기"),

	REGISTER_NAME(General.BASIC.getMessage() + "등록할 노선 이름을 입력하세요."),
	UPWARD_DESTINATION_NAME(General.BASIC.getMessage() + "등록할 노선의 상행 종점역 이름을 입력하세요."),
	DOWNWARD_DESTINATION_NAME(General.BASIC.getMessage() + "등록할 노선의 하행 종점역 이름을 입력하세요."),
	REGISTER_COMPLETE(General.INFO.getMessage() + "지하철 노선이 등록되었습니다."),
	DELETE_NAME(General.BASIC.getMessage() + "삭제할 노선 이름을 입력하세요."),
	DELETE_COMPLETE(General.INFO.getMessage() + "지하철 노선이 삭제되었습니다."),

	DUPLICATE_NAME_ERROR(General.ERROR.getMessage() + "이미 등록된 노선 이름입니다"),
	NAME_LENGTH_ERROR(General.ERROR.getMessage() + "노선 이름은 "
			+ Station.NAME_LENGTH_LOWER_BOUND + "이상이어야 합니다."),
	UNREGISTERED_NAME_ERROR(General.ERROR.getMessage() + "등록되지 않은 노선입니다.");

	final private String message;

	LineMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
