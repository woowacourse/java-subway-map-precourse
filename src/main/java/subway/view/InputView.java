package subway.view;

import java.util.Scanner;

public class InputView {

    private static final String SELECTION_VIEW = "## 원하는 기능을 선택하세요.\n";

    private static final String ADD_STATION = "## 등록할 역 이름을 입력하세요.\n";

    private static final String DELETE_STATION = "## 삭제할 역 이름을 입력하세요.\n";

    private static final String ADD_LINE = "## 등록할 노선 이름을 입력하세요.\n";

    private static final String ADD_LINE_UPWARD_STATION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.\n";

    private static final String ADD_LINE_DOWNWARD_STATION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.\n";

    private static final String DELETE_LINE = "## 삭제할 노선 이름을 입력하세요.\n";

    private static final String ADD_STATION_TO_LINE = "## 노선을 입력하세요.\n";

    private static final String ADD_STATION_ORDER = "## 순서를 입력하세요.\n";

    private static final String DELETE_STATION_FROM_LINE = "## 삭제할 구간의 노선을 입력하세요.\n";

    private static Scanner scanner = new Scanner(System.in);

    public static String getSelectionView() {
        print(SELECTION_VIEW);
        return getInput();
    }

    public static String getAddStation() {
        print(ADD_STATION);
        return getInput();
    }

    public static String getDeleteStation() {
        print(DELETE_STATION);
        return getInput();
    }

    public static String getAddLine() {
        print(ADD_LINE);
        return getInput();
    }

    public static String getAddLineUpwardStation() {
        print(ADD_LINE_UPWARD_STATION);
        return getInput();
    }

    public static String getAddLineDownwardStation() {
        print(ADD_LINE_DOWNWARD_STATION);
        return getInput();
    }

    public static String getDeleteLine() {
        print(DELETE_LINE);
        return getInput();
    }

    public static String getAddStationToLine() {
        print(ADD_STATION_TO_LINE);
        return getInput();
    }

    public static String getAddStationOrder() {
        print(ADD_STATION_ORDER);
        return getInput();
    }

    public static String getDeleteStationFromLine() {
        print(DELETE_STATION_FROM_LINE);
        return getInput();
    }

    private static String getInput() {
        return scanner.nextLine();
    }

    private static void print(String message) {
        System.out.print(message);
    }
}
