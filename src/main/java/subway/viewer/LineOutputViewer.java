package subway.viewer;

import subway.domain.Line;

import java.util.List;

public class LineOutputViewer {
    private static final String COMPLETE_DELETE_MESSAGE = "[INFO] 지하철 노선이 삭제 되었습니다.";
    private static final String COMPLETE_ENROLL_MESSAGE = "[INFO] 지하철 노선이 등록되었습니다.";
    private static final String LINE_LIST = "노선 목록";
    private static final String SHOW_LINE_UNIT = "[INFO] %s\n";

    public static void showDeleteLine() {
        System.out.println();
        System.out.println(COMPLETE_DELETE_MESSAGE);
    }

    public static void showEnrollLine() {
        System.out.println();
        System.out.println(COMPLETE_ENROLL_MESSAGE);
    }

    public static void showLineList(List<Line> lines) {
        System.out.println();
        System.out.printf(SHOW_LINE_UNIT, LINE_LIST);
        for (Line line : lines) {
            System.out.printf(SHOW_LINE_UNIT, line.getName());
        }
    }
}
