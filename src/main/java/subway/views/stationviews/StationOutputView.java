package subway.views.lineviews;

import java.util.Arrays;

public class StationOutputView {
    private static final String MAIN_MESSAGE = "## 역 관리 화면";
    private static final String SELECT_FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";

    public static void printStationSelectMessage() {
        System.out.println(MAIN_MESSAGE);
        printMainMenus();
        System.out.println();
        System.out.println(SELECT_FEATURE_MESSAGE);
    }

    private static void printMainMenus() {
        Arrays.stream(StationMenu.values())
            .map(StationMenu::toString)
            .forEach(System.out::println);
    }
}
