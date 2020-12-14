package subway.views.mainviews;

import subway.menus.MainMenu;

import java.util.Arrays;

public class MainOutputView {
    private static final String MAIN_PAGE = "## 메인 화면";

    private MainOutputView() {
    }

    public static void printMainPage() {
        System.out.println(MAIN_PAGE);
        printMainMenus();
        System.out.println();
    }

    private static void printMainMenus() {
        Arrays.stream(MainMenu.values())
            .map(MainMenu::toString)
            .forEach(System.out::println);
    }
}
