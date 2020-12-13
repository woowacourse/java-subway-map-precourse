package subway.view.lineoutput;

import subway.view.ErrorView;

public class LineErrorView extends ErrorView {
    private static final String ERROR_WRONG_DUPLICATE_LINE = "이미 등록된 노선 이름입니다.";
    private static final String ERROR_END_WITH_WORD_LINE = "등록할 역 이름은 '선'으로 끝나야 합니다";
    private static final String ERROR_NOT_IN_LINE_REPOSITORY = "존재하지 않는 노선입니다.";
    private static final String ERROR_SAME_TERMINUS_INPUT = "상행 종점역과 하행 종점역은 서로 달라야 합니다.";

    public static void printDuplicateLineError() {
        printError(ERROR_WRONG_DUPLICATE_LINE);
    }

    public static void printEndWithWordLineError() {
        printError(ERROR_END_WITH_WORD_LINE);
    }

    public static void printNotInLineRepositoryError() {
        printError(ERROR_NOT_IN_LINE_REPOSITORY);
    }

    public static void printSameTerminusInputError() { printError(ERROR_SAME_TERMINUS_INPUT); }

}
