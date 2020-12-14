package subway.view;

public class SectionView {
    private static String LINE_REQ_MSG = "## 노선을 입력하세요.";
    private static String STATION_REQ_MSG = "## 역이름을 입력하세요.";

    public static void printLineReqMsg() {
        System.out.println();
        System.out.println(LINE_REQ_MSG);
    }

    public static void printStationReqMsg() {
        System.out.println();
        System.out.println(STATION_REQ_MSG);
    }
}
