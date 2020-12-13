package subway.viewer;

public class IntervalOutputViewer {
    private static final String COMPLETE_DELETE_MESSAGE = "[INFO] 구간이 삭제되었습니다.";
    private static final String COMPLETE_ENROLL_MESSAGE = "[INFO] 구간이 등록되었습니다.";

    public static void showDeleteInterval() {
        System.out.println(COMPLETE_DELETE_MESSAGE);
    }

    public static void showEnrollInterval() {
        System.out.println(COMPLETE_ENROLL_MESSAGE);
    }
}
