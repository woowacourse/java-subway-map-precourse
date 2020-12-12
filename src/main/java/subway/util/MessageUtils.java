package subway.util;

public class MessageUtils {

    public static void printMenu(String[] texts) {
        for (String text : texts) {
            System.out.println(text);
        }
        printBlankLine();
    }

    public static void printError(String e) {
        System.out.println(Constants.PREFIX_ERROR + e);
        printBlankLine();
    }

    public static void printInfo(String info) {
        System.out.println(Constants.PREFIX_INFO + info);
    }

    public static void printInputAnnouncement(String text) {
        System.out.println(text);
    }

    public static void printBlankLine() {
        System.out.println(Constants.LINE_BLANK);
    }
}
