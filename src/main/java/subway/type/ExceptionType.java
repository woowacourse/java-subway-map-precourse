package subway.type;

public enum  ExceptionType {
    ERROR("[ERROR] "),
    INVALID_FEATURE_CHOICE(ERROR.getException() + "선택할 수 없는 기능입니다.\n");

    private final String exception;

    ExceptionType(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
