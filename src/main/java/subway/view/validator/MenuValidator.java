package subway.view.validator;

import java.util.HashMap;
import java.util.Map;

public class MenuValidator {
    private static Map<String, String> MenuRegex;

    static {
        MenuRegex = new HashMap<>();
        MenuRegex.put("Main", "1|2|3|Q");
        MenuRegex.put("Station", "1|2|3|B");
        MenuRegex.put("Line", "1|2|3|B");
        MenuRegex.put("Section", "1|2|B");
    }

    public static void validateMenuSelection(String menuType, String menu) {
        String regex = MenuRegex.get(menuType);
        if (!menu.matches(regex)) {
            throw new MenuSelectionException("\n[ERROR] 선택할 수 없는 기능입니다.\n");
        }
    }
}
