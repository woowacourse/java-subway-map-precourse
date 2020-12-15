package subway.viewer.constants;

public enum SystemInputInitiator {
    INITIAL_BLANK(""),
    MAIN_SCREEN("## 메인화면"),
    MANAGE_STATION("1. 역 관리"),
    MANAGE_LINE("2. 노선 관리"),
    MANAGE_INTERVAL("3. 구간 관리"),
    SHOW_LINE_MAP("4. 지하철 노선도 출력"),
    END_SYSTEM("Q. 종료"),
    BLANK(""),
    ASK_FUNCTION("## 원하는 기능을 선택하세요.");

    final private String message;

    private SystemInputInitiator(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
