package subway.domain.selector.menu;

import java.util.LinkedHashMap;
import subway.domain.selector.Selector;

public class Menu extends Selector {

    private final LinkedHashMap<String, Menu> subMenus = new LinkedHashMap<>();
    private final LinkedHashMap<String, Selector> items = new LinkedHashMap<>();

    public Menu(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addMenus(String key, Menu menu) {
        subMenus.put(key, menu);
    }

    public void addMenuItems(String key, Selector item) {
        items.put(key, item);
    }

    public LinkedHashMap<String, Menu> getMenus() {
        return subMenus;
    }

    public LinkedHashMap<String, Selector> getItems() {
        return items;
    }
}
