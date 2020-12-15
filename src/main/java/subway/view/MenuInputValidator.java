package subway.view;

import java.util.HashMap;
import java.util.Map;

public class MenuInputValidator {
    private static final String MAIN_MENU = "Main";
    private static final String MAIN_MENU_FORMAT_REGEX = "1|2|3|4|Q";
    private static final String STATION_MENU = "Station";
    private static final String STATION_MENU_FORMAT_REGEX = "1|2|3|B";
    private static final String LINE_MENU = "Line";
    private static final String LINE_MENU_FORMAT_REGEX = "1|2|3|B";
    private static final String SECTION_MENU = "Section";
    private static final String SECTION_MENU_FORMAT_REGEX = "1|2|B";

    private static Map<String, String> menuFormat;

    static {
        menuFormat = new HashMap<>();
        menuFormat.put(MAIN_MENU, MAIN_MENU_FORMAT_REGEX);
        menuFormat.put(STATION_MENU, STATION_MENU_FORMAT_REGEX);
        menuFormat.put(LINE_MENU, LINE_MENU_FORMAT_REGEX);
        menuFormat.put(SECTION_MENU, SECTION_MENU_FORMAT_REGEX);
    }

    public static void validateMenuSelection(String menuType, String menu) {
        String format = menuFormat.get(menuType);
        if (!isMenuMatchFormat(menu, format)) {
            throw new MenuInputException("\n[ERROR] 선택할 수 없는 기능입니다.\n");
        }
    }

    private static boolean isMenuMatchFormat(String menu, String format) {
        return menu.matches(format);
    }
}
