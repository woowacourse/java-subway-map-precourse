package subway.viewer.constants;

public enum LineInputInitiator {
    MAIN_LINE_MANAGE("## 역 관리 화면"),
    ENROLL_LINE("1. 역 등록"),
    DELETE_LINE("2. 역 삭제"),
    CHECK_LINE("3. 역 조회"),
    BACK_MAIN("B. 돌아가기"),
    BLANK(" "),
    ASK_FUNCTION("## 원하는 기능을 선택하세요.");

    final private String message;

    LineInputInitiator(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
