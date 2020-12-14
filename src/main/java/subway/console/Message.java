package subway.console;

/**
 * @author yhh1056
 * @since 2020/12/10
 */
public class Message {
    public static final String SUBWAY_LINE = "\n## 지하철 노선도";
    public static final String STATIONS = "\n## 역목록";
    public static final String LINES = "\n## 노선목록";
    public static final String INPUT_SELECT_BUTTON = "\n## 원하는 기능을 선택하세요.";
    public static final String INPUT_CREATE_STATION = "\n## 등록할 역 이름을 입력하세요.";
    public static final String INPUT_DELETE_STATION = "\n## 삭제할 역 이름을 입력하세요.";
    public static final String INPUT_CREATE_LINE = "\n## 등록할 노선 이름을 입력하세요.";
    public static final String INPUT_FIRST_STATION =
            "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String INPUT_LAST_STATION =
            "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String INPUT_DELETE_LINE = "\n## 삭제할 노선 이름을 입력하세요.";
    public static final String INPUT_CREATE_SECTION = "\n## 노선을 입력하세요.";
    public static final String INPUT_STATION_SECTION = "\n## 역이름을 입력하세요.";
    public static final String INPUT_ORDER_SECTION = "\n## 순서를 입력하세요.";

    public static final String INFO = "[INFO] ";
    public static final String INFO_CREATE_STATION = "\n[INFO] 지하철 역이 등록되었습니다.";
    public static final String INFO_DELETE_STATION = "\n[INFO] 지하철 역이 삭제되었습니다.";
    public static final String INFO_CREATE_LINE = "\n[INFO] 지하철 노선이 등록되었습니다.";
    public static final String INFO_DELETE_LINE = "\n[INFO] 지하철 노선이 삭제되었습니다.";
    public static final String INFO_CREATE_SECTION = "\n[INFO] 구간이 등록되었습니다.";

    public static final String ERROR_NOT_BUTTON = "\n[ERROR] 선택할 수 없는 기능입니다.";
    public static final String ERROR_NAME_LENGTH = "\n[ERROR] 이름은 2글자 이상이어야 합니다.";
    public static final String ERROR_STATION_NAME_END = "\n[ERROR] 이름은 역으로 끝나야 합니다.";
    public static final String ERROR_LINE_NAME_END = "\n[ERROR] 이름은 선으로 끝나야 합니다.";
    public static final String ERROR_NOT_EXIST_STATION = "\n[ERROR] 존재하지 않는 역입니다.";
    public static final String ERROR_EXIST_STATION = "\n[ERROR] 이미 존재하는 역입니다.";
    public static final String ERROR_EMPTY_STATION = "\n[ERROR] 등록된 역이 없습니다.";
    public static final String ERROR_EXIST_LINE = "\n[ERROR] 이미 존재하는 노선입니다.";
    public static final String ERROR_DUPLICATE_STATION = "\n[ERROR] 중복되는 역이 존재합니다.";

    private Message() {
    }
}
