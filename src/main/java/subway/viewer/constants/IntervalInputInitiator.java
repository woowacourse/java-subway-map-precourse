package subway.viewer.constants;

public enum IntervalInputInitiator {
    INITIAL_BLANK(""),
    MAIN_INTERVAL_MANAGE("## 구간 관리 화면"),
    ENROLL_INTERVAL("1. 구간 등록"),
    DELETE_INTERVAL("2. 구간 삭제"),
    BACK_MAIN("B. 돌아가기"),
    BLANK(""),
    ASK_FUNCTION("## 원하는 기능을 선택하세요.");

    final private String message;

    private IntervalInputInitiator(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
