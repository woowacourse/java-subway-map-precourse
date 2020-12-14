package subway.view.stationoutput;

import subway.view.OutputView;

public class StationOutputView extends OutputView {
    private static final String STATION_CONTROLLER_OPTION = "역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기";

    private static final String ENTER_STATION_NAME_TO_REGISTER = "등록할 역 이름을 입력하세요.";
    private static final String ENTER_STATION_NAME_TO_DELETE = "삭제할 역 이름을 입력하세요.";
    private static final String PRINT_STATION_LIST = "역 목록";

    public static void printOption () {
        printOutput(STATION_CONTROLLER_OPTION);
        printNewLine();
    }

    public static void printRegisterStationInstruction() {
        printOutput(ENTER_STATION_NAME_TO_REGISTER);
    }

    public static void printDeleteStationInstruction() {
        printOutput(ENTER_STATION_NAME_TO_DELETE);
    }

    public static void printStationList() {
        printOutput(PRINT_STATION_LIST);
    }
}
