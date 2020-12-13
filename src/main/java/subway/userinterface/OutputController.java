package subway.userinterface;

import java.util.Map;

public class OutputController {

    public static void printMainMenu(Map<String, Menu> menu, String menuIntro) {
        System.out.println(menuIntro);

        for (String key: menu.keySet()) {
            System.out.println(menu.get(key).getMenuName());
        }
    }

    public static void printInfo(String infoStatement) {
        System.out.println(infoStatement);
    }

}
