package subway.service.output;

import subway.view.Screen;

public interface OutputService {
    String MAIN = Screen.PREFIX_SHARP + "메인 화면";
    String MAIN_ONE = "1. 역 관리";
    String MAIN_TWO = "2. 노선 관리";
    String MAIN_THREE = "3. 구간 관리";
    String MAIN_FOUR = "4. 지하철 노선도 출력";
    String MAIN_QUIT = "Q. 종료";
    String CHOOSE_FUNCTION = Screen.PREFIX_SHARP + "원하는 기능을 선택하세요.";
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
    String SECTION_MAIN = Screen.PREFIX_SHARP + "구간 관리 화면";
    String SECTION_ONE = "1. 구간 등록";
    String SECTION_TWO = "2. 구간 삭제";
    String MANAGE_STATION_ADD = Screen.PREFIX_SHARP + "등록할 역 이름을 입력하세요";

    void printInfo(String string);

    void printSharp(String string);

    void printMain();

    void printManageStation();

    void printManageRoute();

    void printManageSection();

    void printManageStationAdd();
}
