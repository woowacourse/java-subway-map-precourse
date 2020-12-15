package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static void init() {
        Line line1 = new Line(new LineName("2호선"));
        line1.addStations(new Station(new StationName("교대역")));
        line1.addStations(new Station(new StationName("강남역")));
        line1.addStations(new Station(new StationName("역삼역")));
        Line line2 = new Line(new LineName("3호선"));
        line2.addStations(new Station(new StationName("교대역")));
        line2.addStations(new Station(new StationName("남부터미널역")));
        line2.addStations(new Station(new StationName("양재역")));
        line2.addStations(new Station(new StationName("매봉역")));
        Line line3 = new Line(new LineName("신분당선"));
        line3.addStations(new Station(new StationName("강남역")));
        line3.addStations(new Station(new StationName("양재역")));
        line3.addStations(new Station(new StationName("양재시민의숲역")));
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(LineName name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void printLine() {
        System.out.println(Constants.LINE_LIST);
        for (Line line : lines) {
            System.out.println(line.toString());
        }
        System.out.println();
    }

    public static boolean containsStationOfLine(Line line, Station station) {
        for (Line n : lines) {
            if (n.equals(line) && n.getStations().contains(station)) {
                return true;
            }
        }
        return false;
    }

    public static int getLineSize(Line line) {
        int size = 0;
        for (Line n : lines) {
            if (n.equals(line)) {
                size = n.size();
                break;
            }
        }
        return size;
    }

    public static void addSection(Line line, Station station, int orderNumber) {
        for (Line n : lines) {
            if (n.equals(line)) {
                n.addStations(orderNumber, station);
            }
        }
    }

    public static void deleteSection(Line line, Station station) {
        for (Line n : lines) {
            if (n.equals(line)) {
                n.getStations().remove(station);
            }
        }
    }

    public static void printLineAndStation() {
        for (Line line : lines) {
            System.out.println(line.toString() + Constants.INFORMATION_BAR);
            for (Station station : line.getStations()) {
                System.out.println(station.toString());
            }
            System.out.println();
        }
    }

}
