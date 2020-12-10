package subway.view;

import subway.domain.StationRepository;
import subway.enums.ErrorMessage;
import subway.enums.StationInfo;
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
        System.out.println(StationInfo.ASK_STATION_NAME_TO_ENROLL.getInfo());
    }

    public static void informStationEnrolled() {
        System.out.println(StationInfo.INFO_STATION_ENROLLED.getInfo());
    }

    public static void printAskStationNameToDelete() {
        System.out.println(StationInfo.ASK_STATION_NAME_TO_DELETE.getInfo());
    }

    public static void informStationDeleted() {
        System.out.println(StationInfo.INFO_STATION_DELETED.getInfo());
    }

    public static void printStationList() {
        System.out.println(StationInfo.STATION_LIST.getInfo());
        StationRepository.stations().stream()
                .map(station -> StationInfo.INFO.getInfo() + station.getName())
                .forEach(System.out::println);
    }

    public static void infromStationDuplicated() {
        System.err.println(ErrorMessage.STATION_DUPLICATION.getMessage());
    }

    public static void informNameLengthUnder2() {
        System.err.println(ErrorMessage.STATION_NAME_LENGTH_UNDER_2.getMessage());
    }

    public static void informStationNotExist() {
        System.err.println(ErrorMessage.STATION_NOT_EXIST.getMessage());
    }
}
