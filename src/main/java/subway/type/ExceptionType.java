package subway.type;

/**
 * ExceptionType.java : 예외 처리 문구 상수를 모아둔 Enum 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public enum  ExceptionType {
    ERROR("[ERROR] "),

    INVALID_FEATURE_CHOICE(ERROR.getException() + "선택할 수 없는 기능입니다.\n"),

    INVALID_STATION_NAME(ERROR.getException() + "이미 등록된 역 이름입니다.\n"),
    INVALID_STATION_NAME_LENGTH(ERROR.getException() + "2글자 이상의 역 이름을 입력해주세요.\n"),
    INVALID_STATION_NAME_LAST_CHARACTER(ERROR.getException() + "'역'으로 끝나는 역 이름을 입력해주세요.\n"),
    INVALID_STATION_NAME_IN_TRANSIT_MAP(ERROR.getException()
            + "해당 역은 지하철 노선에 등록되어 있어 삭제할 수 없습니다.\n"),
    INVALID_STATION_NAME_EXISTENCE(ERROR.getException() + "해당 역이 존재하지 않습니다.\n"),

    INVALID_LINE_NAME(ERROR.getException() + "이미 등록된 노선 이름입니다.\n"),
    INVALID_LINE_NAME_LENGTH(ERROR.getException() + "2글자 이상의 노선 이름을 입력해주세요.\n"),
    INVALID_LINE_NAME_LAST_CHARACTER(ERROR.getException() + "'선'으로 끝나는 노선 이름을 입력해주세요.\n"),
    INVALID_LINE_STATION_NAMES_EXISTENCE(ERROR.getException()
            + "상행 종점역과 하행 종점역은 지하철 역 목록에 존재해야 합니다.\n"),
    INVALID_LINE_SAME_STATION_NAMES(ERROR.getException() + "상행 종점역과 하행 종점역은 서로 달라야 합니다.\n"),
    INVALID_LINE_NAME_EXISTENCE(ERROR.getException() + "해당 노선이 존재하지 않습니다.\n"),

    INVALID_SECTION_STATION_NAME_IN_LINE_ALREADY_EXISTENCE(ERROR.getException()
            + "해당 역은 이미 노선에 존재합니다.\n"),
    INVALID_SECTION_ORDER_REPLACEMENT_LENGTH(ERROR.getException() + "순서는 숫자로 입력해주세요.\n"),
    INVALID_SECTION_ORDER_NUMBER(ERROR.getException() + "순서는 양의 정수로 입력해주세요.\n"),
    INVALID_SECTION_ORDER_NUMBER_BY_STATIONS(
            ERROR.getException() + "순서는 노선에 있는 역 개수보다 하나 큰 수까지만 입력해주세요.\n"),
    INVALID_NUMBER_OF_SECTION_STATIONS_IN_LINE(ERROR.getException()
            + "해당 노선에 포함된 역이 2개 이하이기 때문에 삭제할 수 없습니다.\n");

    private final String exception;

    ExceptionType(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
