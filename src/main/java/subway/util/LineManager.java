package subway.util;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

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
    }

    public void addStations(Scanner scanner) throws IllegalArgumentException {
        String [] inputStations = new String[2];
        String inputLine;
        StationManager stationManager = new StationManager();
        System.out.println(Constants.ASK_LINE_ADD);
        inputLine = scanner.nextLine().trim();
        while(true) {
            try {
                System.out.println(Constants.ASK_UPPER_END);
                inputStations[0] = scanner.nextLine().trim();
                stationManager.addStation(inputStations[0]);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(Constants.NAME_LENGTH_FAIL);
            }
        }
        while(true) {
            try {
                System.out.println(Constants.ASK_LOWER_END);
                inputStations[1] = scanner.nextLine().trim();
                stationManager.addStation(scanner);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(Constants.NAME_LENGTH_FAIL);
            }
        }


    }

    public void removeLine(Scanner scanner) throws IllegalArgumentException {
        String input;
        System.out.println(Constants.ASK_LINE_REMOVE);
        input = scanner.nextLine().trim();
        if(!ErrorManager.isLineExist(input)) {
            throw new IllegalArgumentException(Constants.LINE_NOT_EXIST);
        }
        boolean check = StationRepository.deleteStation(input);
        if(check) {
            System.out.println(Constants.STATION_REMOVE_COMPLETE);
        } else {
            throw new IllegalArgumentException(Constants.STATION_REMOVE_FAIL);
        }
    }

    public void visitLine() {
        System.out.println(Constants.LINE_LIST);
        for(Line line : LineRepository.lines()) {
            System.out.println(line.getName());
        }
    }
}
