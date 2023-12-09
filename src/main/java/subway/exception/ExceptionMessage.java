package subway.exception;

public enum ExceptionMessage {
    NOT_FOUND_STATION("존재하지 않는 역입니다."),
    NOT_FOUND_LINE("존재하지 않는 노선입니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
