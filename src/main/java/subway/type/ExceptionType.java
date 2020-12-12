package subway.type;

public enum  ExceptionType {
    ERROR("[ERROR] "),
    INVALID_FEATURE_CHOICE(ERROR.getException() + "선택할 수 없는 기능입니다.\n"),
    INVALID_STATION_NAME(ERROR.getException() + "이미 등록된 역 이름입니다.\n"),
    INVALID_STATION_NAME_LENGTH(ERROR.getException() + "2글자 이상의 역 이름을 입력해주세요.\n");

    private final String exception;

    ExceptionType(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
