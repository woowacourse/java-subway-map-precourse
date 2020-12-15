package subway.viewer.constants;

public enum StationInputInitiator {
    INITIAL_BLANK(""),
    MAIN_STATION_MANAGE("## 역 관리 화면"),
    ENROLL_STATION("1. 역 등록"),
    DELETE_STATION("2. 역 삭제"),
    CHECK_STATION("3. 역 조회"),
    BACK_MAIN("B. 돌아가기"),
    BLANK(""),
    ASK_FUNCTION("## 원하는 기능을 선택하세요.");

    final private String message;

    private StationInputInitiator(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
