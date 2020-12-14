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
        Print.hashMessage(Constant.ENTER_LINE_TO_DELETE);
        String input = scanner.next();
        System.out.println();
        input = Exceptions.isInLineList(input);
        LineRepository.deleteLineByName(input);
        Print.infoMessage(Constant.DELETE_LINE_DONE);
    }

    public static void lookUp() {
        Print.hashMessage(Constant.LINE_LIST_TITLE);
        LineRepository.lines().forEach(line -> {
            System.out.print(Constant.HEAD_INFO);
            System.out.println(line.getName());
        });
    }

    public static void addStationToLine(Line line, String stationName) {
        StationRepository.stations().forEach(station -> {
            if (station.getName().equals(stationName)) {
                line.addStation(station);
            }
        });
    }

    public static String lineName(Scanner scanner) {
        Print.hashMessage(Constant.ENTER_LINE_TO_ADD);
        String input = scanner.next();
        System.out.println();
        return Exceptions.checkLineNameAdd(input);
    }

    public static String firstStation(Scanner scanner) {
        Print.hashMessage(Constant.ENTER_FIRST_STATION);
        String input = scanner.next();
        System.out.println();
        return Exceptions.isInStationList(input);
    }

    public static String lastStation(Scanner scanner, String firstStation) {
        Print.hashMessage(Constant.ENTER_LAST_STATION);
        String input = scanner.next();
        System.out.println();
        return Exceptions.checkLastStation(input, firstStation);
    }
}
