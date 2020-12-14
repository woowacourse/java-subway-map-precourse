package subway.view;

public class OutputView {
    public static final String INFORMATION_MARK = "[INFO] ";
    public static final String ERROR_MARK = "[ERROR] ";
    public static final String SEPARATER = "---";

    public static final void printTitle(String title) {
        System.out.println(title);
    }

    public static final void printMenus(String menu) {
        System.out.println(menu);
    }

    public static final void print(String string) {
        System.out.println(string);
    }

    public static final void printMapTitle(String line) {
        System.out.println(INFORMATION_MARK + line);
        System.out.println(INFORMATION_MARK + SEPARATER);
    }

    public static final void printMapStation(String station) {
        System.out.println(INFORMATION_MARK + station);
    }

    public static final void printInvalidCommandExceptionErrorMessage(String command) {
        System.out.println(String.format(ERROR_MARK + "메뉴에 제시된 기능만 선택할 수 있습니다. (입력 값: %s)", command));
    }

    public static final void printExitMessage() {
        System.out.println("프로그램을 종료합니다.");
    }

    public static final void printDuplicatedErrorMessage(String string) {
        System.out.println(String.format(ERROR_MARK + "%s은 이미 존재합니다.", string));
    }
}
