package subway.exception;

public enum ErrorCode {
    CANNOT_CHOOSE_OPTION("I001", "[ERROR] 선택할 수 없는 기능입니다.");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
