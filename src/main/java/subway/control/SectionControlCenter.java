package subway.control;

import subway.domain.*;
import subway.enums.SectionMenu;
import subway.view.LineView;
import subway.view.MainView;
import subway.view.SectionView;
import subway.view.StationView;

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
            enrollSection(scanner);
            return;
        }
        if (command.equals(SectionMenu.DELETE.getCommand())) {

            return;
        }
    }

    private void enrollSection(Scanner scanner) {
        Line lineToEnrollStationOn = inputNameOfLine(scanner);
        Station stationToEnrollOnLine = inputNameOfStation(scanner);
        String positionToEnrollStationOnLine = inputPositionToEnrollStation(scanner);
        SectionRepository.addStationOnLine(
                lineToEnrollStationOn, stationToEnrollOnLine, positionToEnrollStationOnLine);
        SectionView.informSectionEnrolled();
    }

    private Line inputNameOfLine(Scanner scanner) {
        SectionView.printAskLineToEnrollStationOn();
        String lineToEnrollStationOn = MainControlCenter.inputCommand(scanner);
        if (!LineRepository.isNameDuplication(lineToEnrollStationOn)) {
            LineView.informLineNotExist();
            return inputNameOfLine(scanner);
        }
        return LineRepository.getLineByName(lineToEnrollStationOn);
    }

    private Station inputNameOfStation(Scanner scanner) {
        SectionView.printAskStationToEnrollOnLine();
        String stationToEnrollOnLine = MainControlCenter.inputCommand(scanner);
        if (!StationRepository.isNameDuplication(stationToEnrollOnLine)) {
            StationView.informStationNotExist();
            return inputNameOfStation(scanner);
        }
        return StationRepository.getStationByName(stationToEnrollOnLine);
    }

    private String inputPositionToEnrollStation(Scanner scanner) {
        SectionView.printAskPosionToEnrollStation();
        String positionToEnrollStation = MainControlCenter.inputCommand(scanner);
        return positionToEnrollStation;
    }
}
