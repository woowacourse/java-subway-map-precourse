package subway;

public class Printer {
    private final static String USER_SELECTION_MESSAGE
        = "\n## 원하는 기능을 선택하세요.";
    private static final String USER_INPUT_STATION_REGISTRATION_MESSAGE
        = "\n## 등록할 역 이름을 입력하세요.";

    public static void printUserInputStationRegistrationMessage() {
        System.out.println(USER_INPUT_STATION_REGISTRATION_MESSAGE);
    }

    public static void printUserFunctionSelectionMessage() {
        System.out.println(USER_SELECTION_MESSAGE);
    }
}
