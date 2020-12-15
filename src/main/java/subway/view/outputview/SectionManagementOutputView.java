package subway.view.outputview;

public class SectionManagementOutputView {
    public static final String INFO = "[INFO] ";
    public static final String ERROR = "[ERROR] ";

    public void printActionComplete(String completeMessage) {
        System.out.println(INFO + completeMessage);
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR + errorMessage);
        System.out.println();
    }
}
