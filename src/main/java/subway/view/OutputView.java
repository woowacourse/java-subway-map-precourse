package subway.view;

public class OutputView {
    public static final String INFORMATION_MARK = "[INFO] ";
    public static final String ERROR_MARK = "[ERROR] ";
    public static final String SEPARATER = "---";
    public static final String DOUBLE_SHARP = "## ";
    public static final String SELECT_FUNCTION = "원하는 기능을 선택하세요.";
    public static final String INPUT_WITH_ACTION = "%s할 %s 이름을 입력하세요.";
    public static final String ALERT_MESSAGE = "지하철 %s이 %s되었습니다.";
    public static final String ADD_UP_AND_DOWN_LINE = "등록할 노선의 %s행 종점역 이름을 입력하세요.";
    public static final String LIST = " 목록";

    public static final void printMenus(String menu) {
        System.out.println(menu);
    }

    public static final void printWithDoubleSharp(String string){
        printNewLine();
        System.out.println(DOUBLE_SHARP + string);
    }

    public static final void printSelectFunction(){
        printNewLine();
        printWithDoubleSharp(SELECT_FUNCTION);
    }

    public static final void printWithAction(String string, String type){
        printNewLine();
        printWithDoubleSharp(String.format(INPUT_WITH_ACTION, string, type));
    }

    public static final void printUpAndDownLineMessage(String string){
        printNewLine();
        printWithDoubleSharp(String.format(ADD_UP_AND_DOWN_LINE, string));
    }

    public static final void printAlert(String function, String type){
        printNewLine();
        printWithInformationMark(String.format(ALERT_MESSAGE, type, function));
    }
    public static final void printNewLine(){
        System.out.println();
    }

    public static final void printLineTitle(String line) {
        System.out.println(INFORMATION_MARK + line);
        System.out.println(INFORMATION_MARK + SEPARATER);
    }

    public static final void printList(String name){
        printNewLine();
        printWithDoubleSharp(name + LIST);
    }
    public static final void printWithInformationMark(String string) {
        printNewLine();
        System.out.println(INFORMATION_MARK + string);
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

    public static final void printStationDeleteErrorMessage(){
        System.out.println(ERROR_MARK + "해당 역이 노선에 포함되어 있거나, 존재하지 않아 삭제할 수 없습니다.");
    }

    public static final void printNameLengthErrorMessage(String string){
        System.out.println(String.format(ERROR_MARK + "역 명은 두 글자 이상이어야 합니다. (입력값: %s)", string));
    }
}
