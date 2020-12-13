package subway.menu;

import java.util.Arrays;

public class MenuFeature {
    protected static MenuModel findOne(Class<? extends MenuModel> menuType, String menuInput) {
        return Arrays.stream(menuType.getEnumConstants())
                .filter(menu -> menu.getSelection().equals(menuInput))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 입력입니다."));
    }

    protected static String getMenu(Class<? extends MenuModel> menuType) {
        String menuText = "";
        for (MenuModel mainMenu : menuType.getEnumConstants()) {
            menuText += mainMenu.getSelection() + ". " + mainMenu.getFeature() + "\n";
        }
        return menuText;
    }

    public static boolean exist(Class<? extends MenuModel> menuType, String menuInput) {
        return Arrays.stream(menuType.getEnumConstants())
                .filter(menu -> menu.getSelection().equals(menuInput))
                .findFirst()
                .isPresent();
    }


}
