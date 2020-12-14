package subway.console.message;

/**
 * @author yhh1056
 * @since 2020/12/14
 */
public class ErrorMessage {
    public static final String NOT_BUTTON = "\n[ERROR] 선택할 수 없는 기능입니다.";

    public static final String NAME_LENGTH = "\n[ERROR] 이름은 2글자 이상이어야 합니다.";
    public static final String STATION_NAME_END = "\n[ERROR] 이름은 역으로 끝나야 합니다.";
    public static final String LINE_NAME_END = "\n[ERROR] 이름은 선으로 끝나야 합니다.";

    public static final String NOT_EXIST_STATION = "\n[ERROR] 존재하지 않는 역입니다.";
    public static final String EXIST_STATION = "\n[ERROR] 이미 존재하는 역입니다.";
    public static final String EMPTY_STATION = "\n[ERROR] 등록된 역이 없습니다.";
    public static final String DUPLICATE_STATION = "\n[ERROR] 중복되는 역이 존재합니다.";
    public static final String EXIST_STATION_LINE = "\n[ERROR] 노선에 등록되어 있는 역입니다.";

    public static final String EMPTY_LINE = "\n[ERROR] 등록된 노선이 없습니다.";
    public static final String EXIST_LINE = "\n[ERROR] 이미 존재하는 노선입니다.";
    public static final String NOT_EXIST_LINE = "\n[ERROR] 존재하지 않는 노선입니다.";
    public static final String INVALID_RANGE = "\n[ERROR] 추가할 수 없는 구간입니다.";
    public static final String NUMERIC = "\n[ERROR] 숫자가 아닙니다.";
    public static final String SIZE = "\n[ERROR] 더 이상 삭제할 수 없습니다.";

    private ErrorMessage() {
    }
}
