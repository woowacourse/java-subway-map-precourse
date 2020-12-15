package subway.domain;

import java.util.*;

public class SubwayRepository {
    public static final int MINIMUM_SIZE_OF_LINE = 2;

    private static final Map<Line, List<Station>> subway = new LinkedHashMap<>();

    public static Map<Line, List<Station>> subway() {
        return Collections.unmodifiableMap(subway);
    }

    public static void addLineStationSpecificPlace(Line line, Station station, Integer order) {
        if (subway.containsKey(line)) {
            subway.get(line).add(order, station);
        }
    }

    public static void addStationInLine(Line line, Station station) {
        if (subway.containsKey(line)) {
            subway.get(line).add(station);
        }
    }

    public static void addLine(Line lineByName) {
        subway.put(lineByName, new ArrayList<>());
    }

    public static void deleteStationFromLine(Line selectedLine, Station selectedStation) {
        if (subway.get(selectedLine).size() <= MINIMUM_SIZE_OF_LINE) {
            throw new IllegalArgumentException("역이 " + MINIMUM_SIZE_OF_LINE + "개 이하인 노선에서는 역을 삭제할 수 없습니다.");
        }
        subway.get(selectedLine).remove(selectedStation);
    }

    public static void deleteLine(String inputLineName) {
        subway.keySet().removeIf(line -> line.isSameNameThan(inputLineName));

    }

    public static String isStationNotInLine(String inputRemoveName) {
        for (Line line : subway.keySet()) {
            if (subway.get(line).stream().anyMatch(station -> station.isSameName(inputRemoveName))) {
                throw new IllegalArgumentException("노선에 존재하는 역은 삭제할 수 없습니다.");
            }
        }
        return inputRemoveName;
    }

    public static int findCountOfLine(Line line) {
        return subway.get(line).size();
    }
}
