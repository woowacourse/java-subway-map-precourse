package subway.message;

public enum StationMessage {
    STATION_FUNCTION_LIST("## 역 관리 화면\n"
        + "1. 역 등록\n"
        + "2. 역 삭제\n"
        + "3. 역 조회\n"
        + "B. 돌아가기"),
    STATION_ADD_GUIDE("## 등록할 역 이름을 입력하세요"),
    STATION_LIST("## 역 목록"),

    STATION_ADD_SUCCESS("[INFO] 지하철 역이 등록되었습니다."),

    STATION_ADD_NAME_LIMIT_FAIL("[ERROR] 역 이름이 너무 짧습니다."),
    STATION_ADD_NAME_DUPLICATION_FAIL("[ERROR] 중복된 역 이름은 불가능합니다."),
    STATION_LIST_FIND_FAIL("[ERROR] 하나 이상의 역이 존재해야 합니다."),
    ;

    private final String text;

    StationMessage(String text) {
        this.text = text;
    }

    public String getStationMessage() {
        return this.text;
    }

}
