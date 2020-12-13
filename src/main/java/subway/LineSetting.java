package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Scanner;

public class LineSetting {
    public static void add(Scanner scanner) {
        String inputName = lineName(scanner);
        String firstStation = firstStation(scanner);
        String lastStation = lastStation(scanner, firstStation);
        Line line = new Line(inputName);
        addStationToLine(line, firstStation);
        addStationToLine(line, lastStation);
        LineRepository.addLine(line);
        Print.infoMessage(Constant.ADD_LINE_DONE);
    }

    public static void delete(Scanner scanner) {
        while (true) {
            try {
                Print.hashMessage(Constant.ENTER_LINE_TO_DELETE);
                String input = scanner.next();
                System.out.println();
                input = Exception.checkLineNameDelete(input);
                LineRepository.deleteLineByName(input);
                Print.infoMessage(Constant.DELETE_LINE_DONE);
                break;
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage() + "%n");
            }
        }
    }

    public static void addStationToLine(Line line, String stationName){
        StationRepository.stations().forEach(station -> {
            if(station.getName().equals(stationName)){
                line.addStation(station);
            }
        });
    }

    public static String lineName(Scanner scanner) {
        while (true) {
            try {
                Print.hashMessage(Constant.ENTER_LINE_TO_ADD);
                String input = scanner.next();
                System.out.println();
                return Exception.checkLineNameAdd(input);
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage() + "%n");
            }
        }
    }

    public static String firstStation(Scanner scanner) {
        while (true) {
            try {
                Print.hashMessage(Constant.ENTER_FIRST_STATION);
                String input = scanner.next();
                System.out.println();
                return Exception.checkFirstStation(input);
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage() + "%n");
            }
        }
    }

    public static String lastStation(Scanner scanner, String firstStation) {
        while (true) {
            try {
                Print.hashMessage(Constant.ENTER_LAST_STATION);
                String input = scanner.next();
                System.out.println();
                return Exception.checkLastStation(input, firstStation);
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage() + "%n");
            }
        }
    }
}
