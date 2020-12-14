package subway.common;

import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class MenuPrinter {
    private static final String MAIN_HEAD = "메인 화면";
    private static final String STATION_CONTROLLER = "1. 역 관리";
    private static final String LINE_CONTROLLER = "2. 노선 관리";
    private static final String SECTION_CONTROLLER = "3. 구간 관리";
    private static final String PRINT_SUBWAY = "4. 지하철 노선도 출력";
    private static final String EXIT = "Q. 종료";
    private static final String BACK = "B. 돌아가기";

    private static final String LINE_HEAD = "노선 관리 화면";
    private static final String ADD_LINE = "1. 노선 등록";
    private static final String DELETE_LINE = "2. 노선 삭제";
    private static final String PRINT_LINE = "3. 노선 조회";

    private static final String SECTION_HEAD = "구간 관리 화면";
    private static final String ADD_SECTION = "1. 구간 등록";
    private static final String DELETE_SECTION = "2. 구간 삭제";

    private static final String STATION_HEAD = "역 관리 화면";
    private static final String ADD_STATION = "1. 역 등록";
    private static final String DELETE_STATION = "2. 역 삭제";
    private static final String PRINT_STATION = "3. 역 조회";

    private static final List<String> MAIN_MENU_MESSAGES =
            Arrays.asList(MAIN_HEAD, STATION_CONTROLLER, LINE_CONTROLLER, SECTION_CONTROLLER, PRINT_SUBWAY, EXIT);
    private static final List<String> LINE_MENU_MESSAGES = Arrays.asList(LINE_HEAD, ADD_LINE, DELETE_LINE, PRINT_LINE, BACK);
    private static final List<String> SECTION_MENU_MESSAGES = Arrays.asList(SECTION_HEAD, ADD_SECTION, DELETE_SECTION, BACK);
    private static final List<String> STATION_MENU_MESSAGES =
            Arrays.asList(STATION_HEAD, ADD_STATION, DELETE_STATION, PRINT_STATION, BACK);

    public static void printMainControllerMenu() {
        OutputView.printMenuMessage(MAIN_MENU_MESSAGES);
    }

    public static void printLineControllerMenu() {
        OutputView.printMenuMessage(LINE_MENU_MESSAGES);
    }

    public static void printSectionControllerMenu() {
        OutputView.printMenuMessage(SECTION_MENU_MESSAGES);
    }

    public static void printStationControllerMenu() {
        OutputView.printMenuMessage(STATION_MENU_MESSAGES);
    }
}
