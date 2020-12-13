package subway.view;

public class OutputView {

    // todo 컨트롤러에서 준 데이터를 출력
    // todo 출력 방식에 관해서는 모두 OutputView 역할
    // todo 정상, 에러 출력 모두 이곳에서 담당

    public static final String NOTICE_HEADER = "## ";
    public static final String INFO_HEADER = "[INFO] ";
    public static final String ERROR_HEADER = "[ERROR] ";
    public static final String SYSTEM_EXIT_MESSAGE = "지하철 시스템이 종료되었습니다.";

    public static void printSystemExit() {
        printInfo(SYSTEM_EXIT_MESSAGE);
    }

    public static void printInfo(String info) {
        print(INFO_HEADER + info);
    }

    public static void printInfo(Object obj) {
        printInfo(String.valueOf(obj));
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
