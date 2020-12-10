package subway.enums;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    STATION_DUPLICATION(ERROR.getMessage() + "이미 등록된 역 이름입니다.");

    String message = "";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
