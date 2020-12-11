package subway.view;

import java.util.Map;

public class OutputView {
    private static final String VIEW_SELECT_FORM = "## %s \n";
    private static final String MAIN_VIEW_FORM = "%s. %s\n";
    private static final String ERROR_VIEW_FORM = "[ERROR] %s \n";
    private static final String INFO_VIEW_FORM = "[INFO] %s \n";

    public static void selectView(String message) {
        System.out.printf(VIEW_SELECT_FORM, message);
    }

    public static void main(Map<String, ViewStrategy> views) {
        String mainView = "메인 화면";
        selectView(mainView);
        views.forEach((key, value) -> System.out.printf(MAIN_VIEW_FORM, key, value.viewName()));
    }

    public static void errorView(String message) {
        System.out.printf(ERROR_VIEW_FORM, message);
    }

    public static void infoView(String message) {
        System.out.printf(INFO_VIEW_FORM, message);
    }

    public static void enter(){
        System.out.println();
    }
}
