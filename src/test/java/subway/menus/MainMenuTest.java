package subway.menus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainMenuTest {
    @Test
    public void getMenu_메소드_테스트() {
        Assertions.assertEquals(MainMenu.STATION_MANAGEMENT, MainMenu.getMenu("1"));
        Assertions.assertEquals(MainMenu.LINE_MANAGEMENT, MainMenu.getMenu("2"));
        Assertions.assertEquals(MainMenu.SECTION_MANAGEMENT, MainMenu.getMenu("3"));
        Assertions.assertEquals(MainMenu.SHOW_SUBWAY_MAP, MainMenu.getMenu("4"));
        Assertions.assertEquals(MainMenu.EXIT_PROGRAM, MainMenu.getMenu("Q"));
    }

    @Test
    public void getMenu_예외_테스트() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MainMenu.getMenu("0");
        });
        Assertions.assertEquals("\n[ERROR] 존재하지 않는 메뉴입니다.\n", exception.getMessage());
    }
}