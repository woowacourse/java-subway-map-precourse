package subway.viewer;

import subway.viewer.constants.StationInputInitiator;

public class StationInputViewer {
    private static final String ASK_ENROLL_STATION = "## 등록할 역 이름을 입력하세요.";
    private static final String DELETE_ENROLL_STATION = "## 삭제할 역 이름을 입력하세요.";

    /* 처음 가능한 기능 리스트를 보여주는 메소드 */
    public static void askMainScreen() {
        for (StationInputInitiator oneMessage : StationInputInitiator.values()) {
            System.out.println(oneMessage.getMessage());
        }
    }

    public static void askEnrollStation() {
        System.out.println(ASK_ENROLL_STATION);
    }

    public static void askDeleteStation() {
        System.out.println(DELETE_ENROLL_STATION);
    }
}
