package subway.view;

public class SectionView {
    private static final String LINE_ADD_REQ_MSG = "## 노선을 입력하세요.";
    private static final String STATION_ADD_REQ_MSG = "## 역이름을 입력하세요.";
    private static final String LOCATION_REQ_MSG = "## 순서를 입력하세요.";
    private static final String ADD_SUCCESS_MSG = "[INFO] 구간이 등록되었습니다.";

    private static final String LINE_DEL_REQ_MSG = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String STATION_DEL_REQ_MSG = "## 삭제할 구간의 역을 입력하세요.";
    private static final String DEL_SUCCESS_MSG = "[INFO] 구간이 삭제되었습니다.";


    public static void printLineAddReqMsg() {
        System.out.println();
        System.out.println(LINE_ADD_REQ_MSG);
    }

    public static void printStationAddReqMsg() {
        System.out.println();
        System.out.println(STATION_ADD_REQ_MSG);
    }

    public static void printLocationAddReqMsg() {
        System.out.println();
        System.out.println(LOCATION_REQ_MSG);
    }

    public static void printAddSuccessMsg() {
        System.out.println();
        System.out.println(ADD_SUCCESS_MSG);
    }

    public static void printLineDelReqMsg() {
        System.out.println();
        System.out.println(LINE_DEL_REQ_MSG);
    }

    public static void printStationDelReqMsg() {
        System.out.println();
        System.out.println(STATION_DEL_REQ_MSG);
    }

    public static void printDelSuccessMsg() {
        System.out.println();
        System.out.println(DEL_SUCCESS_MSG);
    }
}
