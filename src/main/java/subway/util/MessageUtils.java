package subway.util;

public class MessageUtils {

    public static void printMenu(String[] texts) {
        for (String text : texts) {
            System.out.println(text);
        }
//        System.out.println(Arrays.toString(texts));
    }

    public static void printError(String e) {
        System.out.println(Constants.PREFIX_ERROR + e);
    }

    public static void printInfo(String info) {
        System.out.println(Constants.PREFIX_INFO + info);
    }

    public static void printAnnouncement(String text) {
        System.out.println(text);
    }
}
