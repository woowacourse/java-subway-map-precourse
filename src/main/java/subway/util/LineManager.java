package subway.util;

import subway.domain.*;

import java.util.Scanner;

public class LineManager {
    public void lineMain(Scanner scanner) {
        while(true) {
            try {
                Constants.printLine();
                String inputString = scanner.nextLine().trim();
                if(inputString.equals("B")) {
                    return;
                } else if(inputString.equals("1")) {
                    addLine(scanner);
                } else if(inputString.equals("2")) {
                    removeLine(scanner);
                } else if(inputString.equals("3")) {
                    visitLine();
                }
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return;
    }

    public void addLine(Scanner scanner) throws IllegalArgumentException {
        String input;
        System.out.println(Constants.ASK_LINE_ADD);
        input = scanner.nextLine().trim();
        ErrorManager.checkNameLength(input);
        if(ErrorManager.isLineExist(input)) {
            throw new IllegalArgumentException(Constants.LINE_EXIST);
        }
        Line line = new Line(input);
        LineRepository.addLine(line);
        String [] stations = getStationName(scanner);
        addSection(line, stations);
        System.out.println(Constants.LINE_ADD_COMPLETE);
    }

    public String[] getStationName(Scanner scanner) {
        String [] inputStations = new String[2];
        while(true) {
            try {
                System.out.println(Constants.ASK_UPPER_END);
                inputStations[0] = scanner.nextLine().trim();
                checkStation(inputStations[0]);
                System.out.println(Constants.ASK_LOWER_END);
                inputStations[1] = scanner.nextLine().trim();
                checkStation(inputStations[1]);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return inputStations;
    }

    public void checkStation(String input) throws IllegalArgumentException {
        ErrorManager.checkNameLength(input);
        if(!ErrorManager.isStationExist(input)) {
            throw new IllegalArgumentException(Constants.LINE_NOT_EXIST);
        }
    }

    public void addSection(Line line, String [] stations) {
        Section section = new Section(line);
        for(int i = 0; i < 2; i++) {
            for(Station station : StationRepository.stations()) {
                if(station.getName().equals(stations[i])) {
                    section.addStation(station);
                }
            }
        }
        SectionRepository.addSection(section);
    }

    public void removeLine(Scanner scanner) throws IllegalArgumentException {
        String input;
        System.out.println(Constants.ASK_LINE_REMOVE);
        input = scanner.nextLine().trim();
        if(!ErrorManager.isLineExist(input)) {
            throw new IllegalArgumentException(Constants.LINE_NOT_EXIST);
        }
        if(LineRepository.deleteLineByName(input)) {
            System.out.println(Constants.LINE_REMOVE_COMPLETE);
        } else {
            throw new IllegalArgumentException(Constants.LINE_REMOVE_FAIL);
        }
        SectionRepository.deleteSectionLine(input);
    }

    public void visitLine() {
        System.out.println(Constants.LINE_LIST);
        for(Line line : LineRepository.lines()) {
            System.out.println(line.getName());
        }
    }
}
