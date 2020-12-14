package subway.view;

public class StationView {
    private static final String ADD_SUCCESS_MSG = "[INFO] 지하철 역이 등록되었습니다.";
    private static final String ADD_REQ_MSG = "## 등록할 역 이름을 입력하세요.";

    public static void printStationAddReqMsg(){
        System.out.println();
        System.out.println(ADD_REQ_MSG);
    }

    public static void printStationAddSuccessMsg(){
        System.out.println();
        System.out.println(ADD_SUCCESS_MSG);
    }
}
