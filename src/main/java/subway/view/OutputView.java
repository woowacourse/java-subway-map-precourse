package subway.view;

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

    private static final String DIVIDER = "--";

    public static void printMap() {
        print(TRAVERSE_MAP);
    }

    public static void printMainView() {
        print(MAIN_VIEW);
    }

    public static void printStationView() {
        print(STATION_VIEW);
    }

    public static void printLineView() {
        print(LINE_VIEW);
    }

    public static void printStationLineView() {
        print(STATION_LINE_VIEW);
    }

    public static void printStationList() {
        print(STATION_LIST);
    }

    public static void printAddStationSuccess() {
        printInfo(ADD_STATION_SUCCESS);
    }

    public static void printDeleteStationSuccess() {
        printInfo(DELETE_STATION_SUCCESS);
    }

    public static void printAddLineSuccess() {
        printInfo(ADD_LINE_SUCCESS);
    }

    public static void printDeleteLineSuccess() {
        printInfo(DELETE_LINE_SUCCESS);
    }

    public static void printAddStationToLineSuccess() {
        printInfo(ADD_STATION_TO_LINE_SUCCESS);
    }

    public static void printDeleteStationFromLineSuccess() {
        printInfo(DELETE_STATION_FROM_LINE_SUCCESS);
    }

    public static void printLineList() {
        print(LINE_LIST);
    }

    public static void printError(String error) {
        System.out.println(error);
    }

    private static void print(String message) {
        System.out.print(message);
    }

    public static void printInfo(String message) {
        System.out.println(INFO + message);
    }

    public static void println() {
        System.out.println();
    }
}

