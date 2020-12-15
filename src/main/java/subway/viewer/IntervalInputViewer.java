package subway.viewer;

import subway.viewer.constants.IntervalInputInitiator;

public class IntervalInputViewer {
    private static final String ASK_ENROLL_LINE = "## 노선을 입력하세요.";
    private static final String ASK_ENROLL_STATION = "## 역이름을 입력하세요.";
    private static final String ASK_ENROLL_ORDER = "## 순서를 입력하세요.";
    private static final String DELETE_LINE = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String DELETE_STATION = "## 삭제할 구간의 역을 입력하세요.";

    /* 처음 가능한 기능 리스트를 보여주는 메소드 */
    public static void askMainScreen() {
        for (IntervalInputInitiator oneMessage : IntervalInputInitiator.values()) {
            System.out.println(oneMessage.getMessage());
        }
    }

    public static void askEnrollLine() {
        System.out.println();
        System.out.println(ASK_ENROLL_LINE);
    }

    public static void askEnrollStation() {
        System.out.println();
        System.out.println(ASK_ENROLL_STATION);
    }

    public static void askEnrollOrder() {
        System.out.println();
        System.out.println(ASK_ENROLL_ORDER);
    }

    public static void deleteLine() {
        System.out.println();
        System.out.println(DELETE_LINE);
    }

    public static void deleteStation() {
        System.out.println();
        System.out.println(DELETE_STATION);
    }
}
