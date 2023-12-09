package subway.exception;

public enum ExceptionMessage {
    NOT_FOUND_OPTION("존재하지 않는 메뉴입니다."),
    NOT_FOUND_STATION("존재하지 않는 역입니다."),
    NOT_FOUND_LINE("존재하지 않는 노선입니다."),
    INVALID_STATION_NAME_LENGTH("역 이름은 최소 2글자 이상이어야 합니다."),
    INVALID_STATION_NAME_CHARACTER("역 이름은 한글만 가능합니다."),
    INVALID_STATION_NAME_SUFFIX("역 이름뒤에 '역'이 붙어야 합니다."),
    STATION_ALREADY_EXISTS("중복된 역을 등록할 수 없습니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
