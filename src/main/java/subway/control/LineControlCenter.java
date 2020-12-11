package subway.control;

import subway.domain.*;
import subway.enums.LineMenu;
import subway.enums.MainMenu;
import subway.view.LineView;
import subway.view.MainView;
import subway.view.StationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LineControlCenter {

    public LineControlCenter() {

    }

    public String startLineControl(Scanner scanner) {
        LineView.printLineMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
        String menu = selectMenu(command, scanner);
        if (isUnableCommand(menu)) {
            LineView.informNoMenu();
            return startLineControl(scanner);
        }
        return MainMenu.LINE_CONTROL.getCommand();
    }

    private String selectMenu(String command, Scanner scanner) {
        if (command.equals(LineMenu.ENROLL.getCommand())) {
            return enrollLine(scanner);
        }
        if (command.equals(LineMenu.DELETE.getCommand())) {
            return removeLine(scanner);
        }
        if (command.equals(LineMenu.CHECK.getCommand())) {
            return LineView.printLineList();
        }
        if (command.equalsIgnoreCase(LineMenu.BACK.getCommand())) {
            return LineMenu.BACK.getCommand();
        }
        return "";
    }

    private String enrollLine(Scanner scanner) {
        String nameOfLine = inputNameOfLine(scanner);
        Station upLastStation = inputUpLastStation(scanner);
        Station downLastStation = inputDownLastStation(scanner, upLastStation);
        Line line = new Line(nameOfLine);
        LineRepository.addLine(line);
        LineView.informLineEnrolled();
        SectionRepository.addLineToSection(
                line, getUpDownLastStations(upLastStation, downLastStation));
        return LineMenu.ENROLL.getCommand();
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
        if (StationRepository.isNameDuplication(nameOfLine)) {
            StationView.informStationDuplicated();
            return inputNameOfLine(scanner);
        }
        return nameOfLine;
    }

    private Station inputUpLastStation(Scanner scanner) {
        LineView.printAskUpLastStation();
        String upLastStation = MainControlCenter.inputCommand(scanner);
        if (!StationRepository.isNameDuplication(upLastStation)) {
            StationView.informStationNotExist();
            return inputUpLastStation(scanner);
        }
        return StationRepository.getStationByName(upLastStation);
    }

    private Station inputDownLastStation(Scanner scanner, Station upLastStation) {
        LineView.printAskDownLastStation();
        String downLastStation = MainControlCenter.inputCommand(scanner);
        if (!StationRepository.isNameDuplication(downLastStation)) {
            StationView.informStationNotExist();
            return inputDownLastStation(scanner, upLastStation);
        }
        if (downLastStation.equals(upLastStation.getName())){
            LineView.informLastUpDownStationDuplication();
            return inputDownLastStation(scanner, upLastStation);
        }
        return StationRepository.getStationByName(downLastStation);
    }

    private String removeLine(Scanner scanner) {
        LineView.printAskLineNameToDelete();
        String nameOfLine = MainControlCenter.inputCommand(scanner);
        if (LineRepository.deleteLineByName(nameOfLine)) {
            LineView.informLineDeleted();
            return LineMenu.DELETE.getCommand();
        }
        LineView.informLineNotExist();
        return removeLine(scanner);
    }

    private List<Station> getUpDownLastStations(Station upLastStation, Station downLastStation) {
        List<Station> upDownLastStations = new ArrayList<>();
        upDownLastStations.add(upLastStation);
        upDownLastStations.add(downLastStation);
        return upDownLastStations;
    }

    private boolean isUnableCommand(String menu) {
        return Arrays.stream(LineMenu.values())
                .skip(LineMenu.ENROLL.ordinal())
                .map(LineMenu::getCommand)
                .noneMatch(command -> command.equals(menu));
    }
}
