package subway.menu;

import java.util.Arrays;

public class MenuFeature {
    public static MenuModel findOne(Class<? extends MenuModel> menuType, String menuInput){
        return Arrays.stream(menuType.getEnumConstants())
                .filter(menu -> menu.getSelection().equals(menuInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static String getMenu(Class<? extends MenuModel> menuType) {
        String menuText = "";
        for (MenuModel mainMenu : menuType.getEnumConstants()) {
            menuText += mainMenu.getSelection() + ". " + mainMenu.getFeature() + "\n";
        }
        return menuText;
    }
}
