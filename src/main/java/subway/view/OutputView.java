package subway.view;

public class OutputView {

    // todo 컨트롤러에서 준 데이터를 출력
    // todo 출력 방식에 관해서는 모두 OutputView 역할
    // todo 정상, 에러 출력 모두 이곳에서 담당

    public static final String NOTICE_HEADER = "## ";
    public static final String INFO_HEADER = "[INFO] ";
    public static final String ERROR_HEADER = "[ERROR] ";
    public static final String NEWLINE = "\n";
    public static final String DOT = ". ";
    public static final String CHOOSE_ACTION = "원하는 기능을 선택하세요.";

    public static void printInfo(String info) {
        print(INFO_HEADER + info);
    }

    public static void printMenu(String TITLE, String menuString) {
        print(NOTICE_HEADER + TITLE + NEWLINE +
                menuString + NEWLINE +
                NEWLINE +
                CHOOSE_ACTION);
    }

    public static void printNotice(String notice) {
        print(NOTICE_HEADER + notice);
    }

    public static void printError(Exception exception) {
        print(ERROR_HEADER + exception.getMessage());
    }

    public static void print(String string) {
        System.out.println(string);
    }
}
