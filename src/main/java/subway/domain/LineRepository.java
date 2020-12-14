package subway.domain;

import java.util.*;

public class LineRepository {
    private static final Map<Line, List<Station>> lines = new HashMap<>();
    private static final String[] defaultLines = {"2호선", "3호선", "신분당선"};
    private static final String[][] defaultStations = {
            {"교대역", "강남역", "역삼역"},
            {"교대역", "남부터미널역", "양재역", "매봉역"},
            {"강남역", "양재역", "양재시민의숲역"}
    };

    static {
        for (int i = 0; i < defaultLines.length; i++) {
            List<Station> tmpStations = new ArrayList<>();
            for (int j = 0; j < defaultStations[i].length; j++) {
                tmpStations.add(new Station(defaultStations[i][j]));
            }

            lines.put(new Line(defaultLines[i]), tmpStations);
        }
    }

    public static Map<Line, List<Station>> lines() {
        return Collections.unmodifiableMap(lines);
    }

    public static void addLine(Line line, Station startStation, Station endStation) {
        lines.put(line, new ArrayList<>(Arrays.asList(startStation, endStation)));
    }

    public static boolean deleteLineByName(String name) {
        return lines.keySet().removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void addStationInLineByName(String line, String station, int seq) {
        lines.get(findLineByName(line)).add(seq-1,
                StationRepository.findStationByName(station));
    }

    public static void deleteStationInLineByName(String line, String station) {
        lines.get(findLineByName(line)).removeIf(st -> st.getName().equals(station));
    }

    public static Line findLineByName(String name) {
        return lines.keySet().stream().filter(x -> x.getName().equals(name))
                .findFirst().get();
    }

    public static boolean hasStationInLine(String name) {
        for (Line line : lines.keySet()) {
            if (hasStationInCertainLine(line, name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasStationInCertainLine(Line line, String stationName) {
        return lines.get(line).stream().anyMatch(station -> station.getName().equals(stationName));
    }

    public static boolean isLineExists(String name) {
        return lines.keySet().stream().anyMatch(line -> line.getName().equals(name));
    }
}
