package subway;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constant {
    static final String[] mainMenuItems = {"1. 역 관리", "2. 노선 관리", "3. 구간 관리", "4. 지하철 노선도 출력", "Q. 종료"};
    static final String[] stationMenuItems = {"1. 역 등록", "2. 역 삭제", "3. 역 조회", "B. 돌아가기"};
    static final String[] lineMenuItems = {"1. 노선 등록", "2. 노선 삭제", "3. 노선 조회", "B. 돌아가기"};
    static final String[] sectionMenuItems = {"1. 구간 등록", "2. 구간 삭제", "B. 돌아가기"};

    private static final List<String> mainMenuItemList = Arrays.asList(mainMenuItems);
    private static final List<String> stationMenuItemList = Arrays.asList(stationMenuItems);
    private static final List<String> lineMenuItemList = Arrays.asList(lineMenuItems);
    private static final List<String> sectionMenuItemList = Arrays.asList(sectionMenuItems);

    public static List<String> mainMenuItemList() {
        return Collections.unmodifiableList(mainMenuItemList);
    }

    public static List<String> stationMenuItemList() {
        return Collections.unmodifiableList(stationMenuItemList);
    }

    public static List<String> lineMenuItemList() {
        return Collections.unmodifiableList(lineMenuItemList);
    }

    public static List<String> sectionMenuItemList() {
        return Collections.unmodifiableList(sectionMenuItemList);
    }

    static final String ONE = "1";
    static final String TWO = "2";
    static final String THREE = "3";
    static final String FOUR = "4";
    static final String Q = "Q";
    static final String B = "B";

    static final String MAIN_MENU_TITLE = "메인 화면";
    static final String STATION_MENU_TITLE = "역 관리 화면";
    static final String LINE_MENU_TITLE = "노선 관리 화면";
    static final String SECTION_MENU_TITLE = "구간 관리 화면";
    static final String MAP_TITLE = "지하철 노선도";
    static final String STATION_LIST_TITLE = "역 목록";
    static final String LINE_LIST_TITLE = "노선 목록";

    static final String HEAD_HASH = "## ";
    static final String HEAD_INFO = "[INFO] ";
    static final String HEAD_ERROR = "[ERROR] ";
    static final String DIVIDER = "---";

    static final String CHOOSE_FUNCTION = "원하는 기능을 선택하세요.";
    static final String ENTER_STATION_TO_ADD = "등록할 역 이름을 입력하세요.";
    static final String ENTER_STATION_TO_DELETE = "삭제할 역 이름을 입력하세요.";
    static final String ENTER_LINE_TO_ADD = "등록할 노선 이름을 입력하세요.";
    static final String ENTER_LINE_TO_DELETE = "삭제할 노선 이름을 입력하세요.";
    static final String ENTER_ASCENDING_LINE_TO_ADD = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    static final String ENTER_DESCENDING_LINE_TO_ADD = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    static final String ENTER_LINE_SECTION_TO_ADD = "노선을 입력하세요.";
    static final String ENTER_STATION_SECTION_TO_ADD = "역이름을 입력하세요.";
    static final String ENTER_ORDER_SECTION_TO_ADD = "순서를 입력하세요.";
    static final String ENTER_LINE_SECTION_TO_DELETE = "삭제할 구간의 노선을 입력하세요.";
    static final String ENTER_STATION_SECTION_TO_DELETE = "삭제할 구간의 역을 입력하세요.";

    static final String ADD_STATION_DONE = "지하철 역이 등록되었습니다.";
    static final String DELETE_STATION_DONE = "지하철 역이 삭제되었습니다.";
    static final String ADD_LINE_DONE = "지하철 노선이 등록되었습니다.";
    static final String DELETE_LINE_DONE = "지하철 노선이 삭제되었습니다.";
    static final String ADD_SECTION_DONE = "구간이 등록되었습니다.";
    static final String DELETE_SECTION_DONE = "구간이 삭제되었습니다.";
}
