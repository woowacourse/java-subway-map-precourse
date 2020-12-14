package subway.view;

import subway.domain.line.Line;
import subway.domain.screen.LineManagementScreen;
import subway.domain.screen.MainScreen;
import subway.domain.screen.SectionManagementScreen;
import subway.domain.screen.StationManagementScreen;

import java.util.List;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String INFO_PREFIX = "[INFO]";
    private static final String SPACE = " ";
    private static final String DIVIDER = "---";
    private static final String STATION_LIST_TITLE = "## 역 목록";
    private static final String LINE_LIST_TITLE = "## 노선 목록";
    private static final String SUBWAY_MAP_TITLE = "## 지하철 노선도";
    private static final String STATION_REGISTRATION_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    private static final String STATION_DELETION_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";
    private static final String LINE_REGISTRATION_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.";
    private static final String LINE_DELETION_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.";
    private static final String EMPTY_STATION_GUIDE_MESSAGE = "지하철 역이 존재하지 않습니다.";
    private static final String EMPTY_LINE_GUIDE_MESSAGE = "지하철 노선이 존재하지 않습니다.";
    private static final String SECTION_REGISTRATION_SUCCESS_MESSAGE = "구간이 등록되었습니다.";

    public static void showMainScreen() {
        String message = MainScreen.getInstance().toString();
        printGuide(message);
    }

    public static void showStationManagementScreen() {
        String message = StationManagementScreen.getInstance().toString();
        printGuide(message);
    }

    public static void showStationRegistrationSuccess() {
        printInfo(STATION_REGISTRATION_SUCCESS_MESSAGE);
        lineFeed();
    }

    public static void showStationDeletionSuccess() {
        printInfo(STATION_DELETION_SUCCESS_MESSAGE);
        lineFeed();
    }

    public static void showStationList(List<String> stationNames) {
        printGuide(STATION_LIST_TITLE);
        if (stationNames.isEmpty()) {
            printGuide(EMPTY_STATION_GUIDE_MESSAGE);
        }
        stationNames.stream()
                .forEach(OutputView::printInfo);
        lineFeed();
    }

    public static void showLineManagementScreen() {
        String message = LineManagementScreen.getInstance().toString();
        printGuide(message);
    }

    public static void showLineRegistrationSuccess() {
        printInfo(LINE_REGISTRATION_SUCCESS_MESSAGE);
        lineFeed();
    }

    public static void showLineDeletionSuccess() {
        printInfo(LINE_DELETION_SUCCESS_MESSAGE);
        lineFeed();
    }

    public static void showLineList(List<String> lineNames) {
        printGuide(LINE_LIST_TITLE);
        if (lineNames.isEmpty()) {
            printGuide(EMPTY_LINE_GUIDE_MESSAGE);
        }
        lineNames.stream()
                .forEach(OutputView::printInfo);
        lineFeed();
    }

    public static void showSectionManagementScreen() {
        String message = SectionManagementScreen.getInstance().toString();
        printGuide(message);
    }

    public static void showSubwayMap(List<Line> lines) {
        printGuide(SUBWAY_MAP_TITLE);
        lines.stream()
                .forEach(OutputView::printLineInSubwayMap);
    }

    public static void printLineInSubwayMap(Line line) {
        printInfo(line.getName());
        printInfo(DIVIDER);
        line.getSections()
                .stream()
                .forEach(station -> printInfo(station.getName()));
        lineFeed();
    }

    public static void showSectionRegistrationSuccess() {
        printInfo(SECTION_REGISTRATION_SUCCESS_MESSAGE);
        lineFeed();
    }

    public static void showErrorMessage(String message) {
        printError(message);
        lineFeed();
    }

    private static void printGuide(String message) {
        println(message);
    }

    private static void printError(String message) {
        println(ERROR_PREFIX + SPACE + message);
    }

    private static void printInfo(String message) {
        println(INFO_PREFIX + SPACE + message);
    }

    private static void print(String message) {
        System.out.print(message);
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void lineFeed() {
        System.out.println();
    }
}
