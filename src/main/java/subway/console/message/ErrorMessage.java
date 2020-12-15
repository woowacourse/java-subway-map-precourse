package subway.console.message;

/**
 * @author yhh1056
 * @since 2020/12/15
 */
public enum ErrorMessage {
    ERROR("\n[ERROR] "),
    NOT_BUTTON("선택할 수 없는 기능입니다."),
    NAME_LENGTH("이름은 2글자 이상이어야 합니다."),
    STATION_NAME_END("이름은 역으로 끝나야 합니다."),
    LINE_NAME_END("이름은 선으로 끝나야 합니다."),
    NOT_EXIST_STATION("존재하지 않는 역입니다."),
    EXIST_STATION("이미 존재하는 역입니다."),
    EMPTY_STATION("등록된 역이 없습니다."),
    DUPLICATE_STATION("중복되는 역이 존재합니다."),
    EXIST_STATION_LINE("노선에 등록되어 있는 역입니다."),
    EMPTY_LINE("등록된 노선이 없습니다."),
    EXIST_LINE("이미 존재하는 노선입니다."),
    NOT_EXIST_LINE("존재하지 않는 노선입니다."),
    INVALID_RANGE("추가할 수 없는 구간입니다."),
    NUMERIC("숫자가 아닙니다."),
    SIZE("더 이상 삭제할 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR.message + message;
    }
}
