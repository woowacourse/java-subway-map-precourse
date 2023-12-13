package subway.global.exception;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    INVALID_FUNCTION_COMMAND("선택할 수 없는 기능입니다."),
    STATION_NAME_ERROR("올바른 역 이름을 입력해주세요."),
    STATION_DUPLICATED_ERROR("중복된 역 이름을 입력하였습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
