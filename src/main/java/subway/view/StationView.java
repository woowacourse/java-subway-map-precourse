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

    public static void printAskStationNameToEnroll() {
        System.out.println(StationMenu.ASK_STATION_NAME_TO_ENROLL.getTitle());
    }

    public static void informStationEnrolled() {
        System.out.println(StationMenu.INFO_STATION_ENROLLED.getTitle());
    }

    public static void printAskStationNameToDelete() {
        System.out.println(StationMenu.ASK_STATION_NAME_TO_DELETE.getTitle());
    }

    public static void informStationDeleted() {
        System.out.println(StationMenu.INFO_STATION_DELETED.getTitle());
    }
}
