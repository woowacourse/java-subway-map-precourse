package subway.view;

import subway.domain.Line;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.enums.ErrorMessage;
import subway.enums.MainMenu;
import subway.enums.SectionInfo;
import subway.enums.SectionMenu;

import java.util.Arrays;
import java.util.List;

public class SectionView {

    public static void printSectionMenu() {
        SectionMenu[] sectionMenu = SectionMenu.values();
        List<SectionMenu> menu = Arrays.asList(sectionMenu);
        menu.stream().map(SectionMenu::getTitle).forEach(System.out::println);
        System.out.println();
    }

    public static void printAskLineToRegisterStationOn() {
        System.out.println(SectionInfo.ASK_LINE_TO_REGISTER_STATION_ON.getInfo());
    }

    public static void printAskStationToRegisterOnLine() {
        System.out.println(SectionInfo.ASK_STATION_TO_REGISTER_ON_LINE.getInfo());
    }

    public static void printAskPositionToRegisterStation() {
        System.out.println(SectionInfo.ASK_POSITION_TO_REGISTER_STATION.getInfo());
    }

    public static void informSectionRegistered() {
        System.out.println(SectionInfo.INFO_SECTION_REGISTERED.getInfo());
    }

    public static String printSectionList() {
        List<Section> sections = SectionRepository.sections();
        System.out.println(SectionInfo.SECTION_LIST.getInfo());
        for (Section section : sections) {
            Line line = section.getLine();
            System.out.println(SectionInfo.INFO.getInfo() + line.getName());
            System.out.println(SectionInfo.INFO.getInfo()
                    + SectionInfo.DELIMITER_BETWEEN_LINE_AND_STATIONS.getInfo());
            section.getStations().stream()
                    .map(Station::getName)
                    .forEach(name -> System.out.println(SectionInfo.INFO.getInfo() + name));
            System.out.println();
        }
        return MainMenu.PRINT_SUBWAY_MAP.getCommand();
    }

    public static void printAskLineToDeleteStationFrom() {
        System.out.println(SectionInfo.ASK_LINE_TO_DELETE_STATION_FROM.getInfo());
    }

    public static void printAskStationToDeleteFromLine() {
        System.out.println(SectionInfo.ASK_STATION_TO_DELETE_FROM_LINE.getInfo());
    }

    public static void informSectionDeleted() {
        System.out.println(SectionInfo.INFO_SECTION_DELETED.getInfo());
    }

    public static void informNoMenu() {
        MainView.informUnableCommand();
    }

    public static void informStationUnder2onLine() {
        System.err.println(ErrorMessage.STATION_UNDER_2_ON_LINE.getMessage());
    }

    public static void informNotNumberFormat() {
        System.err.println(ErrorMessage.POSITION_NOT_NUMBER_FORMAT.getMessage());
    }

    public static void informSameOrReverseOrderOfStations() {
        System.err.println(ErrorMessage.SAME_OR_REVERSE_ORDER_OF_STATIONS_EXISTS.getMessage());
    }
}
