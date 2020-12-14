package subway.view;

import java.util.Arrays;
import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;

public class OutputView {

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
    public static final String DIVIDER = "---";

    public static final String INFO_STATION_ADDED = INFO_LABEL + "지하철 역이 등록되었습니다.";
    public static final String INFO_STATION_DELETED = INFO_LABEL + "지하철 역이 삭제되었습니다.";
    public static final String INFO_LINE_ADDED = INFO_LABEL + "지하철 노선이 등록되었습니다.";
    public static final String INFO_LINE_DELETED = INFO_LABEL + "지하철 노선이 삭제되었습니다.";
    public static final String INFO_SECTION_ADDED = INFO_LABEL + "구간이 등록되었습니다.";
    public static final String INFO_SECTION_DELETED = INFO_LABEL + "구간이 삭제되었습니다.";

    private static final List<String> mainMenuOptions = Arrays.asList(
            MAIN_MENU_LABEL,
            MAIN_MENU_STATION,
            MAIN_MENU_LINE,
            MAIN_MENU_SECTION,
            MAIN_MENU_SHOW_MAP,
            MAIN_MENU_QUIT
    );

    private static final List<String> stationMenuOptions = Arrays.asList(
            STATION_MENU_LABEL,
            STATION_MENU_ADD,
            STATION_MENU_DELETE,
            STATION_MENU_VIEW,
            NON_MAIN_MENU_QUIT
    );

    private static final List<String> lineMenuOptions = Arrays.asList(
            LINE_MENU_LABEL,
            LINE_MENU_ADD,
            LINE_MENU_DELETE,
            LINE_MENU_VIEW,
            NON_MAIN_MENU_QUIT
    );

    private static final List<String> sectionMenuOptions = Arrays.asList(
            SECTION_MENU_LABEL,
            SECTION_MENU_ADD,
            SECTION_MENU_DELETE,
            NON_MAIN_MENU_QUIT
    );

    public static void printMainMenu() {
        printMenu(mainMenuOptions);
    }

    public static void printStationMenu() {
        printMenu(stationMenuOptions);
    }

    public static void printLineMenu() {
        printMenu(lineMenuOptions);
    }

    public static void printSectionMenu() {
        printMenu(sectionMenuOptions);
    }

    private static void printMenu(List<String> menuOptions) {
        System.out.println();
        menuOptions.forEach(System.out::println);
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
                .map(line -> INFO_LABEL + line)
                .forEach(System.out::println);
    }

    public static void printMap() {
        System.out.println();
        System.out.println(SHOW_MAP_LABEL);
        LineRepository.lines().forEach(line -> {
            System.out.println(INFO_LABEL + line.getName());
            System.out.println(INFO_LABEL + DIVIDER);
            printStationsOfLine(line);
            System.out.println();
        });
    }

    private static void printStationsOfLine(Line line) {
        line.getStations().forEach(station -> System.out.println(INFO_LABEL + station.getName()));
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
