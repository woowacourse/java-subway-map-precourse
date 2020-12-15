package subway.menus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SectionMenuTest {
    @Test
    public void getMenu_메소드_테스트() {
        Assertions.assertEquals(SectionMenu.SECTION_ADD, SectionMenu.getMenu("1"));
        Assertions.assertEquals(SectionMenu.SECTION_DELETE, SectionMenu.getMenu("2"));
        Assertions.assertEquals(SectionMenu.GO_BACK_TO_MAIN_MENU, SectionMenu.getMenu("B"));
    }

    @Test
    public void getMenu_예외_테스트() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SectionMenu.getMenu("0");
        });
        Assertions.assertEquals("\n[ERROR] 존재하지 않는 메뉴입니다.\n", exception.getMessage());
    }
}