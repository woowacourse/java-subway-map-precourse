package subway;
/*
 * SubwayManager
 *
 * version 1.0
 *
 * 2020.12.15
 *
 * Copyright (c) by Davinci.J
 */
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
