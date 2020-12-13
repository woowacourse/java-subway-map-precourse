package subway.line.view;

import subway.line.Line;
import subway.line.LineRepository;
import subway.station.Station;

import java.util.List;

public class LineOutputView {
    private static final String LINE_MANAGEMENT_TITLE = "## 노선 관리 화면";
    private static final String ADD_LINE = "1. 노선 등록";
    private static final String DELETE_LINE = "2. 노선 삭제";
    private static final String PRINT_LINE = "3. 노선 조회";
    private static final String GO_BACK = "B. 돌아가기";
    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String COMPLETE_ADD_LINE = RESULT_PREFIX + "지하철 노선이 등록되었습니다.";
    private static final String COMPLETE_DELETE_LINE = RESULT_PREFIX + "지하철 노선이 삭제되었습니다.";
    private static final String LINE_LIST_TITLE = "## 노선 목록";
    private static final String SECTION_MANAGEMENT_TITLE = "## 구간 관리 화면";
    private static final String ADD_SECTION = "1. 구간 등록";
    private static final String DELETE_SECTION = "2. 구간 삭제";
    private static final String COMPLETE_ADD_SECTION = RESULT_PREFIX + "구간이 등록되었습니다.";

    public static void printLineManagement() {
        System.out.println(LINE_MANAGEMENT_TITLE);
        System.out.println(ADD_LINE);
        System.out.println(DELETE_LINE);
        System.out.println(PRINT_LINE);
        System.out.println(GO_BACK);
        System.out.println();
    }

    public static void addLineComplete() {
        System.out.println(COMPLETE_ADD_LINE);
        System.out.println();
    }

    public static void printAllLine() {
        List<Line> lines = LineRepository.lines();

        System.out.println(LINE_LIST_TITLE);
        for (Line line : lines) {
            System.out.println(RESULT_PREFIX + line.getName());
        }
        System.out.println();
    }

    public static void deleteStationComplete() {
        System.out.println(COMPLETE_DELETE_LINE);
        System.out.println();
    }

    public static void printSectionManagement() {
        System.out.println(SECTION_MANAGEMENT_TITLE);
        System.out.println(ADD_SECTION);
        System.out.println(DELETE_SECTION);
        System.out.println(GO_BACK);
        System.out.println();
    }

    public static void addSectionComplete() {
        System.out.println(COMPLETE_ADD_SECTION);
        System.out.println();
    }
}
