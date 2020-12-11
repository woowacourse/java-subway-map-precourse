package subway.domain;

import java.util.*;

public class LineRepository {
    private static final Map<Line, List<Station>> lines = new HashMap<>();
    private static final String[] DEFAULT_LINES = {"2호선", "3호선", "신분당선"};
    private static final String[][] DEFAULT_STATIONS = {
            {"교대역", "강남역", "역삼역"},
            {"교대역", "남부터미널역", "양재역", "매봉역"},
            {"강남역", "양재역", "양재시민의숲역"}
    };


    static {
        for (int i = 0; i < DEFAULT_LINES.length; i++) {
            List<Station> tmpStations = new ArrayList<>();
            for (int j = 0; j < DEFAULT_STATIONS[i].length; j++) {
                tmpStations.add(new Station(DEFAULT_STATIONS[i][j]));
            }

            lines.put(new Line(DEFAULT_LINES[i]), tmpStations);
        }
    }

    public static Map<Line, List<Station>> lines() {
        return Collections.unmodifiableMap(lines);
    }

    public static void addLine(Line line, Station startStation, Station endStation) {
        lines.put(line, Arrays.asList(startStation, endStation));
    }

    public static boolean deleteLineByName(String name) {
        return lines.keySet().removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteStationInLine(String name) {
        for (List<Station> stations : lines().values()) {
            if (stations.stream().anyMatch(station -> station.getName().equals(name))) {
                stations.removeIf(station -> Objects.equals(station.getName(), name));
            }
        }
    }

    public static boolean hasStationInLine(String name) {
        for (List<Station> stations : lines().values()) {
            if (stations.stream().anyMatch(station -> station.getName().equals(name))) {
                return true;
            }
        }
        return false;
    }
}
