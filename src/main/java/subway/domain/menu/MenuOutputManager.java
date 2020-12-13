package subway.domain.menu;

import subway.common.Guide;

public class MenuOutputManager {

    public static final String WHAT_MENU = "원하는 기능을 선택하세요.";

    public static void printWhatMenu() {
        Guide.print(WHAT_MENU);
    }

    public static void printMenu(String[] menuItems) {
        for (String item : menuItems) {
            System.out.println(item);
        }
    }

}
