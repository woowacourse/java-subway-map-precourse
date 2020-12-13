package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Scanner;

public class SectionSetting {
    public static void add(Scanner scanner) {
        Print.hashMessage(Constant.ENTER_LINE_SECTION_TO_ADD);
        String lineName = lineName(scanner);
        LineRepository.lines().forEach(line -> {
            if (line.getName().equals(lineName)) {
                String station = stationToAdd(scanner, line);
                int order = orderToAdd(scanner, line);
                addStationToLine(line, station, order);
                Print.infoMessage(Constant.ADD_SECTION_DONE);
            }
        });
    }

    public static void delete(Scanner scanner) {
        Print.hashMessage(Constant.ENTER_LINE_SECTION_TO_DELETE);
        String lineName = lineName(scanner);
        LineRepository.lines().forEach(line -> {
            if (line.getName().equals(lineName)) {
                Exceptions.NumberOfStationsInLineOverTwo(line);
                String station = stationToDelete(scanner, line);
                if (!line.deleteStation(station)){
                    Exceptions.isNotInThisLine();
                }
                Print.infoMessage(Constant.DELETE_SECTION_DONE);
            }
        });
    }

    public static String lineName(Scanner scanner) {
        String input = scanner.next();
        System.out.println();
        return Exceptions.isInLineList(input);
    }

    public static String stationToAdd(Scanner scanner, Line line) {
        Print.hashMessage(Constant.ENTER_STATION_SECTION_TO_ADD);
        String input = scanner.next();
        System.out.println();
        return Exceptions.isInThisLine(input, line);
    }

    public static String stationToDelete(Scanner scanner, Line line) {
        Print.hashMessage(Constant.ENTER_STATION_SECTION_TO_ADD);
        String input = scanner.next();
        System.out.println();
        return input;
    }

    public static int orderToAdd(Scanner scanner, Line line) {
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
