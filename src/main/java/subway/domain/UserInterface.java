package subway.domain;

import java.util.Scanner;

public class UserInterface {
    public static String mainMenu(Scanner scanner) {
        Print.mainMenu();
        return scanner.next();
    }

    public static String stationSetting(Scanner scanner) {
        Print.stationSetting();
        return scanner.next();
    }

    public static String lineSetting(Scanner scanner) {
        Print.lineSetting();
        return scanner.next();
    }

    public static String sectionSetting(Scanner scanner) {
        Print.sectionSetting();
        return scanner.next();
    }

    public static void subwayMap(Scanner scanner) {
        Print.subwayMap();
        mainMenu(scanner);
    }

    public static String getStationName(Scanner scanner) {
        Print.getStationNameToAdd();
        return scanner.next();
    }
}
