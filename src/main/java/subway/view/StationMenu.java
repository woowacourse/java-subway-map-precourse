package subway.view;

import java.util.Arrays;
import java.util.function.Supplier;

public class StationMenu {
    public enum StationView{
        REGISTER_STATION("1", "역 등록", () -> ),
        DELETE_STATION("2", "역 삭제", () -> ),
        INQUIRY_STATION("3", "역 조회", () -> ),
        BACK("B", "돌아가기");

        private String key;
        private String menuList;
        private Supplier<Boolean> next;

        StationView(String key, String menuList) {
            this.key = key;
            this.menuList = menuList;
        }

        StationView(String key, String menuList, Supplier<Boolean> next) {
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

        public static StationMenu.StationView moveByKey(String key) {
            return Arrays.stream(values())
                    .filter(menu -> menu.getKey().equals(key))
                    .findAny().get();
        }
    }
}
