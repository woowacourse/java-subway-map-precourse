package view;

import constants.LineMenu;
import constants.MainMenu;
import constants.StationMenu;
import subway.controllers.SectionMenu;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner;

    public static String selectMainFunction() {
        OutputView.printMainMenu(MainMenu.getWholeMenu());
        OutputView.printSelectFunction();
        return scanner.nextLine();
    }

    public static String readStationName() {
        return scanner.nextLine();
    }

    public static String readDeletingStationName() {

        OutputView.printAskDeleteStation();
        return scanner.nextLine();
    }

    public static String read() {
        return scanner.nextLine();
    }

    public static String selectStationMenu() {
        OutputView.printStationMenu(StationMenu.getWholeMenu());
        return scanner.nextLine();
    }

    public static String selectSectionMenu() {
        OutputView.printSectionMenu(SectionMenu.getWholeMenu());
        return scanner.nextLine();
    }

    public static String readAddingLine() {
        OutputView.print(SectionMenu.getAddingLineName());
        return scanner.nextLine();
    }

    public static String readAddingStation() {
        OutputView.print(SectionMenu.getAddingStationName());
        return scanner.nextLine();
    }

    public static String selectLineMenu() {
        OutputView.printLineMenu(LineMenu.getWholeMenu());
        return scanner.nextLine();
    }

    public static String readDeletingLineName() {
        OutputView.printAskDeleteSectionMessage();
        return scanner.nextLine();
    }

    public static String readOrder() {
        OutputView.print(SectionMenu.getAddingOrder());
        return scanner.nextLine();
    }

    public static String readDeletingStationNameInSection() {
        OutputView.print(SectionMenu.getDeletingStationName());
        return scanner.nextLine();
    }
}
