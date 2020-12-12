package subway.view;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;

public class OutputView implements ViewConstant {


    private OutputView() {
    }

    public static void printAddMessage(String category) {
        if (!category.equals(SECTION)) {
            category = SUBWAY + category;
        }
        System.out.printf(ADD_MESSAGE, category);
    }
    public static void printDeleteMessage(String category) {
        if (!category.equals(SECTION)) {
            category = SUBWAY + category;
        }
        System.out.printf(DELETE_MESSAGE, category);
    }

    public static void printStationList() {
        System.out.println(PRINT_STATION_LIST_MESSAGE);
        StationRepository.stations().stream()
                .map(Station::getName)
                .forEach(name -> System.out.printf(PRINT_LIST, name.getName()));
    }

    public static void printLineList() {
        System.out.println(PRINT_LINE_LIST_MESSAGE);
        LineRepository.lines().stream()
                .map(Line::getName)
                .forEach(name -> System.out.printf(PRINT_LIST, name.getName()));
    }

    public static void printSubwayMap() {
        System.out.println(PRINT_SUBWAY_MAP_MESSAGE);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            System.out.printf(PRINT_LIST, line.getName().getName());
            System.out.printf(PRINT_LIST, DASH);
            line.getStations().stream()
                    .map(Station::getName)
                    .forEach(name -> System.out.printf(PRINT_LIST, name.getName()));
            System.out.println();
        }
    }

}
