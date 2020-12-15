package subway.view;

import java.util.List;
import java.util.Map;
import subway.domain.Line;
import subway.domain.Station;

public class OutputView {
    public static final String PREFIX_INFO = "[INFO] ";
    public static final String STATION_LIST = "## 역 목록";
    public static final String LINE_LIST = "## 노선 목록";
    public static final String ROUTE_MAP = "## 지하철 노선도";
    public static final String DIVISION_LINE = "---";

    public static final String ORDER_TO_REGISTER_STATION = "## 등록할 역 이름을 입력하세요.";
    public static final String ORDER_TO_DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";
    public static final String ORDER_TO_REGISTER_LINE = "## 등록할 노선 이름을 입력하세요.";
    public static final String ORDER_TO_DELETE_LINE = "## 삭제할 노선 이름을 입력하세요.";
    public static final String ORDER_TO_REGISTER_UP_TRAIN_LAST_STATION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String ORDER_TO_REGISTER_DOWN_TRAIN_LAST_STATION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String ORDER_TO_ENTER_LINE = "## 노선을 입력하세요.";
    public static final String ORDER_TO_ENTER_STATION = "## 역이름을 입력하세요.";
    public static final String ORDER_TO_ENTER_SEQUENCE = "## 순서를 입력하세요.";
    public static final String ORDER_TO_ENTER_LINE_TO_DELETE = "## 삭제할 구간의 노선을 입력하세요.";
    public static final String ORDER_TO_ENTER_STATION_TO_DELETE = "## 삭제할 구간의 역을 입력하세요.";

    public static final String SUCCESS_TO_REGISTER_STATION_MESSAGE = "[INFO] 지하철 역이 등록되었습니다.\n";
    public static final String SUCCESS_TO_DELETE_STATION_MESSAGE = "[INFO] 지하철 역이 삭제되었습니다.\n";
    public static final String SUCCESS_TO_REGISTER_LINE_MESSAGE = "[INFO] 지하철 노선이 등록되었습니다.\n";
    public static final String SUCCESS_TO_DELETE_LINE_MESSAGE = "[INFO] 지하철 노선이 삭제되었습니다.\n";
    public static final String SUCCESS_TO_REGISTER_SECTION_MESSAGE = "[INFO] 구간이 등록되었습니다.\n";
    public static final String SUCCESS_TO_DELETE_SECTION_MESSAGE = "[INFO] 구간이 삭제되었습니다.\n";

    public static final String MAIN_SCREEN = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n"
        + "3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n\n## 원하는 기능을 선택하세요.";
    public static final String STATION_MANAGEMENT_SCREEN = "## 역 관리 화면\n1. 역 등록\n"
        + "2. 역 삭제\n3. 역 조회\nB. 돌아가기\n\n## 원하는 기능을 선택하세요.";
    public static final String LINE_MANAGEMENT_SCREEN = "## 노선 관리 화면\n1. 노선 등록\n"
        + "2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n\n## 원하는 기능을 선택하세요.";
    public static final String SECTION_MANAGEMENT_SCREEN = "## 구간 관리 화면\n1. 구간 등록\n"
        + "2. 구간 삭제\nB. 돌아가기\n\n## 원하는 기능을 선택하세요.";

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printList(List<?> list) {
        for (Object object : list) {
            System.out.println(PREFIX_INFO + object);
        }
        System.out.println();
    }

    public static void printMap(Map<Line, List<Station>> lines) {
        System.out.println(ROUTE_MAP);
        for (Line line : lines.keySet()) {
            System.out.println(PREFIX_INFO + line);
            System.out.println(PREFIX_INFO + DIVISION_LINE);
            printList(lines.get(line));
        }
    }
}
