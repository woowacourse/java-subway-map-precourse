package subway.domain;

import java.util.Scanner;

public class UserInterface {
    public static String mainMenu(Scanner scanner) {
        Print.mainMenu();
        return scanner.next();
    }

    public static String stationSetting(Scanner scanner) {
        Print.setting(Constant.STATION);
        return scanner.next();
    }

    public static String lineSetting(Scanner scanner) {
        Print.setting(Constant.LINE);
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

    public static String getStationNameToAdd(Scanner scanner) {
        Print.getStationNameToAdd();
        return scanner.next();
    }
}
