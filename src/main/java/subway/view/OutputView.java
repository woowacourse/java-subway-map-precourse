package subway.view;

import java.util.List;
import subway.controller.Function;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;

public class OutputView {

    private static final String MAIN_MENU_LABEL = "## 메인 화면";
    private static final String MAIN_MENU_STATION_CARE = "1. 역 관리";
    private static final String MAIN_MENU_LINE_CARE = "2. 노선 관리";
    private static final String MAIN_MENU_SECTION_CARE = "3. 구간 관리";
    private static final String MAIN_MENU_SHOW_MAP = "4. 지하철 노선도 출력";
    private static final String MAIN_MENU_QUIT = "Q. 종료";

    private static final String STATION_MENU_LABEL = "## 역 관리 화면";
    private static final String STATION_MENU_ADD = "1. 역 등록";
    private static final String STATION_MENU_DELETE = "2. 역 삭제";
    private static final String STATION_MENU_VIEW = "3. 역 조회";
    private static final String STATION_VIEW_LABEL = "## 역 목록";

    private static final String LINE_MENU_LABEL = "## 노선 관리 화면";
    private static final String LINE_MENU_ADD = "1. 노선 등록";
    private static final String LINE_MENU_DELETE = "2. 노선 삭제";
    private static final String LINE_MENU_VIEW = "3. 노선 조회";
    private static final String LINE_VIEW_LABEL = "## 노선 목록";

    private static final String SECTION_MENU_LABEL = "## 구간 관리 화면";
    private static final String SECTION_MENU_ADD = "1. 구간 등록";
    private static final String SECTION_MENU_DELETE = "2. 구간 삭제";

    private static final String SHOW_MAP_LABEL = "## 지하철 노선도";

    private static final String NON_MAIN_MENU_QUIT = "B. 돌아가기";

    public static final String INFO_LABEL = "[INFO] ";
    public static final String ERROR_LABEL = "[ERROR] ";
    public static final String DIVIDER = "---";

    public static final String INFO_STATION_ADD = INFO_LABEL + "지하철 역이 등록되었습니다.";
    public static final String INFO_STATION_DELETE = INFO_LABEL + "지하철 역이 삭제되었습니다.";
    public static final String INFO_LINE_ADD = INFO_LABEL + "지하철 노선이 등록되었습니다.";
    public static final String INFO_LINE_DELETE = INFO_LABEL + "지하철 노선이 삭제되었습니다.";
    public static final String INFO_SECTION_ADD = INFO_LABEL + "구간이 등록되었습니다.";
    public static final String INFO_SECTION_DELETE = INFO_LABEL + "구간이 삭제되었습니다.";

    public static final String ERROR_NOT_NUMERIC = ERROR_LABEL + "선택할 수 없는 기능입니다.";
    public static final String ERROR_OUT_OF_RANGE = ERROR_LABEL + "선택할 수 없는 기능입니다.";
    public static final String ERROR_NAME_SHORT = ERROR_LABEL + "이름의 길이가 너무 짧습니다";
    public static final String ERROR_DUPLICATE_NAME = ERROR_LABEL + "중복되는 이름이 있습니다.";
    public static final String ERROR_NOTHING = ERROR_LABEL + "해당 이름의 역/노선은 존재하지 않습니다.";
    public static final String ERROR_CONNECTED = ERROR_LABEL + "해당 역은 노선에 연결되어 지울 수 없습니다.";
    public static final String ERROR_SIZE_SMALL = ERROR_LABEL + "해당 노선은 종착역들로만 이루어져 있습니다.";
    public static final String ERROR_DUPLICATE_STATION = ERROR_LABEL + "역이 이미 노선에 등록되어 있습니다.";
    public static final String ERROR_NO_NAME = ERROR_LABEL + "해당 이름의 역/노선이 없습니다.";
    public static final String ERROR_INDEX = ERROR_LABEL + "유효하지 않은 순서입니다.";
    public static final String ERROR_NO_STATION = ERROR_LABEL + "해당 역은 노선에 존재하지 않습니다.";

    public static void printMenu(int currentMenu) {
        if (currentMenu == Function.MAIN_MENU) {
            printMainMenu();
        }
        if (currentMenu == Function.STATION_MENU) {
            printStationMenu();
        }
        if (currentMenu == Function.LINE_MENU) {
            printLineMenu();
        }
        if (currentMenu == Function.SECTION_MENU) {
            printSectionMenu();
        }
    }

    private static void printMainMenu() {
        System.out.println(MAIN_MENU_LABEL);
        System.out.println(MAIN_MENU_STATION_CARE);
        System.out.println(MAIN_MENU_LINE_CARE);
        System.out.println(MAIN_MENU_SECTION_CARE);
        System.out.println(MAIN_MENU_SHOW_MAP);
        System.out.println(MAIN_MENU_QUIT);

    }

    private static void printStationMenu() {
        System.out.println(STATION_MENU_LABEL);
        System.out.println(STATION_MENU_ADD);
        System.out.println(STATION_MENU_DELETE);
        System.out.println(STATION_MENU_VIEW);
        System.out.println(NON_MAIN_MENU_QUIT);
    }

    private static void printLineMenu() {
        System.out.println(LINE_MENU_LABEL);
        System.out.println(LINE_MENU_ADD);
        System.out.println(LINE_MENU_DELETE);
        System.out.println(LINE_MENU_VIEW);
        System.out.println(NON_MAIN_MENU_QUIT);
    }

    private static void printSectionMenu() {
        System.out.println(SECTION_MENU_LABEL);
        System.out.println(SECTION_MENU_ADD);
        System.out.println(SECTION_MENU_DELETE);
        System.out.println(NON_MAIN_MENU_QUIT);
    }

    public static void printStations(List<Station> stations) {
        System.out.println();
        System.out.println(STATION_VIEW_LABEL);
        stations.stream()
                .map(Station::getName)
                .map(x -> INFO_LABEL + x)
                .forEach(System.out::println);
    }

    public static void printLines(List<Line> lines) {
        System.out.println();
        System.out.println(LINE_VIEW_LABEL);
        System.out.println(INFO_LABEL + DIVIDER);
        lines.stream()
                .map(Line::getName)
                .map(x -> INFO_LABEL + x)
                .forEach(System.out::println);
    }

    public static void printMap() {
        System.out.println();
        System.out.println(SHOW_MAP_LABEL);
        LineRepository.lines().forEach(x -> {
            System.out.println(INFO_LABEL + x.getName());
            System.out.println(INFO_LABEL + DIVIDER);
            printStationsOfLine(x);
            System.out.println();
        });
    }

    private static void printStationsOfLine(Line line) {
        line.getStations().forEach( x -> System.out.println(INFO_LABEL + x.getName()));
    }

    public static void printError(Exception e) {
        System.out.println();
        System.out.println(e.getMessage());
    }

    public static void printInfo(String info) {
        System.out.println();
        System.out.println(info);
    }

}
