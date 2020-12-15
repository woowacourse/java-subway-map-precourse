package subway.view;

import java.util.List;

import subway.domain.Line;
import subway.domain.Station;

public class OutputView {

    private static final String MAIN_VIEW = "## 메인 화면\n"
        + "1. 역 관리\n"
        + "2. 노선 관리\n"
        + "3. 구간 관리\n"
        + "4. 지하철 노선도 출력\n"
        + "Q. 종료\n";

    private static final String STATION_VIEW = "## 역 관리 화면\n"
        + "1. 역 등록\n"
        + "2. 역 삭제\n"
        + "3. 역 조회\n"
        + "B. 돌아가기\n";

    private static final String LINE_VIEW = "## 노선 관리 화면\n"
        + "1. 노선 등록\n"
        + "2. 노선 삭제\n"
        + "3. 노선 조회\n"
        + "B. 돌아가기\n";

    private static final String STATION_LINE_VIEW = "## 구간 관리 화면\n"
        + "1. 구간 등록\n"
        + "2. 구간 삭제\n"
        + "B. 돌아가기\n";

    private static final String INFO = "[INFO] ";

    private static final String ADD_STATION_SUCCESS = "지하철 역이 등록되었습니다.\n";

    private static final String STATION_LIST = "## 역 목록\n";

    private static final String LINE_LIST = "## 노선 목록\n";

    private static final String DELETE_STATION_SUCCESS = "지하철 역이 삭제되었습니다.\n";

    private static final String ADD_LINE_SUCCESS = "지하철 노선이 등록되었습니다.\n";

    private static final String DELETE_LINE_SUCCESS = "지하철 노선이 삭제되었습니다.\n";

    private static final String ADD_STATION_TO_LINE_SUCCESS = "구간이 등록되었습니다.\n";

    private static final String DELETE_STATION_FROM_LINE_SUCCESS = "구간이 삭제되었습니다.\n";

    private static final String TRAVERSE_MAP = "## 지하철 노선도\n";

    private static final String DIVIDER = "---";

    public static void printMainView() {
        printView(MAIN_VIEW);
    }

    public static void printStationView() {
        printView(STATION_VIEW);
    }

    public static void printAddStationSuccess() {
        printSuccessOrFailureInfo(ADD_STATION_SUCCESS);
    }

    private static void printSuccessOrFailureInfo(String successOrFailure) {
        println();
        printInfo(successOrFailure);
    }

    public static void printStationList(List<Station> stations) {
        println();
        print(STATION_LIST);
        stations.forEach(station -> {
            printInfo(station.getName());
            println();
        });
    }

    public static void printDeleteStationSuccess() {
        printSuccessOrFailureInfo(DELETE_STATION_SUCCESS);
    }

    public static void printLineView() {
        printView(LINE_VIEW);
    }

    public static void printAddLineSuccess() {
        printSuccessOrFailureInfo(ADD_LINE_SUCCESS);
    }

    public static void printLineList(List<Line> lines) {
        println();
        print(LINE_LIST);
        lines.forEach(line -> {
            printInfo(line.getName());
            println();
        });
    }

    public static void printDeleteLineSuccess() {
        printSuccessOrFailureInfo(DELETE_STATION_SUCCESS);
    }

    public static void printStationLineView() {
        printView(STATION_LINE_VIEW);
    }

    public static void printAddStationToLineSuccess() {
        printSuccessOrFailureInfo(ADD_STATION_TO_LINE_SUCCESS);
    }

    public static void printDeleteStationFromLineSuccess() {
        printSuccessOrFailureInfo(DELETE_STATION_FROM_LINE_SUCCESS);
    }

    public static void printMap(List<Line> map) {
        println();
        print(TRAVERSE_MAP);
        map.forEach(line -> {
            printInfo(line.getName());
            println();
            printInfo(DIVIDER);
            println();
            line.getStations().forEach(station -> {
                printInfo(station.getName());
                println();
            });
        });
    }

    public static void printError(String error) {
        println();
        print(error);
    }

    private static void printView(String view) {
        println();
        print(view);
        println();
    }

    public static void printInfo(String output) {
        print(INFO + output);
    }

    private static void println(String output) {
        System.out.println(output);
    }

    private static void println() {
        System.out.println();
    }

    private static void print(String output) {
        System.out.print(output);
    }
}