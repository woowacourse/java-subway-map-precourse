package subway.view.screen;

import subway.view.InputView;

public interface Screen {

    String ERROR_PREFIX = "[ERROR] ";
    String INFO_PREFIX = "[INFO] ";
    String SELECT_CATEGORY_MESSAGE = "원하는 기능을 선택하세요.";
    String DOUBLE_SHARP = "## ";
    String SPACE = " ";
    String COMMA = ". ";
    String COLUMN_LINE = "---";
    String MANAGEMENT_MESSAGE = "관리";
    String LIST_MESSAGE = "목록";
    String PRINT_MESSAGE = "출력";

    void visualize();
    void logic(InputView inputView);
}
