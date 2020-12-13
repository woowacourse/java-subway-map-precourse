package subway.view;

public class OutputViewMessage {

    public static final String INFO_PREFIX = "[INFO] ";
    public static final String INPUT_PREFIX = "## ";
    public static final String PRINT_STATIONS_TITLE = INPUT_PREFIX + "%s 목록";
    public static final String MENU_SUFFIX = "화면";
    public static final String RESULT_MESSAGE = INFO_PREFIX + "지하철 %s이 %s 되었습니다.";
    public static final String ACTION_PRINT_MESSAGE = "## %s할 %s 이름을 입력하세요.";
    public static final String LIST_TITLE_MESSAGE = "## %s 목록";
    public static final String SUBWAY_MAP_LIST = INPUT_PREFIX + "지하철 노선도";
    public static String LIST_BOUNDARY = "[INFO] ---";

    private OutputViewMessage() {
    }


}
