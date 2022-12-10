package view;

import java.util.List;

public class OutputView {
    private static final String MAIN_MENU_TITLE ="## 메인 화면";
    private static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요.";
    private static final String STATION_MENU_TITLE = "## 역 관리 화면";
    private static final String ASK_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    private static final String FINISHED_ADDING_STATION = "[INFO] 지하철 역이 등록되었습니다.";
    private static final String LOOKUP_STATION_TITLE = "## 역 목록";
    private static final String INFO = "[INFO] ";
    private static final String LINE_MENU_TITLE = "## 노선 관리 화면";
    private static final String FINISHED_ADDING_LINE = "[INFO] 지하철 노선이 등록되었습니다.";
    private static final String LOOKUP_LINE_TITLE = "## 노선 목록";
    private static final String ASK_DELETE_LINE_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    private static final String FINISHED_DELETING_LINE = "[INFO] 지하철 노선이 삭제되었습니다.";
    private static final String ASK_DELETE_STATION_MESSAGE = "## 삭제할 역 이름을 입력하세요.";

    public static void printMainMenu(String value) {
        print(MAIN_MENU_TITLE);
        print(value);
    }

    public static void printSelectFunction() {
        print(SELECT_FUNCTION);
    }


    public static void print(String value) {
        System.out.println(value);
    }

    public static void printStationMenu(String value) {
        print(STATION_MENU_TITLE);
        print(value);
    }

    public static void printAskAddStation() {
        print(ASK_STATION_NAME);
    }

    public static void printFinishedAddingStation() {
        print(FINISHED_ADDING_STATION);
    }

    public static void printLookupStations(List<String> values) {
        print(LOOKUP_STATION_TITLE);
        values.stream()
                .map(value -> INFO + value)
                .forEach(OutputView::print);
    }

    public static void printLineMenu(String menu) {
        print(LINE_MENU_TITLE);
        print(menu);
    }

    public static void printFinishedAddingLine() {
        print(FINISHED_ADDING_LINE);
    }

    public static void printLookupLines(List<String> values) {
        print(LOOKUP_LINE_TITLE);
        values.stream()
                .map(value -> INFO + value)
                .forEach(OutputView::print);
    }

    public static void printAskDeleteLineMessage() {
        print(ASK_DELETE_LINE_MESSAGE);
    }

    public static void finishedDeletingLine() {
        print(FINISHED_DELETING_LINE);
    }

    public static void printAskDeleteStation() {
        print(ASK_DELETE_STATION_MESSAGE);
    }
}
