package subway.view;

import java.util.Arrays;
import java.util.function.Supplier;

public class MainMenu {
    public enum MainView{
        STATION_MANAGEMENT("1", "역 관리", () -> ),
        LINE_MANAGEMENT("2", "노선 관리", () -> ),
        SECTION_MANAGEMENT("3", "구간 관리", () -> ),
        PRINT_SUBWAY_MAP("4", "지하철 노선도 출력", () -> ),
        QUIT("Q", "종료");

        private String key;
        private String menuList;
        private Supplier<Boolean> next;

        MainView(String key, String menuList) {
            this.key = key;
            this.menuList = menuList;
        }

        MainView(String key, String menuList, Supplier<Boolean> next) {
            this.key = key;
            this.menuList = menuList;
            this.next = next;
        }

        public static boolean isValidKey(String input) {
            return Arrays.stream(values()).anyMatch(menu -> menu.getKey().equals(input));
        }

        public String getKey() {
            return key;
        }

        public String getMenuList() {
            return menuList;
        }

        public void moveNext(String key) {
            next.get();
        }

        public static MainView moveByKey(String key) {
            return Arrays.stream(values())
                    .filter(menu -> menu.getKey().equals(key))
                    .findAny().get();
        }
    }
}
