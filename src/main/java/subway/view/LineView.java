package subway.view;

public class LineView {
    private static final String ADD_SUCCESS_MSG = "[INFO] 지하철 노선이 등록되었습니다.";
    private static final String ADD_REQ_MSG = "## 등록할 노선 이름을 입력하세요.";
    private static final String ADD_FRONT_REQ_MSG = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String ADD_BACK_REQ_MSG = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    public static void printLineAddReqMsg(){
        System.out.println();
        System.out.println(ADD_REQ_MSG);
    }

    public static void printLineAddFrontReqMsg(){
        System.out.println();
        System.out.println(ADD_FRONT_REQ_MSG);
    }
    public static void printLineAddBackReqMsg(){
        System.out.println();
        System.out.println(ADD_BACK_REQ_MSG);
    }

    public static void printLineAddSuccessMsg(){
        System.out.println();
        System.out.println(ADD_SUCCESS_MSG);
    }
}
