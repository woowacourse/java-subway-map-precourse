package subway.view;

import javax.print.StreamPrintServiceFactory;

public class OutputView {
    public static final String INFORMATION_MARK = "[INFO] ";
    public static final String ERROR_MARK = "\n[ERROR] ";
    public static final String SEPARATER = "---";
    public static final String ENTER = "\n";
    public static final String DOUBLE_SHARP = "## ";
    public static final String SELECT_FUNCTION = "원하는 기능을 선택하세요.";
    public static final String INPUT_WITH_ACTION = "%s할 %s 이름을 입력하세요.";
    public static final String ALERT_MESSAGE = "지하철 %s이 %s되었습니다.";
    public static final String ADD_UP_AND_DOWN_LINE = "등록할 노선의 %s행 종점역 이름을 입력하세요.";
    public static final String INVALID_COMMAND = "메뉴에 제시된 기능만 선택할 수 있습니다. (입력 값: %s)";
    public static final String EXIT = "프로그램을 종료합니다.";
    public static final String DUPLICATE_MESSAGE = "%s은/는 이미 존재합니다.";
    public static final String STATION_DELETE_ERROR_MESSAGE = "해당 역이 노선에 포함되어 있거나, 존재하지 않아 삭제할 수 없습니다.";
    public static final String PATH_ERROR_MESSAGE = "노선이 존재하지 않거나, 역이 존재하지 않아 구간을 %s할 수 없습니다.";
    public static final String DELETE_ERROR_ABOUT_EXIST = "%s은/는 존재하지 않습니다.";
    public static final String NAME_LENGTH_ERROR_MESSAGE = "%s 명은 두 글자 이상이어야 합니다. (입력값: %s)";
    public static final String SAME_NAME_ERROR_MESSAGE = "상행선과 하행선은 서로 다른 역이어야 합니다.";
    public static final String DOES_NOT_EXIST_ERROR_MESSAGE = "입력한 %s은 존재하지 않아, 등록할 수 없습니다.";
    public static final String SAME_STATION_IN_LINE_ERROR_MESSAGE = "입력한 %s은/는 이미 해당 노선에 존재합니다.";
    public static final String INPUT_LINE = "노선을 입력하세요.";
    public static final String INPUT_STATION = "역을 입력하세요.";
    public static final String INPUT_ORDER = "순서를 입력하세요.";
    public static final String ALERT_ABOUT_PATH = "구간이 %s되었습니다.";
    public static final String DELETE_INPUT_PREFIX = "삭제할 구간의 ";
    public static final String INDEX_VALID_ERROR_MESSAGE = "순서는 숫자만 입력 가능합니다.";
    public static final String SIZE_IS_SMALLER_THAN_MIN_ERROR = "%s에 남은 역이 최소 개수이므로, %s을/를 삭제할 수 없습니다.";
    public static final String INDEX_OUT_OF_RANGE = "순서가 노선의 길이를 넘어섰습니다.";
    public static final String LIST = " 목록";

    public static final void printMenus(String menu) {
        System.out.println(menu);
    }

    public static final void printWithDoubleSharp(String string) {
        System.out.println(DOUBLE_SHARP + string);
    }

    public static final void printSelectFunction() {
        printWithDoubleSharp(SELECT_FUNCTION);
    }

    public static final void printWithAction(String string, String type) {
        printWithDoubleSharp(String.format(INPUT_WITH_ACTION, string, type));
    }

    public static final void printUpAndDownLineMessage(String string) {
        printWithDoubleSharp(String.format(ADD_UP_AND_DOWN_LINE, string));
    }

    public static final void printAlert(String function, String type) {
        printWithInformationMark(String.format(ALERT_MESSAGE, type, function));
    }

    public static final void printNewLine() {
        System.out.print(ENTER);
    }

    public static final void printLineTitle(String line) {
        System.out.println(INFORMATION_MARK + line);
        System.out.println(INFORMATION_MARK + SEPARATER);
    }

    public static final void printList(String name) {
        printWithDoubleSharp(name + LIST);
    }

    public static final void printWithInformationMark(String string) {
        System.out.println(INFORMATION_MARK + string);
    }

    public static final void printInvalidCommandExceptionErrorMessage(String command) {
        System.out.println(String.format(ERROR_MARK + INVALID_COMMAND, command));
    }

    public static final void printExitMessage() {
        System.out.println(EXIT);
    }

    public static final void printDuplicatedErrorMessage(String string) {
        System.out.println(String.format(ERROR_MARK + DUPLICATE_MESSAGE, string));
    }

    public static final void printStationDeleteErrorMessage() {
        System.out.println(ERROR_MARK + STATION_DELETE_ERROR_MESSAGE);
    }

    public static final void printDoesNotExistErrorMessage(String line) {
        System.out.println(String.format(ERROR_MARK + DELETE_ERROR_ABOUT_EXIST, line));
    }

    public static final void printNameLengthErrorMessage(String type, String string) {
        System.out.println(String.format(ERROR_MARK + NAME_LENGTH_ERROR_MESSAGE, type, string));
    }

    public static final void printSameNameErrorMessage() {
        System.out.println(ERROR_MARK + SAME_NAME_ERROR_MESSAGE);
    }

    public static final void printStationDoesNotExistErrorMessage(String station) {
        System.out.println(String.format(ERROR_MARK + DOES_NOT_EXIST_ERROR_MESSAGE, station));
    }

    public static final void printInputLine() {
        printWithDoubleSharp(INPUT_LINE);
    }

    public static final void printInputStation() {
        printWithDoubleSharp(INPUT_STATION);
    }

    public static final void printInputOrder() {
        printWithDoubleSharp(INPUT_ORDER);
    }

    public static final void printDeleteLineInPath() {
        printWithDoubleSharp(DELETE_INPUT_PREFIX + INPUT_LINE);
    }

    public static final void printDeleteStationInPath() {
        printWithDoubleSharp(DELETE_INPUT_PREFIX + INPUT_STATION);
    }

    public static final void printAlertAboutPath(String action) {
        printWithInformationMark(String.format(ALERT_ABOUT_PATH, action));
    }

    public static final void printErrorAboutPath(String action) {
        System.out.println(String.format(ERROR_MARK + PATH_ERROR_MESSAGE, action));
    }

    public static final void printErrorAboutNotValidIndex() {
        System.out.println(INDEX_VALID_ERROR_MESSAGE);
    }

    public static final void printPathSizeIsSmallerThanMin(String line, String station) {
        System.out.println(String.format(ERROR_MARK + SIZE_IS_SMALLER_THAN_MIN_ERROR, line, station));
    }

    public static final void printIndexOutOfRange() {
        System.out.println(ERROR_MARK + INDEX_OUT_OF_RANGE);
    }

    public static final void printSameStationAlreadyInLineError(String station){
        System.out.println(String.format(ERROR_MARK + SAME_STATION_IN_LINE_ERROR_MESSAGE, station));
    }
}

