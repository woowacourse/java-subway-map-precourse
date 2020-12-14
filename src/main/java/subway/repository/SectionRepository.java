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

    public static void addSection(Line line, Station station) {
        findDuplicateStation(line, station);
        sections.computeIfAbsent(line, key -> new ArrayList<>()).add(station);
    }

    public static void findDuplicateStation(Line line, Station station) {
        if (sections.containsKey(line)) {
            if (sections.get(line).contains(station)) {
                throw new IllegalArgumentException(Message.ERROR_DUPLICATE_STATION);
            }
        }
    }
}
