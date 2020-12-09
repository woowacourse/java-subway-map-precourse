package subway.view;

import subway.enums.StationMenu;

import java.util.Arrays;
import java.util.List;

public class StationView {

    public static void printStationMenu() {
        StationMenu[] stationMenu = StationMenu.values();
        List<StationMenu> menu = Arrays.asList(stationMenu);
        menu.stream().map(StationMenu::getTitle).limit(StationMenu.BACK.ordinal()).forEach(System.out::println);
        System.out.println();
    }

    public static void printAskStationName() {
        System.out.println(StationMenu.ASK_STATION_NAME.getTitle());
    }
}
