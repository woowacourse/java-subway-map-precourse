package subway.view;

import subway.enums.StationMenu;

import java.util.Arrays;
import java.util.List;

public class StationView {

    public static void printStationMenu() {
        StationMenu[] stationMenu = StationMenu.values();
        List<StationMenu> menu = Arrays.asList(stationMenu);
        menu.stream().map(StationMenu::getTitle).forEach(System.out::println);
        System.out.println();
        askInputMenu();
    }

    public static void askInputMenu() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }
}
