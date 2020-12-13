package subway.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import subway.utils.ValidationUtils;

public class Menu implements Iterable<MenuItem> {
    private String title;
    private final List<MenuItem> menuItems = new ArrayList<>();;

    private Menu(String title) {
        this.title = title;
    }

    public static Menu createWithMenuItems(String title, MenuItem... menuItems) {
        Menu menu = new Menu(title);
        menu.setMenuItems(menuItems);
        return menu;
    }

    private void setMenuItems(MenuItem[] menuItems) {
        this.menuItems.addAll(Arrays.asList(menuItems));
    }

    public String getTitle() {
        return title;
    }

    public List<MenuItem> getMenuItems() {
        return Collections.unmodifiableList(menuItems);
    }

    public void executeMenuItem(String key) {
        ValidationUtils.validateIllegalFunction(key, getKeys());

        MenuItem matchedMenuItem = menuItems.stream()
                .filter(streamMenuItem -> key.equals(streamMenuItem.getKey()))
                .findAny().orElse(null);

        matchedMenuItem.execute();
    }
    
    private List<String> getKeys() {
        return menuItems.stream().map(MenuItem::getKey).collect(Collectors.toList());
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return menuItems.iterator();
    }
}
