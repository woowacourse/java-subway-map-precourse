package subway.control;

import subway.enums.SectionMenu;
import subway.view.MainView;
import subway.view.SectionView;

import java.util.Scanner;

public class SectionControlCenter {

    public SectionControlCenter() {

    }

    public void startSectionControl(Scanner scanner) {
        SectionView.printSectionMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
        selectMenu(command, scanner);
    }

    private void selectMenu(String command, Scanner scanner) {
        if (command.equals(SectionMenu.ENROLL.getCommand())) {
//            enrollSection(scanner);
            return;
        }
        if (command.equals(SectionMenu.DELETE.getCommand())) {

            return;
        }
    }
//
//    private void enrollSection(Scanner scanner) {
//        String lineToEnrollStationOn = inputNameOfLine(scanner);
//        SectionView.printAskStationToEnrollOnLine();
//        String stationToEnrollOnLine = MainControlCenter.inputCommand(scanner);
//        SectionView.printAskPosionToEnrollStation();
//        String positionToEnrollStation = MainControlCenter.inputCommand(scanner);
//        SectionView.informSectionEnrolled();
//    }
//
//    private String inputNameOfLine(Scanner scanner) {
//        SectionView.printAskLineToEnrollStationOn();
//        String lineToEnrollStationOn = MainControlCenter.inputCommand(scanner);
//
//
//        return "";
//    }

}
