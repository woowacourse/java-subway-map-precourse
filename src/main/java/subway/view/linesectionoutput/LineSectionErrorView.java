package subway.view.linesectionoutput;

import subway.view.ErrorView;

public class LineSectionErrorView extends ErrorView {
    private static final String ERROR_INVALID_NUMBER_INPUT = "자연수만 입력 가능합니다.";
    private static final String ERROR_INVALID_ORDER = "추가할 수 없는 순서입니다.";
    private static final String ERROR_ALREADY_IN_LINE = "이미 노선에 존재하는 역입니다.";
    private static final String ERROR_FEW_STATIONS_IN_LINE = "노선에 포함된 역이 두 개 이하일 때는 역을 제거할 수 없습니다.";
    private static final String ERROR_NOT_IN_LINE = "노선에 존재하지 않는 역입니다.";

    public static void printInvalidNumberInputError() {
        printError(ERROR_INVALID_NUMBER_INPUT);
    }

    public static void printInvalidOrderError() {
        printError(ERROR_INVALID_ORDER);
    }

    public static void printAlreadyInLineError() {
        printError(ERROR_ALREADY_IN_LINE);
    }

    public static void printFewStationsInLineError() {
        printError(ERROR_FEW_STATIONS_IN_LINE);
    }

    public static void printNotInLineError() {
        printError(ERROR_NOT_IN_LINE);
    }
}
