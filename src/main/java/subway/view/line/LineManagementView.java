package subway.view.line;

import subway.line.Line;

import java.util.List;

public class LineManagementView {
    private static final String LINE_MANAGEMENT_TITLE = "## 노선 관리 화면";
    private static final String ADD_LINE = "1. 노선 등록";
    private static final String DELETE_LINE = "2. 노선 삭제";
    private static final String PRINT_LINE = "3. 노선 조회";
    private static final String GO_BACK = "B. 돌아가기";

    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String COMPLETE_ADD_LINE = RESULT_PREFIX + "지하철 노선이 등록되었습니다.";
    private static final String COMPLETE_DELETE_LINE = RESULT_PREFIX + "지하철 노선이 삭제되었습니다.";

    private static final String ENTER_NEW_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    private static final String ENTER_START_STATION_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String ENTER_END_STATION_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String ENTER_DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";

    private static final String LINE_LIST_TITLE = "## 노선 목록";

    public static void showLineManagementMenu() {
        System.out.println(LINE_MANAGEMENT_TITLE);
        System.out.println(ADD_LINE);
        System.out.println(DELETE_LINE);
        System.out.println(PRINT_LINE);
        System.out.println(GO_BACK);
        System.out.println();
    }

    public static void askNewLineName() {
        System.out.println(ENTER_NEW_LINE_NAME);
    }

    public static void addLineComplete() {
        System.out.println(COMPLETE_ADD_LINE);
        System.out.println();
    }

    public static void deleteLineComplete() {
        System.out.println(COMPLETE_DELETE_LINE);
        System.out.println();
    }

    public static void askStartStationName() {
        System.out.println(ENTER_START_STATION_NAME);
    }

    public static void askEndStationName() {
        System.out.println(ENTER_END_STATION_NAME);
    }

    public static void askDeleteLineName() {
        System.out.println(ENTER_DELETE_LINE_NAME);
    }

    public static void showAllLine(List<Line> lines) {
        System.out.println(LINE_LIST_TITLE);
        for (Line line : lines) {
            System.out.println(RESULT_PREFIX + line.getName());
        }
        System.out.println();
    }
}
