package subway.domain.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Menu implements Iterable<MenuItem> {
    private String title;
    private final List<MenuItem> menuItems = new ArrayList<>();;

    public Menu(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<MenuItem> getMenuItems() {
        return Collections.unmodifiableList(menuItems);
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void executeMenuItem(String key) {
        MenuItem anyMatchMenuItem = menuItems.stream()
                .filter(streamMenuItem -> key.equals(streamMenuItem.getKey()))
                .findAny()
                .orElse(null);
        // TODO: 해당하는 메뉴항목이 없을 때 예외처리
        anyMatchMenuItem.execute();
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return menuItems.iterator();
    }
}
