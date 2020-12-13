package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Scanner;

public class SectionSetting {
    public static void add(Scanner scanner) {
        String lineName = lineName(scanner);
        LineRepository.lines().forEach(line -> {
            if (line.getName().equals(lineName)) {
                String station = station(scanner, line);
                int order = orderAdd(scanner, line);
                addStationToLine(line, station, order);
                Print.infoMessage(Constant.ADD_SECTION_DONE);
            }
        });
    }

    public static String lineName(Scanner scanner) {
        Print.hashMessage(Constant.ENTER_LINE_SECTION_TO_ADD);
        String input = scanner.next();
        System.out.println();
        return Exceptions.isInLineList(input);
    }

    public static String station(Scanner scanner, Line line) {
        Print.hashMessage(Constant.ENTER_STATION_SECTION_TO_ADD);
        String input = scanner.next();
        System.out.println();
        return Exceptions.isAlreadyAddedInThisLine(input, line);
    }

    public static int orderAdd(Scanner scanner, Line line) {
        Print.hashMessage(Constant.ENTER_ORDER_SECTION_TO_ADD);
        String input = scanner.next();
        System.out.println();
        return Exceptions.checkOrderInput(input, line.stations().size());
    }

    public static void addStationToLine(Line line, String stationName, int order) {
        StationRepository.stations().forEach(station -> {
            if (station.getName().equals(stationName)) {
                line.addStation(order, station);
            }
        });
    }
}
