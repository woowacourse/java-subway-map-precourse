package subway.view;

import java.util.Arrays;

public class LineConsole {
    private static final String CURRENT_MENU_VIEW = "## 노 관리 화면";

    public void showMenu() {
        System.out.println(CURRENT_MENU_VIEW);
        Arrays.stream(LineMenu.LineView.values())
                .forEach(menu -> {
                    System.out.println(menu.getKey() + ". " + menu.getMenuList());
                });
    }

    public boolean selectMenu() {
        while (true) {
            showMenu();
            String input = InputView.getMenu();
            if (!LineMenu.LineView.isValidKey(input)) {
                OutputViewOfError.cannotSelectMenuError();
            }
            if(!LineMenu.LineView.moveByKey(input).moveNext()) {
                continue;
            }
            break;
        }
        return false;
    }
}
