package subway.repository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import subway.console.message.ErrorMessage;
import subway.domain.Line;
import subway.domain.Station;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class SectionRepository {
    private static final Map<Line, List<Station>> sections = new LinkedHashMap<>();
    private static final int VALID_STATION_SIZE = 2;
    private static final int VALID_ORDER_SIZE = 1;

    public static Map<Line, List<Station>> sections() {
        return Collections.unmodifiableMap(sections);
    }

    public static void addSection(Line line, Station station) {
        findDuplicateStationInLine(line, station);
        sections.computeIfAbsent(line, key -> new LinkedList<>()).add(station);
    }

    private static void findDuplicateStationInLine(Line line, Station station) {
        if (sections.containsKey(line)) {
            validateDuplicateStation(line, station);
        }
    }

    private static void validateDuplicateStation(Line line, Station station) {
        if (sections.get(line).contains(station)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_STATION);
        }
    }

    public static void addSection(Line line, Station station, int order) {
        findDuplicateStationInLine(line, station);
        validateOrder(line, order);

        List<Station> stations = sections.get(line);
        stations.add(order, station);
    }

    private static void validateOrder(Line line, int order) {
        List<Station> stations = sections.get(line);
        if (order < VALID_ORDER_SIZE || order >= stations.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }

    public static void deleteSection(Line line, Station station) {
        List<Station> stations = sections.get(line);
        validateStationsSize(stations);

        stations.remove(station);
    }

    private static void validateStationsSize(List<Station> stations) {
        if (stations.size() <= VALID_STATION_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.SIZE);
        }
    }

    public static boolean isExistStation(Station station) {
        return sections.values().stream()
                .anyMatch(stations -> stations.contains(station));
    }
}
