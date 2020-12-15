package subway.view;

import java.util.Arrays;
import java.util.List;

public class MenuMessage {

    private static final String MAIN_MENU_LABEL = "## 메인 화면";
    private static final String MAIN_MENU_STATION = "1. 역 관리";
    private static final String MAIN_MENU_LINE = "2. 노선 관리";
    private static final String MAIN_MENU_SECTION = "3. 구간 관리";
    private static final String MAIN_MENU_SHOW_MAP = "4. 지하철 노선도 출력";
    private static final String MAIN_MENU_QUIT = "Q. 종료";

    private static final String STATION_MENU_LABEL = "## 역 관리 화면";
    private static final String STATION_MENU_ADD = "1. 역 등록";
    private static final String STATION_MENU_DELETE = "2. 역 삭제";
    private static final String STATION_MENU_VIEW = "3. 역 조회";

    private static final String LINE_MENU_LABEL = "## 노선 관리 화면";
    private static final String LINE_MENU_ADD = "1. 노선 등록";
    private static final String LINE_MENU_DELETE = "2. 노선 삭제";
    private static final String LINE_MENU_VIEW = "3. 노선 조회";

    private static final String SECTION_MENU_LABEL = "## 구간 관리 화면";
    private static final String SECTION_MENU_ADD = "1. 구간 등록";
    private static final String SECTION_MENU_DELETE = "2. 구간 삭제";

    private static final String NON_MAIN_MENU_QUIT = "B. 돌아가기";

    public static final List<String> mainMenuOptions = Arrays.asList(
            MAIN_MENU_LABEL,
            MAIN_MENU_STATION,
            MAIN_MENU_LINE,
            MAIN_MENU_SECTION,
            MAIN_MENU_SHOW_MAP,
            MAIN_MENU_QUIT
    );

    public static final List<String> stationMenuOptions = Arrays.asList(
            STATION_MENU_LABEL,
            STATION_MENU_ADD,
            STATION_MENU_DELETE,
            STATION_MENU_VIEW,
            NON_MAIN_MENU_QUIT
    );

    public static final List<String> lineMenuOptions = Arrays.asList(
            LINE_MENU_LABEL,
            LINE_MENU_ADD,
            LINE_MENU_DELETE,
            LINE_MENU_VIEW,
            NON_MAIN_MENU_QUIT
    );

    public static final List<String> sectionMenuOptions = Arrays.asList(
            SECTION_MENU_LABEL,
            SECTION_MENU_ADD,
            SECTION_MENU_DELETE,
            NON_MAIN_MENU_QUIT
    );
}
