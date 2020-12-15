package subway.view;

import java.util.Arrays;
import java.util.function.Supplier;

public class LineMenu {
    public enum LineView{
        REGISTER_LINE("1", "노선 등록", () -> LineController.getInstatnce.registerLine()),
        DELETE_LINE("2", "노선 삭제", () -> LineController.getInstatnce.deleteLine()),
        INQUIRY_LINE("3", "노 조회", () -> LineController.getInstatnce.inquiryLine()),
        BACK("B", "돌아가기", () -> LineController.getInstatnce.back());

        private String key;
        private String menuList;
        private Supplier<Boolean> next;

        LineView(String key, String menuList) {
            this.key = key;
            this.menuList = menuList;
        }

        LineView(String key, String menuList, Supplier<Boolean> next) {
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

        public static LineMenu.LineView moveByKey(String key) {
            return Arrays.stream(values())
                    .filter(menu -> menu.getKey().equals(key))
                    .findAny().get();
        }
    }
}
