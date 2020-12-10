package subway.control;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.enums.LineMenu;
import subway.view.LineView;
import subway.view.MainView;
import subway.view.StationView;

import java.util.Scanner;

public class LineControlCenter {

    public LineControlCenter() {

    }

    public void startLineControl(Scanner scanner) {
        LineView.printLineMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
        selectMenu(command, scanner);
    }

    private void selectMenu(String command, Scanner scanner) {
        if (command.equals(LineMenu.ENROLL.getCommand())) {
            enrollLine(scanner);
            return;
        }
        if (command.equals(LineMenu.DELETE.getCommand())) {
            removeLine(scanner);
            return;
        }
        if (command.equals(LineMenu.CHECK.getCommand())) {
            LineView.printLineList();
            return;
        }
    }

    private void enrollLine(Scanner scanner) {
        String nameOfLine = inputNameOfLine(scanner);
        String upLastStation = inputUpLastStation(scanner);
        String downLastStation = inputDownLastStation(scanner, upLastStation);

        Line line = new Line(nameOfLine);
        LineRepository.addLine(line);
        LineView.informLineEnrolled();
    }

    private String inputNameOfLine(Scanner scanner) {
        LineView.printAskLineNameToEnroll();
        String nameOfLine = MainControlCenter.inputCommand(scanner);
        if (LineRepository.isNameDuplication(nameOfLine)) {
            LineView.informLineDuplicated();
            return inputNameOfLine(scanner);
        }
        if (LineRepository.isNameLengthUnder2(nameOfLine)) {
            LineView.informNameLengthUnder2();
            return inputNameOfLine(scanner);
        }
        return nameOfLine;
    }

    private String inputUpLastStation(Scanner scanner) {
        LineView.printAskUpLastStation();
        String upLastStation = MainControlCenter.inputCommand(scanner);
        if (!StationRepository.isNameDuplication(upLastStation)) {
            StationView.informStationNotExist();
            return inputUpLastStation(scanner);
        }
        return upLastStation;
    }

    private String inputDownLastStation(Scanner scanner, String upLastStation) {
        LineView.printAskDownLastStation();
        String downLastStation = MainControlCenter.inputCommand(scanner);
        if (!StationRepository.isNameDuplication(downLastStation)) {
            StationView.informStationNotExist();
            return inputDownLastStation(scanner, upLastStation);
        }
        if (downLastStation.equals(upLastStation)){
            LineView.informLastUpDownStationDuplication();
            return inputDownLastStation(scanner, upLastStation);
        }
        return downLastStation;
    }

    private void removeLine(Scanner scanner) {
        LineView.printAskLineNameToDelete();
        String nameOfLine = MainControlCenter.inputCommand(scanner);
        if (LineRepository.deleteLineByName(nameOfLine)) {
            LineView.informLineDeleted();
            return;
        }
        LineView.informLineNotExist();
        removeLine(scanner);
    }
}
