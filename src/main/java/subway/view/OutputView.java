package subway.view;

import java.util.List;
import subway.domain.Station;

@FunctionalInterface
public interface OutputView {
    String STATION_LIST = "## 역 목록";
    String ORDER_TO_REGISTER_STATION = "## 등록할 역 이름을 입력하세요.";
    String ORDER_TO_DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";
    String ORDER_TO_REGISTER_LINE = "## 등록할 노선 이름을 입력하세요.";
    String ORDER_TO_REGISTER_UP_TRAIN_LAST_STATION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    String ORDER_TO_REGISTER_DOWN_TRAIN_LAST_STATION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    String ORDER_TO_DELETE_LINE = "## 삭제할 노선 이름을 입력하세요.";
    String PREFIX_INFO = "[INFO] ";
    String SUCCESS_TO_REGISTER_STATION_MESSAGE = "[INFO] 지하철 역이 등록되었습니다.\n";
    String SUCCESS_TO_DELETE_STATION_MESSAGE = "[INFO] 지하철 역이 삭제되었습니다.\n";
    String SUCCESS_TO_REGISTER_LINE_MESSAGE = "[INFO] 지하철 노선이 등록되었습니다.\n";
    String SUCCESS_TO_DELETE_LINE_MESSAGE = "[INFO] 지하철 노선이 삭제되었습니다.\n";
    String MAIN_SCREEN = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n"
        + "3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n\n## 원하는 기능을 선택하세요.";
    String STATION_MANAGEMENT_SCREEN = "## 역 관리 화면\n1. 역 등록\n"
        + "2. 역 삭제\n3. 역 조회\nB. 돌아가기\n\n## 원하는 기능을 선택하세요.";
    String LINE_MANAGEMENT_SCREEN = "## 노선 관리 화면\n1. 노선 등록\n"
        + "2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n\n## 원하는 기능을 선택하세요.";

    void print(String message);

    static void printStationList(List<Station> stations) {
        stations.stream()
            .map(Station::getName)
            .forEach(station -> System.out.println(PREFIX_INFO + station));
        System.out.println();
    }
}
