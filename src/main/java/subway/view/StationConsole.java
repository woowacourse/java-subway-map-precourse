package subway.view;

import java.util.Arrays;

public class StationConsole {
    private static final String CURRENT_MENU_VIEW = "## 역 관리 화면";

    public static void showMenu() {
        System.out.println(CURRENT_MENU_VIEW);
        Arrays.stream(StationMenu.StationView.values())
                .forEach(menu -> {
                    System.out.println(menu.getKey() + ". " + menu.getMenuList());
                });
    }

    public static boolean selectMenu() {
        while (true) {
            showMenu();
            String input = InputView.getMenu();
            if (!StationMenu.StationView.isValidKey(input)) {
                OutputViewOfError.cannotSelectMenuError();
            }
            if(!StationMenu.StationView.moveByKey(input).moveNext()) {
                continue;
            }
            break;
        }
        return false;
    }
}
