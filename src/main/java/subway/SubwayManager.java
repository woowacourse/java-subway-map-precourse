package subway;

import java.util.Map;

public class SubwayManager {
    private static Map<String, Object> menus;

    public static void initSubwayManager(Map<String, Object> menus) {
        SubwayManager.menus = menus;
    }

    public static Object getMenus(String name) {
        return menus.get(name);
    }
}
