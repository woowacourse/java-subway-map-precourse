package subway.view;

public class OutputView {
    public static final String INFORMATION_MARK = "[INFO] ";
    public static final String ERROR_MARK = "[ERROR] ";
    public static final String SEPARATER = "---";
    public static final String DOUBLE_SHARP = "## ";
    public static final String SELECT_FUNCTION = "원하는 기능을 선택하세요.";

    public static final void printMenus(String menu) {
        System.out.println(menu);
    }

    public static final void printWithDoubleSharp(String string){
        System.out.println(DOUBLE_SHARP + string);
    }

    public static final void printSelectFunction(){
        printWithDoubleSharp(SELECT_FUNCTION);
    }

    public static final void printNewLine(){
        System.out.println();
    }

    public static final void printLineTitle(String line) {
        System.out.println(INFORMATION_MARK + line);
        System.out.println(INFORMATION_MARK + SEPARATER);
    }

    public static final void printStation(String station) {
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
