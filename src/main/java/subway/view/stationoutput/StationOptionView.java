package subway.view.stationoutput;

import subway.view.OptionView;

public class StationOptionView extends OptionView {
    private static final String STATION_CONTROLLER_OPTION = "## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기\n";

    private static final String ENTER_STATION_NAME_TO_REGISTER = "## 등록할 역 이름을 입력하세요.";
    private static final String ENTER_STATION_NAME_TO_DELETE = "## 삭제할 역 이름을 입력하세요.";
    private static final String PRINT_STATION_LIST = "## 역 목록";

    public static void printOption () {
        System.out.println(STATION_CONTROLLER_OPTION);
    }

    public static void printStationRegisterInstruction() {
        System.out.println(ENTER_STATION_NAME_TO_REGISTER);
    }

    public static void printStationDeleteInstruction() {
        System.out.println(ENTER_STATION_NAME_TO_DELETE);
    }

    public static void printStationList() {
        System.out.println(PRINT_STATION_LIST);
    }
}
