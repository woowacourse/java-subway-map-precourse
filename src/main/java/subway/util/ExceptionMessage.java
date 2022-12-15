package subway.util;

public enum ExceptionMessage {

    NO_SUCH_MAIN_OPTION("해당 메인 옵션이 존재하지 않습니다."),
    INVALID_OUT_OF_INT_RANGE("입력 범위를 초과하였습니다."),
    NO_SUCH_STATION_NAME("해당 이름을 가진 역을 찾을 수 없습니다."),
    NO_SUCH_LINE_NAME("해당 이름을 가진 노선을 찾을 수 없습니다."),
    NO_SUCH_STATION_OPTION("올바른 역 관리 옵션을 선택해 주세요.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}
