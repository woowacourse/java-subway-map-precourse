package subway.views.mainviews;

import java.util.Arrays;

public class MainOutputView {
    private static final String MAIN_MESSAGE = "## 메인 화면";
    private static final String SELECT_FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";

    public static void printMainSelectMessage() {
        System.out.println(MAIN_MESSAGE);
        printMainMenus();
        System.out.println();
        System.out.println(SELECT_FEATURE_MESSAGE);
    }

    private static void printMainMenus() {
        Arrays.stream(MainMenu.values())
            .map(MainMenu::toString)
            .forEach(System.out::println);
    }
}
