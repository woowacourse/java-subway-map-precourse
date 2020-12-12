package subway.view;

public class OutputView {
    private static final String PREFIX = "## ";
    private static final String STATION_LIST = "역 목록";
    private static final String ORDER_TO_CHOOSE_COMMAND = "원하는 기능을 선택하세요.";
    private static final String ORDER_TO_REGISTER_STATION = "등록할 역 이름을 입력하세요.";
    private static final String ORDER_TO_DELETE_STATION = "삭제할 역 이름을 입력하세요.";
    private static final String MAIN_SCREEN = "메인 화면\n1. 역 관리\n2. 노선 관리\n"
        + "3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    private static final String STATION_MANAGEMENT_SCREEN = "역 관리 화면\n1. 역 등록\n"
        + "2. 역 삭제\n3. 역 조회\nB. 돌아가기\n";
    private static final String LINE_MANAGEMENT_SCREEN = "노선 관리 화면\n1. 노선 등록\n"
        + "2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n";

    public static void printMainScreen() {
        System.out.println(PREFIX + MAIN_SCREEN);
        printOrderToChooseCommand();
    }


    public static void printStationManagementScreen() {
        System.out.println(PREFIX + STATION_MANAGEMENT_SCREEN);
        printOrderToChooseCommand();
    }

    public static void printLineManagementScreen() {
        System.out.println(PREFIX + LINE_MANAGEMENT_SCREEN);
        printOrderToChooseCommand();
    }

    public static void printOrderToChooseCommand() {
        System.out.println(PREFIX + ORDER_TO_CHOOSE_COMMAND);
    }
    public static void printOrderToRegisterStation() {
        System.out.println(PREFIX + ORDER_TO_REGISTER_STATION);
    }

    public static void printStationList() {
        System.out.println(PREFIX + STATION_LIST);
    }

    public static void printOrderToDeleteStation() {
        System.out.println(PREFIX + ORDER_TO_DELETE_STATION);
    }


}
