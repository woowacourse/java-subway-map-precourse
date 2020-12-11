package subway.view;

import java.util.Map;

public class OutputView {
    private static final String VIEW_SELECT_FORM = "## %s \n";
    private static final String NAVIGATION_FORM = "%s. %s\n";
    private static final String ERROR_VIEW_FORM = "[ERROR] %s \n";
    private static final String INFO_VIEW_FORM = "[INFO] %s \n";
    private static final String SELECT_FUNCTION = "원하는 기능을 선택하세요.";
    private static final String NOT_EXIST = "존재하지 않는 보기입니다.";

    public static void selectStrategy(Map<String, ?> views, String viewName) {
        OutputView.selectView(viewName);
        OutputView.navigate(views);
        OutputView.enter();
        OutputView.selectView(SELECT_FUNCTION);
    }

    public static void selectView(String message) {
        System.out.printf(VIEW_SELECT_FORM, message);
    }

    private static void navigate(Map<String, ?> views) {
        views.forEach((key, value) -> System.out.printf(NAVIGATION_FORM, key, value));
    }

    public static void notExist() {
        errorView(NOT_EXIST);
    }

    public static void errorView(String message) {
        System.out.printf(ERROR_VIEW_FORM, message);
    }

    public static void infoView(String message) {
        System.out.printf(INFO_VIEW_FORM, message);
    }

    public static void enter() {
        System.out.println();
    }
}
