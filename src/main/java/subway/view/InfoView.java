package subway.view;

public class InfoView {
    protected static final String INFO = "[INFO] ";

    protected static void printInfo(String infoMessage) {
        System.out.println(INFO + infoMessage);
        System.out.println();
    }
}
