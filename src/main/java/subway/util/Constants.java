package subway.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import subway.model.MenuGroup.Menu;
import subway.model.MenuGroup.MenuItem;

public class Constants {

    public final static List<MenuItem> MAIN_MENU_ITEMS = Arrays.asList(
        new MenuItem("1", "역 관리"),
        new MenuItem("2", "노선 관리"),
        new MenuItem("3", "구간 관리"),
        new MenuItem("4", "지하철 노선도 출력"),
        new MenuItem("Q", "종료")
    );

    public final static List<MenuItem> STATION_MENU_ITEMS = Arrays.asList(
        new MenuItem("1", "역 등록"),
        new MenuItem("2", "역 삭제"),
        new MenuItem("3", "역 조회"),
        new MenuItem("B", "돌아가기")
    );

    public final static List<MenuItem> LINE_MENU_ITEMS = Arrays.asList(
        new MenuItem("1", "노선 등록"),
        new MenuItem("2", "노선 삭제"),
        new MenuItem("3", "노선 조회"),
        new MenuItem("B", "돌아가기")
    );

    public final static List<MenuItem> SECTION_MENU_ITEMS = Arrays.asList(
        new MenuItem("1", "구간 등록"),
        new MenuItem("2", "구간 삭제"),
        new MenuItem("B", "돌아가기")
    );

    public final static Map<String, Menu> MENU_GROUPS = Map.of(
        Constants.MAIN_MENU_STATE, new Menu("메인 화면", Constants.MAIN_MENU_ITEMS),
        Constants.STATION_MENU_STATE, new Menu("역 관리 화면", Constants.STATION_MENU_ITEMS),
        Constants.LINE_MENU_STATE, new Menu("노선 관리 화면", Constants.LINE_MENU_ITEMS),
        Constants.SECTION_MENU_STATE, new Menu("구간 관리 화면", Constants.SECTION_MENU_ITEMS)
    );

    public static final String MENU_GROUP_PREFIX = "## ";

    public static final String MAIN_MENU_STATE = "MAIN";
    public static final String STATION_MENU_STATE = "STATION";
    public static final String LINE_MENU_STATE = "LINE";
    public static final String SECTION_MENU_STATE = "SECTION";

    public final static String EXIT_INPUT_CHARACTER = new String("Q");
    public final static String BACKWARD_INPUT_CHARACTER = new String("B");

    public final static int MIN_NAME_STRING_LENGTH_INT = 2;
    public final static int MIN_SECTION_LENGTH_INT = 2;
    public final static int INDEX_ARRANGE_INT = 1;

    public final static String PREFIX_INFO = "[INFO] ";
    public final static String PREFIX_ERROR = "[ERROR] ";

    public final static String INVALID_ASK = "선택할 수 없는 기능입니다.";
    public final static String INVALID_STRING = "잘못된 문자 입력입니다.";
    public final static String INVALID_INDEX = "잘못된 위치 입니다.";
    public final static String INVALID_STRING_MIN_LENGTH =
        "역 이름이 " + MIN_NAME_STRING_LENGTH_INT + "글자 이상 필요 합니다.";

    public final static String ASK_FEATURE_SELECT_ANNOUNCEMENT = "## 원하는 기능을 선택하세요.";

    public final static String ADD_STATION_ASK = "## 등록할 역 이름을 입력하세요.";
    public final static String ADDED_STATION = "지하철 역이 등록되었습니다.";
    public final static String DELETE_STATION_ASK = "## 삭제할 역 이름을 입력하세요.";
    public final static String DELETED_STATION = "지하철 역이 삭제되었습니다.";
    public final static String TITLE_STATION_LIST = "## 역 목록";
    public final static String EXIST_STATION = "이미 등록된 역 이름입니다.";
    public final static String NO_EXIST_STATION = "존재하지 않는 역 이름입니다.";
    public final static String EXIST_STATION_IN_SECTION = "구간에 등록되어 있는 역 입니다. 구간을 먼저 삭제해 주세요.";

    public final static String ADD_LINE_ASK = "## 등록할 노선 이름을 입력하세요.";
    public final static String ADD_START_STATION_ASK = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public final static String ADD_END_STATION_ASK = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public final static String ADDED_LINE = "지하철 노선이 등록되었습니다.";
    public final static String DELETE_LINE_NAME_ASK = "## 삭제할 노선 이름을 입력하세요.";
    public final static String DELETED_LINE = "지하철 노선이 삭제되었습니다.";
    public final static String TITLE_LINE_LIST = "## 노선 목록";
    public final static String EXIST_LINE = "이미 등록된 노선 이름입니다.";
    public final static String NO_EXIST_LINE = "존재하지 않는 노선 이름입니다.";
    public static final String INVALID_START_TO_END_STATION = "상행과 하행의 이름이 동일합니다.";

    public final static String ADD_SECTION_LINE_ASK = "## 노선을 입력하세요.";
    public final static String ADD_SECTION_STATION_ASK = "## 역이름을 입력하세요.";
    public final static String ADD_SECTION_INDEX_ASK = "## 순서를 입력하세요.";
    public final static String ADDED_SECTION = "구간이 등록되었습니다.";
    public final static String DELETE_SECTION_LINE_ASK = "## 삭제할 구간의 노선을 입력하세요.";
    public final static String DELETE_SECTION_STATION_ASK = "## 삭제할 구간의 역을 입력하세요.";
    public final static String DELETED_SECTION = "구간이 삭제되었습니다.";
    public final static String NO_EXIST_SECTION = "구간에 역이 존재하지 않습니다.";
    public static final String INVALID_SECTION_MIN_LENGTH = "노선에 상행역과 하행역 뿐입니다.";

    public final static String TITLE_SUBWAY_MAP = "## 지하철 노선도";
    public final static String SEPARATE_STRING_SUBWAY_MAP = "---";
}
