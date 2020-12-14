package subway.util;

import subway.model.MenuGroup.Menu;

public class MessageUtils {

    public static void printMenu(Menu menu) {
        System.out.println(Constants.MENU_GROUP_PREFIX + menu.getTitle());
        menu.getItems().forEach(
            menuItem -> System.out.println(menuItem.getCode() + ". " + menuItem.getTitle())
        );
        printBlankLine();
        MessageUtils.printAnnouncement(Constants.ANNOUNCEMENT_FEATURE_SELECT_COMMENT);
    }

    public static void printError(String e) {
        System.out.println(Constants.PREFIX_ERROR + e);
        MessageUtils.printBlankLine();
    }

    public static void printInfo(String info) {
        System.out.println(Constants.PREFIX_INFO + info);
        MessageUtils.printBlankLine();
    }

    public static void printInfoEntry(String info) {
        System.out.println(Constants.PREFIX_INFO + info);
    }

    public static void printAnnouncement(String text) {
        System.out.println(text);
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
