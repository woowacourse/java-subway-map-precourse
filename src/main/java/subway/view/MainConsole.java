package subway.view;

import java.util.Arrays;

public class MainConsole {
    private static final String CURRENT_MENU_VIEW = "## 메인 화면";

    public void showMenu() {
        System.out.println(CURRENT_MENU_VIEW);
        Arrays.stream(MainMenu.MainView.values())
                .forEach(menu -> {
                    System.out.println(menu.getKey() + ". " + menu.getMenuList());
                });
    }

    public MainMenu.MainView selectMenu() {
        while (true) {
            String input = InputView.getMenu();
            if (!MainMenu.MainView.isValidKey(input)) {
                OutputViewOfError.cannotSelectMenuError();
                continue;
            }
            return MainMenu.MainView.moveByKey(input);
        }
    }
}
