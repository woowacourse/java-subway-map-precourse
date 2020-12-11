package subway.view;

import subway.enums.ErrorMessage;
import subway.enums.MainInfo;
import subway.enums.MainMenu;

import java.util.Arrays;
import java.util.List;

public class MainView {

    public static void printMainMenu() {
        System.out.println();
        MainMenu[] mainMenu = MainMenu.values();
        List<MainMenu> menu = Arrays.asList(mainMenu);
        menu.stream().map(MainMenu::getTitle).forEach(System.out::println);
        System.out.println();
    }

    public static void askInputMenu() {
        System.out.println(MainInfo.INPUT.getInfo());
    }

    public static void informUnableCommand() {
        System.err.println(ErrorMessage.NO_MENU.getMessage());
    }

    public static String exit() {
        System.out.println(MainInfo.EXIT.getInfo());
        return MainMenu.EXIT.getCommand();
    }
}
