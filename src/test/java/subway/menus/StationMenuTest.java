package subway.menus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StationMenuTest {
    @Test
    public void getMenu_메소드_테스트() {
        Assertions.assertEquals(StationMenu.STATION_INSERT, StationMenu.getMenu("1"));
        Assertions.assertEquals(StationMenu.STATION_DELETE, StationMenu.getMenu("2"));
        Assertions.assertEquals(StationMenu.STATION_SELECT, StationMenu.getMenu("3"));
        Assertions.assertEquals(StationMenu.GO_BACK_TO_MAIN_MENU, StationMenu.getMenu("B"));
    }

    @Test
    public void getMenu_예외_테스트() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StationMenu.getMenu("0");
        });
        Assertions.assertEquals("\n[ERROR] 존재하지 않는 메뉴입니다.\n", exception.getMessage());
    }
}