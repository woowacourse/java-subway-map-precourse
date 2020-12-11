package subway;

public class Printer {
    private static final String USER_FUNCTION_SELECTION_MESSAGE
        = "\n## 원하는 기능을 선택하세요.";
    private static final String USER_INPUT_STATION_REGISTRATION_MESSAGE
        = "\n## 등록할 역 이름을 입력하세요.";
    private static final String REGISTER_NEW_STATION_SUCCESS_MESSAGE
        = "\n" + Prefix.INFO_PREFIX + "지하철 역이 등록되었습니다.";
    private static final String USER_INPUT_STATION_TO_DELETE_MESSAGE
        = "\n## 삭제할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_SUCCESS_MESSAGE
        = "\n" + Prefix.INFO_PREFIX + "지하철 역이 삭제되었습니다.";
    private static final String PRINT_ALL_STATIONS_LIST_TITLE
        = "\n## 역 목록";

    public static void printUserInputStationRegistrationMessage() {
        System.out.println(USER_INPUT_STATION_REGISTRATION_MESSAGE);
    }

    public static void printUserFunctionSelectionMessage() {
        System.out.println(USER_FUNCTION_SELECTION_MESSAGE);
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

    public static void printAllStationsTitle() {
        System.out.println(PRINT_ALL_STATIONS_LIST_TITLE);
    }
}
