package subway.function.station.printer;

import subway.common.print.Prefix;

public class StationManagementPrinter {
    private static final String USER_INPUT_STATION_REGISTRATION_MESSAGE
        = "\n## 등록할 역 이름을 입력하세요.";
    private static final String REGISTER_NEW_STATION_SUCCESS_MESSAGE
        = "\n" + Prefix.INFO_PREFIX + "지하철 역이 등록되었습니다.";
    private static final String USER_INPUT_STATION_TO_DELETE_MESSAGE
        = "\n## 삭제할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_SUCCESS_MESSAGE
        = "\n" + Prefix.INFO_PREFIX + "지하철 역이 삭제되었습니다.";
    private static final String STATION_LIST_TITLE
        = "\n## 역 목록";

    public static void printUserInputStationRegistrationMessage() {
        System.out.println(USER_INPUT_STATION_REGISTRATION_MESSAGE);
    }

    public static void printUserInputStationToDeleteMessage() {
        System.out.println(USER_INPUT_STATION_TO_DELETE_MESSAGE);
    }

    public static void printRegisterNewStationSuccessMessage() {
        System.out.println(REGISTER_NEW_STATION_SUCCESS_MESSAGE);
    }

    public static void printDeleteStationSuccessMessage() {
        System.out.println(DELETE_STATION_SUCCESS_MESSAGE);
    }

    public static void printStationListTitle() {
        System.out.println(STATION_LIST_TITLE);
    }
}
