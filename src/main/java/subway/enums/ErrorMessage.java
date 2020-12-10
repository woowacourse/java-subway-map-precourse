package subway.enums;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    STATION_DUPLICATION(ERROR.getMessage() + "이미 등록된 역 이름입니다."),
    NAME_LENGTH_UNDER_2(ERROR.getMessage() + "역 이름은 2자부터 등록 가능합니다."),
    STATION_NOT_EXIST(ERROR.getMessage() + "등록된 역이 없습니다."),

    LINE_DUPLICATION(ERROR.getMessage() + "이미 등록된 노선 이름입니다.");

    String message = "";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
