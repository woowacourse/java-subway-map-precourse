package subway.enums;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    STATION_DUPLICATION(ERROR.getMessage() + "이미 등록된 역 이름입니다."),
    STATION_NAME_LENGTH_UNDER_2(ERROR.getMessage() + "역 이름은 2자부터 등록 가능합니다."),
    STATION_NOT_EXIST(ERROR.getMessage() + "등록된 역이 없습니다."),

    LINE_DUPLICATION(ERROR.getMessage() + "이미 등록된 노선 이름입니다."),
    LINE_NAME_LENGTH_UNDER_2(ERROR.getMessage() + "노선 이름은 2자부터 등록 가능합니다."),

    LAST_UP_AND_DOWN_STATION_DUPLICATION(ERROR.getMessage() + "상행 종점역과 중복됩니다."),
    LINE_NOT_EXIST(ERROR.getMessage() + "등록된 역이 없습니다.");

    String message = "";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
