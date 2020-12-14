package subway.view.resource;

public enum ErrorCode {
    INVALID_FUNCTION("선택할 수 없는 기능입니다."),
    INVALID_NAME_LENGTH(" 이름은 2자 이상이어야 합니다."),
    INVALID_STATION_LAST_CHAR("이름의 마지막 글자는 '역'으로 끝나야 합니다."),
    INVALID_LINE_LAST_CHAR("이름의 마지막 글자는 '선'으로 끝나야 합니다."),
    INVALID_INDEX_RANGE("순서는 1에서 구간의 길이 -1까지여야 합니다."),
    EXISTING_STATION("이미 등록된 역 이름입니다."),
    EXISTING_STATION_IN_SECTION("입력한 노선에 이미 등록된 역입니다."),
    NOT_EXISTING_STATION("등록되지 않은 역 이름입니다."),
    NOT_EXISTING_LINE("등록되지 않은 노선 이름입니다."),
    REGISTERED_ON_LINE("노선에 등록된 역입니다."),
    EQUAL_STATION_FIRST_AND_LAST("상행 종점역과 하행 종점역이 같습니다."),
    LESS_THAN_MIN_STATION("선택한 노선의 역 개수가 2개 이하입니다."),
    NOT_LETTER(" 이름은 문자여야 합니다."),
    NOT_DIGIT("순서는 숫자여야 합니다.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
