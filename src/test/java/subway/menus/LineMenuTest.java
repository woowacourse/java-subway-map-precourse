package subway.menus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LineMenuTest {
    @Test
    public void getMenu_메소드_테스트() {
        Assertions.assertEquals(LineMenu.LINE_ADD, LineMenu.getMenu("1"));
        Assertions.assertEquals(LineMenu.LINE_DELETE, LineMenu.getMenu("2"));
        Assertions.assertEquals(LineMenu.LINE_SELECT, LineMenu.getMenu("3"));
        Assertions.assertEquals(LineMenu.GO_BACK_TO_MAIN_MENU, LineMenu.getMenu("B"));
    }

    @Test
    public void getMenu_예외_테스트() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LineMenu.getMenu("0");
        });
        Assertions.assertEquals("\n[ERROR] 존재하지 않는 메뉴입니다.\n", exception.getMessage());
    }
}