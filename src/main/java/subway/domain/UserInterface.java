package subway.domain;

import java.util.Scanner;

public class UserInterface {
    public static void mainMenu(Scanner scanner) {
        Print.mainMenu();
        String input = scanner.next();
    }

    public static void stationSetting(Scanner scanner) {
        Print.stationSetting();
        String input = scanner.next();
    }

    public static void lineSetting(Scanner scanner) {
        Print.lineSetting();
        String input = scanner.next();
    }

    public static void sectionSetting(Scanner scanner) {
        Print.sectionSetting();
        String input = scanner.next();
    }

    public static void subwayMap(Scanner scanner) {
        Print.subwayMap();
    }

    public static String getStationName(Scanner scanner) {
        Print.getStationName();
        String input = scanner.next();
        return Exception.passNameExceptionTest(input);
    }
}
