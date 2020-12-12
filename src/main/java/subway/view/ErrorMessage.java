package subway.view;

public class ErrorMessage {
    public static final String OUT = "OUT";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INPUT_NEEDED = " 중에서 입력해 주세요.";
    private static final String OVER_TWO = "2글자 이상이어야 한다.";
    private static final String LAST_LETTER_STATION = "역이름 끝에는 역이라고 붙여주세요.";
    private static final String LAST_LETTER_LINE = "노선이름 끝에는 호선이라고 붙여주세요.";
    private static final String VALUE_EXIST = "이미 존재하는 이름입니다.";
    private static final String NOT_EXIST_STATION = "등록되어 있지 않은 역입니다.";
    private static final String SAME_UP_DOWN_STATION = "상행과 하행은 같은 역을 등록할 수 없습니다.";
    private static final String ON_PATH_STATION = "노선에 등록된 역은 삭제할 수 없습니다.";

    private ErrorMessage() {
    }

    public static void printMenu(String selections) {
        System.out.println(ERROR_PREFIX + selections + INPUT_NEEDED);
    }

    public static void printNameLength() {
        System.out.println(ERROR_PREFIX + OVER_TWO);
    }

    public static void printLastLetterStation() {
        System.out.println(ERROR_PREFIX + LAST_LETTER_STATION);
    }

    public static void printLastLetterLine() {
        System.out.println(ERROR_PREFIX + LAST_LETTER_LINE);
    }

    public static void printNotExistStation() {
        System.out.println(ERROR_PREFIX + NOT_EXIST_STATION);
    }

    public static void printSameUpDownStation() {
        System.out.println(ERROR_PREFIX + SAME_UP_DOWN_STATION);
    }

    public static void printNotDeleteOnPathStation() {
        System.out.println(ERROR_PREFIX + ON_PATH_STATION);
    }

    public static void printValeAlreadyExist() {
        System.out.println(ERROR_PREFIX + VALUE_EXIST);
    }

}
