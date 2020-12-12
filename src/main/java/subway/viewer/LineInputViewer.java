package subway.viewer;

public class LineInputViewer {
    private static final String ASK_ENROLL_LINE = "## 등록할 노선 이름을 입력하세요.";
    private static final String ASK_DEPARTURE_STATION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String ASK_TERMINAL_STATION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String DELETE_ENROLL_LINE = "## 삭제할 노선 이름을 입력하세요.";

    /* 처음 가능한 기능 리스트를 보여주는 메소드 */
    public static void askMainScreen() {
        for (LineInputInitiator oneMessage : LineInputInitiator.values()) {
            System.out.println(oneMessage.getMessage());
        }
    }

    public static void askEnrollLine() {
        System.out.println(ASK_ENROLL_LINE);
    }

    public static void askDeleteLine() {
        System.out.println(DELETE_ENROLL_LINE);
    }

    public static void askDepartureStation() {
        System.out.println(ASK_DEPARTURE_STATION);
    }

    public static void setAskTerminalStation() {
        System.out.println(ASK_TERMINAL_STATION);
    }
}
