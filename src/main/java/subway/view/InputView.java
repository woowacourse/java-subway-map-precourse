package subway.view;

import subway.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public static Scanner scanner;

    public static void insertScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    public static String inputMainMenu() {
        System.out.println(Constants.MAIN_MENU);
        return scanner.next();
    }

    public static String inputStationMenu() {
        System.out.println(Constants.STATION_MAIN_MENU);
        return scanner.next();
    }

    public static String inputStationToRegister() {
        System.out.println(Constants.INPUT_STATION_TO_ENROLL);
        return scanner.next();
    }

    public static String inputStationToDelete() {
        System.out.println(Constants.INPUT_STATION_TO_DELETE);
        return scanner.next();
    }

    public static String inputLineMenu() {
        System.out.println(Constants.LINE_MAIN_MENU);
        return scanner.next();
    }

    public static String inputLineToRegister() {
        System.out.println(Constants.INPUT_LINE_TO_ENROLL);
        return scanner.next();
    }

    public static String inputStartStationToEnroll() {
        System.out.println(Constants.INPUT_START_STATION_TO_ENROLL);
        return scanner.next();
    }

    public static String inputEndStationToEnroll() {
        System.out.println(Constants.INPUT_END_STATION_TO_ENROLL);
        return scanner.next();
    }

    public static String inputLineToDelete() {
        System.out.println(Constants.INPUT_LINE_TO_DELETE);
        return scanner.next();
    }

    public static String inputSectionMenu() {
        System.out.println(Constants.SECTION_MAIN_MENU);
        return scanner.next();
    }

    public static String inputSectionToRegister() {
        System.out.println(Constants.INPUT_LINE);
        return scanner.next();
    }

    public static String inputStationInSectionToRegister() {
        System.out.println(Constants.INPUT_STATION);
        return scanner.next();
    }

    public static int inputOrderInSectionToRegister() {
        try {
            System.out.println(Constants.INPUT_ORDER);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(Constants.ERROR_NOT_NUMBER);
            scanner.nextLine();
            return inputOrderInSectionToRegister();
        }
    }

    public static String inputSectionToDelete() {
        System.out.println(Constants.INPUT_LINE_OF_SECTION_TO_DELETE);
        return scanner.next();
    }

    public static String inputStationInSectionToDelete() {
        System.out.println(Constants.INPUT_STATION_OF_SECTION_TO_ENROLL);
        return scanner.next();
    }

}
