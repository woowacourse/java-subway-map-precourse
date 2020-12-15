package subway.console.message;

/**
 * @author yhh1056
 * @since 2020/12/14
 */
public enum InputMessage {
    INPUT("\n## "),
    SELECT_BUTTON("원하는 기능을 선택하세요."),
    CREATE_STATION("등록할 역 이름을 입력하세요."),
    DELETE_STATION("삭제할 역 이름을 입력하세요."),
    CREATE_LINE("등록할 노선 이름을 입력하세요."),
    FIRST_STATION("등록할 노선의 상행 종점역 이름을 입력하세요."),
    LAST_STATION("등록할 노선의 하행 종점역 이름을 입력하세요."),
    DELETE_LINE("삭제할 노선 이름을 입력하세요."),
    LINE_SECTION("노선을 입력하세요."),
    STATION_SECTION("역이름을 입력하세요."),
    ORDER_SECTION("순서를 입력하세요."),
    DELETE_SECTION("삭제할 구간의 노선을 입력하세요."),
    DELETE_ORDER_SECTION("삭제할 구간의 역을 입력하세요.");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return INPUT.message + message;
    }
}
