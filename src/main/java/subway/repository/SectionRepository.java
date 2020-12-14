package subway.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import subway.console.Message;
import subway.domain.Line;
import subway.domain.Station;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class SectionRepository {
    private static final Map<Line, List<Station>> sections = new LinkedHashMap<>();
    private static final int VALID_STATION_SIZE = 2;

    public static void addSection(Line line, Station station) {
        findDuplicateStation(line, station);
//        validateExistLine(line);
        sections.computeIfAbsent(line, key -> new ArrayList<>()).add(station);
    }

    public static void findDuplicateStation(Line line, Station station) {
        if (sections.containsKey(line)) {
            if (sections.get(line).contains(station)) {
                throw new IllegalArgumentException(Message.ERROR_DUPLICATE_STATION);
            }
        }
    }

    private static void validateExistLine(Line line) {
        if (!sections.containsKey(line)) {
            throw new IllegalArgumentException(Message.ERROR_NOT_EXIST_LINE);
        }
    }

    public static void addSection(Line line, Station station, int order) {
        List<Station> stations = sections.get(line);
        stations.add(order, station);
    }

    public static void deleteSection(Line line, Station station) {
        validateExistLine(line);
        List<Station> stations = sections.get(line);
        if (stations.size() <= VALID_STATION_SIZE) {
            throw new IllegalArgumentException(Message.ERROR_SIZE);
        }
        stations.remove(station);
    }
}
