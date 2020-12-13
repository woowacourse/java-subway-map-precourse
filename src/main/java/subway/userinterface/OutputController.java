package subway.userinterface;

import java.util.Map;

public abstract class OutputController {

    protected String VIEW_INTRO;

    public void printMainMenu(Map<String, Menu> menu) {
        System.out.println(VIEW_INTRO);

        for (String key: menu.keySet()) {
            System.out.println(menu.get(key).getMenuName());
        }
    }

}
