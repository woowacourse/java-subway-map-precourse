package subway.global.exception;

public enum ErrorMessage {
    // String
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    INVALID_LENGTH_ERROR("올바른 길이의 문자열을 입력해주세요."),

    // Global
    INVALID_FUNCTION_COMMAND("선택할 수 없는 기능입니다."),

    // Station
    STATION_DUPLICATED_ERROR("중복된 역 이름을 입력하였습니다."),
    STATION_NOT_FOUND_ERROR("입력한 역을 찾을 수 없습니다."),

    // Line
    LINE_DUPLICATED_ERROR("중복된 노선 이름을 입력하였습니다."),
    LINE_NOT_FOUND_ERROR("입력한 노선을 찾을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
