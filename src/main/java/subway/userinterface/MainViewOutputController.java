package subway.userinterface;

import java.util.Map;

public class MainViewOutputController {

    private final static String MAIN_VIEW_INTRO = "## 메인 화면";

    public static void printMainMenu(Map<String, Menu> mainMenu) {
        System.out.println(MAIN_VIEW_INTRO);

        for (String key: mainMenu.keySet()) {
            System.out.println(mainMenu.get(key).getMenuName());
        }
    }
}
