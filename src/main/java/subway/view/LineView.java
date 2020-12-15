package subway.view;

import subway.domain.Line;
import subway.domain.repositories.LineRepository;

import java.util.List;

public class LineView {
    private static final String ADD_REQ_MSG = "## 등록할 노선 이름을 입력하세요.";
    private static final String ADD_SUCCESS_MSG = "[INFO] 지하철 노선이 등록되었습니다.";

    private static final String ADD_FRONT_REQ_MSG = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String ADD_BACK_REQ_MSG = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    private static final String LINE_CHECK_HEADER = "## 역 목록";

    private static final String DELETE_REQ_MSG = "## 삭제할 노선 이름을 입력하세요.";
    private static final String DELETE_SUCCESS_MSG = "[INFO] 지하철 노선이 삭제되었습니다.";


    public static void printLineAddReqMsg() {
        System.out.println();
        System.out.println(ADD_REQ_MSG);
    }

    public static void printLineAddFrontReqMsg() {
        System.out.println();
        System.out.println(ADD_FRONT_REQ_MSG);
    }

    public static void printLineAddBackReqMsg() {
        System.out.println();
        System.out.println(ADD_BACK_REQ_MSG);
    }

    public static void printLineAddSuccessMsg() {
        System.out.println();
        System.out.println(ADD_SUCCESS_MSG);
    }

    public static void printLineCheck() {
        System.out.println();
        System.out.println(LINE_CHECK_HEADER);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
        }
    }

    public static void printLineDeleteReqMsg() {
        System.out.println();
        System.out.println(DELETE_REQ_MSG);
    }

    public static void printLineDeleteSuccessMsg() {
        System.out.println();
        System.out.println(DELETE_SUCCESS_MSG);
    }
}
