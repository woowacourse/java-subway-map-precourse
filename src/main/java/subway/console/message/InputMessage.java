package subway.console.message;

/**
 * @author yhh1056
 * @since 2020/12/14
 */
public class InputMessage {
    public static final String SELECT_BUTTON = "\n## 원하는 기능을 선택하세요.";

    public static final String CREATE_STATION = "\n## 등록할 역 이름을 입력하세요.";
    public static final String DELETE_STATION = "\n## 삭제할 역 이름을 입력하세요.";

    public static final String CREATE_LINE = "\n## 등록할 노선 이름을 입력하세요.";
    public static final String FIRST_STATION = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String LAST_STATION = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String DELETE_LINE = "\n## 삭제할 노선 이름을 입력하세요.";

    public static final String CREATE_SECTION = "\n## 노선을 입력하세요.";
    public static final String STATION_SECTION = "\n## 역이름을 입력하세요.";
    public static final String ORDER_SECTION = "\n## 순서를 입력하세요.";
    public static final String DELETE_SECTION = "\n## 삭제할 구간의 노선을 입력하세요.";
    public static final String DELETE_ORDER_SECTION = "\n## 삭제할 구간의 역을 입력하세요.";

    private InputMessage() {
    }
}
