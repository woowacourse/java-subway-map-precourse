package subway.view;

import java.util.Arrays;

public class SectionConsole {
    private static final String CURRENT_MENU_VIEW = "## 구 관리 화면";

    public void showMenu() {
        System.out.println(CURRENT_MENU_VIEW);
        Arrays.stream(SectionMenu.SectionView.values())
                .forEach(menu -> {
                    System.out.println(menu.getKey() + ". " + menu.getMenuList());
                });
    }

    public boolean selectMenu() {
        while (true) {
            showMenu();
            String input = InputView.getMenu();
            if (!SectionMenu.SectionView.isValidKey(input)) {
                OutputViewOfError.cannotSelectMenuError();
            }
            if(!SectionMenu.SectionView.moveByKey(input).moveNext()) {
                continue;
            }
            break;
        }
        return false;
    }
}
