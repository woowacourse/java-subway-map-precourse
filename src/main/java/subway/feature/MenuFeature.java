package subway.feature;

import subway.menu.MenuModel;
import subway.view.ErrorView;

import java.util.Arrays;

public class MenuFeature {
    public static MenuModel mapInputToSelection(Class<? extends MenuModel> menuType, String menuInput) {
        return Arrays.stream(menuType.getEnumConstants())
                .filter(menu -> menu.getSelection().equals(menuInput))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorView.NOT_SELECTABLE_FEATURE));
    }

    public static String getMenu(Class<? extends MenuModel> menuType) {
        String menuText = "";
        for (MenuModel mainMenu : menuType.getEnumConstants()) {
            menuText += mainMenu.getSelection() + ". " + mainMenu.getFeature() + "\n";
        }
        return menuText;
    }

}
