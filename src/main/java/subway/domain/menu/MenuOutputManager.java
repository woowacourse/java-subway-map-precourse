package subway.domain.menu;

import subway.common.GuideMessage;

public class MenuOutputManager {
    public static final String WHICH_MENU = "원하는 기능을 선택하세요.";

    public static void printWhichMenuGuide() {
        GuideMessage.print(WHICH_MENU);
    }

    public static void printMenu(Menu menu) {
        for (String item : menu.getMenuItems()) {
            System.out.println(item);
        }
    }

}
