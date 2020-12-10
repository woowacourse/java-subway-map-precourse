package subway.view;

public class OutputView {
    private static final String INFO="[INFO] ";
    private static final String ERROR="[ERROR] ";

    public static void printInfo(String info){
        System.out.println(INFO+info);
    }

    public static void printError(String errorMessage){
        System.out.println(ERROR+errorMessage);
        System.out.println();
    }
}
