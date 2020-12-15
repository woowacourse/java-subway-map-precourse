package subway.view;

import java.util.Arrays;
import java.util.function.Supplier;

public class SectionMenu {
    public enum SectionView{
        REGISTER_SECTION("1", "구간 등록", () -> ),
        DELETE_SECTION("2", "구간 삭제", () -> ),
        BACK("B", "돌아가기", () ->);

        private String key;
        private String menuList;
        private Supplier<Boolean> next;

        SectionView(String key, String menuList) {
            this.key = key;
            this.menuList = menuList;
        }

        SectionView(String key, String menuList, Supplier<Boolean> next) {
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

        public boolean moveNext() {
            return next.get();
        }

        public static SectionMenu.SectionView moveByKey(String key) {
            return Arrays.stream(values())
                    .filter(menu -> menu.getKey().equals(key))
                    .findAny().get();
        }
    }
}
