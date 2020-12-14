package subway.view;


public class OutputView {
    private static final String NAVIGATION_VIEW_FORM = "## %s \n";
    private static final String ERROR_VIEW_FORM = "[ERROR] %s \n";
    private static final String INFO_VIEW_FORM = "[INFO] %s \n";

    public static void selectView(String message) {
        System.out.printf(NAVIGATION_VIEW_FORM, message);
    }

    public static void printMessage(String message){
        System.out.print(message);
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
