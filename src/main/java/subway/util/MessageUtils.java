package subway.util;

import subway.model.MenuGroup.Menu;

public class MessageUtils {

    public static void printMenu(Menu menu) {
        System.out.println("## " + menu.getTitle());
        menu.getItems().forEach(
            menuItem -> System.out.println(menuItem.getCode() + ". " + menuItem.getTitle())
        );
        printBlankLine();
    }

    public static void printError(String e) {
        System.out.println(Constants.PREFIX_ERROR + e);
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
