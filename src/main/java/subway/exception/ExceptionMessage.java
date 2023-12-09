package subway.exception;

public enum ExceptionMessage {
    NOT_FOUND_OPTION("존재하지 않는 메뉴입니다."),
    NOT_FOUND_STATION("존재하지 않는 역입니다."),
    NOT_FOUND_LINE("존재하지 않는 노선입니다."),
    INVALID_STATION_NAME_LENGTH("역 이름은 최소 2글자 이상이어야 합니다."),
    INVALID_STATION_NAME_CHARACTER("역 이름은 한글만 가능합니다."),
    INVALID_STATION_NAME_SUFFIX("역 이름뒤에 '역'이 붙어야 합니다."),
    STATION_ALREADY_EXISTS("중복된 역을 등록할 수 없습니다."),
    INVALID_REMOVE_STATION_IN_LINE("노선에 등록된 역은 삭제할 수 없습니다."),
    INVALID_ADD_LINE_ALREADY_EXISTS("이미 존재하는 노선은 등록할 수 없습니다."),
    INVALID_ADD_LINE_NOT_FOUND_STATION("존재하지 않는 역은 등록할 수 없습니다."),
    INVALID_ADD_LINE_NAME("노선의 이름은 2글자 이상이어야 합니다."),
    INVALID_ADD_LINE_NAME_CHARACTER("노선의 이름은 한글만 가능합니다."),
    INVALID_ADD_LINE_NAME_SUFFIX("노선의 이름뒤에 '선'이 붙어야 합니다."),
    ;
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
