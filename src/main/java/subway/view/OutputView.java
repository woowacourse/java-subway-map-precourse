package subway.view;

public class OutputView {
    private static final String INFO_MESSAGE = "[INFO] %s \n";
    private OutputView(){}

    public static void printInfoMsg(String infoMsg){
        printfMsg(INFO_MESSAGE, infoMsg);
    }

    public static void printfMsg(String msg, Object... args){
        System.out.printf(msg, args);
    }

    public static void printMsg(Object msg){
        System.out.print(msg);
    }
}
