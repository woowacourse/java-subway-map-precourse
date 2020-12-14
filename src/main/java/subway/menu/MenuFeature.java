package subway.menu;

import subway.view.ErrorView;

import java.util.Arrays;

public class MenuFeature {
    public static MenuModel findOne(Class<? extends MenuModel> menuType, String menuInput) {
        return Arrays.stream(menuType.getEnumConstants())
                .filter(menu -> menu.getSelection().equals(menuInput))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorView.UNSELECTABLE));
    }

    protected static String getMenu(Class<? extends MenuModel> menuType) {
        String menuText = "";
        for (MenuModel mainMenu : menuType.getEnumConstants()) {
            menuText += mainMenu.getSelection() + ". " + mainMenu.getFeature() + "\n";
        }
        return menuText;
    }

}
