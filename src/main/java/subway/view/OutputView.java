package subway.view;

public class OutputView {
    private static final String MAIN_CONTROLLER_INFORMATION = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    private static final String STATION_CONTROLLER_INFORMATION = "## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기\n";

    private static final String ERROR_WRONG_OPTION = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String ERROR_WRONG_LENGTH = "[ERROR] 2자 미만은 입력할 수 없습니다.";
    private static final String ERROR_WRONG_DUPLICATE_STATION = "[ERROR] 이미 등록된 역 이름입니다.";
    private static final String ERROR_END_WITH_WORD_STATION = "[ERROR] 등록할 역 이름은 '역'으로 끝나야 합니다";
    private static final String ERROR_INPUT_IS_SPACE = "[ERROR] 공백으로만 이루어진 입력은 허용하지 않습니다.";
    private static final String ERROR_NOT_IN_STATION_REPOSITORY = "[ERROR] 존재하지 않는 역입니다.";

    private static final String INFO = "[INFO] ";

    private static final String GIVE_OPTION = "## 원하는 기능을 선택하세요.";

    private static final String ENTER_STATION_NAME_TO_REGISTER = "## 등록할 역 이름을 입력하세요.";
    private static final String ENTER_STATION_NAME_TO_DELETE = "## 삭제할 역 이름을 입력하세요.";
    private static final String PRINT_STATION_LIST = "## 역 목록";


    public static void printNewLine() {
        System.out.println();
    }

    public static void printOptionInstruction() {
        System.out.println(GIVE_OPTION);
    }

    public static void printOptionError() {
        printNewLine();
        System.out.println(ERROR_WRONG_OPTION);
        printNewLine();
    }

    public static void printLengthError() {
        printNewLine();
        System.out.println(ERROR_WRONG_LENGTH);
        printNewLine();
    }

    public static void printDuplicateStationError() {
        printNewLine();
        System.out.println(ERROR_WRONG_DUPLICATE_STATION);
        printNewLine();
    }

    public static void printInputIsSpaceError() {
        printNewLine();
        System.out.println(ERROR_INPUT_IS_SPACE);
        printNewLine();
    }

    public static void printEndWithWordStationError() {
        printNewLine();
        System.out.println(ERROR_END_WITH_WORD_STATION);
        printNewLine();
    }

    public static void printNotInStationRepositoryError() {
        System.out.println(ERROR_NOT_IN_STATION_REPOSITORY);
    }

    public static void printEnterStationRegisterInstruction() {
        System.out.println(ENTER_STATION_NAME_TO_REGISTER);
    }

    public static void printEnterStationDeleteInstruction() {
        System.out.println(ENTER_STATION_NAME_TO_DELETE);
    }

    public static void printMainControllerOption () {
        System.out.println(MAIN_CONTROLLER_INFORMATION);
    }

    public static void printStationControllerOption () {
        System.out.println(STATION_CONTROLLER_INFORMATION);
    }

    public static void printStationList() {
        System.out.println(PRINT_STATION_LIST);
    }

    public static void printInfo(String information) {
        System.out.println(INFO + information);
    }
}
