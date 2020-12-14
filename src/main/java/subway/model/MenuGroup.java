package subway.model;

import java.util.List;

public class MenuGroup {

    public static class Menu {

        private final String title;
        private final List<MenuItem> items;

        public Menu(String title, List<MenuItem> items) {
            this.title = title;
            this.items = items;
        }

        public String getTitle() {
            return title;
        }

        public List<MenuItem> getItems() {
            return items;
        }
    }

    public static class MenuItem {

        private final String code;
        private final String title;

        public MenuItem(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public String getCode() {
            return code;
        }

        public String getTitle() {
            return title;
        }
    }
}
