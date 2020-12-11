package subway.view;

public class OutputView {
    private static final String ORDER_TO_CHOOSE_COMMAND = "## 원하는 기능을 선택하세요.";
    private static final String ORDER_TO_REGISTER_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    private static final String END_MESSAGE = "[INFO] 종료합니다.";
    private static final String BACK_MESSAGE = "[INFO] 메인화면으로 돌아갑니다.";
    private static final String MAIN_SCREEN = "## 메인 화면\n1. 역관리\n2. 노선 관리\n"
        + "3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    private static final String STATION_MANAGEMENT_SCREEN = "## 역 관리 화면\n1. 역 등록\n"
        + "2. 역 삭제\n3. 역 조회\nB. 돌아가기\n";


    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN);
        printOrderToChooseCommand();
    }

    public static void printOrderToChooseCommand() {
        System.out.println(ORDER_TO_CHOOSE_COMMAND);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public static void printStationManagementScreen() {
        System.out.println(STATION_MANAGEMENT_SCREEN);
        printOrderToChooseCommand();
    }

    public static void printBackToMainScreen() {
        System.out.println(BACK_MESSAGE);
    }

    public static void printOrderToRegisterStationName() {
        System.out.println(ORDER_TO_REGISTER_STATION_NAME);
    }
}
