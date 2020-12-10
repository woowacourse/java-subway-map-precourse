package subway.service.output;

public interface OutputService {
    String MAIN = "## 메인 화면";
    String MAIN_ONE = "1. 역 관리";
    String MAIN_TWO = "2. 노선 관리";
    String MAIN_THREE = "3. 구간 관리";
    String MAIN_FOUR = "4. 지하철 노선도 출력";
    String MAIN_QUIT = "Q. 종료";
    String CHOOSE_FUNCTION = "## 원하는 기능을 선택하세요.";
    String ENTER = "\n";
    String BACK = "B. 돌아가기";
    String STATION_MAIN = "## 역 관리 화면";
    String STATION_ONE = "1. 역 등록";
    String STATION_TWO = "2. 역 삭제";
    String STATION_THREE = "3. 역 조회";
    String ROUTE_MAIN = "## 노선 관리 화면";
    String ROUTE_ONE = "1. 노선 등록";
    String ROUTE_TWO = "2. 노선 삭제";
    String ROUTE_THREE = "3. 노선 조회";


    void printMain();
    void printStationManage();
    void printRouteManage();
}
